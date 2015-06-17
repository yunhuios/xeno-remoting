package xeno.remoting.web;

import java.io.Closeable;
import java.io.IOException;

import org.junit.Test;

public class IoUtils_closeQuietly_Test {

	@Test
	public void test1() {
		IoUtils.closeQuietly((Closeable) null);
		IoUtils.closeQuietly(new Mock1());
		IoUtils.closeQuietly(new Mock2());
	}

	@Test
	public void test2() {
		IoUtils.closeQuietly((Closeable[]) null);
		IoUtils.closeQuietly(new Mock1(), new Mock2());
	}

	private class Mock1 implements Closeable {

		@Override
		public void close() throws IOException {
			throw new RuntimeException("Exception occurs");
		}
	}

	private class Mock2 implements Closeable {

		@Override
		public void close() throws IOException {
			// Does nothing.
		}
	}
}
