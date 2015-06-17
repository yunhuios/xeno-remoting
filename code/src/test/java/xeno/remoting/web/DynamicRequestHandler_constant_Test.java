package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class DynamicRequestHandler_constant_Test {

	@Test
	public void testIt() {
		Assert.assertEquals(".do", DynamicRequestHandler.REQUEST_SUFFIX);
		Assert.assertEquals("application/json", DynamicRequestHandler.CONTENT_TYPE);
		Assert.assertEquals("uri", DynamicRequestHandler.CURRENT_PAGE_URI_DATA_KEY);
	}
}
