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

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * A wrapped {@link javax.servlet.http.HttpServletResponse} object, integrated
 * and encapsulated the original HTTP Servlet response methods. This object just
 * provides those methods which are most frequently using in the web
 * application, you could call method
 * {@link xeno.remoting.web.Response#getOriginalHttpServletResponse()} to get
 * the original HTTP Servlet response instance you are current using.
 * </p>
 * 
 * @author Kai Feng
 */
public class Response {
	private HttpServletResponse response = null;

	Response(HttpServletResponse response) throws IllegalArgumentException {
		Validate.notNull(response, "The 'response' is null");

		this.response = response;
	}

	/**
	 * <p>
	 * Returns the original HTTP Servlet response instance you are current
	 * using. Because the feature of the AJAX based web application, stream data
	 * (handled by the {@link xeno.remoting.web.MessageServlet} during each
	 * request), traditional URL dispatch (No any URL redirect or dispatch), or
	 * status reset (override by the {@link xeno.remoting.web.MessageServlet}
	 * during each response) will no longer keep behaviors as before.
	 * </p>
	 * 
	 * @return The object, never be null.
	 */
	public HttpServletResponse getOriginalHttpServletResponse() {
		return response;
	}

	/**
	 * <p>
	 * Please see
	 * {@link javax.servlet.http.HttpServletResponse#getCharacterEncoding()}.
	 * </p>
	 */
	public String getCharacterEncoding() {
		return response.getCharacterEncoding();
	}

	/**
	 * <p>
	 * Please see
	 * {@link javax.servlet.http.HttpServletResponse#addCookie(Cookie)}.
	 * </p>
	 */
	public void addCookie(Cookie cookie) {
		response.addCookie(cookie);
	}

	/**
	 * <p>
	 * Please see
	 * {@link javax.servlet.http.HttpServletResponse#setHeader(String, String)}.
	 * </p>
	 */
	public void setHeader(String name, String value) {
		response.setHeader(name, value);
	}

	/**
	 * <p>
	 * Please see
	 * {@link javax.servlet.http.HttpServletResponse#containsHeader(String)}.
	 * </p>
	 */
	public boolean containsHeader(String name) {
		return response.containsHeader(name);
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpServletResponse#getLocale()}.
	 * </p>
	 */
	public Locale getLocale() {
		return response.getLocale();
	}

	/**
	 * <p>
	 * Please see
	 * {@link javax.servlet.http.HttpServletResponse#setLocale(Locale)}.
	 * </p>
	 */
	public void setLocale(Locale locale) {
		response.setLocale(locale);
	}
}
