package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverrideExtra_04_01 {

	@ExceptionHandler
	public static void e_04_01_a(FileNotFoundException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_04_01_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
