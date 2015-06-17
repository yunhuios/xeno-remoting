package internal.remoteproxy.illegal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class ContainsOverloadWebMethod_01_03 extends ContainsOverloadWebMethod_01_02 {

	@WebMethod
	public void m_01(int i) {
		// Does nothing.
	}
}
