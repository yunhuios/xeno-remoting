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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class StaticRequestHandler extends RequestHandler {

	/**
	 * <p>
	 * The request suffix.
	 * </p>
	 */
	public static final String REQUEST_SUFFIX = ".js";

	/**
	 * <p>
	 * The content type.
	 * </p>
	 */
	public static final String CONTENT_TYPE = "text/html";

	/**
	 * <p>
	 * Please see
	 * {@link xeno.remoting.web.RequestHandler#RequestHandler(HttpServletRequest, HttpServletResponse, String)}.
	 * </p>
	 */
	protected StaticRequestHandler(HttpServletRequest request, HttpServletResponse response, String encoding) throws IllegalArgumentException, UnhandlableException {
		super(request, response, encoding, CONTENT_TYPE);
	}

	/**
	 * <p>
	 * Returns static request handler.
	 * </p>
	 *
	 * @param request
	 *            The HTTP Servlet request, cannot be null.
	 * @param response
	 *            The HTTP Servlet response, cannot be null.
	 * @return encoding
	 *         The encoding, cannot be null.
	 * 
	 * @return The static request handler, never be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "request" or the "response" or the "encoding"
	 *             is null.
	 * @throws UnhandlableException
	 *             Thrown when any other exception occurs.
	 */
	public static StaticRequestHandler get(HttpServletRequest request, HttpServletResponse response, String encoding) throws IllegalArgumentException, UnhandlableException {
		// Validate.notNull(request, "The 'request' is null");
		// Validate.notNull(response, "The 'response' is null");
		// Validate.notNull(encoding, "The 'encoding' is null");

		String pathInfo = null;

		try {
			pathInfo = request.getPathInfo();

		} catch (NullPointerException ex) {
			throw new IllegalArgumentException("The 'request' is null");
		}

		if (pathInfo.startsWith("/") && pathInfo.endsWith(REQUEST_SUFFIX)) {

			if (pathInfo.startsWith(BatchJavaScriptRequestHandler.PATH_INFO_PREFIX)) {
				return new BatchJavaScriptRequestHandler(request, response, encoding);

			} else {
				return MessageServlet.isDebugMode() ? new SingleJavaScriptRequestHandler(request, response, encoding) : new NonDebugModeRequestHandler(request, response, encoding);
			}

		} else if (pathInfo.equals(RemoteProxyRequestHandler.PATH_INFO)) {
			return MessageServlet.isDebugMode() ? new RemoteProxyRequestHandler(request, response, encoding) : new NonDebugModeRequestHandler(request, response, encoding);
		}

		throw new UnhandlableException("Unable to handle the static request: " + pathInfo);
	}
}
