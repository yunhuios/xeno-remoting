package internal.remoteproxy.legal;

import xeno.remoting.bind.WebMethod;

public class OnlyWebMethodExtend_01_04 extends OnlyWebMethodExtend_01_01 {

	@WebMethod
	public String m_01_04_a(boolean f) {
		return null;
	}

	@WebMethod
	public void m_01_04_b() {
		// Does nothing.
	}

	public String m_01_04_c(boolean f, String s) {
		return null;
	}
}
