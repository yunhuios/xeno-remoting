package test.xeno.remoting.web;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import test.xeno.remoting.ServletTestCase;

public class MessageServlet_doGet_Test extends ServletTestCase {

	@Test
	public void testIllegalUrl() throws Exception {
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "// Unable to handle the static request: /org.showcase.web.TestController.do", doGet(true, "http://localhost/xr/org.showcase.web.TestController.do"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "// Unable to handle the static request: /org.showcase.web.TestController.do", doGet(false, "http://localhost/xr/org.showcase.web.TestController.do"));

		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "// Unable to handle the static request: /org.showcase.web.TestController.htm", doGet(true, "http://localhost/xr/org.showcase.web.TestController.htm"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "// Unable to handle the static request: /org.showcase.web.TestController.htm", doGet(false, "http://localhost/xr/org.showcase.web.TestController.htm"));
	}

	@Test
	public void testGetSingleJavaScript() throws Exception {

		// No mapping class.
		assertResponse(HttpServletResponse.SC_NOT_FOUND, "// No mapping class for the request: /org.showcase.web.NoTestController.js", doGet(true, "http://localhost/xr/org.showcase.web.NoTestController.js"));
		assertResponse(HttpServletResponse.SC_OK, "Sorry, content could not be displayed in non-debug mode, access denied!", doGet(false, "http://localhost/xr/org.showcase.web.NoTestController.js"));

		// Empty remote proxy.
		assertResponse(HttpServletResponse.SC_OK, "xeno.remoting.web.Engine.registerClass(\"org.showcase.web.EmptyController\");", doGet(true, "http://localhost/xr/org.showcase.web.EmptyController.js"));
		assertResponse(HttpServletResponse.SC_OK, "Sorry, content could not be displayed in non-debug mode, access denied!", doGet(false, "http://localhost/xr/org.showcase.web.EmptyController.js"));

		// Normal remote proxy.
		StringBuffer content = new StringBuffer();
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.MockController\");\n\n");
		content.append("org.showcase.web.MockController.foo = function(arg0, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.MockController\", \"foo\", [arg0], opts);\n");
		content.append("};");
		assertResponse(HttpServletResponse.SC_OK, content.toString(), doGet(true, "http://localhost/xr/org.showcase.web.MockController.js"));
		assertResponse(HttpServletResponse.SC_OK, "Sorry, content could not be displayed in non-debug mode, access denied!", doGet(false, "http://localhost/xr/org.showcase.web.MockController.js"));

