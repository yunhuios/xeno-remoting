package xeno.remoting.web;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class SingleNotificationJavaScriptCallback_invoke_Test {

	@Test
	public void testNull1() {

		try {
			new SingleNotificationJavaScriptCallback("a", "b").invoke((String) null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'name' is null", ex.getMessage());
		}

		try {
			new SingleNotificationJavaScriptCallback("a", "b").invoke((JavaScriptFunction[]) null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'functions' is null", ex.getMessage());
		}

		try {
			new SingleNotificationJavaScriptCallback("a", "b").invoke((Collection<JavaScriptFunction>) null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'functions' is null", ex.getMessage());
		}
	}

	@Test
	public void testNull2() {

		try {
			new SingleNotificationJavaScriptCallback("a", "b").invoke(new JavaScriptFunction("a"), null, new JavaScriptFunction("b"));
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'functions[1]' is null", ex.getMessage());
		}

		Collection<JavaScriptFunction> col = new ArrayList<JavaScriptFunction>();
		col.add(new JavaScriptFunction("a"));
		col.add(null);
		col.add(new JavaScriptFunction("b"));

		try {
			new SingleNotificationJavaScriptCallback("a", "b").invoke(col);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'functions[1]' is null", ex.getMessage());
		}
	}
}
