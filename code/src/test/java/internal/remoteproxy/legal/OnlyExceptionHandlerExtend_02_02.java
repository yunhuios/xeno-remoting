package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtend_02_02 extends OnlyExceptionHandlerExtend_02_01 {

	@ExceptionHandler
	public static String e_02_02_a(ClassNotFoundException ex) {
		return null;
	}

	public static void e_02_02_b(IllegalStateException ex) {
		// Does nothing.
	}
}
