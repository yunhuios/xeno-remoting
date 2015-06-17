package xeno.remoting.web;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.AsyncContext;

import mock.javax.servlet.MockAsyncContext;

import org.junit.Assert;
import org.junit.Test;

public class AbstractJavaScriptCallback_invokeAsync_Test {

	@Test
	public void testNull() {

		try {
			new JavaScriptCallback().invokeAsync(null, new JavaScriptFunction[0]);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'asyncContexts' is null", ex.getMessage());
		}

		Set<AsyncContext> asyncContexts = new HashSet<AsyncContext>();
		asyncContexts.add(new MockAsyncContext());
		asyncContexts.add(null);
		asyncContexts.add(new MockAsyncContext());

		try {
			new JavaScriptCallback().invokeAsync(asyncContexts, new JavaScriptFunction[0]);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertTrue(ex.getMessage().startsWith("The 'asyncContexts[") && ex.getMessage().endsWith("]' is null"));
		}

		try {
			new JavaScriptCallback().invokeAsync(new HashSet<AsyncContext>(), null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'functions' is null", ex.getMessage());
		}

		try {
			new JavaScriptCallback().invokeAsync(new HashSet<AsyncContext>(), new JavaScriptFunction[] { new JavaScriptFunction("a"), null, new JavaScriptFunction("c") });
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'functions[1]' is null", ex.getMessage());
		}
	}

	@Test
	public void testNormal() throws Exception {
		new JavaScriptCallback().invokeAsync(new HashSet<AsyncContext>(), new JavaScriptFunction[0]);

		Thread.sleep(3000);
	}

	private class JavaScriptCallback extends AbstractJavaScriptCallback {

		@Override
		public void invoke(JavaScriptFunction... functions) throws IllegalArgumentException {
			// Does nothing.
		}

		@Override
		public void invokeAsync(Set<AsyncContext> asyncContexts, JavaScriptFunction[] functions) throws IllegalArgumentException {
			super.invokeAsync(asyncContexts, functions);
		}
	}
}
