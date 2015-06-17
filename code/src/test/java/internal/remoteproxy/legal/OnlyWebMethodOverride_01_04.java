package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodOverride_01_04 extends OnlyWebMethodOverride_01_03 {

	@WebMethod
	public void m_01_01(int i) {
		// Does nothing.
	}
}
