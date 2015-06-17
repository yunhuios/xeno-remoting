package org.showcase.web.extra;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class TestController {
	private static boolean showError = false;

	public static void setShowError(boolean value) {
		showError = value;
	}

	@WebMethod
	@ExceptionHandler
	public String foo(Exception ex) {

		if (showError) {

			if (ex == null) {
				throw new RuntimeException("error occurs");

			} else {
				return "exception handled";
			}

		} else {
			return "success executed";
		}
	}
}
