package org.showcase.web.service.extra;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OverrideExceptionHandlerService_03 extends OverrideExceptionHandlerService_02 {

	@Override
	@ExceptionHandler
	public String t1(IllegalArgumentException ex) {
		return "t1 in OverrideExceptionHandlerService_03";
	}

	@Override
	@ExceptionHandler
	public String t2(IllegalStateException ex) {
		return "t2 in OverrideExceptionHandlerService_03";
	}

	@Override
	@ExceptionHandler
	public String t3(ArithmeticException ex) {
		return "t3 in OverrideExceptionHandlerService_03";
	}

	@Override
	@ExceptionHandler
	public String t4(ArrayIndexOutOfBoundsException ex) {
		return "t4 in OverrideExceptionHandlerService_03";
	}

	@ExceptionHandler
	public static String s1(ClassNotFoundException ex) {
		return "s1 in OverrideExceptionHandlerService_03";
	}

	@ExceptionHandler
	public static String s2(CloneNotSupportedException ex) {
		return "s2 in OverrideExceptionHandlerService_03";
	}

	@ExceptionHandler
	public static String s3(ArrayStoreException ex) {
		return "s3 in OverrideExceptionHandlerService_03";
	}

	@ExceptionHandler
	public static String s4(IndexOutOfBoundsException ex) {
		return "s4 in OverrideExceptionHandlerService_03";
	}

	@WebMethod
	public void e1() throws Exception {
		throw new IllegalArgumentException();
	}

	@WebMethod
	public void e2() throws Exception {
		throw new IllegalStateException();
	}

	@WebMethod
	public void e3() throws Exception {
		throw new ArithmeticException();
	}

	@WebMethod
	public void e4() throws Exception {
		throw new ArrayIndexOutOfBoundsException();
	}

	@WebMethod
	public void e5() throws Exception {
		throw new ClassCastException();
	}

	@WebMethod
	public void e6() throws Exception {
		throw new IllegalAccessException();
	}

	@WebMethod
	public void e7() throws Exception {
		throw new ClassNotFoundException();
	}

	@WebMethod
	public void e8() throws Exception {
		throw new CloneNotSupportedException();
	}

	@WebMethod
	public void e9() throws Exception {
		throw new ArrayStoreException();
	}

	@WebMethod
	public void e10() throws Exception {
		throw new IndexOutOfBoundsException();
	}

	@WebMethod
	public void e11() throws Exception {
		throw new InterruptedException();
	}

	@WebMethod
	public void e12() throws Exception {
		throw new InstantiationException();
	}
}
