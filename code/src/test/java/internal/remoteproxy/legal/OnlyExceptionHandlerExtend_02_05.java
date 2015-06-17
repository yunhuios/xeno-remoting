package internal.remoteproxy.legal;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtend_02_05 extends OnlyExceptionHandlerExtend_02_04 {

	@ExceptionHandler
	public static Object e_02_05_a(SQLException ex) {
		return null;
	}

	public static Object e_02_05_b(NoSuchElementException ex) {
		return null;
	}

	@ExceptionHandler
	public static int e_02_05_c(IndexOutOfBoundsException ex) {
		return 0;
	}
}
