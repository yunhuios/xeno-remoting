package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandler_02_02 {

	@ExceptionHandler
	public static void e_02_02_a(ArithmeticException ex) {
		// Does nothing.
	}

	public static void e_02_02_b(IllegalArgumentException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_02_02_c(NoSuchMethodException ex) throws IOException {
		// Does nothing.
	}

	@ExceptionHandler
	public static String e_02_02_d(ClassNotFoundException ex) {
		return null;
	}

	@ExceptionHandler
	public static boolean e_02_02_e(FileNotFoundException ex) {
		return false;
	}

	public static long e_02_02_f(IOException ex) {
		return 0;
	}
}
