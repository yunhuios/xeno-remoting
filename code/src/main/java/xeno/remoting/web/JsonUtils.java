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

import java.io.InputStream;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

class JsonUtils {
	private static final ObjectMapper JSON = new ObjectMapper();

	static {
		JSON.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * <p>
	 * Stringify a Java object into a JSON string.
	 * </p>
	 * 
	 * @param obj
	 *            The object.
	 * 
	 * @return The string.
	 * 
	 * @throws JsonSerializationException
	 *             Thrown when any error occurs during the serialization.
	 */
	public static String stringify(Object obj) throws JsonSerializationException {

		try {
			return JSON.writeValueAsString(obj);

		} catch (Exception ex) {
			throw new JsonSerializationException("Failed to stringify the object: " + obj, ex);
		}
	}

	/**
	 * <p>
	 * Parse a JSON string into a Java object.
	 * </p>
	 * 
	 * @param str
	 *            The string
	 * @param type
	 *            The type, cannot be null.
	 * 
	 * @return The object.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "type" is null.
	 * @throws JsonDeserializationException
	 *             Thrown when any error occurs during the deserialization.
	 */
	public static <T> T parse(String str, Class<T> type) throws IllegalArgumentException, JsonDeserializationException {
		Validate.notNull(type, "The 'type' is null");

		if (str == null) {
			return null;
		}

		try {
			return JSON.readValue(str, type);

		} catch (Exception ex) {
			throw new JsonDeserializationException("Failed to parse the string: " + str, ex);
		}
	}

	/**
	 * <p>
	 * Parse a JSON stream into a Java object.
	 * </p>
	 * 
	 * @param in
	 *            The input stream.
	 * @param type
	 *            The type, cannot be null.
	 * 
	 * @return The object.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "type" is null.
	 * @throws JsonDeserializationException
	 *             Thrown when any error occurs during the deserialization.
	 */
	public static <T> T parse(InputStream in, Class<T> type) throws IllegalArgumentException, JsonDeserializationException {
		Validate.notNull(type, "The 'type' is null");

		if (in == null) {
			return null;
		}

		try {
			return JSON.readValue(in, type);

		} catch (Exception ex) {
			throw new JsonDeserializationException("Failed to parse the stream: " + in, ex);
		}
	}
}
