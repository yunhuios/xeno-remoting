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
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class RemoteProxyRequestHandler extends StaticRequestHandler {
	private static final String[][] DICTS = new String[][] { { "&", "&amp;" }, { "<", "&lt;" }, { ">", "&gt;" }, { "'", "&#39;" }, { "\"", "&quot;" }, { " ", "&nbsp;" } };

	/**
	 * <p>
	 * The path info.
	 * </p>
	 */
	public static final String PATH_INFO = "/index.htm";

	/**
	 * <p>
	 * Please see
	 * {@link xeno.remoting.web.RequestHandler#RequestHandler(HttpServletRequest, HttpServletResponse, String)}
	 * .
	 * </p>
	 */
	protected RemoteProxyRequestHandler(HttpServletRequest request, HttpServletResponse response, String encoding) throws IllegalArgumentException, UnhandlableException {
		super(request, response, encoding);
	}

	@Override
	public void performTask() throws UnhandlableException, IOException {
		StringBuffer content = new StringBuffer();
		content.append("<!doctype html>\n");
		content.append("<html>\n");
		content.append("\t<head>\n");
		content.append("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
		content.append("\t\t<title>Available Remote Proxies</title>\n");
		content.append("\t\t<style>\n");
		content.append("\t\t\t.empty-item { color: #999999; }\n");
		content.append("\t\t\t.class-item { margin-top: 10px; padding: 5px; border: 1px dotted #999999; }\n");
		content.append("\t\t\t.class-name { display: block; font-weight: bold; color: #0000FF; }\n");
		content.append("\t\t</style>\n");
		content.append("\t</head>\n");
		content.append("\t<body>\n");

		content.append("\t\t<h1>All available remote proxies are listing as below:</h1>\n");

		List<RemoteProxyMetadata> metadatas = MessageServlet.getAvailableRemoteProxyMetadatas();

		if (!metadatas.isEmpty()) {

			for (RemoteProxyMetadata metadata : metadatas) {
				content.append("\t\t<div class=\"class-item\">\n");
				content.append("\t\t\t<span class=\"class-name\">" + metadata.getName() + "</span>\n");

				Method[] methods = metadata.getWebMethods();

				if (methods.length > 0) {
					content.append("\t\t\t<ul>\n");

					for (Method method : methods) {
						content.append("\t\t\t\t<li>" + encode(method.toGenericString()) + "</li>\n");
					}

					content.append("\t\t\t</ul>\n");

				} else {
					content.append("\t\t\t<p class=\"empty-item\">No web method found.</p>\n");
				}

				content.append("\t\t</div>\n");
			}

		} else {
			content.append("\t\t<p class=\"empty-item\">No remote proxy found.</p>\n");
		}

		content.append("\t</body>\n");
		content.append("</html>");

		IoUtils.responseText(response, StringUtils.trimToEmpty(content.toString()));
	}

	private String encode(String value) {
		String out = value.replaceAll(", ", ",").replaceAll(",", ", ");

		for (String[] item : DICTS) {
			out = out.replaceAll(item[0], item[1]);
		}

		return out;
	}
}
