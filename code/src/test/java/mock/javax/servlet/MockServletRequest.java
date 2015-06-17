package mock.javax.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MockServletRequest implements ServletRequest {

	@Override
	public Object getAttribute(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: getAttribute(String)");
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		throw new UnsupportedOperationException("This method has not been implemented: getAttributeNames()");
	}

	@Override
	public String getCharacterEncoding() {
		throw new UnsupportedOperationException("This method has not been implemented: getCharacterEncoding()");
	}

	@Override
	public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
		throw new UnsupportedOperationException("This method has not been implemented: setCharacterEncoding(String)");
	}

	@Override
	public int getContentLength() {
		throw new UnsupportedOperationException("This method has not been implemented: getContentLength()");
	}

	@Override
	public String getContentType() {
		throw new UnsupportedOperationException("This method has not been implemented: getContentType()");
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		throw new UnsupportedOperationException("This method has not been implemented: getInputStream()");
	}

	@Override
	public String getParameter(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: getParameter(String)");
	}

	@Override
	public Enumeration<String> getParameterNames() {
		throw new UnsupportedOperationException("This method has not been implemented: getParameterNames()");
	}

	@Override
	public String[] getParameterValues(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: getParameterValues(String)");
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		throw new UnsupportedOperationException("This method has not been implemented: getParameterMap()");
	}

	@Override
	public String getProtocol() {
		throw new UnsupportedOperationException("This method has not been implemented: getProtocol()");
	}

	@Override
	public String getScheme() {
		throw new UnsupportedOperationException("This method has not been implemented: getScheme()");
	}

	@Override
	public String getServerName() {
		throw new UnsupportedOperationException("This method has not been implemented: getServerName()");
	}

	@Override
	public int getServerPort() {
		throw new UnsupportedOperationException("This method has not been implemented: getServerPort()");
	}

	@Override
	public BufferedReader getReader() throws IOException {
		throw new UnsupportedOperationException("This method has not been implemented: getReader()");
	}

	@Override
	public String getRemoteAddr() {
		throw new UnsupportedOperationException("This method has not been implemented: getRemoteAddr()");
	}

	@Override
	public String getRemoteHost() {
		throw new UnsupportedOperationException("This method has not been implemented: getRemoteHost()");
	}

	@Override
	public void setAttribute(String name, Object o) {
		throw new UnsupportedOperationException("This method has not been implemented: setAttribute(String, Object)");
	}

	@Override
	public void removeAttribute(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: removeAttribute(String)");
	}

	@Override
	public Locale getLocale() {
		throw new UnsupportedOperationException("This method has not been implemented: getLocale()");
	}

	@Override
	public Enumeration<Locale> getLocales() {
		throw new UnsupportedOperationException("This method has not been implemented: getLocales()");
	}

	@Override
	public boolean isSecure() {
		throw new UnsupportedOperationException("This method has not been implemented: isSecure()");
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		throw new UnsupportedOperationException("This method has not been implemented: getRequestDispatcher(String)");
	}

	@Override
	public String getRealPath(String path) {
		throw new UnsupportedOperationException("This method has not been implemented: getRealPath(String)");
	}

	@Override
	public int getRemotePort() {
		throw new UnsupportedOperationException("This method has not been implemented: getRemotePort()");
	}

	@Override
	public String getLocalName() {
		throw new UnsupportedOperationException("This method has not been implemented: getLocalName()");
	}

	@Override
	public String getLocalAddr() {
		throw new UnsupportedOperationException("This method has not been implemented: getLocalAddr()");
	}

	@Override
	public int getLocalPort() {
		throw new UnsupportedOperationException("This method has not been implemented: getLocalPort()");
	}

	@Override
	public ServletContext getServletContext() {
		throw new UnsupportedOperationException("This method has not been implemented: getServletContext()");
	}

	@Override
	public AsyncContext startAsync() {
		throw new UnsupportedOperationException("This method has not been implemented: startAsync()");
	}

	@Override
	public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) {
		throw new UnsupportedOperationException("This method has not been implemented: startAsync(ServletRequest, ServletResponse)");
	}

	@Override
	public boolean isAsyncStarted() {
		throw new UnsupportedOperationException("This method has not been implemented: isAsyncStarted()");
	}

	@Override
	public boolean isAsyncSupported() {
		throw new UnsupportedOperationException("This method has not been implemented: isAsyncSupported()");
	}

	@Override
	public AsyncContext getAsyncContext() {
		throw new UnsupportedOperationException("This method has not been implemented: getAsyncContext()");
	}

	@Override
	public DispatcherType getDispatcherType() {
		throw new UnsupportedOperationException("This method has not been implemented: getDispatcherType()");
	}
}
