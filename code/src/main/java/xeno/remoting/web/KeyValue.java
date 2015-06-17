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

@SuppressWarnings("rawtypes")
class KeyValue<K, V> {
	private K key = null;
	private V value = null;

	/**
	 * <p>
	 * The class constructor.
	 * </p>
	 * 
	 * @param key
	 *            The key, cannot be null.
	 * @param value
	 *            The value, cannot be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "key" or the "value" is null.
	 */
	public KeyValue(K key, V value) throws IllegalArgumentException {
		Validate.notNull(key, "The 'key' is null");
		Validate.notNull(value, "The 'value' is null");

		this.key = key;
		this.value = value;
	}

	/**
	 * <p>
	 * Returns the key.
	 * </p>
	 * 
	 * @return The key, never be null.
	 */
	public K getKey() {
		return key;
	}

	/**
	 * <p>
	 * Returns the value.
	 * </p>
	 * 
	 * @return The value, never be null.
	 */
	public V getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		KeyValue that = (KeyValue) obj;

		return key.equals(that.key);
	}

	@Override
	public int hashCode() {
		return key.hashCode();
	}

	@Override
	public String toString() {
		return key + "=" + value;
	}
}