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

import javax.servlet.http.HttpSession;

/**
 * <p>
 * A wrapped {@link javax.servlet.http.HttpSession} object, integrated and
 * encapsulated the original HTTP session methods. This object just provides
 * those methods which are most frequently using in the web application, you
 * could call method {@link xeno.remoting.web.Session#getOriginalHttpSession()}
 * to get the original HTTP session instance you are current using.
 * </p>
 * 
 * @author Kai Feng
 */
public class Session {
	private HttpSession session = null;

	Session(HttpSession session) throws IllegalArgumentException {
		Validate.notNull(session, "The 'session' is null");

		this.session = session;
	}

	/**
	 * <p>
	 * Returns the original HTTP session instance you are current using. Because
	 * the feature of the AJAX based web application, stream data (handled by
	 * the {@link xeno.remoting.web.MessageServlet} during each request),
	 * traditional URL dispatch (No any URL redirect or dispatch), or status
	 * reset (override by the {@link xeno.remoting.web.MessageServlet} during
	 * each response) will no longer keep behaviors as before.
	 * </p>
	 * 
	 * @return The object, never be null.
	 */
	public HttpSession getOriginalHttpSession() {
		return session;
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpSession#getId()}.
	 * </p>
	 */
	public String getId() throws IllegalStateException {
		return session.getId();
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpSession#getCreationTime()}.
	 * </p>
	 */
	public long getFirstCreatedTime() throws IllegalStateException {
		return session.getCreationTime();
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpSession#getLastAccessedTime()}.
	 * </p>
	 */
	public long getLastAccessedTime() throws IllegalStateException {
		return session.getLastAccessedTime();
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpSession#invalidate()}.
	 * </p>
	 */
	public void invalidate() throws IllegalStateException {
		session.invalidate();
	}

	/**
	 * <p>
	 * Please see
	 * {@link javax.servlet.http.HttpSession#getMaxInactiveInterval()}.
	 * </p>
	 */
	public int getMaxInactiveInterval() {
		return session.getMaxInactiveInterval();
	}

	/**
	 * <p>
	 * Please see
	 * {@link javax.servlet.http.HttpSession#setMaxInactiveInterval(int)}.
	 * </p>
	 */
	public void setMaxInactiveInterval(int interval) {
		session.setMaxInactiveInterval(interval);
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpSession#getAttribute(String)}.
	 * </p>
	 */
	public Object getAttribute(String name) throws IllegalStateException {
		return session.getAttribute(name);
	}

	/**
	 * <p>
	 * Please see
	 * {@link javax.servlet.http.HttpSession#setAttribute(String, Object)}.
	 * </p>
	 */
	public void setAttribute(String name, Object value) throws IllegalStateException {
		session.setAttribute(name, value);
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpSession#removeAttribute(String)}.
	 * </p>
	 */
	public void removeAttribute(String name) throws IllegalStateException {
		session.removeAttribute(name);
	}

	/**
	 * <p>
	 * Please see {@link javax.servlet.http.HttpSession#getAttributeNames()} but
	 * return string array in this method.
	 * </p>
	 */
	public String[] getAttributeNames() throws IllegalStateException {
		List<String> n = new ArrayList<String>();
		Enumeration<String> e = session.getAttributeNames();

		if (e != null) {

			while (e.hasMoreElements()) {
				n.add(e.nextElement());
			}
		}

		return n.toArray(new String[n.size()]);
	}
}
