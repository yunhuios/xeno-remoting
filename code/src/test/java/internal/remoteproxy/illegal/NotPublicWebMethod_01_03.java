package internal.remoteproxy.illegal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class NotPublicWebMethod_01_03 {

	@WebMethod
	private void m_01_03() {
		// Does nothing.
	}
}
