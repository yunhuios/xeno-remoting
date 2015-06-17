package internal.remoteproxy.legal;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtend_03_05 extends OnlyExceptionHandlerExtend_03_04 {

	@ExceptionHandler
	public Object e_03_05_a(SQLException ex) {
		return null;
	}

	public Object e_03_05_b(NoSuchElementException ex) {
		return null;
	}

	@ExceptionHandler
	public static int e_03_05_c(IndexOutOfBoundsException ex) {
		return 0;
	}
}
