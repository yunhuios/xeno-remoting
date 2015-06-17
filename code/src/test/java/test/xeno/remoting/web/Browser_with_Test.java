package test.xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

import test.xeno.remoting.LoggingTestCase;
import xeno.remoting.web.Browser;

public class Browser_with_Test extends LoggingTestCase {

	@Test
	public void testNull() {

		try {
			Browser.with(null, "b");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionId' is null", ex.getMessage());
		}

		try {
			Browser.with("a", null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'pageUri' is null", ex.getMessage());
		}
	}

	@Test
	public void testNormal() {
		Assert.assertEquals("xeno.remoting.web.SingleNotificationJavaScriptCallback", Browser.with("a", "b").getClass().getName());
	}
}
