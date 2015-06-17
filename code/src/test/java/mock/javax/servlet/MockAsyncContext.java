package mock.javax.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncListener;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MockAsyncContext implements AsyncContext {

	@Override
	public ServletRequest getRequest() {
		throw new UnsupportedOperationException("This method has not been implemented: getRequest()");
	}

	@Override
	public ServletResponse getResponse() {
		throw new UnsupportedOperationException("This method has not been implemented: getResponse()");
	}

	@Override
	public boolean hasOriginalRequestAndResponse() {
		throw new UnsupportedOperationException("This method has not been implemented: hasOriginalRequestAndResponse()");
	}

	@Override
	public void dispatch() {
		throw new UnsupportedOperationException("This method has not been implemented: dispatch()");
	}

	@Override
	public void dispatch(String path) {
		throw new UnsupportedOperationException("This method has not been implemented: dispatch(String)");
	}

	@Override
	public void dispatch(ServletContext context, String path) {
		throw new UnsupportedOperationException("This method has not been implemented: dispatch(ServletContext, String)");
	}

	@Override
	public void complete() {
		throw new UnsupportedOperationException("This method has not been implemented: complete()");
	}

	@Override
	public void start(Runnable run) {
		throw new UnsupportedOperationException("This method has not been implemented: start(Runnable)");
	}

	@Override
	public void addListener(AsyncListener listener) {
		throw new UnsupportedOperationException("This method has not been implemented: addListener(AsyncListener)");
	}

	@Override
	public void addListener(AsyncListener listener, ServletRequest request, ServletResponse response) {
		throw new UnsupportedOperationException("This method has not been implemented: addListener(AsyncListener, ServletRequest, ServletResponse)");
	}

	@Override
	public <T extends AsyncListener> T createListener(Class<T> clazz) throws ServletException {
		throw new UnsupportedOperationException("This method has not been implemented: createListener(Class)");
	}

	@Override
	public long getTimeout() {
		throw new UnsupportedOperationException("This method has not been implemented: getTimeout()");
	}

	@Override
	public void setTimeout(long timeout) {
		throw new UnsupportedOperationException("This method has not been implemented: setTimeout(long)");
	}
}
