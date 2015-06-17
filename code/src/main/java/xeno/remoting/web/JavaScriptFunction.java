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

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This is a JavaScript function object.
 * </p>
 * 
 * @author Kai Feng
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class JavaScriptFunction {
	private String name = null;
	private List arguments = null;

	/**
	 * <p>
	 * The class constructor.
	 * </p>
	 * 
	 * @param name
	 *            The function name, cannot be null.
	 * @param arguments
	 *            The arguments.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "name" is null.
	 */
	public JavaScriptFunction(String name, Object... arguments) throws IllegalArgumentException {
		Validate.notNull(name, "The 'name' is null");

		this.name = name;
		this.arguments = new ArrayList();

		if (arguments == null) {
			this.arguments.add(null);

		} else {

			for (Object obj : arguments) {
				this.arguments.add(obj);
			}
		}
	}

	/**
	 * <p>
	 * Returns the function name.
	 * </p>
	 * 
	 * @return The string, never be null.
	 */
	public String getName() {
		return name;
	}

	/**
	 * <p>
	 * Returns the arguments.
	 * </p>
	 * 
	 * @return The array, never be null.
	 */
	public Object[] getArguments() {
		return arguments.toArray(new Object[arguments.size()]);
	}
}
