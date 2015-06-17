package com.since10.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;
import xeno.remoting.web.MessageServlet;
import xeno.remoting.web.Request;

import com.since10.web.model.Document;
import com.since10.web.model.Folder;
import com.since10.web.persist.SiteDao;

@Controller
@RemoteProxy
@SuppressWarnings({ "rawtypes", "unchecked" })
public class BasicFunctionController {

	@Autowired
	private SiteDao siteDao = null;

	@WebMethod
	public void testTimeout1() throws InterruptedException {
		Thread.sleep(10000);
	}

	@WebMethod
	public String testTimeout2() {
		MessageServlet.getCurrentHttpResponseThread().getOriginalHttpServletResponse().setStatus(HttpServletResponse.SC_REQUEST_TIMEOUT);

		return "This message is from server side.";
	}

	@WebMethod
	public Map testBeforeSend() {
		Request request = MessageServlet.getCurrentHttpRequestThread();
		Map data = new HashMap();

		for (String name : request.getHeaderNames()) {
			data.put(name, request.getHeader(name));
		}

		return data;
	}

	@WebMethod
	public Folder testSuccess(Folder folder, Document document) {
		folder.setDisplayName("更新后的名称");
		folder.getDocuments().add(document);

		return folder;
	}

	@WebMethod
	public void testError() {
		throw new IllegalStateException("Illegal state detected");
	}

	@WebMethod
	public void testComplete() {
		// Does nothing.
	}

	@WebMethod
	public String testSpringBean(String id) {
		System.out.println("Autowired Site DAO: " + siteDao);

		if (siteDao != null) {
			throw new IllegalStateException("The 'siteDao' should be null");
		}

		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(MessageServlet.getWebApplicationServletContext());

		return context.getBean("SiteDao", SiteDao.class).getById(id);
	}

	@RequestMapping("/basic/function/test.do")
	public void testSpringBean(HttpServletResponse response) throws IOException {
		System.out.println("Autowired Site DAO: " + siteDao);

		if (siteDao == null) {
			throw new IllegalStateException("The 'siteDao' should not be null");
		}

		PrintWriter output = response.getWriter();
		output.write("OK");
		output.flush();
	}
}
