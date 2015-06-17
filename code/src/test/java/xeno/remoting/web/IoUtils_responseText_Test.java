package xeno.remoting.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import mock.javax.servlet.MockServletResponse;

import org.junit.Assert;
import org.junit.Test;

public class IoUtils_responseText_Test {

	@Test
	public void testNull() throws IOException {

		try {
			IoUtils.responseText(null, "a");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'response' is null", ex.getMessage());
		}
	}

	@Test
	public void testNormal() throws IOException {
		ServletResponse response = new ServletResponse();
		IoUtils.responseText(response, null);
		Assert.assertEquals("", response.getText());

		response = new ServletResponse();
		IoUtils.responseText(response, "");
		Assert.assertEquals("", response.getText());

		response = new ServletResponse();
		IoUtils.responseText(response, " ");
		Assert.assertEquals(" ", response.getText());

		response = new ServletResponse();
		IoUtils.responseText(response, "\n");
		Assert.assertEquals("\n", response.getText());

		response = new ServletResponse();
		IoUtils.responseText(response, "abc");
		Assert.assertEquals("abc", response.getText());
	}

	private class ServletResponse extends MockServletResponse {
		private StringWriter out = new StringWriter();

		@Override
		public PrintWriter getWriter() throws IOException {
			return new PrintWriter(out);
		}

		public String getText() {
			return out.toString();
		}
	}
}
