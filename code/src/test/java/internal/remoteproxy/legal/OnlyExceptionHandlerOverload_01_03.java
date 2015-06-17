package internal.remoteproxy.legal;

import java.io.IOException;
import java.sql.SQLException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverload_01_03 {

	@ExceptionHandler
	public void e_01_03(IllegalArgumentException ex) {
		// Does nothing.
	}

	public static void e_01_03(ClassNotFoundException ex) {
		// Does nothing.
	}

	public void e_01_03(SQLException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_01_03(IOException ex) {
		// Does nothing.
	}
}
