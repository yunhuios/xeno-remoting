package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverride_01_02 extends OnlyExceptionHandlerOverride_01_01 {

	@ExceptionHandler
	public void e_01_01(FileNotFoundException ex) {
		// Does nothing.
	}
}
