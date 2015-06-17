package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodExtend_02_03 extends OnlyWebMethodExtend_02_02 {

	@WebMethod
	public static Object m_02_03_a(boolean f, String s, Object o) {
		return null;
	}

	public static Object m_02_03_b() {
		return null;
	}

	@WebMethod
	public static int m_02_03_c(int a, int b) {
		return 0;
	}
}
