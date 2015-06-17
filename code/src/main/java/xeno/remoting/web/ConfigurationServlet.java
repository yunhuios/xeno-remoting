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

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings({ "serial", "rawtypes" })
class ConfigurationServlet extends HttpServlet {
	private static final Log LOGGER = LogFactory.getLog(ConfigurationServlet.class);
	private static final Map<Integer, KeyValue<String, RemoteProxyMetadata>> INDEX_MAPPING_METADATA_DICT = new HashMap<Integer, KeyValue<String, RemoteProxyMetadata>>();
	private static final Map<String, KeyValue<Integer, RemoteProxyMetadata>> CLASS_MAPPING_METADATA_DICT = new HashMap<String, KeyValue<Integer, RemoteProxyMetadata>>();
	private static final Map<String, Set<KeyValue<Integer, RemoteProxyMetadata>>> PACKAGE_HIERARCHY_DICT = new HashMap<String, Set<KeyValue<Integer, RemoteProxyMetadata>>>();

	private static ServletContext servletContext = null;

	private static String characterEncoding = null;
	private static boolean includeJsonLibrary = false;
	private static boolean scanGlobalDependencies = false;
	private static boolean debugMode = false;
	private static int reverseAjaxMaxRetryCount = 0;
	private static long reverseAjaxIdleLiveTime = 0;

	private static Set<String> excludeClasses = null;
	private static boolean unitTestMode = false;

	static {
		excludeClasses = new HashSet<String>();
		excludeClasses.add("java.*");
		excludeClasses.add("javax.*");
		excludeClasses.add("javassist.*");
		excludeClasses.add("sun.*");
		excludeClasses.add("com.sun.*");
		excludeClasses.add("oracle.*");
		excludeClasses.add("com.oracle.*");
		excludeClasses.add("org.junit.*");
		excludeClasses.add("org.apache.*");
		excludeClasses.add("org.mozilla.*");
		excludeClasses.add("org.springframework.*");
		excludeClasses.add("org.hibernate.*");
		excludeClasses.add("org.jboss.*");
		excludeClasses.add("org.w3c.*");
		excludeClasses.add("org.dom4j.*");
		excludeClasses.add("org.slf4j.*");
		excludeClasses.add("org.aopalliance.*");
		excludeClasses.add("org.eclipse.*");
	}

	/**
	 * <p>
	 * Returns the way of characters encoding.
	 * </p>
	 * <p>
	 * This value could be set in the "web.xml" with the "init-param" node of
	 * this Servlet named as "characterEncoding", and the default value is:
	 * "UTF-8".
	 * </p>
	 * 
	 * @return A string.
	 */
	public static String getCharacterEncoding() {
		return characterEncoding;
	}

	/**
	 * <p>
	 * Returns whether this Servlet will take "json2.js" as an implementation or
	 * not.
	 * </p>
	 * <p>
	 * This value could be set in the "web.xml" with the "init-param" node of
	 * this Servlet named as "includeJsonLibrary", and the default value is:
	 * "false".
	 * </p>
	 * <p>
	 * If the value of this parameter sets to "true" (case insensitive), the
	 * content of "json2.js" will be exported. For some modern browsers (e.g.
	 * IE8+, Firefox, Chrome, etc.), JSON has already be implemented and embed
	 * in the browser. So if you ensure that end users are using such kind of
	 * browsers, there is no need to open this setting.
	 * </p>
	 * 
	 * @return A boolean.
	 */
	public static boolean isIncludeJsonLibrary() {
		return includeJsonLibrary;
	}

	/**
	 * <p>
	 * Returns whether this Servlet will scan global dependencies directory
	 * (e.g. for Apache Tomcat, <Installation Root>\lib) to find remote proxy
	 * classes.
	 * </p>
	 * <p>
	 * This value could be set in the "web.xml" with the "init-param" node of
	 * this Servlet named as "scanGlobalDependencies", and the default value is:
	 * "false".
	 * </p>
	 * <p>
	 * In most cases, you will not allow to put dependencies to that directory,
	 * so there is no need to take time to scan it.
	 * </p>
	 * 
	 * @return A boolean.
	 */
	public static boolean isScanGlobalDependencies() {
		return scanGlobalDependencies;
	}

