package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_01_07 extends OnlyExceptionHandlerHierarchy_01_05 {

	@ExceptionHandler
	public void e_01_07_a(IndexOutOfBoundsException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_07_b(NumberFormatException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_07_c(FileNotFoundException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_07_d(IOException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_07_e(ArrayIndexOutOfBoundsException ex) {
		// Does noting.
	}
}
