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

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class IoUtils {
	private static final Log LOGGER = LogFactory.getLog(IoUtils.class);
	private static final int BUFFER_SIZE = 1024 * 4;

	/**
	 * <p>
	 * Copies input stream to output.
	 * </p>
	 * 
	 * @param in
	 *            The input stream, cannot be null.
	 * @param out
	 *            The output stream, cannot be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "in" or the "out" is null.
	 * @throws IOException
	 *             Thrown when error occurs during the copy.
	 */
	public static void copyContent(Reader in, Writer out) throws IllegalArgumentException, IOException {
		Validate.notNull(in, "The 'in' is null");
		Validate.notNull(out, "The 'out' is null");

		int n = 0;
		char[] b = new char[BUFFER_SIZE];

		while ((n = in.read(b)) != -1) {
			out.write(b, 0, n);
		}
	}

	/**
	 * <p>
	 * Closes streams quietly even if any of them are null or in illegal states.
	 * </p>
	 * 
	 * @param closeables
	 *            The closeable array objects.
	 */
	public static void closeQuietly(Closeable... closeables) {

		if (closeables != null) {

			for (Closeable item : closeables) {

				try {

					if (item != null) {
						item.close();
					}

				} catch (Exception ex) {
					LOGGER.debug("Failed to close target item", ex);
				}
			}
		}
	}

	/**
	 * <p>
	 * Writes out content.
	 * </p>
	 * 
	 * @param response
	 *            The Servlet response, cannot be null.
	 * @param content
	 *            The content.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "response" is null.
	 * @throws IOException
	 *             Thrown when any error occurs during the export.
	 */
	public static void responseText(ServletResponse response, String content) throws IllegalArgumentException, IOException {
		Validate.notNull(response, "The 'response' is null");

		Reader input = null;
		Writer output = null;

		try {
			input = new StringReader(content == null ? "" : content);
			output = response.getWriter();
			copyContent(input, output);

		} finally {
			closeQuietly(output, input);
		}
	}
}
