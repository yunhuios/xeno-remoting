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
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeno.remoting.bind.RemoteProxy;

@SuppressWarnings({ "rawtypes", "unchecked" })
class RemoteProxyUtils {
	private static final Log LOGGER = LogFactory.getLog(RemoteProxyUtils.class);

	private static final String BIN_FILE_EXTENSION = ".class";
	private static final String JAR_FILE_EXTENSION = ".jar";

	/**
	 * <p>
	 * Extracts {@link xeno.remoting.bind.RemoteProxy} from compiled classes
	 * directory directly.
	 * </p>
	 * 
	 * @param directory
	 *            The directory, cannot be null.
	 * @param excludes
	 *            The exclude class names.
	 * 
	 * @return A set holds all matched classes.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "directory" is null.
	 * @throws ClassNotFoundException
	 *             Thrown when such class cannot be found.
	 */
	public static Set<Class> extractDirectly(File directory, Collection<String> excludes) throws IllegalArgumentException, ClassNotFoundException {
		Validate.notNull(directory, "The 'directory' is null");

		Set<Class> results = new HashSet<Class>();
		internalExtractDirectly(directory, directory, excludes, results);

		return results;
	}

	/**
	 * <p>
	 * Extracts {@link xeno.remoting.bind.RemoteProxy} from depended JARs
	 * directory.
	 * </p>
	 * 
	 * @param directory
	 *            The directory, cannot be null.
	 * @param excludes
	 *            The exclude class names.
	 * 
	 * @return A set holds all matched classes.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "directory" is null.
	 * @throws ClassNotFoundException
	 *             Thrown when such class cannot be found.
	 * @throws IOException
	 *             Thrown when any error occurs during the reading operation for
	 *             a JAR.
	 */
	public static Set<Class> extractFromJars(File directory, Collection<String> excludes) throws IllegalArgumentException, ClassNotFoundException, IOException {
		Validate.notNull(directory, "The 'directory' is null");

		Set<Class> results = new HashSet<Class>();
		internalExtractFromJars(directory, excludes, results);

		return results;
	}

	private static void internalExtractDirectly(File base, File search, Collection<String> excludes, Set<Class> classes) throws ClassNotFoundException {

		if (base.isDirectory() && search.isDirectory()) {
			File[] files = search.listFiles();

			for (File file : files) {

				if (file.isDirectory()) {
					internalExtractDirectly(base, file, excludes, classes);

				} else {
					String path = file.getAbsolutePath();

					if (path.endsWith(BIN_FILE_EXTENSION)) {
						String name = path.substring(base.getAbsolutePath().length() + 1, path.lastIndexOf(BIN_FILE_EXTENSION)).replace("\\", ".");

						if (!isIgnoredClass(name, excludes)) {
							addToCollection(name, classes);
						}
					}
				}
			}
		}
	}

	private static void internalExtractFromJars(File search, Collection<String> excludes, Set<Class> classes) throws ClassNotFoundException, IOException {

		if (search.isDirectory()) {
			File[] files = search.listFiles();

			for (File file : files) {

				if (file.isDirectory()) {
					LOGGER.debug("Target file is a directory: " + file);

				} else {
					String path = file.getAbsolutePath();

					if (path.endsWith(JAR_FILE_EXTENSION)) {
						JarFile jar = null;

						try {
							jar = new JarFile(file);
							Enumeration<JarEntry> entries = jar.entries();

							while (entries.hasMoreElements()) {
								JarEntry entry = entries.nextElement();
								String location = entry.getName();

								if (location.endsWith(BIN_FILE_EXTENSION)) {
									String name = StringUtils.removeEnd(location, BIN_FILE_EXTENSION).replace("/", ".");

									if (!isIgnoredClass(name, excludes)) {
										addToCollection(name, classes);
									}
								}
							}

						} finally {
							IoUtils.closeQuietly(jar);
						}
					}
				}
			}
		}
	}

	private static boolean isIgnoredClass(String name, Collection<String> excludes) {

		if (excludes == null) {
			return false;
		}

		for (String item : excludes) {
			String prefix = StringUtils.removeEnd(item, "*");

			if (name.startsWith(prefix)) {
				return true;
			}
		}

		return false;
	}

	private static void addToCollection(String name, Set<Class> classes) throws ClassNotFoundException {

		try {
			Class clazz = Class.forName(name);

			if (clazz.isAnnotationPresent(RemoteProxy.class)) {
				classes.add(clazz);
			}

		} catch (Error err) {
			LOGGER.trace("Failed to lookup the class: " + name, err);
		}
	}
}
