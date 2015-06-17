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
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xeno.remoting.bind.RemoteProxy;

@SuppressWarnings({ "rawtypes", "unchecked" })
class RemoteProxyMetadata {

	/**
	 * <p>
	 * The target class.
	 * </p>
	 */
	protected Class targetClass = null;

	/**
	 * <p>
	 * The valid web methods map.
	 * </p>
	 */
	protected Map<String, Method> webMethods = null;

	/**
	 * <p>
	 * The valid exception handlers map.
	 * </p>
	 */
	protected Map<Class, Method> exceptionHandlers = null;

	/**
	 * <p>
	 * The generated JavaScript string content.
	 * </p>
	 */
	protected String javascriptContent = null;

	/**
	 * <p>
	 * The class constructor.
	 * </p>
	 * 
	 * @param clazz
	 *            The class, cannot be null and must be the annotation of
	 *            {@link xeno.remoting.bind.RemoteProxy}.
	 * @param obfuscate
	 *            A flag to decide whether the generated JavaScript string
	 *            content is minified or not.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "clazz" is null. Or thrown when the "clazz"
	 *             is not a remote proxy.
	 * @throws IllegalAccessException
	 *             Thrown when field or method cannot be accessed.
	 * @throws InstantiationException
	 *             Thrown when cannot do the instantiation.
	 * @throws IOException
	 *             Thrown when any error occurs during the JavaScript content's
	 *             generation.
	 */
	public RemoteProxyMetadata(Class clazz, boolean obfuscate) throws IllegalArgumentException, IllegalAccessException, InstantiationException, IOException {
		Validate.notNull(clazz, "The 'clazz' is null");

		if (!clazz.isAnnotationPresent(RemoteProxy.class)) {
			throw new IllegalArgumentException("The 'clazz' is not a remote proxy");
		}

		String name = clazz.getName();
		int modifier = clazz.getModifiers();

		// Filters the class type.
		if (clazz.isMemberClass()) {
			throw new InstantiationException("Inner class cannot be instantiated: " + name);

		} else if (clazz.isAnnotation()) {
			throw new InstantiationException("Annotation cannot be instantiated: " + name);

		} else if (clazz.isEnum()) {
			throw new InstantiationException("Enum cannot be instantiated: " + name);

		} else if (Modifier.isInterface(modifier)) {
			throw new InstantiationException("Interface cannot be instantiated: " + name);

		} else if (Modifier.isAbstract(modifier)) {
			throw new InstantiationException("Abstract class cannot be instantiated: " + name);

		} else if (!Modifier.isPublic(modifier)) {
			throw new InstantiationException("Non public class cannot be instantiated: " + name);
		}

		// Ensures this class can be instantiated by default constructor.
		try {
			clazz.newInstance();

		} catch (Exception ex) {
			throw new InstantiationException("Target class cannot be instantiated: " + name);
		}

		targetClass = clazz;
		webMethods = new HashMap<String, Method>();
		exceptionHandlers = new HashMap<Class, Method>();
		parseMetadata(name, targetClass, webMethods, exceptionHandlers);

		// Generates JavaScript content.
		StringBuffer content = new StringBuffer();
		content.append(Engine.CLASS_NAME + ".registerClass(\"" + name + "\");\n\n");

		Method[] methods = getWebMethods();

		for (Method item : methods) {
			String func = item.getName();
			int count = item.getParameterTypes().length;

			content.append(name + "." + func + " = function(" + JavaScriptUtils.toArguments(count, true) + ") {\n\t");
			content.append("return " + Engine.CLASS_NAME + ".processRemoteCall" + "(\"" + name + "\", \"" + func + "\", " + JavaScriptUtils.toArguments(count, false) + ");\n");
			content.append("};\n\n");
		}

		javascriptContent = StringUtils.trimToEmpty(obfuscate ? JavaScriptUtils.minifyContent(content.toString()) : content.toString());
	}

	/**
	 * <p>
	 * Return the name.
	 * </p>
	 * 
	 * @return The string, never be null.
	 */
	public String getName() {
		return targetClass.getName();
	}

	/**
	 * <p>
	 * Returns the target class, this class can be ensured to be instantiated by
	 * default constructor.
	 * </p>
	 * 
	 * @return The class, never be null.
	 */
	public Class getTargetClass() {
		return targetClass;
	}

	/**
	 * <p>
	 * Returns all web methods.
	 * </p>
	 * 
	 * @return The method array, never be null.
	 */
	public Method[] getWebMethods() {
		List<Method> results = new ArrayList<Method>(webMethods.values());

		Collections.sort(results, new Comparator<Method>() {

			@Override
			public int compare(Method o1, Method o2) {
				String n1 = o1.getName();
				String n2 = o2.getName();

				return n1.compareTo(n2);
			}
		});

		return results.toArray(new Method[results.size()]);
	}

	/**
	 * <p>
	 * Returns a web method by name.
	 * </p>
	 * 
	 * @param name
	 *            The name.
	 * 
	 * @return The found method, or null if there is no such method.
	 */
	public Method getWebMethod(String name) {

		if (name == null) {
			return null;
		}

		return webMethods.get(name);
	}

