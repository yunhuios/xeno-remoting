package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_03_02 {

	@ExceptionHandler
	public void e_03_02_a(RuntimeException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_03_02_b(Exception ex) {
		// Does noting.
	}

	public void e_03_02_c(IllegalArgumentException ex) {
		// Does noting.
	}
}
