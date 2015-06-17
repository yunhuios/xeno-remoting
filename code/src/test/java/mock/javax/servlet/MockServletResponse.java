package mock.javax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class MockServletResponse implements ServletResponse {

	@Override
	public String getCharacterEncoding() {
		throw new UnsupportedOperationException("This method has not been implemented: getCharacterEncoding()");
	}

	@Override
	public String getContentType() {
		throw new UnsupportedOperationException("This method has not been implemented: getContentType()");
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		throw new UnsupportedOperationException("This method has not been implemented: getOutputStream()");
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		throw new UnsupportedOperationException("This method has not been implemented: getWriter()");
	}

	@Override
	public void setCharacterEncoding(String charset) {
		throw new UnsupportedOperationException("This method has not been implemented: setCharacterEncoding(String)");
	}

	@Override
	public void setContentLength(int len) {
		throw new UnsupportedOperationException("This method has not been implemented: setContentLength(int)");
	}

	@Override
	public void setContentType(String type) {
		throw new UnsupportedOperationException("This method has not been implemented: setContentType(String)");
	}

	@Override
	public void setBufferSize(int size) {
		throw new UnsupportedOperationException("This method has not been implemented: setBufferSize(int)");
	}

	@Override
	public int getBufferSize() {
		throw new UnsupportedOperationException("This method has not been implemented: getBufferSize()");
	}

	@Override
	public void flushBuffer() throws IOException {
		throw new UnsupportedOperationException("This method has not been implemented: flushBuffer()");
	}

	@Override
	public void resetBuffer() {
		throw new UnsupportedOperationException("This method has not been implemented: resetBuffer()");
	}

	@Override
	public boolean isCommitted() {
		throw new UnsupportedOperationException("This method has not been implemented: isCommitted()");
	}

	@Override
	public void reset() {
		throw new UnsupportedOperationException("This method has not been implemented: reset()");
	}

	@Override
	public void setLocale(Locale loc) {
		throw new UnsupportedOperationException("This method has not been implemented: setLocale(Locale)");
	}

	@Override
	public Locale getLocale() {
		throw new UnsupportedOperationException("This method has not been implemented: getLocale()");
	}
}
