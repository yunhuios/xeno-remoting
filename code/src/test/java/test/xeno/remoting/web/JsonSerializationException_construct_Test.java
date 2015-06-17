package test.xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

import xeno.remoting.web.JsonSerializationException;

public class JsonSerializationException_construct_Test {

	@Test
	public void test1() {
		JsonSerializationException ex = new JsonSerializationException(null, null);
		Assert.assertNull(ex.getMessage());
		Assert.assertNull(ex.getCause());
	}

	@Test
	public void test2() {
		JsonSerializationException ex = new JsonSerializationException(null);
		Assert.assertNull(ex.getMessage());
		Assert.assertNull(ex.getCause());
	}

	@Test
	public void test3() {
		final String message = "a";

		JsonSerializationException ex = new JsonSerializationException(message, null);
		Assert.assertEquals(message, ex.getMessage());
		Assert.assertNull(ex.getCause());
	}

	@Test
	public void test4() {
		final String message = "a";

		JsonSerializationException ex = new JsonSerializationException(message);
		Assert.assertEquals(message, ex.getMessage());
		Assert.assertNull(ex.getCause());
	}

	@Test
	public void test5() {
		final Throwable throwable = new Exception();

		JsonSerializationException ex = new JsonSerializationException(null, throwable);
		Assert.assertNull(ex.getMessage());
		Assert.assertEquals(throwable, ex.getCause());
	}

	@Test
	public void test6() {
		final String message = "a";
		final Throwable throwable = new Exception();

		JsonSerializationException ex = new JsonSerializationException(message, throwable);
		Assert.assertEquals(message, ex.getMessage());
		Assert.assertEquals(throwable, ex.getCause());
	}
}
