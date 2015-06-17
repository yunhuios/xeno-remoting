package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class IllegalArgumentCountForExceptionHandler_02_01 {

	@ExceptionHandler
	public static void e_02_01() {
		// Does nothing.
	}
}
