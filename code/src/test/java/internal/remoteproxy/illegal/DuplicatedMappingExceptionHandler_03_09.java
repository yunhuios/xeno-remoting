package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class DuplicatedMappingExceptionHandler_03_09 extends DuplicatedMappingExceptionHandler_03_08 {

	@ExceptionHandler
	public static void e_03_09_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
