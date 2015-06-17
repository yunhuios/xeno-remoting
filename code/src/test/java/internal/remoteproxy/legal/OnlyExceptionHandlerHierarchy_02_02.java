package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_02_02 {

	@ExceptionHandler
	public static void e_02_02_a(RuntimeException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_02_b(Exception ex) {
		// Does noting.
	}

	public static void e_02_02_c(IllegalArgumentException ex) {
		// Does noting.
	}
}
