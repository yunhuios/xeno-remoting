package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_01_08 {

	@ExceptionHandler
	public void e_01_08_a(RuntimeException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_08_b(Exception ex) {
		// Does noting.
	}
}
