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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.AsyncContext;

class ReverseAjaxThreadPool {
	private Map<String, Map<String, Set<AsyncContext>>> dictSessionIdToPageUri = new HashMap<String, Map<String, Set<AsyncContext>>>();
	private Map<String, Map<String, Set<AsyncContext>>> dictPageUriToSessionId = new HashMap<String, Map<String, Set<AsyncContext>>>();

	/**
	 * <p>
	 * Adds an asynchronous context into the pool.
	 * </p>
	 * 
	 * @param sessionId
	 *            The session ID, cannot be null.
	 * @param pageUri
	 *            The page URI, cannot be null.
	 * @param asyncContext
	 *            The asynchronous context, cannot be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "sessionId" or the "pageUri" or the
	 *             "asyncContext" is null.
	 */
	public synchronized void add(String sessionId, String pageUri, AsyncContext asyncContext) throws IllegalArgumentException {
		Validate.notNull(sessionId, "The 'sessionId' is null");
		Validate.notNull(pageUri, "The 'pageUri' is null");
		Validate.notNull(asyncContext, "The 'asyncContext' is null");

		String fixedPageUri = getFixedPageUri(pageUri);

		add(sessionId, fixedPageUri, asyncContext, dictSessionIdToPageUri);
		add(fixedPageUri, sessionId, asyncContext, dictPageUriToSessionId);
	}

	/**
	 * <p>
	 * Removes an asynchronous context from the pool.
	 * </p>
	 * 
	 * @param sessionId
	 *            The session ID, cannot be null.
	 * @param pageUri
	 *            The page URI, cannot be null.
	 * @param asyncContext
	 *            The asynchronous context, cannot be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "sessionId" or the "pageUri" or the
	 *             "asyncContext" is null.
	 */
	public synchronized void remove(String sessionId, String pageUri, AsyncContext asyncContext) throws IllegalArgumentException {
		Validate.notNull(sessionId, "The 'sessionId' is null");
		Validate.notNull(pageUri, "The 'pageUri' is null");
		Validate.notNull(asyncContext, "The 'asyncContext' is null");

		String fixedPageUri = getFixedPageUri(pageUri);

		remove(sessionId, fixedPageUri, asyncContext, dictSessionIdToPageUri);
		remove(fixedPageUri, sessionId, asyncContext, dictPageUriToSessionId);
	}

	/**
	 * <p>
	 * Removes an asynchronous context from the pool.
	 * </p>
	 * 
	 * @param sessionId
	 *            The session ID, cannot be null.
	 * @param pageUri
	 *            The page URI, cannot be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "sessionId" or the "pageUri" is null.
	 */
	public synchronized void remove(String sessionId, String pageUri) throws IllegalArgumentException {
		Validate.notNull(sessionId, "The 'sessionId' is null");
		Validate.notNull(pageUri, "The 'pageUri' is null");

		String fixedPageUri = getFixedPageUri(pageUri);

		remove(sessionId, fixedPageUri, dictSessionIdToPageUri);
		remove(fixedPageUri, sessionId, dictPageUriToSessionId);
	}

	/**
	 * <p>
	 * Removes a set of asynchronous contexts from the pool by session IDs.
	 * </p>
	 * 
	 * @param sessionIds
	 *            The session IDs, cannot be null. And all items in the
	 *            array also cannot be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "sessionIds" is null. Or thrown when any item
	 *             in the "sessionIds" is null.
	 */
	public synchronized void removeBySessionIds(String... sessionIds) throws IllegalArgumentException {
		Validate.notNull(sessionIds, "The 'sessionIds' is null", "The 'sessionIds[index]' is null");

		Set<String> inputs = convertToSet(sessionIds);

		for (String sessionId : inputs) {
			removeByKey(sessionId, dictSessionIdToPageUri, dictPageUriToSessionId);
		}
	}