		content = new StringBuffer();
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.TestController\");\n\n");
		content.append("org.showcase.web.TestController.getNextPage = function(arg0, arg1, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\", \"getNextPage\", [arg0, arg1], opts);\n");
		content.append("};\n\n");
		content.append("org.showcase.web.TestController.getPreviousPage = function(arg0, arg1, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\", \"getPreviousPage\", [arg0, arg1], opts);\n");
		content.append("};\n\n");
		content.append("org.showcase.web.TestController.login = function(arg0, arg1, arg2, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\", \"login\", [arg0, arg1, arg2], opts);\n");
		content.append("};\n\n");
		content.append("org.showcase.web.TestController.logout = function(opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\", \"logout\", [], opts);\n");
		content.append("};");
		assertResponse(HttpServletResponse.SC_OK, content.toString(), doGet(true, "http://localhost/xr/org.showcase.web.TestController.js"));
		assertResponse(HttpServletResponse.SC_OK, "Sorry, content could not be displayed in non-debug mode, access denied!", doGet(false, "http://localhost/xr/org.showcase.web.TestController.js"));
	}

	@Test
	public void testGetBatchJavaScript() throws Exception {

		// Invalid mapping index.
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "// Invalid mapping index for the request: /combined-0-a.js, index: a", doGet(true, "http://localhost/xr/combined-0-a.js"));
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "// Invalid mapping index for the request: /combined-0-a.js, index: a", doGet(false, "http://localhost/xr/combined-0-a.js"));

		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "// Invalid mapping index for the request: /combined-b-0.js, index: b", doGet(true, "http://localhost/xr/combined-b-0.js"));
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "// Invalid mapping index for the request: /combined-b-0.js, index: b", doGet(false, "http://localhost/xr/combined-b-0.js"));

		// No mapping index.
		assertResponse(HttpServletResponse.SC_NOT_FOUND, "// No mapping index for the request: /combined-0-99998.js, index: 99998", doGet(true, "http://localhost/xr/combined-0-99998.js"));
		assertResponse(HttpServletResponse.SC_NOT_FOUND, "// No mapping index for the request: /combined-0-99998.js, index: 99998", doGet(false, "http://localhost/xr/combined-0-99998.js"));

		assertResponse(HttpServletResponse.SC_NOT_FOUND, "// No mapping index for the request: /combined-99999-0.js, index: 99999", doGet(true, "http://localhost/xr/combined-99999-0.js"));
		assertResponse(HttpServletResponse.SC_NOT_FOUND, "// No mapping index for the request: /combined-99999-0.js, index: 99999", doGet(false, "http://localhost/xr/combined-99999-0.js"));

		// Normal remote proxy.
		StringBuffer content = new StringBuffer();
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.EmptyController\");");
		assertResponse(HttpServletResponse.SC_OK, content.toString(), doGet(true, "http://localhost/xr/combined-0.js"));
		assertResponse(HttpServletResponse.SC_OK, content.toString(), doGet(false, "http://localhost/xr/combined-0.js"));

		content = new StringBuffer();
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.EmptyController\");\n");
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.MockController\");\n\n");
		content.append("org.showcase.web.MockController.foo = function(arg0, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.MockController\", \"foo\", [arg0], opts);\n");
		content.append("};");
		assertResponse(HttpServletResponse.SC_OK, content.toString(), doGet(true, "http://localhost/xr/combined-0-1.js"));
		assertResponse(HttpServletResponse.SC_OK, "xeno.remoting.web.Engine.registerClass(\"org.showcase.web.EmptyController\");\nxeno.remoting.web.Engine.registerClass(\"org.showcase.web.MockController\");org.showcase.web.MockController.foo=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.MockController\",\"foo\",[a],b)};", doGet(false, "http://localhost/xr/combined-0-1.js"));

		content = new StringBuffer();
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.MockController\");\n\n");
		content.append("org.showcase.web.MockController.foo = function(arg0, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.MockController\", \"foo\", [arg0], opts);\n");
		content.append("};\n");
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.EmptyController\");");
		assertResponse(HttpServletResponse.SC_OK, content.toString(), doGet(true, "http://localhost/xr/combined-1-0.js"));
		assertResponse(HttpServletResponse.SC_OK, "xeno.remoting.web.Engine.registerClass(\"org.showcase.web.MockController\");org.showcase.web.MockController.foo=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.MockController\",\"foo\",[a],b)};\nxeno.remoting.web.Engine.registerClass(\"org.showcase.web.EmptyController\");", doGet(false, "http://localhost/xr/combined-1-0.js"));

		content = new StringBuffer();
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.TestController\");\n\n");
		content.append("org.showcase.web.TestController.getNextPage = function(arg0, arg1, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\", \"getNextPage\", [arg0, arg1], opts);\n");
		content.append("};\n\n");
		content.append("org.showcase.web.TestController.getPreviousPage = function(arg0, arg1, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\", \"getPreviousPage\", [arg0, arg1], opts);\n");
		content.append("};\n\n");
		content.append("org.showcase.web.TestController.login = function(arg0, arg1, arg2, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\", \"login\", [arg0, arg1, arg2], opts);\n");
		content.append("};\n\n");
		content.append("org.showcase.web.TestController.logout = function(opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\", \"logout\", [], opts);\n");
		content.append("};\n");
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.EmptyController\");\n");
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.MockController\");\n\n");
		content.append("org.showcase.web.MockController.foo = function(arg0, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.MockController\", \"foo\", [arg0], opts);\n");
		content.append("};");
		assertResponse(HttpServletResponse.SC_OK, content.toString(), doGet(true, "http://localhost/xr/combined-2-0-1.js"));
		assertResponse(HttpServletResponse.SC_OK, "xeno.remoting.web.Engine.registerClass(\"org.showcase.web.TestController\");org.showcase.web.TestController.getNextPage=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\",\"getNextPage\",[b,a],c)};org.showcase.web.TestController.getPreviousPage=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\",\"getPreviousPage\",[b,a],c)};org.showcase.web.TestController.login=function(c,b,a,d){return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\",\"login\",[c,b,a],d)};org.showcase.web.TestController.logout=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\",\"logout\",[],a)};\nxeno.remoting.web.Engine.registerClass(\"org.showcase.web.EmptyController\");\nxeno.remoting.web.Engine.registerClass(\"org.showcase.web.MockController\");org.showcase.web.MockController.foo=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.MockController\",\"foo\",[a],b)};", doGet(false, "http://localhost/xr/combined-2-0-1.js"));

		content = new StringBuffer();
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.EmptyController\");\n");
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.MockController\");\n\n");
		content.append("org.showcase.web.MockController.foo = function(arg0, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.MockController\", \"foo\", [arg0], opts);\n");
		content.append("};");
		assertResponse(HttpServletResponse.SC_OK, content.toString(), doGet(true, "http://localhost/xr/combined-0-1-1-0.js"));
		assertResponse(HttpServletResponse.SC_OK, "xeno.remoting.web.Engine.registerClass(\"org.showcase.web.EmptyController\");\nxeno.remoting.web.Engine.registerClass(\"org.showcase.web.MockController\");org.showcase.web.MockController.foo=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.MockController\",\"foo\",[a],b)};", doGet(false, "http://localhost/xr/combined-0-1-1-0.js"));

		content = new StringBuffer();
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.TestController\");\n\n");
		content.append("org.showcase.web.TestController.getNextPage = function(arg0, arg1, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\", \"getNextPage\", [arg0, arg1], opts);\n");
		content.append("};\n\n");
		content.append("org.showcase.web.TestController.getPreviousPage = function(arg0, arg1, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\", \"getPreviousPage\", [arg0, arg1], opts);\n");
		content.append("};\n\n");
		content.append("org.showcase.web.TestController.login = function(arg0, arg1, arg2, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\", \"login\", [arg0, arg1, arg2], opts);\n");
		content.append("};\n\n");
		content.append("org.showcase.web.TestController.logout = function(opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\", \"logout\", [], opts);\n");
		content.append("};\n");
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.EmptyController\");\n");
		content.append("xeno.remoting.web.Engine.registerClass(\"org.showcase.web.MockController\");\n\n");
		content.append("org.showcase.web.MockController.foo = function(arg0, opts) {\n\t");
		content.append("return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.MockController\", \"foo\", [arg0], opts);\n");
		content.append("};");
		assertResponse(HttpServletResponse.SC_OK, content.toString(), doGet(true, "http://localhost/xr/combined-2-0-1-2-1-0-1.js"));
		assertResponse(HttpServletResponse.SC_OK, "xeno.remoting.web.Engine.registerClass(\"org.showcase.web.TestController\");org.showcase.web.TestController.getNextPage=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\",\"getNextPage\",[b,a],c)};org.showcase.web.TestController.getPreviousPage=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\",\"getPreviousPage\",[b,a],c)};org.showcase.web.TestController.login=function(c,b,a,d){return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\",\"login\",[c,b,a],d)};org.showcase.web.TestController.logout=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.TestController\",\"logout\",[],a)};\nxeno.remoting.web.Engine.registerClass(\"org.showcase.web.EmptyController\");\nxeno.remoting.web.Engine.registerClass(\"org.showcase.web.MockController\");org.showcase.web.MockController.foo=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"org.showcase.web.MockController\",\"foo\",[a],b)};", doGet(false, "http://localhost/xr/combined-2-0-1-2-1-0-1.js"));
	}

	@Test
	public void testGetRemoteProxyHtml() throws Exception {
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "// Unable to handle the static request: /a/index.htm", doGet(true, "http://localhost/xr/a/index.htm"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "// Unable to handle the static request: /a/index.htm", doGet(false, "http://localhost/xr/a/index.htm"));

		assertResponsePartly(HttpServletResponse.SC_OK, "<!doctype html>\n<html>", "</html>", doGet(true, "http://localhost/xr/index.htm"));
		assertResponse(HttpServletResponse.SC_OK, "Sorry, content could not be displayed in non-debug mode, access denied!", doGet(false, "http://localhost/xr/index.htm"));
	}
}
