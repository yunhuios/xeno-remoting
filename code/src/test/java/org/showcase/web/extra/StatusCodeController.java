package org.showcase.web.extra;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;
import xeno.remoting.web.MessageServlet;

@RemoteProxy
public class StatusCodeController {

	@ExceptionHandler
	public String h(IllegalArgumentException ex) {
		MessageServlet.getCurrentHttpResponseThread().getOriginalHttpServletResponse().setStatus(HttpServletResponse.SC_OK);

		return "200 status code";
	}

	@ExceptionHandler
	public String h(IllegalStateException ex) {
		MessageServlet.getCurrentHttpResponseThread().getOriginalHttpServletResponse().setStatus(HttpServletResponse.SC_NO_CONTENT);

		return "204 status code";
	}

	@ExceptionHandler
	public int h(ClassNotFoundException ex) {
		MessageServlet.getCurrentHttpResponseThread().getOriginalHttpServletResponse().setStatus(HttpServletResponse.SC_OK);

		return 1 / 0;
	}

	@ExceptionHandler
	public int h(IOException ex) {
		MessageServlet.getCurrentHttpResponseThread().getOriginalHttpServletResponse().setStatus(HttpServletResponse.SC_NO_CONTENT);

		return 1 / 0;
	}

	@WebMethod
	public String t1() {
		MessageServlet.getCurrentHttpResponseThread().getOriginalHttpServletResponse().setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		return "500 status code";
	}

	@WebMethod
	public void t2() {
		throw new IllegalArgumentException("illegal argument exception");
	}

	@WebMethod
	public void t3() {
		MessageServlet.getCurrentHttpResponseThread().getOriginalHttpServletResponse().setStatus(HttpServletResponse.SC_CONFLICT);

		throw new IllegalStateException("illegal state exception");
	}

	@WebMethod
	public void t4() throws ClassNotFoundException {
		throw new ClassNotFoundException("class not found exception");
	}

	@WebMethod
	public void t5() throws IOException {
		MessageServlet.getCurrentHttpResponseThread().getOriginalHttpServletResponse().setStatus(HttpServletResponse.SC_CONFLICT);

		throw new IOException("io exception");
	}

	@WebMethod
	public void t6() throws SQLException {
		MessageServlet.getCurrentHttpResponseThread().getOriginalHttpServletResponse().setStatus(HttpServletResponse.SC_OK);

		throw new SQLException("sql exception");
	}
}
