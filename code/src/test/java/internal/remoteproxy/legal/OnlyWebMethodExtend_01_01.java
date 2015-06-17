package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodExtend_01_01 {

	public void m_01_01_a(String s) {
		// Does nothing.
	}

	@WebMethod
	public int m_01_01_a() {
		return 0;
	}

	@WebMethod
	public void m_01_01_b(char c) {
		// Does nothing.
	}
}
