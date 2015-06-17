package mock.javax.servlet.http;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import mock.javax.servlet.MockServletRequest;

public class MockHttpServletRequest extends MockServletRequest implements HttpServletRequest {

	@Override
	public String getAuthType() {
		throw new UnsupportedOperationException("This method has not been implemented: getAuthType()");
	}

	@Override
	public Cookie[] getCookies() {
		throw new UnsupportedOperationException("This method has not been implemented: getCookies()");
	}

	@Override
	public long getDateHeader(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: getDateHeader(String)");
	}

	@Override
	public String getHeader(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: getHeader(String)");
	}

	@Override
	public Enumeration<String> getHeaders(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: getHeaders(String)");
	}

	@Override
	public Enumeration<String> getHeaderNames() {
		throw new UnsupportedOperationException("This method has not been implemented: getHeaderNames()");
	}

	@Override
	public int getIntHeader(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: getIntHeader(String)");
	}

	@Override
	public String getMethod() {
		throw new UnsupportedOperationException("This method has not been implemented: getMethod()");
	}

	@Override
	public String getPathInfo() {
		throw new UnsupportedOperationException("This method has not been implemented: getPathInfo()");
	}

	@Override
	public String getPathTranslated() {
		throw new UnsupportedOperationException("This method has not been implemented: getPathTranslated()");
	}

	@Override
	public String getContextPath() {
		throw new UnsupportedOperationException("This method has not been implemented: getContextPath()");
	}

	@Override
	public String getQueryString() {
		throw new UnsupportedOperationException("This method has not been implemented: getQueryString()");
	}

	@Override
	public String getRemoteUser() {
		throw new UnsupportedOperationException("This method has not been implemented: getRemoteUser()");
	}

	@Override
	public boolean isUserInRole(String role) {
		throw new UnsupportedOperationException("This method has not been implemented: isUserInRole(String)");
	}

	@Override
	public Principal getUserPrincipal() {
		throw new UnsupportedOperationException("This method has not been implemented: getUserPrincipal()");
	}

	@Override
	public String getRequestedSessionId() {
		throw new UnsupportedOperationException("This method has not been implemented: getRequestedSessionId()");
	}

	@Override
	public String getRequestURI() {
		throw new UnsupportedOperationException("This method has not been implemented: getRequestURI()");
	}

	@Override
	public StringBuffer getRequestURL() {
		throw new UnsupportedOperationException("This method has not been implemented: getRequestURL()");
	}

	@Override
	public String getServletPath() {
		throw new UnsupportedOperationException("This method has not been implemented: getServletPath()");
	}

	@Override
	public HttpSession getSession(boolean create) {
		throw new UnsupportedOperationException("This method has not been implemented: getSession(boolean)");
	}

	@Override
	public HttpSession getSession() {
		throw new UnsupportedOperationException("This method has not been implemented: getSession()");
	}

	@Override
	public boolean isRequestedSessionIdValid() {
		throw new UnsupportedOperationException("This method has not been implemented: isRequestedSessionIdValid()");
	}

	@Override
	public boolean isRequestedSessionIdFromCookie() {
		throw new UnsupportedOperationException("This method has not been implemented: isRequestedSessionIdFromCookie()");
	}

	@Override
	public boolean isRequestedSessionIdFromURL() {
		throw new UnsupportedOperationException("This method has not been implemented: isRequestedSessionIdFromURL()");
	}

	@Override
	public boolean isRequestedSessionIdFromUrl() {
		throw new UnsupportedOperationException("This method has not been implemented: isRequestedSessionIdFromUrl()");
	}

	@Override
	public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
		throw new UnsupportedOperationException("This method has not been implemented: authenticate(HttpServletResponse)");
	}

	@Override
	public void login(String username, String password) throws ServletException {
		throw new UnsupportedOperationException("This method has not been implemented: login(String, String)");
	}

	@Override
	public void logout() throws ServletException {
		throw new UnsupportedOperationException("This method has not been implemented: logout()");
	}

	@Override
	public Collection<Part> getParts() throws IOException, IllegalStateException, ServletException {
		throw new UnsupportedOperationException("This method has not been implemented: getParts()");
	}

	@Override
	public Part getPart(String name) throws IOException, IllegalStateException, ServletException {
		throw new UnsupportedOperationException("This method has not been implemented: getPart(String)");
	}
}
