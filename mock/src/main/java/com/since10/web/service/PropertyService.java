package com.since10.web.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;
import xeno.remoting.web.MessageServlet;
import xeno.remoting.web.Request;
import xeno.remoting.web.Response;
import xeno.remoting.web.Session;

@RemoteProxy
public class PropertyService {

	@WebMethod
	public Map<String, Object> loop() throws InterruptedException {
		Thread.sleep(1000);

		Request request = MessageServlet.getCurrentHttpRequestThread();
		Response response = MessageServlet.getCurrentHttpResponseThread();
		Session session = MessageServlet.getCurrentHttpSessionThread();
		String uri = MessageServlet.getCurrentPageUriThread();

		String key = "test";
		String val = (String) session.getAttribute(key);

		if (val == null) {
			session.setAttribute(key, UUID.randomUUID().toString());
		}

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("Timestamp", new Date().getTime());
		data.put("GUID", val);
		data.put("SessionID", session.getId());
		data.put("PageURI", uri);

		data.put("CharacterEncoding", request.getCharacterEncoding());
		data.put("ContextPath", request.getContextPath());

		data.put("ServerName", request.getServerName());
		data.put("ServerPort", request.getServerPort());

		data.put("LocalAddress", request.getLocalAddress());
		data.put("LocalName", request.getLocalName());
		data.put("LocalPort", request.getLocalPort());

		data.put("RemoteAddress", request.getRemoteAddress());
		data.put("RemoteHost", request.getRemoteHost());
		data.put("RemotePort", request.getRemotePort());

		// Request headers & cookies.
		data.put("RequestHeader1", request.getHeader("request-h1"));
		data.put("RequestHeader2", request.getHeader("request-h2"));
		data.put("RequestHeader3", request.getHeader("request-h3"));

		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			data.put(cookie.getName(), cookie.getValue());
		}

		// Response headers & cookies.
		response.setHeader("response-h1", "This is a response header test, for: " + val);
		response.setHeader("response-h2", "This is another response header test, for: " + val);
		response.addCookie(new Cookie("server-c1", "This is a server cookie: " + val));
		response.addCookie(new Cookie("server-c2", "This is another server cookie: " + val));

		return data;
	}
}
