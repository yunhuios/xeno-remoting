package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodExtend_01_02 extends OnlyWebMethodExtend_01_01 {

	@WebMethod
	public String m_01_02_a(boolean f, Object o) {
		return null;
	}

	public void m_01_02_b() {
		// Does nothing.
	}
}
