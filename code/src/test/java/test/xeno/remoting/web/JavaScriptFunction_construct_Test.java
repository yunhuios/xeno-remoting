package test.xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

import xeno.remoting.web.JavaScriptFunction;

public class JavaScriptFunction_construct_Test {

	@Test
	public void testNullName() {

		try {
			new JavaScriptFunction(null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'name' is null", ex.getMessage());
		}
	}

	@Test
	public void testEmptyName() {
		final String name = "";

		JavaScriptFunction func = new JavaScriptFunction(name);
		Assert.assertEquals(name, func.getName());
		Assert.assertEquals(0, func.getArguments().length);
	}

	@Test
	public void testBlankName() {
		final String name = " ";

		JavaScriptFunction func = new JavaScriptFunction(name);
		Assert.assertEquals(name, func.getName());
		Assert.assertEquals(0, func.getArguments().length);
	}

	@Test
	public void test1() {
		final String name = "a";

		JavaScriptFunction func = new JavaScriptFunction(name);
		Assert.assertEquals(name, func.getName());
		Assert.assertEquals(0, func.getArguments().length);
	}

	@Test
	public void test2() {
		final String name = "a";
		final int a = 1;
		final boolean b = true;
		final Object c = new Object();

		JavaScriptFunction func = new JavaScriptFunction(name, (String) null);
		Assert.assertEquals(name, func.getName());
		Assert.assertEquals(1, func.getArguments().length);
		Assert.assertNull(func.getArguments()[0]);

		func = new JavaScriptFunction(name, null, null);
		Assert.assertEquals(name, func.getName());
		Assert.assertEquals(2, func.getArguments().length);
		Assert.assertNull(func.getArguments()[0]);
		Assert.assertNull(func.getArguments()[1]);

		func = new JavaScriptFunction(name, a);
		Assert.assertEquals(name, func.getName());
		Assert.assertEquals(1, func.getArguments().length);
		Assert.assertEquals(a, func.getArguments()[0]);

		func = new JavaScriptFunction(name, b, a, c);
		Assert.assertEquals(name, func.getName());
		Assert.assertEquals(3, func.getArguments().length);
		Assert.assertEquals(b, func.getArguments()[0]);
		Assert.assertEquals(a, func.getArguments()[1]);
		Assert.assertEquals(c, func.getArguments()[2]);
	}

	@Test
	public void test3() {
		final String name = "a";
		final int a = 1;
		final boolean b = true;
		final Object c = new Object();

		JavaScriptFunction func = new JavaScriptFunction(name, (Object[]) null);
		Assert.assertEquals(name, func.getName());
		Assert.assertEquals(1, func.getArguments().length);
		Assert.assertNull(func.getArguments()[0]);

		func = new JavaScriptFunction(name, null, null);
		Assert.assertEquals(name, func.getName());
		Assert.assertEquals(2, func.getArguments().length);
		Assert.assertNull(func.getArguments()[0]);
		Assert.assertNull(func.getArguments()[1]);

		func = new JavaScriptFunction(name, a);
		Assert.assertEquals(name, func.getName());
		Assert.assertEquals(1, func.getArguments().length);
		Assert.assertEquals(a, func.getArguments()[0]);

		func = new JavaScriptFunction(name, b, a, c);
		Assert.assertEquals(name, func.getName());
		Assert.assertEquals(3, func.getArguments().length);
		Assert.assertEquals(b, func.getArguments()[0]);
		Assert.assertEquals(a, func.getArguments()[1]);
		Assert.assertEquals(c, func.getArguments()[2]);
	}
}
