package org.showcase.web.service.extra;

import java.sql.DataTruncation;
import java.sql.SQLWarning;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class HierarchyExceptionService_02 {

	@ExceptionHandler
	public String h(SQLWarning ex) {
		return "sql warning";
	}

	@WebMethod
	public void t() throws DataTruncation {
		throw new DataTruncation(1, true, false, 2, 3);
	}
}
