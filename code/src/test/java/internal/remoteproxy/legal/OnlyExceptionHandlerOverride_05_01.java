package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

import xeno.remoting.bind.ExceptionHandler;

public class OnlyExceptionHandlerOverride_05_01 {

	public void e_05_01(IllegalArgumentException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public void e_05_01(FileNotFoundException ex) {
		// Does nothing.
	}
}
