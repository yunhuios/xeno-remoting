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

import java.util.Collection;

/**
 * <p>
 * An interface for client side to execute JavaScript.
 * </p>
 * 
 * @author Kai Feng
 */
public interface JavaScriptCallback {

	/**
	 * <p>
	 * Invokes client side JavaScript functions.
	 * </p>
	 * 
	 * @param functions
	 *            The JavaScript functions, cannot be null. And all items in the
	 *            array also cannot be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "functions" is null. Or thrown when any item
	 *             in the "functions" is null.
	 */
	public void invoke(JavaScriptFunction... functions) throws IllegalArgumentException;

	/**
	 * <p>
	 * Please see
	 * {@link xeno.remoting.web.JavaScriptCallback#invoke(JavaScriptFunction...)}
	 * with the {@link java.util.Collection} type argument.
	 * </p>
	 */
	public void invoke(Collection<JavaScriptFunction> functions) throws IllegalArgumentException;

	/**
	 * <p>
	 * Invokes a single JavaScript function.
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
	public void invoke(String name, Object... arguments) throws IllegalArgumentException;
}
