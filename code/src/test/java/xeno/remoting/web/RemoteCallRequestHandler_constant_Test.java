package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class RemoteCallRequestHandler_constant_Test {

	@Test
	public void testIt() {
		Assert.assertEquals("/xeno.remoting.web.RemoteCall.do", RemoteCallRequestHandler.PATH_INFO);
		Assert.assertEquals("name", RemoteCallRequestHandler.REMOTE_PROXY_NAME_DATA_KEY);
		Assert.assertEquals("method", RemoteCallRequestHandler.WEB_METHOD_NAME_DATA_KEY);
		Assert.assertEquals("params", RemoteCallRequestHandler.INPUT_ARGUMENTS_DATA_KEY);
	}
}
