package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtend_01_02 extends OnlyExceptionHandlerExtend_01_01 {

	@ExceptionHandler
	public String e_01_02_a(ClassNotFoundException ex) {
		return null;
	}

	public void e_01_02_b(IllegalStateException ex) {
		// Does nothing.
	}
}
