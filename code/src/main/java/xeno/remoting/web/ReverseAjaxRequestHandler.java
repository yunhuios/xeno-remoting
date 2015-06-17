/**
 * NOTICE - T20150126
 * 
 * The "xeno-remoting" is free software, licensed under the Apache License, Version 2.0 (the "License").
 * Commercial and non-commercial use are permitted in compliance with the License.
 * 
 * Copyright (c) 2015 Kai Feng, All rights reserved.
 * 
 * You may obtain a copy of the License at: "http://www.apache.org/licenses/LICENSE-2.0".
 * In addition, a copy of the License is included with this distribution.
 * 
 * As stated in Section 7, "Disclaimer of Warranty" of the License:
 * 
 * 7. Disclaimer of Warranty. Unless required by applicable law or
 *    agreed to in writing, Licensor provides the Work (and each
 *    Contributor provides its Contributions) on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *    implied, including, without limitation, any warranties or conditions
 *    of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A
 *    PARTICULAR PURPOSE. You are solely responsible for determining the
 *    appropriateness of using or redistributing the Work and assume any
 *    risks associated with Your exercise of permissions under this License.
 * 
 * The source code is available at: "https://github.com/kfeng2015/xeno-remoting".
 */
package xeno.remoting.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings({ "rawtypes", "unchecked" })
class ReverseAjaxRequestHandler extends DynamicRequestHandler {
	private static final Log LOGGER = LogFactory.getLog(ReverseAjaxRequestHandler.class);

	/**
	 * <p>
	 * The path info.
	 * </p>
	 */
	public static final String PATH_INFO = "/xeno.remoting.web.ReverseAjax" + REQUEST_SUFFIX;

	/**
	 * <p>
	 * The request attribute key for asynchronous response status flag.
	 * </p>
	 */
	public static final String RESPONSE_STATUS_FLAG_REQUEST_ATTRIBUTE_KEY = "ReverseAjax.RequestAttribute.ResponseStatusFlag";

	/**
	 * <p>
	 * The request attribute key for JavaScript functions.
	 * </p>
	 */
	public static final String JAVASCRIPT_FUNCTION_REQUEST_ATTRIBUTE_KEY = "ReverseAjax.RequestAttribute.JavaScriptFunction";

	/**
	 * <p>
	 * Please see
	 * {@link xeno.remoting.web.RequestHandler#RequestHandler(HttpServletRequest, HttpServletResponse, String)}.
	 * </p>
	 */
	protected ReverseAjaxRequestHandler(HttpServletRequest request, HttpServletResponse response, String encoding) throws IllegalArgumentException, UnhandlableException {
		super(request, response, encoding);
	}

	@Override
	public void performTask() throws UnhandlableException, IOException {

		// Parses the request content.
		String uri = null;

		try {
			Map data = JsonUtils.parse(request.getInputStream(), Map.class);
			uri = Validate.notNull((String) data.get(CURRENT_PAGE_URI_DATA_KEY), "No page URI info in the request");

		} catch (Exception ex) {
			String message = StringUtils.trimToEmpty(ex.getMessage());

			throw new UnhandlableException(HttpServletResponse.SC_BAD_REQUEST, message.length() == 0 ? "Invalid data format detected" : message, ex);
		}

		// Binds a thread for current page URI.
		MessageServlet.setCurrentPageUriThread(uri);

		final String sessionId = MessageServlet.getCurrentHttpSessionThread().getId();
		final String pageUri = uri;
		final AsyncContext asyncContext = request.startAsync(request, response);
		asyncContext.setTimeout(MessageServlet.getReverseAjaxIdleLiveTime());
		asyncContext.addListener(new AsyncListener() {

			@Override
			public void onStartAsync(AsyncEvent evt) throws IOException {
				// Does nothing.
			}

			@Override
			public void onComplete(AsyncEvent evt) throws IOException {
				MessageServlet.getReverseAjaxThreadPool().remove(sessionId, pageUri, asyncContext);

				String content = null;

				try {
					boolean success = (Boolean) request.getAttribute(RESPONSE_STATUS_FLAG_REQUEST_ATTRIBUTE_KEY);

					if (success) {
						response.setStatus(HttpServletResponse.SC_OK);
						LOGGER.debug("Success to process the reverse AJAX, session ID: " + sessionId + ", page URI: " + pageUri);

						JavaScriptFunction[] functions = (JavaScriptFunction[]) request.getAttribute(JAVASCRIPT_FUNCTION_REQUEST_ATTRIBUTE_KEY);
						List data = new ArrayList();

						if (functions != null) {

							for (JavaScriptFunction func : functions) {

								if (func != null) {
									Map item = new HashMap();
									item.put("name", func.getName());
									item.put("arguments", func.getArguments());

									data.add(item);
								}
							}
						}

						try {
							Result result = new Result(data);
							content = JsonUtils.stringify(result);

						} catch (Exception ex) {
							throw new JsonSerializationException("Failed to serialize the reverse AJAX result", ex);
						}

					} else {
						throw new IllegalStateException("The reverse AJAX does not complete in a success state");
					}

				} catch (Exception ex) {
					response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					Throwable cause = new UnhandlableException(ex.getMessage());
					LOGGER.warn("Failed to process the reverse AJAX, session ID: " + sessionId + ", page URI: " + pageUri, ex);

					Fault fault = new Fault(cause);
					content = JsonUtils.stringify(fault);
				}

				IoUtils.responseText(response, content);
			}

			@Override
			public void onError(AsyncEvent evt) throws IOException {
				request.setAttribute(RESPONSE_STATUS_FLAG_REQUEST_ATTRIBUTE_KEY, false);
				LOGGER.debug("Error occurs during the asynchronous request");
			}

			@Override
			public void onTimeout(AsyncEvent evt) throws IOException {
				request.setAttribute(RESPONSE_STATUS_FLAG_REQUEST_ATTRIBUTE_KEY, true);
				LOGGER.debug("Asynchronous request timeout and complete the request");
			}
		});

		MessageServlet.getReverseAjaxThreadPool().add(sessionId, pageUri, asyncContext);
	}
}
