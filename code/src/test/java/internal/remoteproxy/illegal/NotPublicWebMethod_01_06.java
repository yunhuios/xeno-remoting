package internal.remoteproxy.illegal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class NotPublicWebMethod_01_06 {

	@WebMethod
	private static void m_01_06() {
		// Does nothing.
	}
}
