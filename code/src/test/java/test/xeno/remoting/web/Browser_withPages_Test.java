package test.xeno.remoting.web;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import test.xeno.remoting.LoggingTestCase;
import xeno.remoting.web.Browser;

public class Browser_withPages_Test extends LoggingTestCase {

	@Test
	public void testNull1() {

		try {
			Browser.withPage(null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'pageUri' is null", ex.getMessage());
		}

		try {
			Browser.withPages((String[]) null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'pageUris' is null", ex.getMessage());
		}

		try {
			Browser.withPages((Collection<String>) null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'pageUris' is null", ex.getMessage());
		}
	}

	@Test
	public void testNull2() {

		try {
			Browser.withPages("a", null, "c");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'pageUris[1]' is null", ex.getMessage());
		}

		Collection<String> col = new ArrayList<String>();
		col.add("a");
		col.add(null);
		col.add("c");

		try {
			Browser.withPages(col);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'pageUris[1]' is null", ex.getMessage());
		}
	}

	@Test
	public void testNormal() {
		Assert.assertEquals("xeno.remoting.web.PageFilteredJavaScriptCallback", Browser.withPage("a").getClass().getName());

		Assert.assertEquals("xeno.remoting.web.PageFilteredJavaScriptCallback", Browser.withPages().getClass().getName());
		Assert.assertEquals("xeno.remoting.web.PageFilteredJavaScriptCallback", Browser.withPages("a").getClass().getName());
		Assert.assertEquals("xeno.remoting.web.PageFilteredJavaScriptCallback", Browser.withPages("a", "b").getClass().getName());

		Collection<String> col = new ArrayList<String>();
		Assert.assertEquals("xeno.remoting.web.PageFilteredJavaScriptCallback", Browser.withPages(col).getClass().getName());

		col.add("a");
		Assert.assertEquals("xeno.remoting.web.PageFilteredJavaScriptCallback", Browser.withPages(col).getClass().getName());

		col.add("c");
		Assert.assertEquals("xeno.remoting.web.PageFilteredJavaScriptCallback", Browser.withPages(col).getClass().getName());
	}
}
