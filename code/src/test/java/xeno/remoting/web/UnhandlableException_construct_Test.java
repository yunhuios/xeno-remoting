package xeno.remoting.web;

import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Test;

public class UnhandlableException_construct_Test {

	@Test
	public void test1() {
		final int statusCode = 1;

		UnhandlableException ex = new UnhandlableException(statusCode, null, null);
		Assert.assertEquals(1, ex.getStatusCode());
		Assert.assertNull(ex.getMessage());
		Assert.assertNull(ex.getCause());

		ex = new UnhandlableException(null, null);
		Assert.assertEquals(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getStatusCode());
		Assert.assertNull(ex.getMessage());
		Assert.assertNull(ex.getCause());

		ex = new UnhandlableException(statusCode, null);
		Assert.assertEquals(statusCode, ex.getStatusCode());
		Assert.assertNull(ex.getMessage());
		Assert.assertNull(ex.getCause());

		ex = new UnhandlableException(null);
		Assert.assertEquals(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getStatusCode());
		Assert.assertNull(ex.getMessage());
		Assert.assertNull(ex.getCause());
	}

	@Test
	public void test2() {
		final int statusCode = 2;
		final String message = "a";

		UnhandlableException ex = new UnhandlableException(statusCode, message, null);
		Assert.assertEquals(statusCode, ex.getStatusCode());
		Assert.assertEquals(message, ex.getMessage());
		Assert.assertNull(ex.getCause());

		ex = new UnhandlableException(message, null);
		Assert.assertEquals(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getStatusCode());
		Assert.assertEquals(message, ex.getMessage());
		Assert.assertNull(ex.getCause());

		ex = new UnhandlableException(statusCode, message);
		Assert.assertEquals(statusCode, ex.getStatusCode());
		Assert.assertEquals(message, ex.getMessage());
		Assert.assertNull(ex.getCause());

		ex = new UnhandlableException(message);
		Assert.assertEquals(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getStatusCode());
		Assert.assertEquals(message, ex.getMessage());
		Assert.assertNull(ex.getCause());
	}

	@Test
	public void test3() {
		final int statusCode = 3;
		final String message = "b";
		final Throwable cause = new Exception();

		UnhandlableException ex = new UnhandlableException(statusCode, null, cause);
		Assert.assertEquals(statusCode, ex.getStatusCode());
		Assert.assertNull(ex.getMessage());
		Assert.assertEquals(cause, ex.getCause());

		ex = new UnhandlableException(null, cause);
		Assert.assertEquals(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getStatusCode());
		Assert.assertNull(ex.getMessage());
		Assert.assertEquals(cause, ex.getCause());

		ex = new UnhandlableException(statusCode, message, cause);
		Assert.assertEquals(statusCode, ex.getStatusCode());
		Assert.assertEquals(message, ex.getMessage());
		Assert.assertEquals(cause, ex.getCause());

		ex = new UnhandlableException(message, cause);
		Assert.assertEquals(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getStatusCode());
		Assert.assertEquals(message, ex.getMessage());
		Assert.assertEquals(cause, ex.getCause());
	}
}
