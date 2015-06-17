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

class Validate {

	/**
	 * <p>
	 * Ensures the object is not null.
	 * </p>
	 * 
	 * @param o
	 *            The object to be validated.
	 * @param m
	 *            The message of the thrown
	 *            {@link java.lang.IllegalArgumentException} to be carried on
	 *            when validation failed.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the validation failed.
	 */
	public static <T> T notNull(T o, String m) throws IllegalArgumentException {
		check(o != null, m);

		return o;
	}

	/**
	 * <p>
	 * Ensures the array is not null, and all its direct sub elements are also
	 * not null.
	 * </p>
	 * 
	 * @param a
	 *            The array to be validated.
	 * @param m
	 *            The message of the thrown
	 *            {@link java.lang.IllegalArgumentException} to be carried on
	 *            when the array is null.
	 * @param e
	 *            The message of the thrown
	 *            {@link java.lang.IllegalArgumentException} to be carried on
	 *            when any direct sub element is null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the validation failed.
	 */
	public static <T> T[] notNull(T[] a, String m, String e) throws IllegalArgumentException {
		// Validate.notNull(a, m);

		try {

			for (int i = 0; i < a.length; i += 1) {
				check(a[i] != null, e != null ? e.replace("[index]", "[" + i + "]") : null);
			}

			return a;

		} catch (NullPointerException ex) {
			throw new IllegalArgumentException(m);
		}
	}

	/**
	 * <p>
	 * Please see
	 * {@link xeno.remoting.web.Validate#notNull(Object[], String, String)} with
	 * the {@link java.util.Collection} argument.
	 * </p>
	 */
	public static <T> Collection<T> notNull(Collection<T> c, String m, String e) throws IllegalArgumentException {
		// Validate.notNull(c, m);

		try {
			Validate.notNull(c.toArray(new Object[c.size()]), m, e);

		} catch (NullPointerException ex) {
			throw new IllegalArgumentException(m);
		}

		return c;
	}

	private static void check(boolean condition, String message) throws IllegalArgumentException {

		if (!condition) {
			throw new IllegalArgumentException(message);
		}
	}
}
