package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class SessionFilteredJavaScriptCallback_construct_Test {

	@Test
	public void testNull() {

		try {
			new SessionFilteredJavaScriptCallback(null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionIds' is null", ex.getMessage());
		}

		try {
			new SessionFilteredJavaScriptCallback(new String[] { "a", null, "c" });
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionIds[1]' is null", ex.getMessage());
		}
	}

	@Test
	public void testNormal() {
		SessionFilteredJavaScriptCallback callback = new SessionFilteredJavaScriptCallback(new String[] { "a", "c", "b" });
		Assert.assertEquals(3, callback.getSessionIds().length);
		Assert.assertEquals("a", callback.getSessionIds()[0]);
		Assert.assertEquals("c", callback.getSessionIds()[1]);
		Assert.assertEquals("b", callback.getSessionIds()[2]);
	}

	@Test
	public void testDuplicated() {
		SessionFilteredJavaScriptCallback callback = new SessionFilteredJavaScriptCallback(new String[] { "a", "c", "b", "a" });
		Assert.assertEquals(4, callback.getSessionIds().length);
		Assert.assertEquals("a", callback.getSessionIds()[0]);
		Assert.assertEquals("c", callback.getSessionIds()[1]);
		Assert.assertEquals("b", callback.getSessionIds()[2]);
		Assert.assertEquals("a", callback.getSessionIds()[3]);
	}
}
