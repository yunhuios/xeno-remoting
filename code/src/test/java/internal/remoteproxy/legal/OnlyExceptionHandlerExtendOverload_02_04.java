package internal.remoteproxy.legal;

import java.io.IOException;
import java.sql.SQLException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtendOverload_02_04 extends OnlyExceptionHandlerExtendOverload_02_03 {

	public static void e_02_04(SQLException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_02_04(IOException ex) {
		// Does nothing.
	}
}
