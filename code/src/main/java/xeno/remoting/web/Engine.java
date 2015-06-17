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
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.HashMap;

@SuppressWarnings("rawtypes")
class Engine extends RemoteProxyMetadata {

	/**
	 * <p>
	 * The class name.
	 * </p>
	 */
	public static final String CLASS_NAME = Engine.class.getName();

	/**
	 * <p>
	 * The class constructor.
	 * </p>
	 * 
	 * @param encoding
	 *            The encoding, cannot be null.
	 * @param obfuscate
	 *            A flag to decide whether the generated JavaScript string
	 *            content is minified or not.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "encoding" is null.
	 * @throws IOException
	 *             Thrown when any error occurs during the JavaScript content's
	 *             generation.
	 */
	public Engine(String encoding, boolean obfuscate) throws IllegalArgumentException, IOException {
		Validate.notNull(encoding, "The 'encoding' is null");

		targetClass = getClass();
		webMethods = new HashMap<String, Method>();
		exceptionHandlers = new HashMap<Class, Method>();

		Reader input = null;
		Writer output = null;

		try {
			input = new InputStreamReader(targetClass.getResourceAsStream("/xeno/remoting/web/Engine.js"), encoding);
			output = new StringWriter();
			IoUtils.copyContent(input, output);

			String contextPath = StringUtils.trimToEmpty(MessageServlet.getWebApplicationServletContext().getContextPath());

			// Replaces variables to real values in the JavaScript.
			String content = output.toString().replace("${Param.Value.ContentType}", DynamicRequestHandler.CONTENT_TYPE + ";charset=" + MessageServlet.getCharacterEncoding());
			content = content.replace("${Param.Value.ContextPath}", contextPath);
			content = content.replace("${Param.Value.RemoteCallRequestUrl}", contextPath + MessageServlet.SERVLET_PATH + RemoteCallRequestHandler.PATH_INFO);
			content = content.replace("${Param.Value.ReverseAjaxRequestUrl}", contextPath + MessageServlet.SERVLET_PATH + ReverseAjaxRequestHandler.PATH_INFO);
			content = content.replace("${Param.Value.UnhandlableException}", UnhandlableException.class.getName());
			content = content.replace("\"${Param.Value.ReverseAjaxMaxRetryCount}\"", String.valueOf(MessageServlet.getReverseAjaxMaxRetryCount()));
			content = content.replace("\"${Param.DataKey.CurrentPageUri}\"", DynamicRequestHandler.CURRENT_PAGE_URI_DATA_KEY);
			content = content.replace("\"${Param.DataKey.RemoteProxyName}\"", RemoteCallRequestHandler.REMOTE_PROXY_NAME_DATA_KEY);
			content = content.replace("\"${Param.DataKey.WebMethodName}\"", RemoteCallRequestHandler.WEB_METHOD_NAME_DATA_KEY);
			content = content.replace("\"${Param.DataKey.InputArguments}\"", RemoteCallRequestHandler.INPUT_ARGUMENTS_DATA_KEY);

			javascriptContent = StringUtils.trimToEmpty(obfuscate ? JavaScriptUtils.minifyContent(content) : content);

		} finally {
			IoUtils.closeQuietly(output, input);
		}
	}
}
