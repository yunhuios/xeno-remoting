package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class SingleNotificationJavaScriptCallback_construct_Test {

	@Test
	public void testNull() {

		try {
			new SingleNotificationJavaScriptCallback(null, "b");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionId' is null", ex.getMessage());
		}

		try {
			new SingleNotificationJavaScriptCallback("a", null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'pageUri' is null", ex.getMessage());
		}
	}

	@Test
	public void testNormal() {
		SingleNotificationJavaScriptCallback callback = new SingleNotificationJavaScriptCallback("a", "b");
		Assert.assertEquals("a", callback.getSessionId());
		Assert.assertEquals("b", callback.getPageUri());
	}
}