	/**
	 * <p>
	 * Removes a set of asynchronous contexts from the pool by page URIs.
	 * </p>
	 * 
	 * @param pageUris
	 *            The page URIs, cannot be null. And all items in the
	 *            array also cannot be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "pageUris" is null. Or thrown when any item
	 *             in the "pageUris" is null.
	 */
	public synchronized void removeByPageUris(String... pageUris) throws IllegalArgumentException {
		Validate.notNull(pageUris, "The 'pageUris' is null", "The 'pageUris[index]' is null");

		Set<String> inputs = convertToSet(pageUris);

		for (String pageUri : inputs) {
			String fixedPageUri = getFixedPageUri(pageUri);

			removeByKey(fixedPageUri, dictPageUriToSessionId, dictSessionIdToPageUri);
		}
	}

	/**
	 * <p>
	 * Removes all asynchronous contexts in the pool.
	 * </p>
	 */
	public synchronized void removeAll() {
		dictSessionIdToPageUri.clear();
		dictPageUriToSessionId.clear();
	}

	/**
	 * <p>
	 * Returns a set of asynchronous contexts in the pool by the session ID and
	 * the page URI.
	 * </p>
	 * 
	 * @param sessionId
	 *            The session ID, cannot be null.
	 * @param pageUri
	 *            The page URI, cannot be null.
	 * 
	 * @return A set of asynchronous contexts, never be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "sessionId" or the "pageUri" is null.
	 */
	public synchronized Set<AsyncContext> get(String sessionId, String pageUri) throws IllegalArgumentException {
		Validate.notNull(sessionId, "The 'sessionId' is null");
		Validate.notNull(pageUri, "The 'pageUri' is null");

		String fixedPageUri = getFixedPageUri(pageUri);

		// return get(sessionId, fixedPageUri, dictSessionIdToPageUri);
		return get(fixedPageUri, sessionId, dictPageUriToSessionId);
	}

	/**
	 * <p>
	 * Returns a set of asynchronous contexts in the pool by session IDs.
	 * </p>
	 * 
	 * @param sessionIds
	 *            The session IDs, cannot be null. And all items in the
	 *            array also cannot be null.
	 * 
	 * @return A set of asynchronous contexts, never be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "sessionIds" is null. Or thrown when any item
	 *             in the "sessionIds" is null.
	 */
	public synchronized Set<AsyncContext> getBySessionIds(String... sessionIds) throws IllegalArgumentException {
		Validate.notNull(sessionIds, "The 'sessionIds' is null", "The 'sessionIds[index]' is null");

		Set<String> inputs = convertToSet(sessionIds);
		Set<AsyncContext> results = new HashSet<AsyncContext>();

		for (String sessionId : inputs) {
			results.addAll(getByKey(sessionId, dictSessionIdToPageUri));
		}

		return results;
	}

	/**
	 * <p>
	 * Returns a set of asynchronous contexts in the pool by page URIs.
	 * </p>
	 * 
	 * @param pageUris
	 *            The page URIs, cannot be null. And all items in the
	 *            array also cannot be null.
	 * 
	 * @return A set of asynchronous contexts, never be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "pageUris" is null. Or thrown when any item
	 *             in the "pageUris" is null.
	 */
	public synchronized Set<AsyncContext> getByPageUris(String... pageUris) throws IllegalArgumentException {
		Validate.notNull(pageUris, "The 'pageUris' is null", "The 'pageUris[index]' is null");

		Set<String> inputs = convertToSet(pageUris);
		Set<AsyncContext> results = new HashSet<AsyncContext>();

		for (String pageUri : inputs) {
			String fixedPageUri = getFixedPageUri(pageUri);

			results.addAll(getByKey(fixedPageUri, dictPageUriToSessionId));
		}

		return results;
	}

	/**
	 * <p>
	 * Returns all asynchronous contexts in the pool.
	 * </p>
	 * 
	 * @return A set of asynchronous contexts, never be null.
	 */
	public synchronized Set<AsyncContext> getAll() {
		// return getAll(dictSessionIdToPageUri);
		return getAll(dictPageUriToSessionId);
	}

	private synchronized void add(String majorKey, String minorKey, AsyncContext asyncContext, Map<String, Map<String, Set<AsyncContext>>> dataMap) {
		Map<String, Set<AsyncContext>> majorDataMapFound = dataMap.get(majorKey);

		if (majorDataMapFound == null) {
			majorDataMapFound = new HashMap<String, Set<AsyncContext>>();
			dataMap.put(majorKey, majorDataMapFound);
		}

		Set<AsyncContext> minorDataMapFound = majorDataMapFound.get(minorKey);

		if (minorDataMapFound == null) {
			minorDataMapFound = new HashSet<AsyncContext>();
			majorDataMapFound.put(minorKey, minorDataMapFound);
		}

		minorDataMapFound.add(asyncContext);
	}

