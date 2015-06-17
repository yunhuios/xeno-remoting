package internal.remoteproxy.legal;

import java.io.IOException;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethod_03_02 {

	@WebMethod
	public void m_03_02_a() {
		// Does nothing.
	}

	public static void m_03_02_b() {
		// Does nothing.
	}

	@WebMethod
	public static void m_03_02_c(int i) throws IOException {
		// Does nothing.
	}

	@WebMethod
	public String m_03_02_d(Object o, int i) {
		return null;
	}

	@WebMethod
	public static boolean m_03_02_e(String s, boolean f, long l, int i) {
		return false;
	}

	public long m_03_02_f(int i) {
		return 0;
	}
}
