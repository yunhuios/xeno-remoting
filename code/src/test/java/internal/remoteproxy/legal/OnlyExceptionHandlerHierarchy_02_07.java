package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_02_07 extends OnlyExceptionHandlerHierarchy_02_05 {

	@ExceptionHandler
	public static void e_02_07_a(IndexOutOfBoundsException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_07_b(NumberFormatException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_07_c(FileNotFoundException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_07_d(IOException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_07_e(ArrayIndexOutOfBoundsException ex) {
		// Does noting.
	}
}