	/**
	 * <p>
	 * Returns whether this Servlet will be startup in a debug mode or not.
	 * </p>
	 * <p>
	 * This value could be set in the "web.xml" with the "init-param" node of
	 * this Servlet named as "debugMode", and the default value is: "false".
	 * </p>
	 * If the value of this parameter sets to "true" (case insensitive), all
	 * JavaScripts generated by this Servlet will in a readable format. And you
	 * could use "<contextPath>/xr/index.htm" to see all available remote
	 * proxies. Otherwise, all JavaScripts generated by this Servlet will be
	 * minified to reduce the size.
	 * </p>
	 * 
	 * @return A boolean.
	 */
	public static boolean isDebugMode() {
		return debugMode;
	}

	/**
	 * <p>
	 * Returns the maximum continuous error retry count when the reverse AJAX
	 * thread failed.
	 * </p>
	 * <p>
	 * This value could be set in the "web.xml" with the "init-param" node of
	 * this Servlet named as "reverseAjaxMaxRetryCount", and the default value
	 * is: 0.
	 * </p>
	 * <p>
	 * If this value provides, the reverse AJAX thread will be stopped after
	 * specific continuous error retry count occurs to reduce the network
	 * traffic. 0 or less than 0 means unlimited retry count.
	 * </p>
	 * 
	 * @return An int.
	 */
	public static int getReverseAjaxMaxRetryCount() {
		return reverseAjaxMaxRetryCount;
	}

	/**
	 * <p>
	 * Returns the time (in millisecond) of idle reverse AJAX thread live.
	 * </p>
	 * <p>
	 * This value could be set in the "web.xml" with the "init-param" node of
	 * this Servlet named as "reverseAjaxIdleLiveTime", and the default value
	 * is: 0.
	 * </p>
	 * <p>
	 * If this value provides, each reverse AJAX thread will be aborted and
	 * setup a new request thread when there is no server side response occurs
	 * during this time period. 0 or less than 0 means unlimited idle live time.
	 * It is recommended this value should be set less than the session timeout
	 * to prevent the reverse AJAX to be inactivated automatically.
	 * </p>
	 * 
	 * @return A long.
	 */
	public static long getReverseAjaxIdleLiveTime() {
		return reverseAjaxIdleLiveTime;
	}

