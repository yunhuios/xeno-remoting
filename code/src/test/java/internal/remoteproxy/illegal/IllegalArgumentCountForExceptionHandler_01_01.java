package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class IllegalArgumentCountForExceptionHandler_01_01 {

	@ExceptionHandler
	public void e_01_01() {
		// Does nothing.
	}
}