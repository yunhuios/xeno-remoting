package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverride_02_02 extends OnlyExceptionHandlerOverride_02_01 {

	@ExceptionHandler
	public static void e_02_01(FileNotFoundException ex) {
		// Does nothing.
	}
}