	/**
	 * <p>
	 * Returns the web application Servlet context object.
	 * </p>
	 * 
	 * @return The Servlet context, never be null.
	 * 
	 * @throws IllegalStateException
	 *             Thrown when the Servlet context has not been initialized.
	 */
	public static ServletContext getWebApplicationServletContext() throws IllegalStateException {

		if (servletContext == null) {
			throw new IllegalStateException("The Servlet context has not been initialized");
		}

		return servletContext;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		try {
			super.init(config);

			servletContext = config.getServletContext();

			// Retrieves initial parameters.
			String characterEncoding = config.getInitParameter("characterEncoding");
			String includeJsonLibrary = config.getInitParameter("includeJsonLibrary");
			String scanGlobalDependencies = config.getInitParameter("scanGlobalDependencies");
			String debugMode = config.getInitParameter("debugMode");
			String reverseAjaxMaxRetryCount = config.getInitParameter("reverseAjaxMaxRetryCount");
			String reverseAjaxIdleLiveTime = config.getInitParameter("reverseAjaxIdleLiveTime");
			ConfigurationServlet.characterEncoding = StringUtils.isNotEmpty(characterEncoding) ? characterEncoding.toUpperCase() : "UTF-8";
			ConfigurationServlet.includeJsonLibrary = "true".equalsIgnoreCase(includeJsonLibrary);
			ConfigurationServlet.scanGlobalDependencies = "true".equalsIgnoreCase(scanGlobalDependencies);
			ConfigurationServlet.debugMode = "true".equalsIgnoreCase(debugMode);
			ConfigurationServlet.reverseAjaxMaxRetryCount = fixValue(reverseAjaxMaxRetryCount);
			ConfigurationServlet.reverseAjaxIdleLiveTime = fixValue(reverseAjaxIdleLiveTime);
			LOGGER.debug("Configured the 'characterEncoding' parameter: " + characterEncoding + ", resolved the value to: " + getCharacterEncoding());
			LOGGER.debug("Configured the 'includeJsonLibrary' parameter: " + includeJsonLibrary + ", resolved the value to: " + isIncludeJsonLibrary());
			LOGGER.debug("Configured the 'scanGlobalDependencies' parameter: " + scanGlobalDependencies + ", resolved the value to: " + isScanGlobalDependencies());
			LOGGER.debug("Configured the 'debugMode' parameter: " + debugMode + ", resolved value to: " + isDebugMode());
			LOGGER.debug("Configured the 'reverseAjaxMaxRetryCount' parameter: " + reverseAjaxMaxRetryCount + ", resolved the value to: " + getReverseAjaxMaxRetryCount());
			LOGGER.debug("Configured the 'reverseAjaxIdleLiveTime' parameter: " + reverseAjaxIdleLiveTime + ", resolved the value to: " + getReverseAjaxIdleLiveTime());

			// Retrieves internal parameters.
			String excludeClasses = config.getInitParameter("excludeClasses");
			String unitTestMode = config.getInitParameter("unitTestMode");
			ConfigurationServlet.excludeClasses.addAll(Arrays.asList(StringUtils.splitItems(StringUtils.trimToEmpty(excludeClasses), ";")));
			ConfigurationServlet.unitTestMode = "true".equalsIgnoreCase(unitTestMode);

			// Prepares directories to scan remote proxy classes.
			File customClassesDirectory = new File(ConfigurationServlet.getWebApplicationServletContext().getRealPath("/"), "WEB-INF/classes");
			File webappJarsDirectory = new File(customClassesDirectory.getParentFile(), "lib");
			File globalJarsDirectory = new File(config.getClass().getResource("/").toURI());
			LOGGER.debug("Detected custom classes directory: " + customClassesDirectory);
			LOGGER.debug("Detected webapp JARs directory: " + webappJarsDirectory);
			LOGGER.debug("Detected global JARs directory: " + globalJarsDirectory);

			// Extracts remote proxy classes.
			Set<Class> classes = new HashSet<Class>();
			classes.addAll(RemoteProxyUtils.extractDirectly(customClassesDirectory, getExcludeClasses()));
			classes.addAll(RemoteProxyUtils.extractFromJars(webappJarsDirectory, getExcludeClasses()));
			classes.addAll(isScanGlobalDependencies() ? RemoteProxyUtils.extractFromJars(globalJarsDirectory, getExcludeClasses()) : new HashSet<Class>());
			classes.addAll(isUnitTestMode() ? RemoteProxyUtils.extractDirectly(globalJarsDirectory, getExcludeClasses()) : new HashSet<Class>());
			LOGGER.debug("Extracted remote proxy classes count: " + classes.size());

			// Constructs remote proxy metadata.
			List<Class> remoteProxyClasses = new ArrayList<Class>(classes);
			Collections.sort(remoteProxyClasses, new Comparator<Class>() {

				@Override
				public int compare(Class o1, Class o2) {
					String n1 = o1.getName();
					String n2 = o2.getName();

					return n1.compareTo(n2);
				}
			});

			for (Class clazz : remoteProxyClasses) {
				RemoteProxyMetadata metadata = new RemoteProxyMetadata(clazz, !isDebugMode());
				int index = registerRemoteProxyMetadata(metadata);
				LOGGER.info("The remote proxy metadata for '" + metadata.getName() + "' has been constructed, index: " + index);
			}

			LOGGER.info("Initialization complete");

		} catch (Exception ex) {
			LOGGER.fatal("Failed to initialize the Servlet for configurations", ex);

			throw new ServletException(ex);
		}
	}

