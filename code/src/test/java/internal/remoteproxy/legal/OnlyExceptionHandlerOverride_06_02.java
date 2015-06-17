package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverride_06_02 extends OnlyExceptionHandlerOverride_06_01 {

	public static void e_06_01(FileNotFoundException ex) {
		// Does nothing.
	}
}
