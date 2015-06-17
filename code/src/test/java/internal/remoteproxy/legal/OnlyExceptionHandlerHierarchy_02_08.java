package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_02_08 {

	@ExceptionHandler
	public static void e_02_08_a(RuntimeException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_08_b(Exception ex) {
		// Does noting.
	}
}
