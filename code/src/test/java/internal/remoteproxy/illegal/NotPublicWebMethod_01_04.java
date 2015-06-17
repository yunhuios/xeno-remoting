package internal.remoteproxy.illegal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class NotPublicWebMethod_01_04 {

	@WebMethod
	protected static void m_01_04() {
		// Does nothing.
	}
}
