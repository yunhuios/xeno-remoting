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
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import com.yahoo.platform.yui.compressor.JavaScriptCompressor;

class JavaScriptUtils {
	private static final String OPTION_NAME = "opts";

	/**
	 * <p>
	 * Minifies the JavaScript content.
	 * </p>
	 * 
	 * @param content
	 *            The content, null will be converted into an empty string.
	 * 
	 * @return The string, never be null.
	 * 
	 * @throws IOException
	 *             Thrown when any error occurs during the operation.
	 */
	public static String minifyContent(String content) throws IOException {
		Reader input = null;
		Writer output = null;

		try {
			input = new StringReader(content == null ? "" : content);
			output = new StringWriter();

			JavaScriptCompressor operator = new JavaScriptCompressor(input, null);
			operator.compress(output, -1, true, false, false, false);

			return output.toString();

		} finally {
			IoUtils.closeQuietly(output, input);
		}
	}

	/**
	 * <p>
	 * Generates the JavaScript arguments by count provides, zero or negative
	 * value will return an empty string.
	 * </p>
	 * 
	 * @param count
	 *            The arguments count.
	 * @param flag
	 *            The flag determines generated code form.
	 * 
	 * @return The string.
	 */
	public static String toArguments(int count, boolean flag) {
		StringBuffer s = new StringBuffer();

		for (int i = 0; i < count; i += 1) {
			s.append(", arg" + i);
		}

		String result = s.length() > 0 ? s.substring(2) : s.toString();

		if (flag) {
			return result.length() > 0 ? result + ", " + OPTION_NAME : OPTION_NAME;

		} else {
			return "[" + result + "], " + OPTION_NAME;
		}
	}
}
