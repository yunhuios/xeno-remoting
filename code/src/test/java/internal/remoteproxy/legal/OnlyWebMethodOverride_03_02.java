package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodOverride_03_02 extends OnlyWebMethodOverride_03_01 {

	@WebMethod
	public void m_03_01(int i) {
		// Does nothing.
	}
}
