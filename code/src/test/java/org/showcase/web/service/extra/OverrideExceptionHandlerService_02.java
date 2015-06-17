package org.showcase.web.service.extra;

import xeno.remoting.bind.ExceptionHandler;

public class OverrideExceptionHandlerService_02 extends OverrideExceptionHandlerService_01 {

	@Override
	public String t1(IllegalArgumentException ex) {
		return "t1 in OverrideExceptionHandlerService_02";
	}

	@Override
	@ExceptionHandler
	public String t3(ArithmeticException ex) {
		return "t3 in OverrideExceptionHandlerService_02";
	}

	@Override
	@ExceptionHandler
	public String t4(ArrayIndexOutOfBoundsException ex) {
		return "t4 in OverrideExceptionHandlerService_02";
	}

	@ExceptionHandler
	public String t6(IllegalAccessException ex) {
		return "t6 in OverrideExceptionHandlerService_02";
	}

	public static String s1(ClassNotFoundException ex) {
		return "s1 in OverrideExceptionHandlerService_02";
	}

	@ExceptionHandler
	public static String s3(ArrayStoreException ex) {
		return "s3 in OverrideExceptionHandlerService_02";
	}

	@ExceptionHandler
	public static String s4(IndexOutOfBoundsException ex) {
		return "s4 in OverrideExceptionHandlerService_02";
	}

	@ExceptionHandler
	public static String s6(InstantiationException ex) {
		return "s6 in OverrideExceptionHandlerService_02";
	}
}
