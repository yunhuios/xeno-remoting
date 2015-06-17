package internal.remoteproxy.legal;

import java.io.IOException;
import java.sql.SQLException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtendOverload_02_02 extends OnlyExceptionHandlerExtendOverload_02_01 {

	public static void e_02_02(SQLException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_02_02(IOException ex) {
		// Does nothing.
	}
}
