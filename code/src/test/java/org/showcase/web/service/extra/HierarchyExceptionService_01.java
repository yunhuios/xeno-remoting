package org.showcase.web.service.extra;

import java.sql.DataTruncation;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class HierarchyExceptionService_01 {

	@ExceptionHandler
	public String h(DataTruncation ex) {
		return "data truncation";
	}

	@WebMethod
	public void t() throws DataTruncation {
		throw new DataTruncation(1, true, false, 2, 3);
	}
}
