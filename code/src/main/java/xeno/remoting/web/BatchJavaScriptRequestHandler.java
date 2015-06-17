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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class BatchJavaScriptRequestHandler extends StaticRequestHandler {

	/**
	 * <p>
	 * The path info prefix.
	 * </p>
	 */
	public static final String PATH_INFO_PREFIX = "/combined-";

	/**
	 * <p>
	 * Please see
	 * {@link xeno.remoting.web.RequestHandler#RequestHandler(HttpServletRequest, HttpServletResponse, String)}.
	 * </p>
	 */
	protected BatchJavaScriptRequestHandler(HttpServletRequest request, HttpServletResponse response, String encoding) throws IllegalArgumentException, UnhandlableException {
		super(request, response, encoding);
	}

	@Override
	public void performTask() throws UnhandlableException, IOException {
		StringBuffer content = new StringBuffer();

		try {
			String shortcut = StringUtils.removeEnd(StringUtils.removeStart(pathInfo, PATH_INFO_PREFIX), REQUEST_SUFFIX);
			String[] indices = StringUtils.splitItems(shortcut, "-");

			for (String i : indices) {

				try {
					int index = Integer.parseInt(i);
					RemoteProxyMetadata metadata = MessageServlet.getByClassIndex(index).getValue();

					content.append(metadata.getJavaScriptContent() + "\n");

				} catch (NumberFormatException ex) {
					throw new UnhandlableException(HttpServletResponse.SC_BAD_REQUEST, "Invalid mapping index for the request: " + pathInfo + ", index: " + i, ex);

				} catch (NullPointerException ex) {
					throw new UnhandlableException(HttpServletResponse.SC_NOT_FOUND, "No mapping index for the request: " + pathInfo + ", index: " + i, ex);
				}
			}

		} catch (UnhandlableException ex) {
			throw ex;

		} catch (Exception ex) {
			throw new UnhandlableException("Error occurs for the request: " + pathInfo, ex);
		}

		IoUtils.responseText(response, StringUtils.trimToEmpty(content.toString()));
	}
}
