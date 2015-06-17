package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;

public class OnlyExceptionHandlerExtend_02_04 extends OnlyExceptionHandlerExtend_02_01 {

	@ExceptionHandler
	public static String e_02_04_a(NumberFormatException ex) {
		return null;
	}

	@ExceptionHandler
	public static void e_02_04_b(IllegalAccessException ex) {
		// Does nothing.
	}

	public static String e_02_04_c(ClassCastException ex) {
		return null;
	}
}
