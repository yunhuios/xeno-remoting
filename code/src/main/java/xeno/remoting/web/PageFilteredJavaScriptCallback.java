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

class PageFilteredJavaScriptCallback extends AbstractJavaScriptCallback {
	private String[] pageUris = null;

	/**
	 * <p>
	 * The class constructor.
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
	public PageFilteredJavaScriptCallback(String[] pageUris) throws IllegalArgumentException {
		Validate.notNull(pageUris, "The 'pageUris' is null", "The 'pageUris[index]' is null");

		this.pageUris = pageUris;
	}

	@Override
	public void invoke(JavaScriptFunction... functions) throws IllegalArgumentException {
		// Validate.notNull(functions, "The 'functions' is null", "The 'functions[index]' is null");

		invokeAsync(MessageServlet.getReverseAjaxThreadPool().getByPageUris(pageUris), functions);
	}

	/**
	 * <p>
	 * Returns the page URIs.
	 * </p>
	 * 
	 * @return The array, never be null.
	 */
	public String[] getPageUris() {
		return pageUris;
	}
}
