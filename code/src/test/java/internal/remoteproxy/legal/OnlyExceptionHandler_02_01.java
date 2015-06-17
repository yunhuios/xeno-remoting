package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandler_02_01 {

	@ExceptionHandler
	public static void e_02_01(ClassNotFoundException ex) {
		// Does nothing.
	}
}
