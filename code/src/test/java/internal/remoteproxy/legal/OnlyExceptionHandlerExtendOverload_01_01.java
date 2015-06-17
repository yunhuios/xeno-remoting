package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtendOverload_01_01 {

	@ExceptionHandler
	public void e_01_01(IllegalArgumentException ex) {
		// Does nothing.
	}

	public void e_01_01(ClassNotFoundException ex) {
		// Does nothing.
	}
}
