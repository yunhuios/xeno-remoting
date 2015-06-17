package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtend_03_02 extends OnlyExceptionHandlerExtend_03_01 {

	@ExceptionHandler
	public static String e_03_02_a(ClassNotFoundException ex) {
		return null;
	}

	public static void e_03_02_b(IllegalStateException ex) {
		// Does nothing.
	}
}