	private synchronized void remove(String majorKey, String minorKey, AsyncContext asyncContext, Map<String, Map<String, Set<AsyncContext>>> dataMap) {
		Map<String, Set<AsyncContext>> majorDataMapFound = dataMap.get(majorKey);

		if (majorDataMapFound != null) {
			Set<AsyncContext> minorDataMapFound = majorDataMapFound.get(minorKey);

			if (minorDataMapFound != null) {
				minorDataMapFound.remove(asyncContext);

				if (minorDataMapFound.isEmpty()) {
					majorDataMapFound.remove(minorKey);
				}
			}

			if (majorDataMapFound.isEmpty()) {
				dataMap.remove(majorKey);
			}
		}
	}

	private synchronized void remove(String majorKey, String minorKey, Map<String, Map<String, Set<AsyncContext>>> dataMap) {
		Map<String, Set<AsyncContext>> majorDataMapFound = dataMap.get(majorKey);

		if (majorDataMapFound != null) {
			majorDataMapFound.remove(minorKey);

			if (majorDataMapFound.isEmpty()) {
				dataMap.remove(majorKey);
			}
		}
	}

	private synchronized void removeByKey(String key, Map<String, Map<String, Set<AsyncContext>>> majorDataMap, Map<String, Map<String, Set<AsyncContext>>> minorDataMap) {
		Map<String, Set<AsyncContext>> majorDataMapFound = majorDataMap.get(key);

		if (majorDataMapFound != null) {
			Set<String> minorKeys = majorDataMapFound.keySet();

			for (String minorKey : minorKeys) {
				Map<String, Set<AsyncContext>> minorDataMapFound = minorDataMap.get(minorKey);

				if (minorDataMapFound != null) {
					minorDataMapFound.remove(key);

					if (minorDataMapFound.isEmpty()) {
						minorDataMap.remove(minorKey);
					}
				}
			}
		}

		majorDataMap.remove(key);
	}

	private synchronized Set<AsyncContext> get(String majorKey, String minorKey, Map<String, Map<String, Set<AsyncContext>>> dataMap) {
		Map<String, Set<AsyncContext>> majorDataMapFound = dataMap.get(majorKey);

		if (majorDataMapFound == null) {
			return new HashSet<AsyncContext>();
		}

		Set<AsyncContext> minorDataMapFound = majorDataMapFound.get(minorKey);

		if (minorDataMapFound == null) {
			return new HashSet<AsyncContext>();
		}

		return minorDataMapFound;
	}

	private synchronized Set<AsyncContext> getByKey(String key, Map<String, Map<String, Set<AsyncContext>>> dataMap) {
		Set<AsyncContext> results = new HashSet<AsyncContext>();

		Map<String, Set<AsyncContext>> majorDataMapFound = dataMap.get(key);

		if (majorDataMapFound != null) {
			Collection<Set<AsyncContext>> minorDataMapValues = majorDataMapFound.values();

			for (Set<AsyncContext> minorDataMapFound : minorDataMapValues) {
				results.addAll(minorDataMapFound);
			}
		}

		return results;
	}

	private synchronized Set<AsyncContext> getAll(Map<String, Map<String, Set<AsyncContext>>> dataMap) {
		Set<AsyncContext> results = new HashSet<AsyncContext>();

		Collection<Map<String, Set<AsyncContext>>> majorDataMapValues = dataMap.values();

		for (Map<String, Set<AsyncContext>> majorDataMapFound : majorDataMapValues) {
			Collection<Set<AsyncContext>> minorDataMapValues = majorDataMapFound.values();

			for (Set<AsyncContext> minorDataMapFound : minorDataMapValues) {
				results.addAll(minorDataMapFound);
			}
		}

		return results;
	}

	private String getFixedPageUri(String pageUri) {
		return StringUtils.removeEnd(pageUri, "/");
	}

	private Set<String> convertToSet(String[] items) {
		return new HashSet<String>(Arrays.asList(items));
	}
}
