package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverride_06_04 extends OnlyExceptionHandlerOverride_06_03 {

	public static void e_06_01(FileNotFoundException ex) {
		// Does nothing.
	}
}
