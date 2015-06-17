package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_03_06 extends OnlyExceptionHandlerHierarchy_03_04 {

	@ExceptionHandler
	public static void e_03_06_a(IndexOutOfBoundsException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_03_06_b(NumberFormatException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_03_06_c(FileNotFoundException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_03_06_d(IOException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_03_06_e(ArrayIndexOutOfBoundsException ex) {
		// Does noting.
	}
}
