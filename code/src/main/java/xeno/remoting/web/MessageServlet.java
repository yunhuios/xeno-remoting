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

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * A Servlet handling requests from the client side, encapsulating request &
 * response data into JSON string, calling methods of the server side directly.
 * </p>
 * 
 * @author Kai Feng
 */
@WebListener
@SuppressWarnings("serial")
public class MessageServlet extends ConfigurationServlet implements HttpSessionListener {
	private static final Log LOGGER = LogFactory.getLog(MessageServlet.class);
	private static final ReverseAjaxThreadPool REVERSE_AJAX_THREAD_POOL = new ReverseAjaxThreadPool();
	private static final ThreadLocal<HttpServletRequest> CURRENT_REQUESTS_THREAD = new ThreadLocal<HttpServletRequest>();
	private static final ThreadLocal<HttpServletResponse> CURRENT_RESPONSES_THREAD = new ThreadLocal<HttpServletResponse>();
	private static final ThreadLocal<String> CURRENT_PAGE_URIS_THREAD = new ThreadLocal<String>();

	static final String SERVLET_PATH = "/xr";

	/**
	 * <p>
	 * Returns the client HTTP request thread of current using.
	 * </p>
	 * 
	 * @return The HTTP request, never be null.
	 * 
	 * @throws IllegalStateException
	 *             Thrown when the HTTP request is in illegal state.
	 */
	public static Request getCurrentHttpRequestThread() throws IllegalStateException {

		try {
			return Validate.notNull(new Request(CURRENT_REQUESTS_THREAD.get()), "No bound HTTP request thread found");

		} catch (Exception ex) {
			throw new IllegalStateException("Illegal HTTP request state", ex);
		}
	}

	/**
	 * <p>
	 * Returns the client HTTP response thread of current using.
	 * </p>
	 * 
	 * @return The HTTP response, never be null.
	 * 
	 * @throws IllegalStateException
	 *             Thrown when the HTTP response is in illegal state.
	 */
	public static Response getCurrentHttpResponseThread() throws IllegalStateException {

		try {
			return Validate.notNull(new Response(CURRENT_RESPONSES_THREAD.get()), "No bound HTTP response thread found");

		} catch (Exception ex) {
			throw new IllegalStateException("Illegal HTTP response state", ex);
		}
	}

	/**
	 * <p>
	 * Returns the client HTTP session thread of current using.
	 * </p>
	 * 
	 * @return The HTTP session, never be null.
	 * 
	 * @throws IllegalStateException
	 *             Thrown when the HTTP session is in illegal state.
	 */
	public static Session getCurrentHttpSessionThread() throws IllegalStateException {

		try {
			return Validate.notNull(new Session(CURRENT_REQUESTS_THREAD.get().getSession()), "No bound HTTP session thread found");

		} catch (Exception ex) {
			throw new IllegalStateException("Illegal HTTP session state", ex);
		}
	}

	/**
	 * <p>
	 * Returns the client page URI (excluded context path & Servlet path) thread
	 * of current using.
	 * </p>
	 * 
	 * @return The string, never be null.
	 * 
	 * @throws IllegalStateException
	 *             Thrown when the page is in illegal state.
	 */
	public static String getCurrentPageUriThread() throws IllegalStateException {

		try {
			return Validate.notNull(CURRENT_PAGE_URIS_THREAD.get(), "No bound page URI thread found");

		} catch (Exception ex) {
			throw new IllegalStateException("Illegal page URI state", ex);
		}
	}

	static ReverseAjaxThreadPool getReverseAjaxThreadPool() {
		return REVERSE_AJAX_THREAD_POOL;
	}

	@Override
	public void sessionCreated(HttpSessionEvent evt) {
		// Does nothing.
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent evt) {
		String sessionId = evt.getSession().getId();
		LOGGER.debug("Start to clean up unused session ID: " + sessionId);

		REVERSE_AJAX_THREAD_POOL.removeBySessionIds(sessionId);
		LOGGER.debug("Complete to clean up unused session ID: " + sessionId);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			registerRemoteProxyMetadata(new Json2(getCharacterEncoding(), !isDebugMode()));
			registerRemoteProxyMetadata(new Engine(getCharacterEncoding(), !isDebugMode()));

		} catch (Exception ex) {
			LOGGER.fatal("Failed to initialize the Servlet for handling requests", ex);

			throw new ServletException(ex);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			CURRENT_REQUESTS_THREAD.set(request);
			CURRENT_RESPONSES_THREAD.set(response);

			DynamicRequestHandler.get(request, response, getCharacterEncoding()).performTask();

		} catch (UnhandlableException ex) {
			LOGGER.error(ex.getMessage(), ex);

			response.setStatus(ex.getStatusCode());
			IoUtils.responseText(response, JsonUtils.stringify(new Fault(ex)));
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			StaticRequestHandler.get(request, response, getCharacterEncoding()).performTask();

		} catch (UnhandlableException ex) {
			LOGGER.error(ex.getMessage(), ex);

			response.setStatus(ex.getStatusCode());
			IoUtils.responseText(response, "// " + ex.getMessage());
		}
	}

	static void setCurrentPageUriThread(String pageUri) {
		CURRENT_PAGE_URIS_THREAD.set(pageUri);
	}
}
