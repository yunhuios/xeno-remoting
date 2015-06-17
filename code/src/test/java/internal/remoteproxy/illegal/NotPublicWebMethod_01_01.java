package internal.remoteproxy.illegal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class NotPublicWebMethod_01_01 {

	@WebMethod
	protected void m_01_01() {
		// Does nothing.
	}
}
