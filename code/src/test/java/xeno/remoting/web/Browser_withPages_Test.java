package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class Browser_withPages_Test {

	@Test
	public void testSequence() {
		PageFilteredJavaScriptCallback callback = (PageFilteredJavaScriptCallback) Browser.withPages("a", "d", "c", "b");
		Assert.assertEquals(4, callback.getPageUris().length);
		Assert.assertEquals("a", callback.getPageUris()[0]);
		Assert.assertEquals("d", callback.getPageUris()[1]);
		Assert.assertEquals("c", callback.getPageUris()[2]);
		Assert.assertEquals("b", callback.getPageUris()[3]);
	}

	@Test
	public void testDuplicated() {
		PageFilteredJavaScriptCallback callback = (PageFilteredJavaScriptCallback) Browser.withPages("a", "c", "c", "b");
		Assert.assertEquals(4, callback.getPageUris().length);
		Assert.assertEquals("a", callback.getPageUris()[0]);
		Assert.assertEquals("c", callback.getPageUris()[1]);
		Assert.assertEquals("c", callback.getPageUris()[2]);
		Assert.assertEquals("b", callback.getPageUris()[3]);
	}
}
