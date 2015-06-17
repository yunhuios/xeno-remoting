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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings({ "rawtypes", "unchecked" })
class RemoteCallRequestHandler extends DynamicRequestHandler {
	private static final Log LOGGER = LogFactory.getLog(RemoteCallRequestHandler.class);

	/**
	 * <p>
	 * The path info.
	 * </p>
	 */
	public static final String PATH_INFO = "/xeno.remoting.web.RemoteCall" + REQUEST_SUFFIX;

	/**
	 * <p>
	 * The remote proxy name data key.
	 * </p>
	 */
	public static final String REMOTE_PROXY_NAME_DATA_KEY = "name";

	/**
	 * <p>
	 * The web method name data key.
	 * </p>
	 */
	public static final String WEB_METHOD_NAME_DATA_KEY = "method";

	/**
	 * <p>
	 * The web method arguments data key.
	 * </p>
	 */
	public static final String INPUT_ARGUMENTS_DATA_KEY = "params";

	/**
	 * <p>
	 * Please see
	 * {@link xeno.remoting.web.RequestHandler#RequestHandler(HttpServletRequest, HttpServletResponse, String)}.
	 * </p>
	 */
	protected RemoteCallRequestHandler(HttpServletRequest request, HttpServletResponse response, String encoding) throws IllegalArgumentException, UnhandlableException {
		super(request, response, encoding);
	}

	@Override
	public void performTask() throws UnhandlableException, IOException {

		// Parses the request content.
		String uri = null;
		String name = null;
		String method = null;
		List params = null;

		try {
			Map data = JsonUtils.parse(request.getInputStream(), Map.class);
			uri = Validate.notNull((String) data.get(CURRENT_PAGE_URI_DATA_KEY), "No page URI info in the request");
			name = Validate.notNull((String) data.get(REMOTE_PROXY_NAME_DATA_KEY), "No remote proxy info in the request");
			method = Validate.notNull((String) data.get(WEB_METHOD_NAME_DATA_KEY), "No web method info in the request");
			params = Validate.notNull((List) data.get(INPUT_ARGUMENTS_DATA_KEY), "No arguments data in the request");

		} catch (Exception ex) {
			String message = StringUtils.trimToEmpty(ex.getMessage());

			throw new UnhandlableException(HttpServletResponse.SC_BAD_REQUEST, message.length() == 0 ? "Invalid data format detected" : message, ex);
		}

		// Finds the remote proxy metadata.
		RemoteProxyMetadata metadata = null;
		Object instance = null;

		try {
			metadata = MessageServlet.getByClassName(name).getValue();
			instance = metadata.getTargetClass().newInstance();

		} catch (Exception ex) {
			throw new UnhandlableException(HttpServletResponse.SC_BAD_REQUEST, "Cannot find the remote proxy metadata: " + name);
		}

		// Finds the web method.
		Method webMethod = null;

		try {
			webMethod = Validate.notNull(metadata.getWebMethod(method), "Cannot find the web method: " + method);

		} catch (Exception ex) {
			String message = StringUtils.trimToEmpty(ex.getMessage());

			throw new UnhandlableException(HttpServletResponse.SC_BAD_REQUEST, message.length() == 0 ? "Invalid data format detected" : message, ex);
		}

		// Binds a thread for current page URI.
		MessageServlet.setCurrentPageUriThread(uri);

		// Exceptions could be handled now.
		String content = null;

		try {
			Class[] argumentTypes = webMethod.getParameterTypes();
			int expectedCount = argumentTypes.length;
			int actualCount = params.size();

			if (expectedCount != actualCount) {
				throw new JsonDeserializationException("Argument(s) count does not match, expected: " + expectedCount + ", actual: " + actualCount);
			}

			Object[] arguments = new Object[expectedCount];

			for (int i = 0; i < arguments.length; i += 1) {
				Object item = params.get(i);
				Class type = argumentTypes[i];

				try {
					String json = JsonUtils.stringify(item);
					arguments[i] = JsonUtils.parse(json, type);

				} catch (Exception ex) {
					throw new JsonDeserializationException("Failed to convert argument[" + i + "] to specific Java type: " + type.getName(), (ex instanceof JsonSerializationException || ex instanceof JsonDeserializationException) ? ex.getCause() : ex);
				}
			}

			Object data = webMethod.invoke(instance, arguments);

			try {
				Result result = new Result(data);
				content = JsonUtils.stringify(result);

			} catch (Exception ex) {
				throw new JsonSerializationException("Failed to serialize the result", ex);
			}

		} catch (Exception ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			LOGGER.warn("Failed to process the remote call, try to lookup exception handlers", ex);

			Throwable initialCause = getRootCause(ex);
			Method exceptionHandler = metadata.getExceptionHandler(initialCause);

			if (exceptionHandler == null) {
				LOGGER.info("No mapped exception handler found", ex);

				Fault fault = new Fault(initialCause);
				content = JsonUtils.stringify(fault);

			} else {
				LOGGER.info("Attempt to resolve with exception handler", ex);

				try {
					Object data = exceptionHandler.invoke(instance, (Exception) initialCause);
					Fault fault = new Fault(initialCause, data);
					content = JsonUtils.stringify(fault);

				} catch (Exception e) {
					response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					Throwable nestedCause = new UnhandlableException(e.getClass().equals(JsonSerializationException.class) ? "Failed to serialize the fault for the exception handler" : "An exception has been thrown in the exception handler", e);
					LOGGER.error(nestedCause.getMessage(), e);

					Fault fault = new Fault(nestedCause);
					content = JsonUtils.stringify(fault);
				}
			}
		}

		IoUtils.responseText(response, content);
	}

	private Throwable getRootCause(Exception ex) {

		if (ex.getClass().equals(InvocationTargetException.class)) {
			InvocationTargetException e = (InvocationTargetException) ex;

			return e.getTargetException();
		}

		return ex;
	}
}
