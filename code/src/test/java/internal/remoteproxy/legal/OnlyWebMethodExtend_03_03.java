package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodExtend_03_03 extends OnlyWebMethodExtend_03_02 {

	@WebMethod
	public Object m_03_03_a(boolean f, String s, Object o) {
		return null;
	}

	public static Object m_03_03_b() {
		return null;
	}

	@WebMethod
	public static int m_03_03_c(int a, int b) {
		return 0;
	}
}
