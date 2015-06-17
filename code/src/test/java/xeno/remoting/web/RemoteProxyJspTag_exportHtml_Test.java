package xeno.remoting.web;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("serial")
public class RemoteProxyJspTag_exportHtml_Test extends ProxyJspTag {

	@Test
	public void testNull() throws Exception {

		try {
			exportHtml(null, new ArrayList<KeyValue<Integer, RemoteProxyMetadata>>(), false, new StringWriter());
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'path' is null", ex.getMessage());
		}

		try {
			exportHtml(null, new ArrayList<KeyValue<Integer, RemoteProxyMetadata>>(), true, new StringWriter());
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'path' is null", ex.getMessage());
		}

		try {
			exportHtml("", null, false, new StringWriter());
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'imports' is null", ex.getMessage());
		}

		try {
			exportHtml("", null, true, new StringWriter());
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'imports' is null", ex.getMessage());
		}

		try {
			exportHtml("", new ArrayList<KeyValue<Integer, RemoteProxyMetadata>>(), false, null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'output' is null", ex.getMessage());
		}

		try {
			exportHtml("", new ArrayList<KeyValue<Integer, RemoteProxyMetadata>>(), true, null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'output' is null", ex.getMessage());
		}
	}

	@Test
	public void testEmpty() throws Exception {
		List<KeyValue<Integer, RemoteProxyMetadata>> imports = new ArrayList<KeyValue<Integer, RemoteProxyMetadata>>();

		StringWriter output = new StringWriter();
		exportHtml("", imports, false, output);
		Assert.assertEquals("", output.toString());

		output = new StringWriter();
		exportHtml("", imports, true, output);
		Assert.assertEquals("", output.toString());
	}

	@Test
	public void testDebug() throws Exception {
		List<KeyValue<Integer, RemoteProxyMetadata>> imports = new ArrayList<KeyValue<Integer, RemoteProxyMetadata>>();

		StringWriter output = new StringWriter();
		exportHtml("", imports, true, output);
		Assert.assertEquals("", output.toString());

		imports = new ArrayList<KeyValue<Integer, RemoteProxyMetadata>>();
		imports.add(new KeyValue<Integer, RemoteProxyMetadata>(0, new RemoteProxyMetadata(internal.remoteproxy.legal.EmptyRemoteProxy.class, false)));

		output = new StringWriter();
		exportHtml("", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.EmptyRemoteProxy.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml(" ", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.EmptyRemoteProxy.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml("a", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"a/internal.remoteproxy.legal.EmptyRemoteProxy.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml(" a", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"a/internal.remoteproxy.legal.EmptyRemoteProxy.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml("a ", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"a/internal.remoteproxy.legal.EmptyRemoteProxy.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml("/a", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/a/internal.remoteproxy.legal.EmptyRemoteProxy.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml(" /a", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/a/internal.remoteproxy.legal.EmptyRemoteProxy.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml("/a ", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/a/internal.remoteproxy.legal.EmptyRemoteProxy.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml("/", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.EmptyRemoteProxy.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml(" /", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.EmptyRemoteProxy.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml("/ ", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.EmptyRemoteProxy.js\"></script>", output.toString());

		imports = new ArrayList<KeyValue<Integer, RemoteProxyMetadata>>();
		imports.add(new KeyValue<Integer, RemoteProxyMetadata>(1, new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.MockClass_01.class, false)));
		imports.add(new KeyValue<Integer, RemoteProxyMetadata>(2, new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.MockClass_03.class, false)));

		output = new StringWriter();
		exportHtml("", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.cat01.MockClass_01.js\"></script>\n<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.cat01.MockClass_03.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml(" ", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.cat01.MockClass_01.js\"></script>\n<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.cat01.MockClass_03.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml("a", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"a/internal.remoteproxy.legal.cat01.MockClass_01.js\"></script>\n<script type=\"text/javascript\" src=\"a/internal.remoteproxy.legal.cat01.MockClass_03.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml(" a", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"a/internal.remoteproxy.legal.cat01.MockClass_01.js\"></script>\n<script type=\"text/javascript\" src=\"a/internal.remoteproxy.legal.cat01.MockClass_03.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml("a ", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"a/internal.remoteproxy.legal.cat01.MockClass_01.js\"></script>\n<script type=\"text/javascript\" src=\"a/internal.remoteproxy.legal.cat01.MockClass_03.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml("/a", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/a/internal.remoteproxy.legal.cat01.MockClass_01.js\"></script>\n<script type=\"text/javascript\" src=\"/a/internal.remoteproxy.legal.cat01.MockClass_03.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml(" /a", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/a/internal.remoteproxy.legal.cat01.MockClass_01.js\"></script>\n<script type=\"text/javascript\" src=\"/a/internal.remoteproxy.legal.cat01.MockClass_03.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml("/a ", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/a/internal.remoteproxy.legal.cat01.MockClass_01.js\"></script>\n<script type=\"text/javascript\" src=\"/a/internal.remoteproxy.legal.cat01.MockClass_03.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml("/", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.cat01.MockClass_01.js\"></script>\n<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.cat01.MockClass_03.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml(" /", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.cat01.MockClass_01.js\"></script>\n<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.cat01.MockClass_03.js\"></script>", output.toString());

		output = new StringWriter();
		exportHtml("/ ", imports, true, output);
		Assert.assertEquals("<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.cat01.MockClass_01.js\"></script>\n<script type=\"text/javascript\" src=\"/internal.remoteproxy.legal.cat01.MockClass_03.js\"></script>", output.toString());
	}

	@Test
	public void testProduct() throws Exception {
		List<KeyValue<Integer, RemoteProxyMetadata>> imports = new ArrayList<KeyValue<Integer, RemoteProxyMetadata>>();

		StringWriter output = new StringWriter();
		exportHtml("", imports, false, output);
		Assert.assertEquals("", output.toString());

		imports = new ArrayList<KeyValue<Integer, RemoteProxyMetadata>>();
		imports.add(new KeyValue<Integer, RemoteProxyMetadata>(0, new RemoteProxyMetadata(internal.remoteproxy.legal.EmptyRemoteProxy.class, false)));

		output = new StringWriter();
		exportHtml("", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/combined-0.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml(" ", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/combined-0.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml("a", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"a/combined-0.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml(" a", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"a/combined-0.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml("a ", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"a/combined-0.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml("/a", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/a/combined-0.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml(" /a", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/a/combined-0.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml("/a ", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/a/combined-0.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml("/", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/combined-0.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml(" /", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/combined-0.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml("/ ", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/combined-0.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		imports = new ArrayList<KeyValue<Integer, RemoteProxyMetadata>>();
		imports.add(new KeyValue<Integer, RemoteProxyMetadata>(1, new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.MockClass_01.class, false)));
		imports.add(new KeyValue<Integer, RemoteProxyMetadata>(2, new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.MockClass_03.class, false)));

		output = new StringWriter();
		exportHtml("", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/combined-1-2.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml(" ", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/combined-1-2.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml("a", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"a/combined-1-2.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml(" a", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"a/combined-1-2.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml("a ", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"a/combined-1-2.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml("/a", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/a/combined-1-2.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml(" /a", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/a/combined-1-2.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml("/a ", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/a/combined-1-2.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml("/", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/combined-1-2.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml(" /", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/combined-1-2.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));

		output = new StringWriter();
		exportHtml("/ ", imports, false, output);
		Assert.assertTrue(output.toString().startsWith("<script type=\"text/javascript\" src=\"/combined-1-2.js?t="));
		Assert.assertTrue(output.toString().endsWith("\"></script>"));
	}
}
