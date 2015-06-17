package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverride_02_04 extends OnlyExceptionHandlerOverride_02_03 {

	@ExceptionHandler
	public static void e_02_01(FileNotFoundException ex) {
		// Does nothing.
	}
}
