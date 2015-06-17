package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtend_01_01 {

	public void e_01_01_a(ArithmeticException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public int e_01_01_a(IllegalArgumentException ex) {
		return 0;
	}

	@ExceptionHandler
	public void e_01_01_b(NoSuchMethodException ex) {
		// Does nothing.
	}
}
