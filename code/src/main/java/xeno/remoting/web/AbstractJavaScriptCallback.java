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
import java.util.Set;

import javax.servlet.AsyncContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

abstract class AbstractJavaScriptCallback implements JavaScriptCallback {
	private static final Log LOGGER = LogFactory.getLog(AbstractJavaScriptCallback.class);

	@Override
	public void invoke(Collection<JavaScriptFunction> functions) throws IllegalArgumentException {
		// Validate.notNull(functions, "The 'functions' is null");

		try {
			invoke(functions.toArray(new JavaScriptFunction[functions.size()]));

		} catch (NullPointerException ex) {
			throw new IllegalArgumentException("The 'functions' is null");
		}
	}

	@Override
	public void invoke(String name, Object... arguments) throws IllegalArgumentException {
		// Validate.notNull(name, "The 'name' is null");

		invoke(new JavaScriptFunction(name, arguments));
	}

	/**
	 * <p>
	 * Invokes reverse AJAX asynchronously.
	 * </p>
	 * 
	 * @param asyncContexts
	 *            The asynchronous contexts, cannot be null. And all items in
	 *            the set also cannot be null.
	 * @param functions
	 *            The JavaScript functions, cannot be null. And all items in the
	 *            array also cannot be null.
	 * 
	 * @throws IllegalArgumentException
	 *             Thrown when the "asyncContexts" or the "functions" is null.
	 *             Or thrown when any item in the "asyncContexts" or in the
	 *             "functions" is null.
	 */
	protected void invokeAsync(final Set<AsyncContext> asyncContexts, final JavaScriptFunction[] functions) throws IllegalArgumentException {
		Validate.notNull(asyncContexts, "The 'asyncContexts' is null", "The 'asyncContexts[index]' is null");
		Validate.notNull(functions, "The 'functions' is null", "The 'functions[index]' is null");

		try {
			new Thread(new Runnable() {

				@Override
				public void run() {

					for (AsyncContext i : asyncContexts) {

						try {
							i.getRequest().setAttribute(ReverseAjaxRequestHandler.JAVASCRIPT_FUNCTION_REQUEST_ATTRIBUTE_KEY, functions);
							i.getRequest().setAttribute(ReverseAjaxRequestHandler.RESPONSE_STATUS_FLAG_REQUEST_ATTRIBUTE_KEY, true);
							i.complete();

						} catch (Exception ex) {
							LOGGER.warn("Failed to complete the asynchronous request", ex);
						}
					}
				}

			}).start();

		} catch (Exception ex) {
			LOGGER.warn("Failed to run the callback thread", ex);
		}
	}
}
