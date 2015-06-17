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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * A wrapped {@link javax.servlet.http.HttpServletRequest} object, integrated
 * and encapsulated the original HTTP Servlet request methods. This object just
 * provides those methods which are most frequently using in the web
 * application, you could call method
 * {@link xeno.remoting.web.Request#getOriginalHttpServletRequest()} to get the
 * original HTTP Servlet request instance you are current using.
 * </p>
 * 
 * @author Kai Feng
 */
public class Request {
	private HttpServletRequest request = null;

	Request(HttpServletRequest request) throws IllegalArgumentException {
		Validate.notNull(request, "The 'request' is null");

		this.request = request;
	}

	/**
	 * <p>
	 * Returns the original HTTP Servlet request instance you are current using.
	 * Because the feature of the AJAX based web application, stream data
	 * (handled by the {@link xeno.remoting.web.MessageServlet} during each
	 * request), traditional URL dispatch (No any URL redirect or dispatch), or
	 * status reset (override by the {@link xeno.remoting.web.MessageServlet}
	 * during each response) will no longer keep behaviors as before.
	 * </p>
	 * 
	 * @return The object, never be null.
	 */
	public HttpServletRequest getOriginalHttpServletRequest() {
		return request;
	}

	/**
	 * <p>
	 * Please see
	 * {@link javax.servlet.http.HttpServletRequest#getCharacterEncoding()}.
	 * </p>
	 */
	public String getCharacterEncoding() {
		return request.getCharacterEncoding();
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpServletRequest#getContextPath()}.
	 * </p>
	 */
	public String getContextPath() {
		return request.getContextPath();
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpServletRequest#getServerName()}.
	 * </p>
	 */
	public String getServerName() {
		return request.getServerName();
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpServletRequest#getServerPort()}.
	 * </p>
	 */
	public int getServerPort() {
		return request.getServerPort();
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpServletRequest#getLocalName()}.
	 * </p>
	 */
	public String getLocalName() {
		return request.getLocalName();
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpServletRequest#getLocalAddr()}.
	 * </p>
	 */
	public String getLocalAddress() {
		return request.getLocalAddr();
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpServletRequest#getLocalPort()}.
	 * </p>
	 */
	public int getLocalPort() {
		return request.getLocalPort();
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpServletRequest#getRemoteHost()}.
	 * </p>
	 */
	public String getRemoteHost() {
		return request.getRemoteHost();
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpServletRequest#getRemoteAddr()}.
	 * </p>
	 */
	public String getRemoteAddress() {
		return request.getRemoteAddr();
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpServletRequest#getRemotePort()}.
	 * </p>
	 */
	public int getRemotePort() {
		return request.getRemotePort();
	}

	/**
	 * <p>
	 * Please see
	 * {@link javax.servlet.http.HttpServletRequest#getAttribute(String)}.
	 * </p>
	 */
	public Object getAttribute(String name) {
		return request.getAttribute(name);
	}

	/**
	 * <p>
	 * Please see
	 * {@link javax.servlet.http.HttpServletRequest#setAttribute(String, Object)}
	 * .
	 * </p>
	 */
	public void setAttribute(String name, Object value) {
		request.setAttribute(name, value);
	}

	/**
	 * <p>
	 * Please see
	 * {@link javax.servlet.http.HttpServletRequest#removeAttribute(String)}.
	 * </p>
	 */
	public void removeAttribute(String name) {
		request.removeAttribute(name);
	}

	/**
	 * <p>
	 * Please see
	 * {@link javax.servlet.http.HttpServletRequest#getAttributeNames()} but
	 * return string array in this method.
	 * </p>
	 */
	public String[] getAttributeNames() {
		List<String> n = new ArrayList<String>();
		Enumeration<String> e = request.getAttributeNames();

		if (e != null) {

			while (e.hasMoreElements()) {
				n.add(e.nextElement());
			}
		}

		return n.toArray(new String[n.size()]);
	}

	/**
	 * <p>
	 * Please see
	 * {@link javax.servlet.http.HttpServletRequest#getHeader(String)}.
	 * </p>
	 */
	public String getHeader(String name) {
		return request.getHeader(name);
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpServletRequest#getHeaderNames()}
	 * but return string array in this method.
	 * </p>
	 */
	public String[] getHeaderNames() {
		List<String> n = new ArrayList<String>();
		Enumeration<String> e = request.getHeaderNames();

		if (e != null) {

			while (e.hasMoreElements()) {
				n.add(e.nextElement());
			}
		}

		return n.toArray(new String[n.size()]);
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpServletRequest#getCookies()}.
	 * </p>
	 */
	public Cookie[] getCookies() {
		Cookie[] c = request.getCookies();

		return c == null ? new Cookie[0] : c;
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpServletRequest#getLocale()}.
	 * </p>
	 */
	public Locale getLocale() {
		return request.getLocale();
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpServletRequest#getLocales()} but
	 * return locale array in this method.
	 * </p>
	 */
	public Locale[] getLocales() {
		List<Locale> n = new ArrayList<Locale>();
		Enumeration<Locale> e = request.getLocales();

		if (e != null) {

			while (e.hasMoreElements()) {
				n.add(e.nextElement());
			}
		}

		return n.toArray(new Locale[n.size()]);
	}
}
