package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandler_01_01 {

	@ExceptionHandler
	public void e_01_01(ClassNotFoundException ex) {
		// Does nothing.
	}
}
