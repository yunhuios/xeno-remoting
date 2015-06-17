package internal.remoteproxy.legal;

import xeno.remoting.bind.WebMethod;

public class OnlyWebMethodExtend_03_04 extends OnlyWebMethodExtend_03_01 {

	@WebMethod
	public static String m_03_04_a(boolean f) {
		return null;
	}

	@WebMethod
	public void m_03_04_b() {
		// Does nothing.
	}

	public static String m_03_04_c(boolean f, String s) {
		return null;
	}
}
