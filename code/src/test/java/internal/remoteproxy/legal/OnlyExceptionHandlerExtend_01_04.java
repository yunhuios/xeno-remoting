package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;

public class OnlyExceptionHandlerExtend_01_04 extends OnlyExceptionHandlerExtend_01_01 {

	@ExceptionHandler
	public String e_01_04_a(NumberFormatException ex) {
		return null;
	}

	@ExceptionHandler
	public void e_01_04_b(IllegalAccessException ex) {
		// Does nothing.
	}

	public String e_01_04_c(ClassCastException ex) {
		return null;
	}
}