	static Set<KeyValue<Integer, RemoteProxyMetadata>> findByPackageName(String name) {

		try {
			return PACKAGE_HIERARCHY_DICT.get(name);

		} catch (Exception ex) {
			return null;
		}
	}

	static KeyValue<String, RemoteProxyMetadata> getByClassIndex(int index) {

		try {
			return INDEX_MAPPING_METADATA_DICT.get(index);

		} catch (Exception ex) {
			return null;
		}
	}

	static KeyValue<Integer, RemoteProxyMetadata> getByClassName(String name) {

		try {
			return CLASS_MAPPING_METADATA_DICT.get(name);

		} catch (Exception ex) {
			return null;
		}
	}

	static List<RemoteProxyMetadata> getAvailableRemoteProxyMetadatas() {
		List<RemoteProxyMetadata> results = new ArrayList<RemoteProxyMetadata>();
		Collection<KeyValue<String, RemoteProxyMetadata>> values = INDEX_MAPPING_METADATA_DICT.values();

		for (KeyValue<String, RemoteProxyMetadata> item : values) {
			RemoteProxyMetadata metadata = item.getValue();

			if (metadata.getClass().equals(RemoteProxyMetadata.class)) {
				results.add(metadata);
			}
		}

		Collections.sort(results, new Comparator<RemoteProxyMetadata>() {

			@Override
			public int compare(RemoteProxyMetadata o1, RemoteProxyMetadata o2) {
				String n1 = o1.getName();
				String n2 = o2.getName();

				return n1.compareTo(n2);
			}
		});

		return results;
	}

	static int registerRemoteProxyMetadata(RemoteProxyMetadata metadata) throws IllegalArgumentException, IllegalStateException {
		Validate.notNull(metadata, "The 'metadata' is null");

		// Checks consistent.
		int indexDictCount = INDEX_MAPPING_METADATA_DICT.size();
		int classDictCount = CLASS_MAPPING_METADATA_DICT.size();

		if (indexDictCount != classDictCount) {
			throw new IllegalStateException("Inconsistent element detected, index mapping count: " + indexDictCount + ", class mapping count: " + classDictCount);
		}

		// Collects indexes & class names.
		String className = metadata.getName();
		KeyValue<Integer, RemoteProxyMetadata> found = CLASS_MAPPING_METADATA_DICT.get(className);
		Integer index = found == null ? indexDictCount : found.getKey();
		INDEX_MAPPING_METADATA_DICT.put(index, new KeyValue<String, RemoteProxyMetadata>(className, metadata));
		CLASS_MAPPING_METADATA_DICT.put(className, new KeyValue<Integer, RemoteProxyMetadata>(index, metadata));

		// Collects package names.
		String packageName = metadata.getTargetClass().getPackage().getName();
		Set<KeyValue<Integer, RemoteProxyMetadata>> results = PACKAGE_HIERARCHY_DICT.get(packageName);

		if (results == null) {
			results = new HashSet<KeyValue<Integer, RemoteProxyMetadata>>();
			PACKAGE_HIERARCHY_DICT.put(packageName, results);
		}

		results.add(new KeyValue<Integer, RemoteProxyMetadata>(index, metadata));

		return index;
	}

	static void unregisterAllRemoteProxyMetadata() {
		INDEX_MAPPING_METADATA_DICT.clear();
		CLASS_MAPPING_METADATA_DICT.clear();
		PACKAGE_HIERARCHY_DICT.clear();
	}

	private static Set<String> getExcludeClasses() {
		return excludeClasses;
	}

	private static boolean isUnitTestMode() {
		return unitTestMode;
	}

	private int fixValue(String value) throws NumberFormatException {

		if (StringUtils.isEmpty(value)) {
			return 0;
		}

		int v = Integer.parseInt(value);

		return v > 0 ? v : 0;
	}
}
