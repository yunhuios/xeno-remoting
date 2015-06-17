package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverride_04_02 extends OnlyExceptionHandlerOverride_04_01 {

	@ExceptionHandler
	public static void e_04_01(FileNotFoundException ex) {
		// Does nothing.
	}
}
