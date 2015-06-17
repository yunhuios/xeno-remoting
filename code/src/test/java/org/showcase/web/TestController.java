package org.showcase.web;

import java.util.Map;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
@SuppressWarnings("rawtypes")
public class TestController {

	@ExceptionHandler
	public Object handleException(ClassNotFoundException ex) {
		return null;
	}

	@WebMethod
	public String getNextPage(int index, Map option) {
		return null;
	}

	@WebMethod
	public String getPreviousPage(int index, Map option) {
		return null;
	}

	public String getCurrentPage() {
		return null;
	}

	@WebMethod
	public void login(String username, String password, String key) {
		// Does nothing.
	}

	@WebMethod
	public void logout() {
		// Does nothing.
	}
}
