package internal.remoteproxy.legal;

import java.io.IOException;
import java.sql.SQLException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverload_01_02 {

	@ExceptionHandler
	public static void e_01_02(IllegalArgumentException ex) {
		// Does nothing.
	}

	public static void e_01_02(ClassNotFoundException ex) {
		// Does nothing.
	}

	public static void e_01_02(SQLException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_01_02(IOException ex) {
		// Does nothing.
	}
}
