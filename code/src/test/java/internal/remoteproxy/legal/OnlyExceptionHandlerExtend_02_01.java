package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtend_02_01 {

	public static void e_02_01_a(ArithmeticException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static int e_02_01_a(IllegalArgumentException ex) {
		return 0;
	}

	@ExceptionHandler
	public static void e_02_01_b(NoSuchMethodException ex) {
		// Does nothing.
	}
}
