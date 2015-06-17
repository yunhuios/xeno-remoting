package com.since10.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;
import xeno.remoting.web.Browser;
import xeno.remoting.web.JavaScriptFunction;
import xeno.remoting.web.MessageServlet;

import com.since10.web.model.Document;
import com.since10.web.model.Folder;

@RemoteProxy
public class AjaxBridgeService {

	@WebMethod
	public void testReverseCallSelfOnly() {
		String sessionId = MessageServlet.getCurrentHttpSessionThread().getId();
		String pageUri = MessageServlet.getCurrentPageUriThread();

		Browser.with(sessionId, pageUri).invoke(new JavaScriptFunction("test"), new JavaScriptFunction("global.calculate", 1, 2));
	}

	@WebMethod
	public void testReverseCallAll() {
		Browser.withAll().invoke("global.calculate", 3, 4);
	}

	@WebMethod
	public void testReverseCallWithSessionIds(List<String> sessionIds) {
		Document document = new Document();
		document.setId(new Date().getTime());
		document.setDisplayName("s_我的文档_" + UUID.randomUUID().toString());

		Document childDoc1 = new Document();
		childDoc1.setId(1);
		childDoc1.setDisplayName("s_Java");

		Document childDoc2 = new Document();
		childDoc2.setId(2);
		childDoc2.setDisplayName("s_Spring MVC");

		List<Document> documents = new ArrayList<Document>();
		documents.add(childDoc1);
		documents.add(childDoc2);

		Folder folder = new Folder();
		folder.setId(3);
		folder.setDisplayName("s_技术类_" + UUID.randomUUID().toString());
		folder.setDocuments(documents);

		Browser.withSessions(sessionIds).invoke(new JavaScriptFunction("global.calculate", 5, 6), new JavaScriptFunction("withSessionIdsCallback", folder, document));
	}

	@WebMethod
	public void testReverseCallWithPageUris(List<String> pageUris) {
		Document document = new Document();
		document.setId(new Date().getTime());
		document.setDisplayName("p_我的文档_" + UUID.randomUUID().toString());

		Document childDoc1 = new Document();
		childDoc1.setId(4);
		childDoc1.setDisplayName("p_Java");

		Document childDoc2 = new Document();
		childDoc2.setId(5);
		childDoc2.setDisplayName("p_Spring MVC");

		List<Document> documents = new ArrayList<Document>();
		documents.add(childDoc1);
		documents.add(childDoc2);

		Folder folder = new Folder();
		folder.setId(6);
		folder.setDisplayName("p_技术类_" + UUID.randomUUID().toString());
		folder.setDocuments(documents);

		Browser.withPages(pageUris).invoke(new JavaScriptFunction("global.calculate", 7, 8), new JavaScriptFunction("withPageUrisCallback", folder, document));
	}
}
