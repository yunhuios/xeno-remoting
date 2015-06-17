package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class DuplicatedMappingExceptionHandler_02_09 extends DuplicatedMappingExceptionHandler_02_08 {

	@ExceptionHandler
	public static void e_02_09_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
