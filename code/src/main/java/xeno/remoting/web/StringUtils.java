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
import java.util.Arrays;
import java.util.List;

class StringUtils {

	/**
	 * <p>
	 * Tests whether the input string is blank or not.
	 * </p>
	 * 
	 * @param s
	 *            The string.
	 * 
	 * @return The boolean.
	 */
	public static boolean isBlank(String s) {
		return s == null || s.trim().length() == 0;
	}

	/**
	 * <p>
	 * Tests whether the input string is not blank or not.
	 * </p>
	 * 
	 * @param s
	 *            The string.
	 * 
	 * @return The boolean.
	 */
	public static boolean isNotBlank(String s) {
		return !isBlank(s);
	}

	/**
	 * <p>
	 * Tests whether the input string is empty or not.
	 * </p>
	 * 
	 * @param s
	 *            The string.
	 * 
	 * @return The boolean.
	 */
	public static boolean isEmpty(String s) {
		return s == null || s.length() == 0;
	}

	/**
	 * <p>
	 * Tests whether the input string is not empty or not.
	 * </p>
	 * 
	 * @param s
	 *            The string.
	 * 
	 * @return The boolean.
	 */
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}

	/**
	 * <p>
	 * Trims a string, if result is blank, a null returns.
	 * </p>
	 * 
	 * @param s
	 *            The string.
	 * 
	 * @return The string.
	 */
	public static String trimToNull(String s) {
		return isBlank(s) ? null : s.trim();
	}

	/**
	 * <p>
	 * Trims a string, if result is blank, an empty string returns.
	 * </p>
	 * 
	 * @param s
	 *            The string.
	 * 
	 * @return The string.
	 */
	public static String trimToEmpty(String s) {
		return isBlank(s) ? "" : s.trim();
	}

	/**
	 * <p>
	 * Removes the specific string from a string's start position.
	 * </p>
	 * 
	 * @param s
	 *            The string.
	 * @param r
	 *            The specific string.
	 * 
	 * @return The string.
	 */
	public static String removeStart(String s, String r) {

		if (isEmpty(s) || isEmpty(r)) {
			return s;
		}

		if (!s.startsWith(r)) {
			return s;
		}

		return s.substring(r.length());
	}

	/**
	 * <p>
	 * Removes the specific string from a string's end position.
	 * </p>
	 * 
	 * @param s
	 *            The string.
	 * @param r
	 *            The specific string.
	 * 
	 * @return The string.
	 */
	public static String removeEnd(String s, String r) {

		if (isEmpty(s) || isEmpty(r)) {
			return s;
		}

		if (!s.endsWith(r)) {
			return s;
		}

		return s.substring(0, s.lastIndexOf(r));
	}

	/**
	 * <p>
	 * Splits input string according to the separators provide and trim each
	 * item, and filters blank & duplicated items.
	 * </p>
	 * 
	 * @param s
	 *            The string.
	 * @param separators
	 *            The separators, null or empty string item will be ignored.
	 * 
	 * @return An array to contain the result, never be null.
	 */
	public static String[] splitItems(String s, String... separators) {

		if (isBlank(s)) {
			return new String[0];
		}

		if (separators == null) {
			return new String[] { trimToEmpty(s) };
		}

		List<String> fixedSeparators = new ArrayList<String>();

		for (String item : separators) {

			if (item != null && item.length() != 0 && !fixedSeparators.contains(item)) {
				fixedSeparators.add(item);
			}
		}

		if (fixedSeparators.isEmpty()) {
			return new String[] { trimToEmpty(s) };
		}

		List<String> r = new ArrayList<String>();
		List<String> a = new ArrayList<String>();
		List<String> b = new ArrayList<String>();

		b.add(s);

		for (String item : fixedSeparators) {

			for (String i : b) {
				a.addAll(Arrays.asList(i.split(item)));
			}

			b.clear();
			b.addAll(a);
			a.clear();
		}

		for (String item : b) {
			String i = trimToNull(item);

			if (i != null && !r.contains(i)) {
				r.add(i);
			}
		}

		return r.toArray(new String[r.size()]);
	}
}
