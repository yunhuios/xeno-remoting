package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_03_03 extends OnlyExceptionHandlerHierarchy_03_02 {

	@ExceptionHandler
	public static void e_03_03_a(IndexOutOfBoundsException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_03_03_b(NumberFormatException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_03_03_c(FileNotFoundException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_03_03_d(IOException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_03_03_e(ArrayIndexOutOfBoundsException ex) {
		// Does noting.
	}
}
