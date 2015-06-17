package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class StaticRequestHandler_constant_Test {

	@Test
	public void testIt() {
		Assert.assertEquals(".js", StaticRequestHandler.REQUEST_SUFFIX);
		Assert.assertEquals("text/html", StaticRequestHandler.CONTENT_TYPE);
	}
}
