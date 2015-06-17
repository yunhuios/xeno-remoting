package org.showcase.web.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class ProblemService {

	@WebMethod
	public void t1() {
		throw new IllegalArgumentException();
	}

	@WebMethod
	public void t2() {
		throw new IllegalArgumentException("a");
	}

	@WebMethod
	public void t3() {
		throw new IllegalArgumentException("b", new IOException());
	}

	@WebMethod
	public void t4() {
		throw new IllegalArgumentException("c", new IOException("a"));
	}

	@WebMethod
	public void t5() throws Exception {
		throw new InvocationTargetException(new IllegalStateException());
	}

	@WebMethod
	public void t6() throws Exception {
		throw new InvocationTargetException(new IllegalStateException("a"));
	}

	@WebMethod
	public void t7() throws Exception {
		throw new InvocationTargetException(new IllegalStateException(), "b");
	}

	@WebMethod
	public void t8() throws Exception {
		throw new InvocationTargetException(new IllegalStateException("a"), "c");
	}

	@WebMethod
	public Object t9() {
		return new Object();
	}
}
