package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverride_03_02 extends OnlyExceptionHandlerOverride_03_01 {

	@ExceptionHandler
	public void e_03_01(FileNotFoundException ex) {
		// Does nothing.
	}
}
