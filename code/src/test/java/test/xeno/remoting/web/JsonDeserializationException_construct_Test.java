package test.xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

import xeno.remoting.web.JsonDeserializationException;

public class JsonDeserializationException_construct_Test {

	@Test
	public void test1() {
		JsonDeserializationException ex = new JsonDeserializationException(null, null);
		Assert.assertNull(ex.getMessage());
		Assert.assertNull(ex.getCause());
	}

	@Test
	public void test2() {
		JsonDeserializationException ex = new JsonDeserializationException(null);
		Assert.assertNull(ex.getMessage());
		Assert.assertNull(ex.getCause());
	}

	@Test
	public void test3() {
		final String message = "a";

		JsonDeserializationException ex = new JsonDeserializationException(message, null);
		Assert.assertEquals(message, ex.getMessage());
		Assert.assertNull(ex.getCause());
	}

	@Test
	public void test4() {
		final String message = "a";

		JsonDeserializationException ex = new JsonDeserializationException(message);
		Assert.assertEquals(message, ex.getMessage());
		Assert.assertNull(ex.getCause());
	}

	@Test
	public void test5() {
		final Throwable throwable = new Exception();

		JsonDeserializationException ex = new JsonDeserializationException(null, throwable);
		Assert.assertNull(ex.getMessage());
		Assert.assertEquals(throwable, ex.getCause());
	}

	@Test
	public void test6() {
		final String message = "a";
		final Throwable throwable = new Exception();

		JsonDeserializationException ex = new JsonDeserializationException(message, throwable);
		Assert.assertEquals(message, ex.getMessage());
		Assert.assertEquals(throwable, ex.getCause());
	}
}
