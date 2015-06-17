package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodExtend_02_05 extends OnlyWebMethodExtend_02_04 {

	@WebMethod
	public static Object m_02_05_a(boolean f, String s, Object o) {
		return null;
	}

	public static Object m_02_05_b() {
		return null;
	}

	@WebMethod
	public static int m_02_05_c(int a, int b) {
		return 0;
	}
}
