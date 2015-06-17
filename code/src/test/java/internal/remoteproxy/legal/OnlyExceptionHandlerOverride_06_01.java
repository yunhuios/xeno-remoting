package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

import xeno.remoting.bind.ExceptionHandler;

public class OnlyExceptionHandlerOverride_06_01 {

	public static void e_06_01(IllegalArgumentException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_06_01(FileNotFoundException ex) {
		// Does nothing.
	}
}
