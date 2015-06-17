package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class BatchJavaScriptRequestHandler_constant_Test {

	@Test
	public void testIt() {
		Assert.assertEquals("/combined-", BatchJavaScriptRequestHandler.PATH_INFO_PREFIX);
	}
}
