package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverride_05_02 extends OnlyExceptionHandlerOverride_05_01 {

	public void e_05_01(FileNotFoundException ex) {
		// Does nothing.
	}
}
