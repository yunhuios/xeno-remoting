package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

import xeno.remoting.bind.ExceptionHandler;

public class OnlyExceptionHandlerOverride_02_01 {

	public static void e_02_01(IllegalArgumentException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_02_01(FileNotFoundException ex) {
		// Does nothing.
	}
}
