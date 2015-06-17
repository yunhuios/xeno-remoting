package internal.remoteproxy.legal;

import java.io.IOException;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethod_01_02 {

	@WebMethod
	public void m_01_02_a() {
		// Does nothing.
	}

	public void m_01_02_b() {
		// Does nothing.
	}

	@WebMethod
	public void m_01_02_c(int i) throws IOException {
		// Does nothing.
	}

	@WebMethod
	public String m_01_02_d(Object o, int i) {
		return null;
	}

	@WebMethod
	public boolean m_01_02_e(String s, boolean f, long l, int i) {
		return false;
	}

	public long m_01_02_f(int i) {
		return 0;
	}
}
