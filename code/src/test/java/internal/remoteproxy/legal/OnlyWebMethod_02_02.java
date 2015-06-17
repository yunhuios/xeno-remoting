package internal.remoteproxy.legal;

import java.io.IOException;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethod_02_02 {

	@WebMethod
	public static void m_02_02_a() {
		// Does nothing.
	}

	public static void m_02_02_b() {
		// Does nothing.
	}

	@WebMethod
	public static void m_02_02_c(int i) throws IOException {
		// Does nothing.
	}

	@WebMethod
	public static String m_02_02_d(Object o, int i) {
		return null;
	}

	@WebMethod
	public static boolean m_02_02_e(String s, boolean f, long l, int i) {
		return false;
	}

	public static long m_02_02_f(int i) {
		return 0;
	}
}
