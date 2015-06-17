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

class SingleNotificationJavaScriptCallback extends AbstractJavaScriptCallback {
	private String sessionId = null;
	private String pageUri = null;

	/**
	 * <p>
	 * The class construtcor.
	 * </p>
	 * 
	 * @param sessionId
	 *            The session ID, cannot be null.
	 * @param pageUri
	 *            The page URI, cannot be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "sessionId" or the "pageUri" is null.
	 */
	public SingleNotificationJavaScriptCallback(String sessionId, String pageUri) throws IllegalArgumentException {
		Validate.notNull(sessionId, "The 'sessionId' is null");
		Validate.notNull(pageUri, "The 'pageUri' is null");

		this.sessionId = sessionId;
		this.pageUri = pageUri;
	}

	@Override
	public void invoke(JavaScriptFunction... functions) throws IllegalArgumentException {
		// Validate.notNull(functions, "The 'functions' is null", "The 'functions[index]' is null");

		invokeAsync(MessageServlet.getReverseAjaxThreadPool().get(sessionId, pageUri), functions);
	}

	/**
	 * <p>
	 * Returns the session ID.
	 * </p>
	 * 
	 * @return The string, never be null.
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * <p>
	 * Returns the page URI.
	 * </p>
	 * 
	 * @return The string, never be null.
	 */
	public String getPageUri() {
		return pageUri;
	}
}
