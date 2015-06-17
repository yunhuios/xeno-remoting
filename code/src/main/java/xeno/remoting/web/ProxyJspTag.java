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
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * The "proxy" JSP custom tag.
 * </p>
 * 
 * @author Kai Feng
 */
@SuppressWarnings("serial")
public class ProxyJspTag extends BodyTagSupport {
	private static final Log LOGGER = LogFactory.getLog(ProxyJspTag.class);
	private static Pattern NAMESPACE_REGEX = Pattern.compile("^[_$a-z][_$0-9a-z]*(\\.[_$a-z][_$0-9a-z]*)*$", Pattern.CASE_INSENSITIVE);

	private boolean excludeEngineClass = false;

	@Override
	public int doEndTag() throws JspException {
		BodyContent content = getBodyContent();

		try {
			List<KeyValue<Integer, RemoteProxyMetadata>> imports = parseContent(content == null ? "" : StringUtils.trimToEmpty(content.getString()));

			if (!excludeEngineClass) {

				if (MessageServlet.isIncludeJsonLibrary()) {
					imports.add(0, MessageServlet.getByClassName(Json2.CLASS_NAME));
					imports.add(1, MessageServlet.getByClassName(Engine.CLASS_NAME));

				} else {
					imports.add(0, MessageServlet.getByClassName(Engine.CLASS_NAME));
				}
			}

			exportHtml(MessageServlet.getWebApplicationServletContext().getContextPath() + MessageServlet.SERVLET_PATH, imports, MessageServlet.isDebugMode(), pageContext.getOut());

			return EVAL_PAGE;

		} catch (Exception ex) {
			LOGGER.error("Failed to do the tag operation", ex);

			throw new JspException(ex);
		}
	}

	void exportHtml(String path, List<KeyValue<Integer, RemoteProxyMetadata>> imports, boolean debug, Writer output) throws IllegalArgumentException, IOException {
		Validate.notNull(path, "The 'path' is null");
		Validate.notNull(imports, "The 'imports' is null");
		Validate.notNull(output, "The 'output' is null");

		List<String> links = new ArrayList<String>();

		if (debug) {

			for (KeyValue<Integer, RemoteProxyMetadata> item : imports) {
				links.add("/" + item.getValue().getName() + StaticRequestHandler.REQUEST_SUFFIX);
			}

		} else {
			StringBuffer shortcut = new StringBuffer();

			for (KeyValue<Integer, RemoteProxyMetadata> item : imports) {
				shortcut.append("-" + item.getKey());
			}

			if (shortcut.length() > 0) {
				links.add(BatchJavaScriptRequestHandler.PATH_INFO_PREFIX + shortcut.toString().substring(1) + StaticRequestHandler.REQUEST_SUFFIX + "?t=" + new Date().getTime());
			}
		}

		StringBuffer html = new StringBuffer();

		for (String item : links) {
			String source = path.trim() + item;

			html.append("<script type=\"text/javascript\" src=\"" + source.replaceFirst("//", "/") + "\"></script>\n");
		}

		if (html.length() > 0) {
			output.write(StringUtils.removeEnd(html.toString(), "\n"));
		}
	}

	List<KeyValue<Integer, RemoteProxyMetadata>> parseContent(String content) throws IllegalArgumentException, ParseException, ClassNotFoundException {
		Validate.notNull(content, "The 'content' is null");

		Set<String> importItems = new HashSet<String>();
		Set<KeyValue<Integer, RemoteProxyMetadata>> foundItems = new HashSet<KeyValue<Integer, RemoteProxyMetadata>>();
		String separator = UUID.randomUUID().toString();
		String[] lineData = StringUtils.splitItems(content, "\n");

		// Splits line data, trims comments, extracts import items.
		for (String data : lineData) {

			if (!data.startsWith("//")) {
				String value = data;
				int index = value.indexOf("//");

				if (index > 0) {
					value = value.substring(0, index).trim();
				}

				String fakeValue = value.replace(";", ";" + separator);
				importItems.addAll(Arrays.asList(StringUtils.splitItems(fakeValue, separator)));
			}
		}

		// Validates import items, collects remote proxy metadata.
		for (String item : importItems) {

			if (!(item.startsWith("import ") && item.endsWith(";"))) {
				throw new ParseException("Syntax error on token: " + item, -1);
			}

			String value = StringUtils.removeEnd(StringUtils.removeStart(item, "import "), ";").trim();

			if (value.endsWith(".*")) {
				String packageName = StringUtils.removeEnd(value, ".*");

				if (!NAMESPACE_REGEX.matcher(packageName).find()) {
					throw new ParseException("Invalid package name on token: " + value, -1);
				}

				Set<KeyValue<Integer, RemoteProxyMetadata>> results = MessageServlet.findByPackageName(packageName);

				if (results == null) {
					throw new ClassNotFoundException("No remote proxy metadata found for the package: " + packageName);
				}

				foundItems.addAll(results);

			} else {

				if (!NAMESPACE_REGEX.matcher(value).find()) {
					throw new ParseException("Invalid class name on token: " + value, -1);
				}

				KeyValue<Integer, RemoteProxyMetadata> result = MessageServlet.getByClassName(value);

				if (result == null) {
					throw new ClassNotFoundException("No remote proxy metadata found for the class: " + value);
				}

				foundItems.add(result);
			}
		}

		List<KeyValue<Integer, RemoteProxyMetadata>> ret = new ArrayList<KeyValue<Integer, RemoteProxyMetadata>>(foundItems);

		Collections.sort(ret, new Comparator<KeyValue<Integer, RemoteProxyMetadata>>() {

			@Override
			public int compare(KeyValue<Integer, RemoteProxyMetadata> o1, KeyValue<Integer, RemoteProxyMetadata> o2) {
				String n1 = o1.getValue().getName();
				String n2 = o2.getValue().getName();

				return n1.compareTo(n2);
			}
		});

		return ret;
	}

	// ------------------------------------------------------------
	// Below method(s) for the JSP custom tag uses only.
	// Marked as "@Deprecated" to prevent be called externally.
	// ------------------------------------------------------------

	@Deprecated
	public void setExcludeEngineClass(boolean excludeEngineClass) {
		this.excludeEngineClass = excludeEngineClass;
	}
}
