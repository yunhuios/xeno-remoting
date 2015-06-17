package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class Browser_withSessions_Test {

	@Test
	public void testSequence() {
		SessionFilteredJavaScriptCallback callback = (SessionFilteredJavaScriptCallback) Browser.withSessions("a", "d", "c", "b");
		Assert.assertEquals(4, callback.getSessionIds().length);
		Assert.assertEquals("a", callback.getSessionIds()[0]);
		Assert.assertEquals("d", callback.getSessionIds()[1]);
		Assert.assertEquals("c", callback.getSessionIds()[2]);
		Assert.assertEquals("b", callback.getSessionIds()[3]);
	}

	@Test
	public void testDuplicated() {
		SessionFilteredJavaScriptCallback callback = (SessionFilteredJavaScriptCallback) Browser.withSessions("a", "c", "c", "b");
		Assert.assertEquals(4, callback.getSessionIds().length);
		Assert.assertEquals("a", callback.getSessionIds()[0]);
		Assert.assertEquals("c", callback.getSessionIds()[1]);
		Assert.assertEquals("c", callback.getSessionIds()[2]);
		Assert.assertEquals("b", callback.getSessionIds()[3]);
	}
}
