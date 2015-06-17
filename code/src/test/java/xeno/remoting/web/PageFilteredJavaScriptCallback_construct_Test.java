package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class PageFilteredJavaScriptCallback_construct_Test {

	@Test
	public void testNull() {

		try {
			new PageFilteredJavaScriptCallback(null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'pageUris' is null", ex.getMessage());
		}

		try {
			new PageFilteredJavaScriptCallback(new String[] { "a", null, "c" });
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'pageUris[1]' is null", ex.getMessage());
		}
	}

	@Test
	public void testNormal() {
		PageFilteredJavaScriptCallback callback = new PageFilteredJavaScriptCallback(new String[] { "a", "c", "b" });
		Assert.assertEquals(3, callback.getPageUris().length);
		Assert.assertEquals("a", callback.getPageUris()[0]);
		Assert.assertEquals("c", callback.getPageUris()[1]);
		Assert.assertEquals("b", callback.getPageUris()[2]);
	}

	@Test
	public void testDuplicated() {
		PageFilteredJavaScriptCallback callback = new PageFilteredJavaScriptCallback(new String[] { "a", "c", "b", "a" });
		Assert.assertEquals(4, callback.getPageUris().length);
		Assert.assertEquals("a", callback.getPageUris()[0]);
		Assert.assertEquals("c", callback.getPageUris()[1]);
		Assert.assertEquals("b", callback.getPageUris()[2]);
		Assert.assertEquals("a", callback.getPageUris()[3]);
	}
}
