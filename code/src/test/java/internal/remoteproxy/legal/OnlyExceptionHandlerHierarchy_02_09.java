package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_02_09 extends OnlyExceptionHandlerHierarchy_02_08 {

	public static void e_02_09_a(IllegalArgumentException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_09_b(IndexOutOfBoundsException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_09_c(NumberFormatException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_09_d(FileNotFoundException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_09_e(IOException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_09_f(ArrayIndexOutOfBoundsException ex) {
		// Does noting.
	}
}
