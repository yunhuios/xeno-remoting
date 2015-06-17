package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_01_02 {

	@ExceptionHandler
	public void e_01_02_a(RuntimeException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_02_b(Exception ex) {
		// Does noting.
	}

	public void e_01_02_c(IllegalArgumentException ex) {
		// Does noting.
	}
}
