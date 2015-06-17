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
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class RequestHandler {

	/**
	 * <p>
	 * The HTTP Servlet request.
	 * </p>
	 */
	protected HttpServletRequest request = null;

	/**
	 * <p>
	 * The HTTP Servlet response.
	 * </p>
	 */
	protected HttpServletResponse response = null;

	/**
	 * <p>
	 * The path info.
	 * </p>
	 */
	protected String pathInfo = null;

	/**
	 * <p>
	 * The class constructor.
	 * </p>
	 * 
	 * @param request
	 *            The HTTP Servlet request, cannot be null.
	 * @param response
	 *            The HTTP Servlet response, cannot be null.
	 * @return encoding
	 *         The encoding, cannot be null.
	 * @param contentType
	 *            The HTTP content type, cannot be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "request" or the "response" or the "encoding"
	 *             or the "contentType" is null.
	 * @throws UnhandlableException
	 *             Thrown when unable to handle the request.
	 */
	protected RequestHandler(HttpServletRequest request, HttpServletResponse response, String encoding, String contentType) throws IllegalArgumentException, UnhandlableException {
		Validate.notNull(request, "The 'request' is null");
		Validate.notNull(response, "The 'response' is null");
		Validate.notNull(encoding, "The 'encoding' is null");
		Validate.notNull(contentType, "The 'contentType' is null");

		try {
			this.request = request;
			this.response = response;
			this.pathInfo = request.getPathInfo();

			this.request.setCharacterEncoding(encoding);
			this.response.setCharacterEncoding(encoding);
			this.response.setContentType(contentType);
			this.response.setStatus(HttpServletResponse.SC_OK);

		} catch (UnsupportedEncodingException ex) {
			throw new UnhandlableException("Unsupported character encoding: " + encoding, ex);
		}
	}

	/**
	 * <p>
	 * Performs the task.
	 * </p>
	 * 
	 * @throws UnhandlableException
	 *             Thrown when unable to handle the request.
	 * @throws IOException
	 *             Thrown when I/O error occurs during the string content
	 *             export.
	 */
	public abstract void performTask() throws UnhandlableException, IOException;
}
