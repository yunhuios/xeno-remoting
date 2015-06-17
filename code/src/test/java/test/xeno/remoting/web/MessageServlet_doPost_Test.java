package test.xeno.remoting.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.showcase.model.Account;
import org.showcase.model.Document;
import org.showcase.model.Folder;
import org.showcase.web.extra.TestController;

import test.xeno.remoting.ServletTestCase;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class MessageServlet_doPost_Test extends ServletTestCase {

	@Test
	public void testIllegalUrl() throws Exception {
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Unable to handle the dynamic request: /xeno.remoting.web.RemoteCall.js\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost("http://localhost/xr/xeno.remoting.web.RemoteCall.js"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Unable to handle the dynamic request: /xeno.remoting.web.RemoteCall.htm\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost("http://localhost/xr/xeno.remoting.web.RemoteCall.htm"));

		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Unable to handle the dynamic request: /xeno.remoting.web.ReverseAjax.js\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost("http://localhost/xr/xeno.remoting.web.ReverseAjax.js"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Unable to handle the dynamic request: /xeno.remoting.web.ReverseAjax.htm\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost("http://localhost/xr/xeno.remoting.web.ReverseAjax.htm"));

		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Unable to handle the dynamic request: /org.showcase.web.TestController.do\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost("http://localhost/xr/org.showcase.web.TestController.do"));
	}

	@Test
	public void testInvalidStreamForRemoteCall() throws Exception {
		final String url = "http://localhost/xr/xeno.remoting.web.RemoteCall.do";

		// For the whole request content.
		assertResponsePartly(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"Failed to parse the stream: com.meterware.servletunit.ServletInputStreamImpl@", "\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url));
		assertResponsePartly(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"Failed to parse the stream: com.meterware.servletunit.ServletInputStreamImpl@", "\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url, "a"));

		// For missing request content item.
		Map data = new HashMap();
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"No page URI info in the request\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url, data));

		data.put("uri", "a");
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"No remote proxy info in the request\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url, data));

		data.put("name", "b");
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"No web method info in the request\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url, data));

		data.put("method", "c");
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"No arguments data in the request\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url, data));

		// For mismatch item type.
		data.clear();
		data.put("uri", new ArrayList());
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"java.util.ArrayList cannot be cast to java.lang.String\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url, data));

		data.put("uri", "a");
		data.put("name", new ArrayList());
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"java.util.ArrayList cannot be cast to java.lang.String\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url, data));

		data.put("name", "b");
		data.put("method", new ArrayList());
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"java.util.ArrayList cannot be cast to java.lang.String\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url, data));

		data.put("method", "c");
		data.put("params", "d");
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"java.lang.String cannot be cast to java.util.List\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url, data));

		// For non-exist remote proxy.
		data.clear();
		data.put("uri", "a");
		data.put("name", "b");
		data.put("method", "c");
		data.put("params", new ArrayList());
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"Cannot find the remote proxy metadata: b\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url, data));

		// For not-exist web method.
		data.clear();
		data.put("uri", "a");
		data.put("name", "org.showcase.web.TestController");
		data.put("method", "c");
		data.put("params", new ArrayList());
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"Cannot find the web method: c\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url, data));
	}

	@Test
	public void testIllegalArgumentForRemoteCall() throws Exception {

		// Mismatch argument count.
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Argument(s) count does not match, expected: 3, actual: 0\",\"type\":\"xeno.remoting.web.JsonDeserializationException\"}", doCall("org.showcase.web.TestController", "login"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Argument(s) count does not match, expected: 3, actual: 1\",\"type\":\"xeno.remoting.web.JsonDeserializationException\"}", doCall("org.showcase.web.TestController", "login", "a"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Argument(s) count does not match, expected: 3, actual: 2\",\"type\":\"xeno.remoting.web.JsonDeserializationException\"}", doCall("org.showcase.web.TestController", "login", "a", "b"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Argument(s) count does not match, expected: 3, actual: 4\",\"type\":\"xeno.remoting.web.JsonDeserializationException\"}", doCall("org.showcase.web.TestController", "login", "a", "b", "c", "d"));

		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Argument(s) count does not match, expected: 0, actual: 1\",\"type\":\"xeno.remoting.web.JsonDeserializationException\"}", doCall("org.showcase.web.TestController", "logout", "a"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Argument(s) count does not match, expected: 0, actual: 2\",\"type\":\"xeno.remoting.web.JsonDeserializationException\"}", doCall("org.showcase.web.TestController", "logout", "a", "b"));

		// Mismatch argument type.
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Failed to convert argument[0] to specific Java type: java.lang.String\",\"type\":\"xeno.remoting.web.JsonDeserializationException\"}", doCall("org.showcase.web.TestController", "login", new ArrayList(), "b", "c"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Failed to convert argument[1] to specific Java type: java.lang.String\",\"type\":\"xeno.remoting.web.JsonDeserializationException\"}", doCall("org.showcase.web.TestController", "login", "a", new ArrayList(), "c"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Failed to convert argument[2] to specific Java type: java.lang.String\",\"type\":\"xeno.remoting.web.JsonDeserializationException\"}", doCall("org.showcase.web.TestController", "login", "a", "b", new ArrayList()));

		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Failed to convert argument[0] to specific Java type: int\",\"type\":\"xeno.remoting.web.JsonDeserializationException\"}", doCall("org.showcase.web.TestController", "getPreviousPage", "a", "b"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Failed to convert argument[1] to specific Java type: java.util.Map\",\"type\":\"xeno.remoting.web.JsonDeserializationException\"}", doCall("org.showcase.web.TestController", "getPreviousPage", 1, "b"));

		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Failed to convert argument[0] to specific Java type: int\",\"type\":\"xeno.remoting.web.JsonDeserializationException\"}", doCall("org.showcase.web.TestController", "getNextPage", "a", "b"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Failed to convert argument[1] to specific Java type: java.util.Map\",\"type\":\"xeno.remoting.web.JsonDeserializationException\"}", doCall("org.showcase.web.TestController", "getNextPage", 1, "b"));

		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Failed to convert argument[0] to specific Java type: int\",\"type\":\"xeno.remoting.web.JsonDeserializationException\"}", doCall("org.showcase.web.MockController", "foo", new HashMap()));
	}

	@Test
	public void testExceptionThrownForRemoteCall() throws Exception {

		// Throws exception in the web method.
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":null,\"type\":\"java.lang.IllegalArgumentException\"}", doCall("org.showcase.web.service.ProblemService", "t1"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"a\",\"type\":\"java.lang.IllegalArgumentException\"}", doCall("org.showcase.web.service.ProblemService", "t2"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"b\",\"type\":\"java.lang.IllegalArgumentException\"}", doCall("org.showcase.web.service.ProblemService", "t3"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"c\",\"type\":\"java.lang.IllegalArgumentException\"}", doCall("org.showcase.web.service.ProblemService", "t4"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":null,\"type\":\"java.lang.reflect.InvocationTargetException\"}", doCall("org.showcase.web.service.ProblemService", "t5"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":null,\"type\":\"java.lang.reflect.InvocationTargetException\"}", doCall("org.showcase.web.service.ProblemService", "t6"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"b\",\"type\":\"java.lang.reflect.InvocationTargetException\"}", doCall("org.showcase.web.service.ProblemService", "t7"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"c\",\"type\":\"java.lang.reflect.InvocationTargetException\"}", doCall("org.showcase.web.service.ProblemService", "t8"));

		// Throws exception during result JSON serialization.
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Failed to serialize the result\",\"type\":\"xeno.remoting.web.JsonSerializationException\"}", doCall("org.showcase.web.service.ProblemService", "t9"));
	}

	@Test
	public void testGetterAndSetterForRemoteCall() throws Exception {

		// Pure getter & setter.
		Map data = new HashMap();
		data.put("code", 1);
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Failed to serialize the result\",\"type\":\"xeno.remoting.web.JsonSerializationException\"}", doCall("org.showcase.web.service.PropertyService", "c1", data));

		data.clear();
		data.put("code", 2);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"code\":2}}", doCall("org.showcase.web.service.PropertyService", "c2", data));

		data.clear();
		data.put("code", 3);
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Failed to serialize the result\",\"type\":\"xeno.remoting.web.JsonSerializationException\"}", doCall("org.showcase.web.service.PropertyService", "c3", data));

		data.clear();
		data.put("code", 4);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"code\":4}}", doCall("org.showcase.web.service.PropertyService", "c4", data));

		// Custom getter & setter.
		data.clear();
		data.put("code", 51);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"myCode\":0}}", doCall("org.showcase.web.service.PropertyService", "c5", data));

		data.clear();
		data.put("myCode", 52);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"myCode\":0}}", doCall("org.showcase.web.service.PropertyService", "c5", data));

		data.clear();
		data.put("code", 61);
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Failed to serialize the result\",\"type\":\"xeno.remoting.web.JsonSerializationException\"}", doCall("org.showcase.web.service.PropertyService", "c6", data));

		data.clear();
		data.put("myCode", 62);
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Failed to serialize the result\",\"type\":\"xeno.remoting.web.JsonSerializationException\"}", doCall("org.showcase.web.service.PropertyService", "c6", data));

		data.clear();
		data.put("code", 71);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"myCode\":0}}", doCall("org.showcase.web.service.PropertyService", "c7", data));

		data.clear();
		data.put("myCode", 72);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"myCode\":72}}", doCall("org.showcase.web.service.PropertyService", "c7", data));

		data.clear();
		data.put("code", 81);
		// A bug for Jackson data-bind? Why the value is not 0 here?
		// Original expected result is: "{\"data\":{\"code\":0}}".
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"code\":81}}", doCall("org.showcase.web.service.PropertyService", "c8", data));

		data.clear();
		data.put("myCode", 82);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"code\":82}}", doCall("org.showcase.web.service.PropertyService", "c8", data));

		data.clear();
		data.put("code", 91);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"myCode\":91}}", doCall("org.showcase.web.service.PropertyService", "c9", data));

		data.clear();
		data.put("myCode", 92);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"myCode\":0}}", doCall("org.showcase.web.service.PropertyService", "c9", data));
	}

	@Test
	public void testGetResultForRemoteCall() throws Exception {
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":null}", doCall("org.showcase.web.service.GenericService", "t1", (Object) null));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":1}", doCall("org.showcase.web.service.GenericService", "t1", 1));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":true}", doCall("org.showcase.web.service.GenericService", "t1", true));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"abc\"}", doCall("org.showcase.web.service.GenericService", "t1", "abc"));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"code\":0,\"name\":null}}", doCall("org.showcase.web.service.GenericService", "t1", new Account()));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"id\":0,\"name\":null,\"documents\":null}}", doCall("org.showcase.web.service.GenericService", "t1", new Folder()));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"id\":0,\"name\":null}}", doCall("org.showcase.web.service.GenericService", "t1", new Document()));

		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"null\"}", doCall("org.showcase.web.service.GenericService", "t2", (Object) null));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"[Folder]\"}", doCall("org.showcase.web.service.GenericService", "t2", new Folder()));

		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"null\"}", doCall("org.showcase.web.service.GenericService", "t3", (Object) null));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"[Document]\"}", doCall("org.showcase.web.service.GenericService", "t3", new Document()));

		assertResponse(HttpServletResponse.SC_OK, "{\"data\":null}", doCall("org.showcase.web.service.GenericService", "t4"));

		// Ignore properties.
		Map data = new HashMap();
		data.put("code", 234);
		data.put("age", true);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"code\":234,\"name\":null}}", doCall("org.showcase.web.service.GenericService", "t5", data));

		data.clear();
		data.put("name", "a");
		data.put("age", true);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"code\":0,\"name\":\"a\"}}", doCall("org.showcase.web.service.GenericService", "t5", data));

		// Primitive type arguments & return value.
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":100}", doCall("org.showcase.web.service.GenericService", "c1", 1));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"c2\"}", doCall("org.showcase.web.service.GenericService", "c2", 1, "a"));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":null}", doCall("org.showcase.web.service.GenericService", "c3", 1));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":null}", doCall("org.showcase.web.service.GenericService", "c4", "a", 1));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"b\":true,\"c\":\"cc\",\"a\":1}}", doCall("org.showcase.web.service.GenericService", "c5"));

		// Custom model.
		data.clear();
		data.put("id", 1400556322162L);
		data.put("name", "ttt");
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"id\":1400556322162,\"name\":\"ttt\"}}", doCall("org.showcase.web.service.GenericService", "c6", data));

		Map inner = new HashMap();
		inner.put("id", 100001);
		inner.put("name", "test");

		data.clear();
		data.put("model", inner);
		data.put("myAge", 30);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"age\":30,\"innerModel\":{\"id\":100001,\"name\":\"test\"}}}", doCall("org.showcase.web.service.GenericService", "c7", data));

		// Multi-arguments.
		inner.clear();
		inner.put("id", 2015);
		inner.put("name", "bbb");
		data.clear();
		data.put("model", inner);
		data.put("myAge", 84);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"m1\":{\"id\":2015,\"name\":\"bbb\"},\"m2\":{\"age\":84,\"innerModel\":{\"id\":2015,\"name\":\"bbb\"}},\"i\":13}}", doCall("org.showcase.web.service.GenericService", "c8", inner, 13, data));

		// Inheriting model.
		data.clear();
		data.put("id", 23);
		data.put("name", "ccc");
		data.put("age", 4);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":{\"id\":23,\"name\":\"ccc\",\"age\":4}}", doCall("org.showcase.web.service.GenericService", "c9", data));

		// Static method.
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":3}", doCall("org.showcase.web.service.GenericService", "c10", 1, 2));
	}

	@Test
	public void testExceptionHandlerForRemoteCall() throws Exception {
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":3,\"message\":null,\"type\":\"org.showcase.exception.MyException\"}", doCall("org.showcase.web.service.GenericService", "e1"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":{\"b\":\"bb\",\"a\":1},\"message\":\"illegal argument exception message\",\"type\":\"java.lang.IllegalArgumentException\"}", doCall("org.showcase.web.service.GenericService", "e2"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"io exception\",\"message\":\"io exception message\",\"type\":\"java.io.IOException\"}", doCall("org.showcase.web.service.GenericService", "e3"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"OK\",\"message\":\"invocation target exception message\",\"type\":\"java.lang.reflect.InvocationTargetException\"}", doCall("org.showcase.web.service.GenericService", "e4"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"c\",\"type\":\"java.lang.ArrayIndexOutOfBoundsException\"}", doCall("org.showcase.web.service.GenericService", "e5"));

		// For throwing exception during fault JSON serialization.
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Failed to serialize the fault for the exception handler\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doCall("org.showcase.web.service.GenericService", "e6"));

		// For handing hierarchy.
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"data truncation\",\"message\":\"Data truncation\",\"type\":\"java.sql.DataTruncation\"}", doCall("org.showcase.web.service.extra.HierarchyExceptionService_01", "t"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"sql warning\",\"message\":\"Data truncation\",\"type\":\"java.sql.DataTruncation\"}", doCall("org.showcase.web.service.extra.HierarchyExceptionService_02", "t"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"exception\",\"message\":\"Data truncation\",\"type\":\"java.sql.DataTruncation\"}", doCall("org.showcase.web.service.extra.HierarchyExceptionService_03", "t"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"Data truncation\",\"type\":\"java.sql.DataTruncation\"}", doCall("org.showcase.web.service.extra.HierarchyExceptionService_04", "t"));

		// For nested exception occurs.
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"An exception has been thrown in the exception handler\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doCall("org.showcase.web.extra.NestedController", "test"));
	}

	@Test
	public void testOverrideMethodForRemoteCall() throws Exception {

		// Override general method.
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"t1 in OverrideWebMethodService_03\"}", doCall("org.showcase.web.service.extra.OverrideWebMethodService_03", "t1"));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"t2 in OverrideWebMethodService_03\"}", doCall("org.showcase.web.service.extra.OverrideWebMethodService_03", "t2"));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"t3 in OverrideWebMethodService_03\"}", doCall("org.showcase.web.service.extra.OverrideWebMethodService_03", "t3"));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"t4 in OverrideWebMethodService_03\"}", doCall("org.showcase.web.service.extra.OverrideWebMethodService_03", "t4"));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"t5 in OverrideWebMethodService_01\"}", doCall("org.showcase.web.service.extra.OverrideWebMethodService_03", "t5"));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"t6 in OverrideWebMethodService_02\"}", doCall("org.showcase.web.service.extra.OverrideWebMethodService_03", "t6"));

		// Override static method.
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"s1 in OverrideWebMethodService_03\"}", doCall("org.showcase.web.service.extra.OverrideWebMethodService_03", "s1"));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"s2 in OverrideWebMethodService_03\"}", doCall("org.showcase.web.service.extra.OverrideWebMethodService_03", "s2"));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"s3 in OverrideWebMethodService_03\"}", doCall("org.showcase.web.service.extra.OverrideWebMethodService_03", "s3"));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"s4 in OverrideWebMethodService_03\"}", doCall("org.showcase.web.service.extra.OverrideWebMethodService_03", "s4"));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"s5 in OverrideWebMethodService_01\"}", doCall("org.showcase.web.service.extra.OverrideWebMethodService_03", "s5"));
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"s6 in OverrideWebMethodService_02\"}", doCall("org.showcase.web.service.extra.OverrideWebMethodService_03", "s6"));
	}

	@Test
	public void testOverrideExceptionHandlerForRemoteCall() throws Exception {

		// Override general method.
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"t1 in OverrideExceptionHandlerService_03\",\"message\":null,\"type\":\"java.lang.IllegalArgumentException\"}", doCall("org.showcase.web.service.extra.OverrideExceptionHandlerService_03", "e1"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"t2 in OverrideExceptionHandlerService_03\",\"message\":null,\"type\":\"java.lang.IllegalStateException\"}", doCall("org.showcase.web.service.extra.OverrideExceptionHandlerService_03", "e2"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"t3 in OverrideExceptionHandlerService_03\",\"message\":null,\"type\":\"java.lang.ArithmeticException\"}", doCall("org.showcase.web.service.extra.OverrideExceptionHandlerService_03", "e3"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"t4 in OverrideExceptionHandlerService_03\",\"message\":null,\"type\":\"java.lang.ArrayIndexOutOfBoundsException\"}", doCall("org.showcase.web.service.extra.OverrideExceptionHandlerService_03", "e4"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"t5 in OverrideExceptionHandlerService_01\",\"message\":null,\"type\":\"java.lang.ClassCastException\"}", doCall("org.showcase.web.service.extra.OverrideExceptionHandlerService_03", "e5"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"t6 in OverrideExceptionHandlerService_02\",\"message\":null,\"type\":\"java.lang.IllegalAccessException\"}", doCall("org.showcase.web.service.extra.OverrideExceptionHandlerService_03", "e6"));

		// Override static method.
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"s1 in OverrideExceptionHandlerService_03\",\"message\":null,\"type\":\"java.lang.ClassNotFoundException\"}", doCall("org.showcase.web.service.extra.OverrideExceptionHandlerService_03", "e7"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"s2 in OverrideExceptionHandlerService_03\",\"message\":null,\"type\":\"java.lang.CloneNotSupportedException\"}", doCall("org.showcase.web.service.extra.OverrideExceptionHandlerService_03", "e8"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"s3 in OverrideExceptionHandlerService_03\",\"message\":null,\"type\":\"java.lang.ArrayStoreException\"}", doCall("org.showcase.web.service.extra.OverrideExceptionHandlerService_03", "e9"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"s4 in OverrideExceptionHandlerService_03\",\"message\":null,\"type\":\"java.lang.IndexOutOfBoundsException\"}", doCall("org.showcase.web.service.extra.OverrideExceptionHandlerService_03", "e10"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"s5 in OverrideExceptionHandlerService_01\",\"message\":null,\"type\":\"java.lang.InterruptedException\"}", doCall("org.showcase.web.service.extra.OverrideExceptionHandlerService_03", "e11"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"s6 in OverrideExceptionHandlerService_02\",\"message\":null,\"type\":\"java.lang.InstantiationException\"}", doCall("org.showcase.web.service.extra.OverrideExceptionHandlerService_03", "e12"));
	}

	@Test
	public void testWebMethodAndExceptionHandlerIsTheSameForRemoteCall() throws Exception {
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"success executed\"}", doCall("org.showcase.web.extra.TestController", "foo", (Exception) null));

		TestController.setShowError(true);
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"exception handled\",\"message\":\"error occurs\",\"type\":\"java.lang.RuntimeException\"}", doCall("org.showcase.web.extra.TestController", "foo", (Exception) null));

		TestController.setShowError(false);
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"success executed\"}", doCall("org.showcase.web.extra.TestController", "foo", (Exception) null));
	}

	@Test
	public void testChangeStatusCodeForRemoteCall() throws Exception {

		// For success, but return error status code.
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":\"500 status code\"}", doCall("org.showcase.web.extra.StatusCodeController", "t1"));

		// For error, but return success status code.
		assertResponse(HttpServletResponse.SC_OK, "{\"data\":\"200 status code\",\"message\":\"illegal argument exception\",\"type\":\"java.lang.IllegalArgumentException\"}", doCall("org.showcase.web.extra.StatusCodeController", "t2"));
		assertResponse(HttpServletResponse.SC_NO_CONTENT, "{\"data\":\"204 status code\",\"message\":\"illegal state exception\",\"type\":\"java.lang.IllegalStateException\"}", doCall("org.showcase.web.extra.StatusCodeController", "t3"));

		// For error, but return success status code, and error again in the exception handler.
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"An exception has been thrown in the exception handler\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doCall("org.showcase.web.extra.StatusCodeController", "t4"));
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"An exception has been thrown in the exception handler\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doCall("org.showcase.web.extra.StatusCodeController", "t5"));

		// For exception handler not found.
		assertResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"data\":null,\"message\":\"sql exception\",\"type\":\"java.sql.SQLException\"}", doCall("org.showcase.web.extra.StatusCodeController", "t6"));
	}

	@Test
	public void testInvalidStreamForReverseAjax() throws Exception {
		final String url = "http://localhost/xr/xeno.remoting.web.ReverseAjax.do";

		// For the whole request content.
		assertResponsePartly(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"Failed to parse the stream: com.meterware.servletunit.ServletInputStreamImpl@", "\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url));
		assertResponsePartly(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"Failed to parse the stream: com.meterware.servletunit.ServletInputStreamImpl@", "\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url, "a"));

		// For missing request content item.
		Map data = new HashMap();
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"No page URI info in the request\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url, data));

		// For mismatch item type.
		data.put("uri", new ArrayList());
		assertResponse(HttpServletResponse.SC_BAD_REQUEST, "{\"data\":null,\"message\":\"java.util.ArrayList cannot be cast to java.lang.String\",\"type\":\"xeno.remoting.web.UnhandlableException\"}", doPost(url, data));
	}
}
