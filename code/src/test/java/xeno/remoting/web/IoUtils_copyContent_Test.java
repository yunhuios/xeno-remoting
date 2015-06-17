package xeno.remoting.web;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Assert;
import org.junit.Test;

public class IoUtils_copyContent_Test {

	@Test
	public void testNull() throws IOException {

		try {
			IoUtils.copyContent(null, new StringWriter());
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'in' is null", ex.getMessage());
		}

		try {
			IoUtils.copyContent(new StringReader(""), null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'out' is null", ex.getMessage());
		}
	}

	@Test
	public void testNormal() throws IOException {
		Reader in = new StringReader("");
		Writer out = new StringWriter();
		IoUtils.copyContent(in, out);
		IoUtils.closeQuietly(in, out);
		Assert.assertEquals("", out.toString());

		in = new StringReader("a");
		out = new StringWriter();
		IoUtils.copyContent(in, out);
		IoUtils.closeQuietly(in, out);
		Assert.assertEquals("a", out.toString());

		in = new StringReader(" a");
		out = new StringWriter();
		IoUtils.copyContent(in, out);
		IoUtils.closeQuietly(in, out);
		Assert.assertEquals(" a", out.toString());

		in = new StringReader("a ");
		out = new StringWriter();
		IoUtils.copyContent(in, out);
		Assert.assertEquals("a ", out.toString());

		in = new StringReader(" a ");
		out = new StringWriter();
		IoUtils.copyContent(in, out);
		IoUtils.closeQuietly(in, out);
		Assert.assertEquals(" a ", out.toString());

		in = new StringReader("\na\n");
		out = new StringWriter();
		IoUtils.copyContent(in, out);
		IoUtils.closeQuietly(in, out);
		Assert.assertEquals("\na\n", out.toString());
	}
}
