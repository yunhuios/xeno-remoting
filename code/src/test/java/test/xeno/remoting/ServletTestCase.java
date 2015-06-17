package test.xeno.remoting;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Assert;
import org.xml.sax.SAXException;

import xeno.remoting.web.MessageServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

public class ServletTestCase extends LoggingTestCase {
	private static final ObjectMapper JSON = new ObjectMapper();
	private static final String TYPE = "application/json";

	protected WebResponse[] doPost(String url) throws SAXException, IOException {
		WebRequest request1 = new PostMethodWebRequest(url);
		WebRequest request2 = new PostMethodWebRequest(url + "?a=1");
		WebRequest request3 = new PostMethodWebRequest(url + "#a");
		WebRequest request4 = new PostMethodWebRequest(url);
		WebRequest request5 = new PostMethodWebRequest(url + "?a=1");
		WebRequest request6 = new PostMethodWebRequest(url + "#a");

		WebResponse response1 = createTestClient(true).getResponse(request1);
		WebResponse response2 = createTestClient(true).getResponse(request2);
		WebResponse response3 = createTestClient(true).getResponse(request3);
		WebResponse response4 = createTestClient(false).getResponse(request4);
		WebResponse response5 = createTestClient(false).getResponse(request5);
		WebResponse response6 = createTestClient(false).getResponse(request6);

		return new WebResponse[] { response1, response2, response3, response4, response5, response6 };
	}

	protected WebResponse[] doPost(String url, Object data) throws SAXException, IOException {
		String content = JSON.writeValueAsString(data);

		WebRequest request1 = new PostMethodWebRequest(url, new ByteArrayInputStream(content.getBytes()), TYPE);
		WebRequest request2 = new PostMethodWebRequest(url + "?a=1", new ByteArrayInputStream(content.getBytes()), TYPE);
		WebRequest request3 = new PostMethodWebRequest(url + "#a", new ByteArrayInputStream(content.getBytes()), TYPE);
		WebRequest request4 = new PostMethodWebRequest(url, new ByteArrayInputStream(content.getBytes()), TYPE);
		WebRequest request5 = new PostMethodWebRequest(url + "?a=1", new ByteArrayInputStream(content.getBytes()), TYPE);
		WebRequest request6 = new PostMethodWebRequest(url + "#a", new ByteArrayInputStream(content.getBytes()), TYPE);

		WebResponse response1 = createTestClient(true).getResponse(request1);
		WebResponse response2 = createTestClient(true).getResponse(request2);
		WebResponse response3 = createTestClient(true).getResponse(request3);
		WebResponse response4 = createTestClient(false).getResponse(request4);
		WebResponse response5 = createTestClient(false).getResponse(request5);
		WebResponse response6 = createTestClient(false).getResponse(request6);

		return new WebResponse[] { response1, response2, response3, response4, response5, response6 };
	}

	protected WebResponse[] doGet(boolean debugMode, String url) throws SAXException, IOException {
		WebRequest request1 = new GetMethodWebRequest(url);
		WebRequest request2 = new GetMethodWebRequest(url + "?a=1");
		WebRequest request3 = new GetMethodWebRequest(url + "#a");

		WebResponse response1 = createTestClient(debugMode).getResponse(request1);
		WebResponse response2 = createTestClient(debugMode).getResponse(request2);
		WebResponse response3 = createTestClient(debugMode).getResponse(request3);

		return new WebResponse[] { response1, response2, response3 };
	}

	protected WebResponse[] doCall(String name, String method, Object... arguments) throws SAXException, IOException {
		List<Object> params = new ArrayList<Object>();

		if (arguments != null) {

			for (Object item : arguments) {
				params.add(item);
			}
		}

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("uri", "/" + UUID.randomUUID().toString().replace("-", ""));
		data.put("name", name);
		data.put("method", method);
		data.put("params", params);

		return doPost("http://localhost/xr/xeno.remoting.web.RemoteCall.do", data);
	}

	protected void assertResponse(int expectedStatusCode, String expectedText, WebResponse[] actualResponses) throws IOException {

		for (WebResponse actualResponse : actualResponses) {
			Assert.assertEquals(expectedStatusCode, actualResponse.getResponseCode());
			Assert.assertEquals(expectedText, actualResponse.getText());
		}
	}

	protected void assertResponse(int expectedStatusCode, StringBuffer expectedText, WebResponse[] actualResponses) throws IOException {
		assertResponse(expectedStatusCode, expectedText.toString(), actualResponses);
	}

	protected void assertResponsePartly(int expectedStatusCode, String expectedStartText, String expectedEndText, WebResponse[] actualResponses) throws IOException {

		for (WebResponse actualResponse : actualResponses) {
			Assert.assertEquals(expectedStatusCode, actualResponse.getResponseCode());
			Assert.assertTrue(actualResponse.getText().startsWith(expectedStartText));
			Assert.assertTrue(actualResponse.getText().endsWith(expectedEndText));
		}
	}

	private ServletUnitClient createTestClient(boolean debugMode) {
		Hashtable<String, String> params = new Hashtable<String, String>();
		params.put("debugMode", String.valueOf(debugMode));
		params.put("unitTestMode", "true");
		params.put("excludeClasses", "internal.*;external.*");

		ServletRunner runner = new ServletRunner();
		runner.registerServlet("/xr/*", MessageServlet.class.getName(), params);

		ServletUnitClient client = runner.newClient();
		client.setExceptionsThrownOnErrorStatus(false);

		return client;
	}
}
