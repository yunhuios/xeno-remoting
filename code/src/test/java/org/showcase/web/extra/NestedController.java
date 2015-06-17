package org.showcase.web.extra;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class NestedController {

	@ExceptionHandler
	public String handleIllegalStateException(IllegalStateException ex) {
		return "illegal state exception handled";
	}

	@ExceptionHandler
	public String handleIllegalArgumentException(IllegalArgumentException ex) {
		throw new IllegalStateException("nested error occurs");
	}

	@WebMethod
	public void test() {
		throw new IllegalArgumentException("source error occurs");
	}
}
