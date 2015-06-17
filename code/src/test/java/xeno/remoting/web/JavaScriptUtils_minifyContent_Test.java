package xeno.remoting.web;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class JavaScriptUtils_minifyContent_Test {

	@Test
	public void testIt() throws IOException {
		Assert.assertEquals("", JavaScriptUtils.minifyContent(null));
		Assert.assertEquals("", JavaScriptUtils.minifyContent(""));
		Assert.assertEquals("", JavaScriptUtils.minifyContent(" "));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("//"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("// "));
		Assert.assertEquals("", JavaScriptUtils.minifyContent(" //"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("// var a = 0;"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/**/"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/**/ "));
		Assert.assertEquals("", JavaScriptUtils.minifyContent(" /**/"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/*\\n*/"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/*\\n*/ "));
		Assert.assertEquals("", JavaScriptUtils.minifyContent(" /*\\n*/"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/* a */"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/* var a = 0; */"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/*\\na\\n*/"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/*\\nvar a = 0;\\n*/"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/***/"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/***/ "));
		Assert.assertEquals("", JavaScriptUtils.minifyContent(" /***/"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/**\\n*/"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/**\\n*/ "));
		Assert.assertEquals("", JavaScriptUtils.minifyContent(" /**\\n*/"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/** a */"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/** var a = 0; */"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/**\\na\\n*/"));
		Assert.assertEquals("", JavaScriptUtils.minifyContent("/**\\nvar a = 0;\\n*/"));
		Assert.assertEquals("var A=function(d,c){var f=0;var e=\"abc\"};", JavaScriptUtils.minifyContent("var A = function(a, b) {\n\tvar _a = 0;\n\tvar _b = \"abc\";\n};"));
	}
}
