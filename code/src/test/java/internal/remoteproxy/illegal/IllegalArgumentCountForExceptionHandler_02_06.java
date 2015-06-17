package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class IllegalArgumentCountForExceptionHandler_02_06 {

	@ExceptionHandler
	public static void e_02_06(int i, String s) {
		// Does nothing.
	}
}
