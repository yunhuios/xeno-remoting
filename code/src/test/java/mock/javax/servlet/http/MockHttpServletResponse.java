package mock.javax.servlet.http;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import mock.javax.servlet.MockServletResponse;

public class MockHttpServletResponse extends MockServletResponse implements HttpServletResponse {

	@Override
	public void addCookie(Cookie cookie) {
		throw new UnsupportedOperationException("This method has not been implemented: addCookie(Cookie)");
	}

	@Override
	public boolean containsHeader(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: containsHeader(String)");
	}

	@Override
	public String encodeURL(String url) {
		throw new UnsupportedOperationException("This method has not been implemented: encodeURL(String)");
	}

	@Override
	public String encodeRedirectURL(String url) {
		throw new UnsupportedOperationException("This method has not been implemented: encodeRedirectURL(String)");
	}

	@Override
	public String encodeUrl(String url) {
		throw new UnsupportedOperationException("This method has not been implemented: encodeUrl(String)");
	}

	@Override
	public String encodeRedirectUrl(String url) {
		throw new UnsupportedOperationException("This method has not been implemented: encodeRedirectUrl(String)");
	}

	@Override
	public void sendError(int sc, String msg) throws IOException {
		throw new UnsupportedOperationException("This method has not been implemented: sendError(int, String)");
	}

	@Override
	public void sendError(int sc) throws IOException {
		throw new UnsupportedOperationException("This method has not been implemented: sendError(int)");
	}

	@Override
	public void sendRedirect(String location) throws IOException {
		throw new UnsupportedOperationException("This method has not been implemented: sendRedirect(String)");
	}

	@Override
	public void setDateHeader(String name, long date) {
		throw new UnsupportedOperationException("This method has not been implemented: setDateHeader(String, long)");
	}

	@Override
	public void addDateHeader(String name, long date) {
		throw new UnsupportedOperationException("This method has not been implemented: addDateHeader(String, long)");
	}

	@Override
	public void setHeader(String name, String value) {
		throw new UnsupportedOperationException("This method has not been implemented: setHeader(String, String)");
	}

	@Override
	public void addHeader(String name, String value) {
		throw new UnsupportedOperationException("This method has not been implemented: addHeader(String, String)");
	}

	@Override
	public void setIntHeader(String name, int value) {
		throw new UnsupportedOperationException("This method has not been implemented: setIntHeader(String, int)");
	}

	@Override
	public void addIntHeader(String name, int value) {
		throw new UnsupportedOperationException("This method has not been implemented: addIntHeader(String, int)");
	}

	@Override
	public void setStatus(int sc) {
		throw new UnsupportedOperationException("This method has not been implemented: setStatus(int)");
	}

	@Override
	public void setStatus(int sc, String sm) {
		throw new UnsupportedOperationException("This method has not been implemented: setStatus(int, String)");
	}

	@Override
	public int getStatus() {
		throw new UnsupportedOperationException("This method has not been implemented: getStatus()");
	}

	@Override
	public String getHeader(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: getHeader(String)");
	}

	@Override
	public Collection<String> getHeaders(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: getHeaders(String)");
	}

	@Override
	public Collection<String> getHeaderNames() {
		throw new UnsupportedOperationException("This method has not been implemented: getHeaderNames()");
	}
}
