package com.since10.web;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class ResponseSuspendedController {

	@WebMethod
	public void performTask() throws InterruptedException {
		Thread.sleep(20000);
	}
}
