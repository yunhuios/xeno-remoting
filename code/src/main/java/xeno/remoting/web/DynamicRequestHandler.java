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

abstract class DynamicRequestHandler extends RequestHandler {

	/**
	 * <p>
	 * The request suffix.
	 * </p>
	 */
	public static final String REQUEST_SUFFIX = ".do";

	/**
	 * <p>
	 * The content type.
	 * </p>
	 */
	public static final String CONTENT_TYPE = "application/json";

	/**
	 * <p>
	 * The current page URI data key.
	 * </p>
	 */
	public static final String CURRENT_PAGE_URI_DATA_KEY = "uri";

	/**
	 * <p>
	 * Please see
	 * {@link xeno.remoting.web.RequestHandler#RequestHandler(HttpServletRequest, HttpServletResponse, String)}.
	 * </p>
	 */
	protected DynamicRequestHandler(HttpServletRequest request, HttpServletResponse response, String encoding) throws IllegalArgumentException, UnhandlableException {
		super(request, response, encoding, CONTENT_TYPE);
	}

	/**
	 * <p>
	 * Returns dynamic request handler.
	 * </p>
	 *
	 * @param request
	 *            The HTTP Servlet request, cannot be null.
	 * @param response
	 *            The HTTP Servlet response, cannot be null.
	 * @return encoding
	 *         The encoding, cannot be null.
	 * 
	 * @return The dynamic request handler, never be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "request" or the "response" or the "encoding"
	 *             is null.
	 * @throws UnhandlableException
	 *             Thrown when any other exception occurs.
	 */
	public static DynamicRequestHandler get(HttpServletRequest request, HttpServletResponse response, String encoding) throws IllegalArgumentException, UnhandlableException {
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

			if (pathInfo.equals(RemoteCallRequestHandler.PATH_INFO)) {
				return new RemoteCallRequestHandler(request, response, encoding);

			} else if (pathInfo.equals(ReverseAjaxRequestHandler.PATH_INFO)) {
				return new ReverseAjaxRequestHandler(request, response, encoding);
			}
		}

		throw new UnhandlableException("Unable to handle the dynamic request: " + pathInfo);
	}
}
