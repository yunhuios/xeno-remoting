package org.showcase.web;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class MockController {

	@WebMethod
	public String foo(int i) {
		return null;
	}
}
