package mock.javax.servlet.http;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

@SuppressWarnings("deprecation")
public class MockHttpSession implements HttpSession {

	@Override
	public long getCreationTime() {
		throw new UnsupportedOperationException("This method has not been implemented: getCreationTime()");
	}

	@Override
	public String getId() {
		throw new UnsupportedOperationException("This method has not been implemented: getId()");
	}

	@Override
	public long getLastAccessedTime() {
		throw new UnsupportedOperationException("This method has not been implemented: getLastAccessedTime()");
	}

	@Override
	public ServletContext getServletContext() {
		throw new UnsupportedOperationException("This method has not been implemented: getServletContext()");
	}

	@Override
	public void setMaxInactiveInterval(int interval) {
		throw new UnsupportedOperationException("This method has not been implemented: setMaxInactiveInterval(int)");
	}

	@Override
	public int getMaxInactiveInterval() {
		throw new UnsupportedOperationException("This method has not been implemented: getMaxInactiveInterval()");
	}

	@Override
	public HttpSessionContext getSessionContext() {
		throw new UnsupportedOperationException("This method has not been implemented: getSessionContext()");
	}

	@Override
	public Object getAttribute(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: getAttribute(String)");
	}

	@Override
	public Object getValue(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: getValue(String)");
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		throw new UnsupportedOperationException("This method has not been implemented: getAttributeNames()");
	}

	@Override
	public String[] getValueNames() {
		throw new UnsupportedOperationException("This method has not been implemented: getValueNames()");
	}

	@Override
	public void setAttribute(String name, Object value) {
		throw new UnsupportedOperationException("This method has not been implemented: setAttribute(String, Object)");
	}

	@Override
	public void putValue(String name, Object value) {
		throw new UnsupportedOperationException("This method has not been implemented: putValue(String, Object)");
	}

	@Override
	public void removeAttribute(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: removeAttribute(String)");
	}

	@Override
	public void removeValue(String name) {
		throw new UnsupportedOperationException("This method has not been implemented: removeValue(String)");
	}

	@Override
	public void invalidate() {
		throw new UnsupportedOperationException("This method has not been implemented: invalidate()");
	}

	@Override
	public boolean isNew() {
		throw new UnsupportedOperationException("This method has not been implemented: isNew()");
	}
}
