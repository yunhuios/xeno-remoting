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

import java.util.Collection;

/**
 * <p>
 * An object to locate the specific client for calling JavaScript functions. To
 * call client side JavaScript success, you should provide session ID or page
 * URI, these two items are following below rules:
 * </p>
 * <ul>
 * <li>Session ID - This is the same value of
 * {@link javax.servlet.http.HttpSession#getId()}, you could get your current
 * session thread from
 * {@link xeno.remoting.web.MessageServlet#getCurrentHttpSessionThread()} and
 * then get the session ID.</li>
 * <li>Page URI - This is the value comes from the browser address bar, and
 * start after your application context path. For an example, if current URL is
 * "http://www.abc.com:8030/testapp/account/list#bookmark?p1=1&p2=a", and
 * "testapp" is the context path of this application deployed, then the page URI
 * will be "/account/list".</li>
 * </ul>
 * 
 * @author Kai Feng
 */
public class Browser {

	/**
	 * <p>
	 * Returns the callback for the specific client by session ID and page URI
	 * provided.
	 * </p>
	 * 
	 * @param sessionId
	 *            The session ID, cannot be null.
	 * @param pageUri
	 *            The page URI, cannot be null.
	 * 
	 * @return The callback, never be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "sessionId" or the "pageUri" is null.
	 */
	public static JavaScriptCallback with(String sessionId, String pageUri) throws IllegalArgumentException {
		// Validate.notNull(sessionId, "The 'sessionId' is null");
		// Validate.notNull(pageUri, "The 'pageUri' is null");

		return new SingleNotificationJavaScriptCallback(sessionId, pageUri);
	}

	/**
	 * <p>
	 * Returns the callback for all clients.
	 * </p>
	 * 
	 * @return The callback, never be null.
	 */
	public static JavaScriptCallback withAll() {
		return new BroadcastJavaScriptCallback();
	}

	/**
	 * <p>
	 * Returns the callback for specific clients by the page URI provided. All
	 * sessions matches this page URI will be invoked.
	 * </p>
	 * 
	 * @param pageUri
	 *            The page URI, cannot be null.
	 * 
	 * @return The callback, never be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "pageUri" is null.
	 */
	public static JavaScriptCallback withPage(String pageUri) throws IllegalArgumentException {
		Validate.notNull(pageUri, "The 'pageUri' is null");

		return withPages(new String[] { pageUri });
	}

	/**
	 * <p>
	 * Returns the callback for specific clients by page URIs provided. All
	 * sessions matches these page URIs will be invoked.
	 * </p>
	 * 
	 * @param pageUris
	 *            The page URIs, cannot be null. And all items in the
	 *            array also cannot be null.
	 * 
	 * @return The callback, never be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "pageUris" is null. Or thrown when any item
	 *             in the "pageUris" is null.
	 */
	public static JavaScriptCallback withPages(String... pageUris) throws IllegalArgumentException {
		// Validate.notNull(pageUris, "The 'pageUris' is null", "The 'pageUris[index]' is null");

		return new PageFilteredJavaScriptCallback(pageUris);
	}

	/**
	 * <p>
	 * Please see {@link xeno.remoting.web.Browser#withPages(String...)} with
	 * the {@link java.util.Collection} type argument.
	 * </p>
	 */
	public static JavaScriptCallback withPages(Collection<String> pageUris) throws IllegalArgumentException {
		// Validate.notNull(pageUris, "The 'pageUris' is null");

		try {
			return withPages(pageUris.toArray(new String[pageUris.size()]));

		} catch (NullPointerException ex) {
			throw new IllegalArgumentException("The 'pageUris' is null");
		}
	}

	/**
	 * <p>
	 * Returns the callback for specific clients by the session ID provided. All
	 * pages matches this session ID will be invoked.
	 * </p>
	 * 
	 * @param sessionId
	 *            The session ID, cannot be null.
	 * 
	 * @return The callback, never be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "sessionId" is null.
	 */
	public static JavaScriptCallback withSession(String sessionId) throws IllegalArgumentException {
		Validate.notNull(sessionId, "The 'sessionId' is null");

		return withSessions(new String[] { sessionId });
	}

	/**
	 * <p>
	 * Returns the callback for specific clients by session IDs provided. All
	 * pages matches these session IDs will be invoked.
	 * </p>
	 * 
	 * @param sessionIds
	 *            The session IDs, cannot be null. And all items in the
	 *            array also cannot be null.
	 * 
	 * @return The callback, never be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "sessionIds" is null. Or thrown when any item
	 *             in the "sessionIds" is null.
	 */
	public static JavaScriptCallback withSessions(String... sessionIds) throws IllegalArgumentException {
		// Validate.notNull(sessionIds, "The 'sessionIds' is null", "The 'sessionIds[index]' is null");

		return new SessionFilteredJavaScriptCallback(sessionIds);
	}

	/**
	 * <p>
	 * Please see {@link xeno.remoting.web.Browser#withSessions(String...)} with
	 * the {@link java.util.Collection} type argument.
	 * </p>
	 */
	public static JavaScriptCallback withSessions(Collection<String> sessionIds) throws IllegalArgumentException {
		// Validate.notNull(sessionIds, "The 'sessionIds' is null");

		try {
			return withSessions(sessionIds.toArray(new String[sessionIds.size()]));

		} catch (NullPointerException ex) {
			throw new IllegalArgumentException("The 'sessionIds' is null");
		}
	}
}
