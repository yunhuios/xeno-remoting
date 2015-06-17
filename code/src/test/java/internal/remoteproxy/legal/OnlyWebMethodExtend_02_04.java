package internal.remoteproxy.legal;

import xeno.remoting.bind.WebMethod;

public class OnlyWebMethodExtend_02_04 extends OnlyWebMethodExtend_02_01 {

	@WebMethod
	public static String m_02_04_a(boolean f) {
		return null;
	}

	@WebMethod
	public static void m_02_04_b() {
		// Does nothing.
	}

	public static String m_02_04_c(boolean f, String s) {
		return null;
	}
}
