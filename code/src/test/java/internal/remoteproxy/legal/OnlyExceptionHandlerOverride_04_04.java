package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverride_04_04 extends OnlyExceptionHandlerOverride_04_03 {

	@ExceptionHandler
	public static void e_04_01(FileNotFoundException ex) {
		// Does nothing.
	}
}