	/**
	 * <p>
	 * Returns the exception handler according to the class provides.
	 * </p>
	 * 
	 * @param clazz
	 *            The class.
	 * 
	 * @return The found method, may be null.
	 */
	public Method getExceptionHandler(Class clazz) {

		if (clazz == null) {
			return null;
		}

		Method handler = exceptionHandlers.get(clazz);

		if (handler == null) {
			return getExceptionHandler(clazz.getSuperclass());
		}

		return handler;
	}

	/**
	 * <p>
	 * Returns the exception handler according to the instance provides.
	 * </p>
	 * 
	 * @param instance
	 *            The instance.
	 * 
	 * @return The found method, may be null.
	 */
	public Method getExceptionHandler(Object instance) {

		if (instance == null) {
			return null;
		}

		return getExceptionHandler(instance.getClass());
	}

	/**
	 * <p>
	 * Returns the JavaScript content.
	 * </p>
	 * 
	 * @return The string, may be empty.
	 */
	public String getJavaScriptContent() {
		return javascriptContent;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		RemoteProxyMetadata that = (RemoteProxyMetadata) obj;

		return getName().equals(that.getName());
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	@Override
	public String toString() {
		return "[name=" + getName() + ",targetClass=" + targetClass.getName() + ",webMethods=" + webMethods.size() + ",exceptionHandlers=" + exceptionHandlers.size() + "]";
	}

	/**
	 * <p>
	 * The class constructor.
	 * </p>
	 */
	protected RemoteProxyMetadata() {
		// Does nothing.
	}

	private void parseMetadata(String name, Class clazz, Map<String, Method> methods, Map<Class, Method> handlers) throws IllegalAccessException {
		Set<String> dataSet = new HashSet<String>();
		Map<String, String> methodsMap = new HashMap<String, String>();
		Map<String, String> handlersMap = new HashMap<String, String>();

		parseMetadataRecursively(name, clazz, methods, handlers, dataSet, methodsMap, handlersMap);
	}

	private void parseMetadataRecursively(String name, Class clazz, Map<String, Method> methods, Map<Class, Method> handlers, Set<String> dataSet, Map<String, String> methodsMap, Map<String, String> handlersMap) throws IllegalAccessException {

		if (!Object.class.equals(clazz)) {

			// JAVA 1.6+ BUG
			// --------------------------------------------------
			// If super class is with default modifier, the "getDeclaredMethods"
			// could also get parent methods. And annotation information about
			// those parent methods will be lost.
			// http://www.cnblogs.com/mvii/p/3268342.html
			// http://bugs.java.com/bugdatabase/view_bug.do?bug_id=6815786
			Method[] declaredMethods = clazz.getDeclaredMethods();

			for (Method method : declaredMethods) {
				String shortName = method.getName();
				String fullName = extractFullName(method);

				if (!dataSet.contains(fullName)) {
					dataSet.add(fullName);

					if (method.isAnnotationPresent(xeno.remoting.bind.WebMethod.class)) {

						if (!Modifier.isPublic(method.getModifiers())) {
							throw new IllegalAccessException("Target class " + name + " contains non public web method: " + shortName);
						}

						if (methodsMap.containsKey(shortName)) {

							if (!methodsMap.get(shortName).equals(fullName)) {
								throw new IllegalAccessException("Target class " + name + " contains overload web method: " + shortName);
							}

						} else {
							methodsMap.put(shortName, fullName);
							methods.put(shortName, method);
						}
					}

					if (method.isAnnotationPresent(xeno.remoting.bind.ExceptionHandler.class)) {

						if (!Modifier.isPublic(method.getModifiers())) {
							throw new IllegalAccessException("Target class " + name + " contains non public exception handler: " + shortName);
						}

						Class[] paramTypes = method.getParameterTypes();
						int paramCount = paramTypes.length;

						if (paramCount == 0) {
							throw new IllegalAccessException("Target class " + name + " contains missing required argument exception handler: " + shortName);

						} else if (paramCount != 1) {
							throw new IllegalAccessException("Target class " + name + " contains multiple arguments exception handler: " + shortName);
						}

						Class paramType = paramTypes[0];

						if (!Exception.class.isAssignableFrom(paramType)) {
							throw new IllegalAccessException("Target class " + name + " contains illegal argument type exception handler: " + shortName);
						}

						String paramTypeName = paramType.getName();

						if (handlersMap.containsKey(paramTypeName)) {

							if (!handlersMap.get(paramTypeName).equals(fullName)) {
								throw new IllegalAccessException("Target class " + name + " contains duplicated exception handler for: " + paramTypeName);
							}

						} else {
							handlersMap.put(paramTypeName, fullName);
							handlers.put(paramType, method);
						}
					}
				}
			}

			parseMetadataRecursively(name, clazz.getSuperclass(), methods, handlers, dataSet, methodsMap, handlersMap);
		}
	}

	private String extractFullName(Method method) {
		String signature = method.toGenericString();

		int begin = signature.indexOf(method.getName() + "(");
		int end = signature.lastIndexOf(")");

		return signature.substring(begin, end + 1);
	}
}
