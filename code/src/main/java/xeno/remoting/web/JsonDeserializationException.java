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

/**
 * <p>
 * An exception to be thrown when error occurs during deserializing a JSON
 * string to the object.
 * </p>
 * 
 * @author Kai Feng
 */
@SuppressWarnings("serial")
public class JsonDeserializationException extends IOException {

	/**
	 * <p>
	 * Please see {@link java.io.IOException#IOException(String)}.
	 * </p>
	 */
	public JsonDeserializationException(String message) {
		super(message);
	}

	/**
	 * <p>
	 * Please see {@link java.io.IOException#IOException(String, Throwable)}.
	 * </p>
	 */
	public JsonDeserializationException(String message, Throwable cause) {
		super(message, cause);
	}
}
