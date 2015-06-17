package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtendOverload_03_01 {

	@ExceptionHandler
	public void e_03_01(IllegalArgumentException ex) {
		// Does nothing.
	}

	public static void e_03_01(ClassNotFoundException ex) {
		// Does nothing.
	}
}
