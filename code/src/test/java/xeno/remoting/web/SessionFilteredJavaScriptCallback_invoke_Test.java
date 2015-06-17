package xeno.remoting.web;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class SessionFilteredJavaScriptCallback_invoke_Test {

	@Test
	public void testNull1() {

		try {
			new SessionFilteredJavaScriptCallback(new String[0]).invoke((String) null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'name' is null", ex.getMessage());
		}

		try {
			new SessionFilteredJavaScriptCallback(new String[0]).invoke((JavaScriptFunction[]) null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'functions' is null", ex.getMessage());
		}

		try {
			new SessionFilteredJavaScriptCallback(new String[0]).invoke((Collection<JavaScriptFunction>) null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'functions' is null", ex.getMessage());
		}
	}

	@Test
	public void testNull2() {

		try {
			new SessionFilteredJavaScriptCallback(new String[0]).invoke(new JavaScriptFunction("a"), null, new JavaScriptFunction("c"));
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'functions[1]' is null", ex.getMessage());
		}

		Collection<JavaScriptFunction> col = new ArrayList<JavaScriptFunction>();
		col.add(new JavaScriptFunction("a"));
		col.add(null);
		col.add(new JavaScriptFunction("c"));

		try {
			new SessionFilteredJavaScriptCallback(new String[0]).invoke(col);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'functions[1]' is null", ex.getMessage());
		}
	}
}
