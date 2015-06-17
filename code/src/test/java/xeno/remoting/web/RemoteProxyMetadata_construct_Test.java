package xeno.remoting.web;

import internal.remoteproxy.illegal.*;
import internal.remoteproxy.legal.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotActiveException;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("rawtypes")
public class RemoteProxyMetadata_construct_Test {

	@Test
	public void testNull() throws Exception {

		try {
			new RemoteProxyMetadata(null, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is null", ex.getMessage());
		}
	}

	@Test
	public void testNotRemoteProxyError() throws Exception {
		new RemoteProxyMetadata(EmptyRemoteProxy_01.class, true);

		try {
			new RemoteProxyMetadata(NotRemoteProxy_01.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotRemoteProxy_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotRemoteProxy_03.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}
	}

	@Test
	public void testCannotInstantiatedClassError() throws Exception {

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.CannotInstantiatedClass_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Non public class cannot be instantiated: internal.remoteproxy.illegal.CannotInstantiatedClass_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.CannotInstantiatedClass_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Abstract class cannot be instantiated: internal.remoteproxy.illegal.CannotInstantiatedClass_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.CannotInstantiatedClass_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Abstract class cannot be instantiated: internal.remoteproxy.illegal.CannotInstantiatedClass_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.CannotInstantiatedClass_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Interface cannot be instantiated: internal.remoteproxy.illegal.CannotInstantiatedClass_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.CannotInstantiatedClass_05"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Interface cannot be instantiated: internal.remoteproxy.illegal.CannotInstantiatedClass_05", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.CannotInstantiatedClass_06"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Enum cannot be instantiated: internal.remoteproxy.illegal.CannotInstantiatedClass_06", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.CannotInstantiatedClass_07"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Enum cannot be instantiated: internal.remoteproxy.illegal.CannotInstantiatedClass_07", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.CannotInstantiatedClass_08"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Annotation cannot be instantiated: internal.remoteproxy.illegal.CannotInstantiatedClass_08", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.CannotInstantiatedClass_09"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Annotation cannot be instantiated: internal.remoteproxy.illegal.CannotInstantiatedClass_09", ex.getMessage());
		}
	}

	@Test
	public void testInnerClassError() throws Exception {

		// internal.remoteproxy.illegal.InnerClass_01
		new RemoteProxyMetadata(InnerClass_01_01.class, true);

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_01_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_01_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_01_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_01_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_01_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_01_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_01_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_01_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_02_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_02_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_02_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_02_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_02_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_02_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_02_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_02_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_03_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_03_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_03_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_03_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_03_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_03_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_03_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_03_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_04_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_04_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_04_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_04_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_04_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_04_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_04_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_04_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_05_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_05_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_05_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_05_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_05_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_05_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_05_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_01$InnerClass_01_01_05_04", ex.getMessage());
		}

		// internal.remoteproxy.illegal.InnerClass_02
		try {
			new RemoteProxyMetadata(InnerClass_01_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_01_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_01_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_01_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_01_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_01_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_01_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_01_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_01_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_02_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_02_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_02_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_02_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_02_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_02_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_02_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_02_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_03_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_03_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_03_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_03_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_03_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_03_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_03_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_03_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_04_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_04_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_04_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_04_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_04_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_04_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_04_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_04_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_05_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_05_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_05_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_05_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_05_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_05_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_05_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_01_02$InnerClass_01_02_05_04", ex.getMessage());
		}

		// internal.remoteproxy.illegal.InnerClass_03
		try {
			new RemoteProxyMetadata(InnerClass_01_03.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_01_01"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_01_02"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_01_03"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_01_04"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_02_01"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_02_02"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_02_03"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_02_04"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_03_01"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_03_02"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_03_03"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_03_04"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_04_01"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_04_02"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_04_03"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_04_04"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_05_01"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_05_02"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_05_03"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_01_03$InnerClass_01_03_05_04"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		// internal.remoteproxy.illegal.InnerClass_04
		new RemoteProxyMetadata(InnerClass_02_01.class, true);

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_01_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_01_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_01_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_01_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_01_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_01_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_01_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_01_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_02_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_02_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_02_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_02_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_02_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_02_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_02_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_02_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_03_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_03_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_03_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_03_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_03_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_03_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_03_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_03_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_04_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_04_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_04_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_04_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_04_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_04_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_04_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_04_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_05_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_05_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_05_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_05_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_05_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_05_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_05_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_01$InnerClass_02_01_05_04", ex.getMessage());
		}

		// internal.remoteproxy.illegal.InnerClass_05
		try {
			new RemoteProxyMetadata(InnerClass_02_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_01_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_01_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_01_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_01_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_01_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_01_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_01_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_01_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_02_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_02_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_02_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_02_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_02_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_02_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_02_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_02_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_03_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_03_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_03_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_03_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_03_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_03_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_03_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_03_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_04_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_04_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_04_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_04_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_04_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_04_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_04_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_04_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_05_01"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_05_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_05_02"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_05_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_05_03"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_05_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_05_04"), true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Inner class cannot be instantiated: internal.remoteproxy.illegal.InnerClass_02_02$InnerClass_02_02_05_04", ex.getMessage());
		}

		// internal.remoteproxy.illegal.InnerClass_06
		try {
			new RemoteProxyMetadata(InnerClass_02_03.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_01_01"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_01_02"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_01_03"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_01_04"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_02_01"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_02_02"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_02_03"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_02_04"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_03_01"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_03_02"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_03_03"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_03_04"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_04_01"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_04_02"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_04_03"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_04_04"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_05_01"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_05_02"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_05_03"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(Class.forName("internal.remoteproxy.illegal.InnerClass_02_03$InnerClass_02_03_05_04"), true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}
	}

	@Test
	public void testNoDefaultConstructorError() throws Exception {

		try {
			new RemoteProxyMetadata(NoDefaultConstructor_01.class, true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Target class cannot be instantiated: internal.remoteproxy.illegal.NoDefaultConstructor_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NoDefaultConstructor_02.class, true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Target class cannot be instantiated: internal.remoteproxy.illegal.NoDefaultConstructor_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NoDefaultConstructor_03.class, true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Target class cannot be instantiated: internal.remoteproxy.illegal.NoDefaultConstructor_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NoDefaultConstructor_04.class, true);
			Assert.fail();

		} catch (InstantiationException ex) {
			Assert.assertEquals("Target class cannot be instantiated: internal.remoteproxy.illegal.NoDefaultConstructor_04", ex.getMessage());
		}
	}

	@Test
	public void testNotPublicWebMethodError() throws Exception {

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_01_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicWebMethod_01_01 contains non public web method: m_01_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_01_02.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicWebMethod_01_02 contains non public web method: m_01_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_01_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicWebMethod_01_03 contains non public web method: m_01_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_01_04.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicWebMethod_01_04 contains non public web method: m_01_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_01_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicWebMethod_01_05 contains non public web method: m_01_05", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_01_06.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicWebMethod_01_06 contains non public web method: m_01_06", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_02_01.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_02_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_02_03.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_02_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_02_05.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_02_06.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_03_01.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_03_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_03_03.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_03_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_03_05.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_03_06.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_04_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicWebMethod_04_01 contains non public web method: m_02_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_04_02.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicWebMethod_04_02 contains non public web method: m_02_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_04_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicWebMethod_04_03 contains non public web method: m_02_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_04_04.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicWebMethod_04_04 contains non public web method: m_02_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_04_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicWebMethod_04_05 contains non public web method: m_02_05", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicWebMethod_04_06.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicWebMethod_04_06 contains non public web method: m_02_06", ex.getMessage());
		}
	}

	@Test
	public void testContainsOverloadWebMethodError() throws Exception {

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_01_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.ContainsOverloadWebMethod_01_01 contains overload web method: m_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_01_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_01_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.ContainsOverloadWebMethod_01_03 contains overload web method: m_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_01_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_01_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.ContainsOverloadWebMethod_01_05 contains overload web method: m_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_02_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.ContainsOverloadWebMethod_02_01 contains overload web method: m_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_02_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_02_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.ContainsOverloadWebMethod_02_03 contains overload web method: m_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_02_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_02_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.ContainsOverloadWebMethod_02_05 contains overload web method: m_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_03_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.ContainsOverloadWebMethod_03_01 contains overload web method: m_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_03_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_03_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.ContainsOverloadWebMethod_03_03 contains overload web method: m_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_03_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_03_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.ContainsOverloadWebMethod_03_05 contains overload web method: m_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_04_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.ContainsOverloadWebMethod_04_01 contains overload web method: m_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_04_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_04_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.ContainsOverloadWebMethod_04_03 contains overload web method: m_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_04_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(ContainsOverloadWebMethod_04_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.ContainsOverloadWebMethod_04_05 contains overload web method: m_04", ex.getMessage());
		}
	}

	@Test
	public void testNotPublicExceptionHandlerError() throws Exception {

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_01_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicExceptionHandler_01_01 contains non public exception handler: e_01_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_01_02.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicExceptionHandler_01_02 contains non public exception handler: e_01_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_01_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicExceptionHandler_01_03 contains non public exception handler: e_01_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_01_04.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicExceptionHandler_01_04 contains non public exception handler: e_01_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_01_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicExceptionHandler_01_05 contains non public exception handler: e_01_05", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_01_06.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicExceptionHandler_01_06 contains non public exception handler: e_01_06", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_02_01.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_02_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_02_03.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_02_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_02_05.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_02_06.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_03_01.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_03_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_03_03.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_03_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_03_05.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_03_06.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_04_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicExceptionHandler_04_01 contains non public exception handler: e_02_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_04_02.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicExceptionHandler_04_02 contains non public exception handler: e_02_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_04_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicExceptionHandler_04_03 contains non public exception handler: e_02_03", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_04_04.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicExceptionHandler_04_04 contains non public exception handler: e_02_04", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_04_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicExceptionHandler_04_05 contains non public exception handler: e_02_05", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(NotPublicExceptionHandler_04_06.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.NotPublicExceptionHandler_04_06 contains non public exception handler: e_02_06", ex.getMessage());
		}
	}

	@Test
	public void testIllegalArgumentForExceptionHandlerError() throws Exception {

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_01_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentCountForExceptionHandler_01_01 contains missing required argument exception handler: e_01_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_01_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_01_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentCountForExceptionHandler_01_03 contains missing required argument exception handler: e_01_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_01_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_01_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentCountForExceptionHandler_01_05 contains missing required argument exception handler: e_01_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_01_06.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentCountForExceptionHandler_01_06 contains multiple arguments exception handler: e_01_06", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_01_07.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_01_08.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentCountForExceptionHandler_01_08 contains multiple arguments exception handler: e_01_07", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_01_09.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_01_10.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentCountForExceptionHandler_01_10 contains multiple arguments exception handler: e_01_07", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_02_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentCountForExceptionHandler_02_01 contains missing required argument exception handler: e_02_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_02_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_02_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentCountForExceptionHandler_02_03 contains missing required argument exception handler: e_02_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_02_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_02_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentCountForExceptionHandler_02_05 contains missing required argument exception handler: e_02_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_02_06.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentCountForExceptionHandler_02_06 contains multiple arguments exception handler: e_02_06", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_02_07.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_02_08.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentCountForExceptionHandler_02_08 contains multiple arguments exception handler: e_02_07", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_02_09.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentCountForExceptionHandler_02_10.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentCountForExceptionHandler_02_10 contains multiple arguments exception handler: e_02_07", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentTypeForExceptionHandler_01_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentTypeForExceptionHandler_01_01 contains illegal argument type exception handler: e_01_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentTypeForExceptionHandler_01_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentTypeForExceptionHandler_01_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentTypeForExceptionHandler_01_03 contains illegal argument type exception handler: e_01_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentTypeForExceptionHandler_01_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentTypeForExceptionHandler_01_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentTypeForExceptionHandler_01_05 contains illegal argument type exception handler: e_01_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentTypeForExceptionHandler_02_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentTypeForExceptionHandler_02_01 contains illegal argument type exception handler: e_02_01", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentTypeForExceptionHandler_02_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentTypeForExceptionHandler_02_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentTypeForExceptionHandler_02_03 contains illegal argument type exception handler: e_02_02", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentTypeForExceptionHandler_02_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(IllegalArgumentTypeForExceptionHandler_02_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.IllegalArgumentTypeForExceptionHandler_02_05 contains illegal argument type exception handler: e_02_02", ex.getMessage());
		}
	}

	@Test
	public void testDuplicatedMappingExceptionHandlerError() throws Exception {

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_01_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_01_01 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_01_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_01_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_01_03 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_01_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_01_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_01_05 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_01_06.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_01_07.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_01_07 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_01_08.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_01_09.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_01_09 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_02_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_02_01 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_02_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_02_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_02_03 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_02_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_02_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_02_05 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_02_06.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_02_07.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_02_07 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_02_08.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_02_09.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_02_09 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_03_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_03_01 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_03_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_03_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_03_03 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_03_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_03_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_03_05 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_03_06.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_03_07.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_03_07 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_03_08.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_03_09.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_03_09 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_04_01.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_04_01 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_04_02.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_04_03.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_04_03 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_04_04.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_04_05.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_04_05 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_04_06.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_04_07.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_04_07 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_04_08.class, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(DuplicatedMappingExceptionHandler_04_09.class, true);
			Assert.fail();

		} catch (IllegalAccessException ex) {
			Assert.assertEquals("Target class internal.remoteproxy.illegal.DuplicatedMappingExceptionHandler_04_09 contains duplicated exception handler for: java.lang.IllegalArgumentException", ex.getMessage());
		}
	}

	@Test
	public void testOnlyWebMethod() throws Exception {
		StringBuffer readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethod_01_01\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethod_01_01.m_01_01 = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_01_01\", \"m_01_01\", [], opts);\n");
		readable.append("};");
		StringBuffer minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethod_01_01\");internal.remoteproxy.legal.OnlyWebMethod_01_01.m_01_01=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_01_01\",\"m_01_01\",[],a)};");
		assertResult(readable, minified, OnlyWebMethod_01_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(1, metadata.getWebMethods().length);
				assertWebMethod("public void internal.remoteproxy.legal.OnlyWebMethod_01_01.m_01_01()", "m_01_01", metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethod_01_02\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethod_01_02.m_01_02_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_01_02\", \"m_01_02_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethod_01_02.m_01_02_c = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_01_02\", \"m_01_02_c\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethod_01_02.m_01_02_d = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_01_02\", \"m_01_02_d\", [arg0, arg1], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethod_01_02.m_01_02_e = function(arg0, arg1, arg2, arg3, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_01_02\", \"m_01_02_e\", [arg0, arg1, arg2, arg3], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethod_01_02\");internal.remoteproxy.legal.OnlyWebMethod_01_02.m_01_02_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_01_02\",\"m_01_02_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethod_01_02.m_01_02_c=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_01_02\",\"m_01_02_c\",[a],b)};internal.remoteproxy.legal.OnlyWebMethod_01_02.m_01_02_d=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_01_02\",\"m_01_02_d\",[b,a],c)};internal.remoteproxy.legal.OnlyWebMethod_01_02.m_01_02_e=function(d,c,b,a,e){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_01_02\",\"m_01_02_e\",[d,c,b,a],e)};");
		assertResult(readable, minified, OnlyWebMethod_01_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(4, metadata.getWebMethods().length);
				assertWebMethod("public void internal.remoteproxy.legal.OnlyWebMethod_01_02.m_01_02_a()", "m_01_02_a", metadata);
				assertWebMethod("m_01_02_b", metadata);
				assertWebMethod("public void internal.remoteproxy.legal.OnlyWebMethod_01_02.m_01_02_c(int) throws java.io.IOException", "m_01_02_c", metadata);
				assertWebMethod("public java.lang.String internal.remoteproxy.legal.OnlyWebMethod_01_02.m_01_02_d(java.lang.Object,int)", "m_01_02_d", metadata);
				assertWebMethod("public boolean internal.remoteproxy.legal.OnlyWebMethod_01_02.m_01_02_e(java.lang.String,boolean,long,int)", "m_01_02_e", metadata);
				assertWebMethod("m_01_02_f", metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethod_02_01\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethod_02_01.m_02_01 = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_02_01\", \"m_02_01\", [], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethod_02_01\");internal.remoteproxy.legal.OnlyWebMethod_02_01.m_02_01=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_02_01\",\"m_02_01\",[],a)};");
		assertResult(readable, minified, OnlyWebMethod_02_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(1, metadata.getWebMethods().length);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethod_02_01.m_02_01()", "m_02_01", metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethod_02_02\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethod_02_02.m_02_02_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_02_02\", \"m_02_02_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethod_02_02.m_02_02_c = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_02_02\", \"m_02_02_c\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethod_02_02.m_02_02_d = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_02_02\", \"m_02_02_d\", [arg0, arg1], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethod_02_02.m_02_02_e = function(arg0, arg1, arg2, arg3, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_02_02\", \"m_02_02_e\", [arg0, arg1, arg2, arg3], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethod_02_02\");internal.remoteproxy.legal.OnlyWebMethod_02_02.m_02_02_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_02_02\",\"m_02_02_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethod_02_02.m_02_02_c=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_02_02\",\"m_02_02_c\",[a],b)};internal.remoteproxy.legal.OnlyWebMethod_02_02.m_02_02_d=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_02_02\",\"m_02_02_d\",[b,a],c)};internal.remoteproxy.legal.OnlyWebMethod_02_02.m_02_02_e=function(d,c,b,a,e){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_02_02\",\"m_02_02_e\",[d,c,b,a],e)};");
		assertResult(readable, minified, OnlyWebMethod_02_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(4, metadata.getWebMethods().length);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethod_02_02.m_02_02_a()", "m_02_02_a", metadata);
				assertWebMethod("m_02_02_b", metadata);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethod_02_02.m_02_02_c(int) throws java.io.IOException", "m_02_02_c", metadata);
				assertWebMethod("public static java.lang.String internal.remoteproxy.legal.OnlyWebMethod_02_02.m_02_02_d(java.lang.Object,int)", "m_02_02_d", metadata);
				assertWebMethod("public static boolean internal.remoteproxy.legal.OnlyWebMethod_02_02.m_02_02_e(java.lang.String,boolean,long,int)", "m_02_02_e", metadata);
				assertWebMethod("m_02_02_f", metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethod_03_02\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethod_03_02.m_03_02_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_03_02\", \"m_03_02_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethod_03_02.m_03_02_c = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_03_02\", \"m_03_02_c\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethod_03_02.m_03_02_d = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_03_02\", \"m_03_02_d\", [arg0, arg1], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethod_03_02.m_03_02_e = function(arg0, arg1, arg2, arg3, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_03_02\", \"m_03_02_e\", [arg0, arg1, arg2, arg3], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethod_03_02\");internal.remoteproxy.legal.OnlyWebMethod_03_02.m_03_02_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_03_02\",\"m_03_02_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethod_03_02.m_03_02_c=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_03_02\",\"m_03_02_c\",[a],b)};internal.remoteproxy.legal.OnlyWebMethod_03_02.m_03_02_d=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_03_02\",\"m_03_02_d\",[b,a],c)};internal.remoteproxy.legal.OnlyWebMethod_03_02.m_03_02_e=function(d,c,b,a,e){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethod_03_02\",\"m_03_02_e\",[d,c,b,a],e)};");
		assertResult(readable, minified, OnlyWebMethod_03_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(4, metadata.getWebMethods().length);
				assertWebMethod("public void internal.remoteproxy.legal.OnlyWebMethod_03_02.m_03_02_a()", "m_03_02_a", metadata);
				assertWebMethod("m_03_02_b", metadata);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethod_03_02.m_03_02_c(int) throws java.io.IOException", "m_03_02_c", metadata);
				assertWebMethod("public java.lang.String internal.remoteproxy.legal.OnlyWebMethod_03_02.m_03_02_d(java.lang.Object,int)", "m_03_02_d", metadata);
				assertWebMethod("public static boolean internal.remoteproxy.legal.OnlyWebMethod_03_02.m_03_02_e(java.lang.String,boolean,long,int)", "m_03_02_e", metadata);
				assertWebMethod("m_03_02_f", metadata);
			}
		});
	}

	@Test
	public void testOnlyWebMethodExtend() throws Exception {
		StringBuffer readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_01\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_01.m_01_01_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_01\", \"m_01_01_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_01.m_01_01_b = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_01\", \"m_01_01_b\", [arg0], opts);\n");
		readable.append("};");
		StringBuffer minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_01\");internal.remoteproxy.legal.OnlyWebMethodExtend_01_01.m_01_01_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_01\",\"m_01_01_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_01_01.m_01_01_b=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_01\",\"m_01_01_b\",[a],b)};");
		assertResult(readable, minified, OnlyWebMethodExtend_01_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(2, metadata.getWebMethods().length);
				assertWebMethod("public int internal.remoteproxy.legal.OnlyWebMethodExtend_01_01.m_01_01_a()", "m_01_01_a", metadata);
				assertWebMethod("public void internal.remoteproxy.legal.OnlyWebMethodExtend_01_01.m_01_01_b(char)", "m_01_01_b", metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_02\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_02.m_01_01_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_02\", \"m_01_01_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_02.m_01_01_b = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_02\", \"m_01_01_b\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_02.m_01_02_a = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_02\", \"m_01_02_a\", [arg0, arg1], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_02\");internal.remoteproxy.legal.OnlyWebMethodExtend_01_02.m_01_01_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_02\",\"m_01_01_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_01_02.m_01_01_b=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_02\",\"m_01_01_b\",[a],b)};internal.remoteproxy.legal.OnlyWebMethodExtend_01_02.m_01_02_a=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_02\",\"m_01_02_a\",[b,a],c)};");
		assertResult(readable, minified, OnlyWebMethodExtend_01_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(3, metadata.getWebMethods().length);
				assertWebMethod("public int internal.remoteproxy.legal.OnlyWebMethodExtend_01_01.m_01_01_a()", "m_01_01_a", metadata);
				assertWebMethod("public void internal.remoteproxy.legal.OnlyWebMethodExtend_01_01.m_01_01_b(char)", "m_01_01_b", metadata);
				assertWebMethod("public java.lang.String internal.remoteproxy.legal.OnlyWebMethodExtend_01_02.m_01_02_a(boolean,java.lang.Object)", "m_01_02_a", metadata);
				assertWebMethod("m_01_02_b", metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_03\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_03.m_01_01_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_03\", \"m_01_01_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_03.m_01_01_b = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_03\", \"m_01_01_b\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_03.m_01_02_a = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_03\", \"m_01_02_a\", [arg0, arg1], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_03.m_01_03_a = function(arg0, arg1, arg2, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_03\", \"m_01_03_a\", [arg0, arg1, arg2], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_03.m_01_03_c = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_03\", \"m_01_03_c\", [arg0, arg1], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_03\");internal.remoteproxy.legal.OnlyWebMethodExtend_01_03.m_01_01_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_03\",\"m_01_01_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_01_03.m_01_01_b=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_03\",\"m_01_01_b\",[a],b)};internal.remoteproxy.legal.OnlyWebMethodExtend_01_03.m_01_02_a=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_03\",\"m_01_02_a\",[b,a],c)};internal.remoteproxy.legal.OnlyWebMethodExtend_01_03.m_01_03_a=function(c,b,a,d){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_03\",\"m_01_03_a\",[c,b,a],d)};internal.remoteproxy.legal.OnlyWebMethodExtend_01_03.m_01_03_c=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_03\",\"m_01_03_c\",[b,a],c)};");
		assertResult(readable, minified, OnlyWebMethodExtend_01_03.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(5, metadata.getWebMethods().length);
				assertWebMethod("public int internal.remoteproxy.legal.OnlyWebMethodExtend_01_01.m_01_01_a()", "m_01_01_a", metadata);
				assertWebMethod("public void internal.remoteproxy.legal.OnlyWebMethodExtend_01_01.m_01_01_b(char)", "m_01_01_b", metadata);
				assertWebMethod("public java.lang.String internal.remoteproxy.legal.OnlyWebMethodExtend_01_02.m_01_02_a(boolean,java.lang.Object)", "m_01_02_a", metadata);
				assertWebMethod("m_01_02_b", metadata);
				assertWebMethod("public java.lang.Object internal.remoteproxy.legal.OnlyWebMethodExtend_01_03.m_01_03_a(boolean,java.lang.String,java.lang.Object)", "m_01_03_a", metadata);
				assertWebMethod("m_01_03_b", metadata);
				assertWebMethod("public int internal.remoteproxy.legal.OnlyWebMethodExtend_01_03.m_01_03_c(int,int)", "m_01_03_c", metadata);
			}
		});

		assertFault(OnlyWebMethodExtend_01_04.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_05\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_05.m_01_01_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_05\", \"m_01_01_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_05.m_01_01_b = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_05\", \"m_01_01_b\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_05.m_01_04_a = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_05\", \"m_01_04_a\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_05.m_01_04_b = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_05\", \"m_01_04_b\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_05.m_01_05_a = function(arg0, arg1, arg2, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_05\", \"m_01_05_a\", [arg0, arg1, arg2], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_01_05.m_01_05_c = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_05\", \"m_01_05_c\", [arg0, arg1], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_05\");internal.remoteproxy.legal.OnlyWebMethodExtend_01_05.m_01_01_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_05\",\"m_01_01_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_01_05.m_01_01_b=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_05\",\"m_01_01_b\",[a],b)};internal.remoteproxy.legal.OnlyWebMethodExtend_01_05.m_01_04_a=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_05\",\"m_01_04_a\",[a],b)};internal.remoteproxy.legal.OnlyWebMethodExtend_01_05.m_01_04_b=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_05\",\"m_01_04_b\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_01_05.m_01_05_a=function(c,b,a,d){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_05\",\"m_01_05_a\",[c,b,a],d)};internal.remoteproxy.legal.OnlyWebMethodExtend_01_05.m_01_05_c=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_01_05\",\"m_01_05_c\",[b,a],c)};");
		assertResult(readable, minified, OnlyWebMethodExtend_01_05.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(6, metadata.getWebMethods().length);
				assertWebMethod("public int internal.remoteproxy.legal.OnlyWebMethodExtend_01_01.m_01_01_a()", "m_01_01_a", metadata);
				assertWebMethod("public void internal.remoteproxy.legal.OnlyWebMethodExtend_01_01.m_01_01_b(char)", "m_01_01_b", metadata);
				assertWebMethod("public java.lang.String internal.remoteproxy.legal.OnlyWebMethodExtend_01_04.m_01_04_a(boolean)", "m_01_04_a", metadata);
				assertWebMethod("public void internal.remoteproxy.legal.OnlyWebMethodExtend_01_04.m_01_04_b()", "m_01_04_b", metadata);
				assertWebMethod("m_01_04_c", metadata);
				assertWebMethod("public java.lang.Object internal.remoteproxy.legal.OnlyWebMethodExtend_01_05.m_01_05_a(boolean,java.lang.String,java.lang.Object)", "m_01_05_a", metadata);
				assertWebMethod("m_01_05_b", metadata);
				assertWebMethod("public int internal.remoteproxy.legal.OnlyWebMethodExtend_01_05.m_01_05_c(int,int)", "m_01_05_c", metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_01\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_01.m_02_01_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_01\", \"m_02_01_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_01.m_02_01_b = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_01\", \"m_02_01_b\", [arg0], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_01\");internal.remoteproxy.legal.OnlyWebMethodExtend_02_01.m_02_01_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_01\",\"m_02_01_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_02_01.m_02_01_b=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_01\",\"m_02_01_b\",[a],b)};");
		assertResult(readable, minified, OnlyWebMethodExtend_02_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(2, metadata.getWebMethods().length);
				assertWebMethod("public static int internal.remoteproxy.legal.OnlyWebMethodExtend_02_01.m_02_01_a()", "m_02_01_a", metadata);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethodExtend_02_01.m_02_01_b(char)", "m_02_01_b", metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_02\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_02.m_02_01_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_02\", \"m_02_01_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_02.m_02_01_b = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_02\", \"m_02_01_b\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_02.m_02_02_a = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_02\", \"m_02_02_a\", [arg0, arg1], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_02\");internal.remoteproxy.legal.OnlyWebMethodExtend_02_02.m_02_01_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_02\",\"m_02_01_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_02_02.m_02_01_b=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_02\",\"m_02_01_b\",[a],b)};internal.remoteproxy.legal.OnlyWebMethodExtend_02_02.m_02_02_a=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_02\",\"m_02_02_a\",[b,a],c)};");
		assertResult(readable, minified, OnlyWebMethodExtend_02_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(3, metadata.getWebMethods().length);
				assertWebMethod("public static int internal.remoteproxy.legal.OnlyWebMethodExtend_02_01.m_02_01_a()", "m_02_01_a", metadata);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethodExtend_02_01.m_02_01_b(char)", "m_02_01_b", metadata);
				assertWebMethod("public static java.lang.String internal.remoteproxy.legal.OnlyWebMethodExtend_02_02.m_02_02_a(boolean,java.lang.Object)", "m_02_02_a", metadata);
				assertWebMethod("m_02_02_b", metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_03\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_03.m_02_01_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_03\", \"m_02_01_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_03.m_02_01_b = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_03\", \"m_02_01_b\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_03.m_02_02_a = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_03\", \"m_02_02_a\", [arg0, arg1], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_03.m_02_03_a = function(arg0, arg1, arg2, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_03\", \"m_02_03_a\", [arg0, arg1, arg2], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_03.m_02_03_c = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_03\", \"m_02_03_c\", [arg0, arg1], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_03\");internal.remoteproxy.legal.OnlyWebMethodExtend_02_03.m_02_01_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_03\",\"m_02_01_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_02_03.m_02_01_b=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_03\",\"m_02_01_b\",[a],b)};internal.remoteproxy.legal.OnlyWebMethodExtend_02_03.m_02_02_a=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_03\",\"m_02_02_a\",[b,a],c)};internal.remoteproxy.legal.OnlyWebMethodExtend_02_03.m_02_03_a=function(c,b,a,d){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_03\",\"m_02_03_a\",[c,b,a],d)};internal.remoteproxy.legal.OnlyWebMethodExtend_02_03.m_02_03_c=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_03\",\"m_02_03_c\",[b,a],c)};");
		assertResult(readable, minified, OnlyWebMethodExtend_02_03.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(5, metadata.getWebMethods().length);
				assertWebMethod("public static int internal.remoteproxy.legal.OnlyWebMethodExtend_02_01.m_02_01_a()", "m_02_01_a", metadata);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethodExtend_02_01.m_02_01_b(char)", "m_02_01_b", metadata);
				assertWebMethod("public static java.lang.String internal.remoteproxy.legal.OnlyWebMethodExtend_02_02.m_02_02_a(boolean,java.lang.Object)", "m_02_02_a", metadata);
				assertWebMethod("m_02_02_b", metadata);
				assertWebMethod("public static java.lang.Object internal.remoteproxy.legal.OnlyWebMethodExtend_02_03.m_02_03_a(boolean,java.lang.String,java.lang.Object)", "m_02_03_a", metadata);
				assertWebMethod("m_02_03_b", metadata);
				assertWebMethod("public static int internal.remoteproxy.legal.OnlyWebMethodExtend_02_03.m_02_03_c(int,int)", "m_02_03_c", metadata);
			}
		});

		assertFault(OnlyWebMethodExtend_02_04.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_05\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_05.m_02_01_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_05\", \"m_02_01_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_05.m_02_01_b = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_05\", \"m_02_01_b\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_05.m_02_04_a = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_05\", \"m_02_04_a\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_05.m_02_04_b = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_05\", \"m_02_04_b\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_05.m_02_05_a = function(arg0, arg1, arg2, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_05\", \"m_02_05_a\", [arg0, arg1, arg2], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_02_05.m_02_05_c = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_05\", \"m_02_05_c\", [arg0, arg1], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_05\");internal.remoteproxy.legal.OnlyWebMethodExtend_02_05.m_02_01_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_05\",\"m_02_01_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_02_05.m_02_01_b=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_05\",\"m_02_01_b\",[a],b)};internal.remoteproxy.legal.OnlyWebMethodExtend_02_05.m_02_04_a=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_05\",\"m_02_04_a\",[a],b)};internal.remoteproxy.legal.OnlyWebMethodExtend_02_05.m_02_04_b=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_05\",\"m_02_04_b\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_02_05.m_02_05_a=function(c,b,a,d){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_05\",\"m_02_05_a\",[c,b,a],d)};internal.remoteproxy.legal.OnlyWebMethodExtend_02_05.m_02_05_c=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_02_05\",\"m_02_05_c\",[b,a],c)};");
		assertResult(readable, minified, OnlyWebMethodExtend_02_05.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(6, metadata.getWebMethods().length);
				assertWebMethod("public static int internal.remoteproxy.legal.OnlyWebMethodExtend_02_01.m_02_01_a()", "m_02_01_a", metadata);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethodExtend_02_01.m_02_01_b(char)", "m_02_01_b", metadata);
				assertWebMethod("public static java.lang.String internal.remoteproxy.legal.OnlyWebMethodExtend_02_04.m_02_04_a(boolean)", "m_02_04_a", metadata);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethodExtend_02_04.m_02_04_b()", "m_02_04_b", metadata);
				assertWebMethod("m_02_04_c", metadata);
				assertWebMethod("public static java.lang.Object internal.remoteproxy.legal.OnlyWebMethodExtend_02_05.m_02_05_a(boolean,java.lang.String,java.lang.Object)", "m_02_05_a", metadata);
				assertWebMethod("m_02_05_b", metadata);
				assertWebMethod("public static int internal.remoteproxy.legal.OnlyWebMethodExtend_02_05.m_02_05_c(int,int)", "m_02_05_c", metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_01\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_01.m_03_01_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_01\", \"m_03_01_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_01.m_03_01_b = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_01\", \"m_03_01_b\", [arg0], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_01\");internal.remoteproxy.legal.OnlyWebMethodExtend_03_01.m_03_01_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_01\",\"m_03_01_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_03_01.m_03_01_b=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_01\",\"m_03_01_b\",[a],b)};");
		assertResult(readable, minified, OnlyWebMethodExtend_03_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(2, metadata.getWebMethods().length);
				assertWebMethod("public int internal.remoteproxy.legal.OnlyWebMethodExtend_03_01.m_03_01_a()", "m_03_01_a", metadata);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethodExtend_03_01.m_03_01_b(char)", "m_03_01_b", metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_02\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_02.m_03_01_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_02\", \"m_03_01_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_02.m_03_01_b = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_02\", \"m_03_01_b\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_02.m_03_02_a = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_02\", \"m_03_02_a\", [arg0, arg1], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_02\");internal.remoteproxy.legal.OnlyWebMethodExtend_03_02.m_03_01_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_02\",\"m_03_01_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_03_02.m_03_01_b=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_02\",\"m_03_01_b\",[a],b)};internal.remoteproxy.legal.OnlyWebMethodExtend_03_02.m_03_02_a=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_02\",\"m_03_02_a\",[b,a],c)};");
		assertResult(readable, minified, OnlyWebMethodExtend_03_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(3, metadata.getWebMethods().length);
				assertWebMethod("public int internal.remoteproxy.legal.OnlyWebMethodExtend_03_01.m_03_01_a()", "m_03_01_a", metadata);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethodExtend_03_01.m_03_01_b(char)", "m_03_01_b", metadata);
				assertWebMethod("public static java.lang.String internal.remoteproxy.legal.OnlyWebMethodExtend_03_02.m_03_02_a(boolean,java.lang.Object)", "m_03_02_a", metadata);
				assertWebMethod("m_03_02_b", metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_03\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_03.m_03_01_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_03\", \"m_03_01_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_03.m_03_01_b = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_03\", \"m_03_01_b\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_03.m_03_02_a = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_03\", \"m_03_02_a\", [arg0, arg1], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_03.m_03_03_a = function(arg0, arg1, arg2, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_03\", \"m_03_03_a\", [arg0, arg1, arg2], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_03.m_03_03_c = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_03\", \"m_03_03_c\", [arg0, arg1], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_03\");internal.remoteproxy.legal.OnlyWebMethodExtend_03_03.m_03_01_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_03\",\"m_03_01_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_03_03.m_03_01_b=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_03\",\"m_03_01_b\",[a],b)};internal.remoteproxy.legal.OnlyWebMethodExtend_03_03.m_03_02_a=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_03\",\"m_03_02_a\",[b,a],c)};internal.remoteproxy.legal.OnlyWebMethodExtend_03_03.m_03_03_a=function(c,b,a,d){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_03\",\"m_03_03_a\",[c,b,a],d)};internal.remoteproxy.legal.OnlyWebMethodExtend_03_03.m_03_03_c=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_03\",\"m_03_03_c\",[b,a],c)};");
		assertResult(readable, minified, OnlyWebMethodExtend_03_03.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(5, metadata.getWebMethods().length);
				assertWebMethod("public int internal.remoteproxy.legal.OnlyWebMethodExtend_03_01.m_03_01_a()", "m_03_01_a", metadata);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethodExtend_03_01.m_03_01_b(char)", "m_03_01_b", metadata);
				assertWebMethod("public static java.lang.String internal.remoteproxy.legal.OnlyWebMethodExtend_03_02.m_03_02_a(boolean,java.lang.Object)", "m_03_02_a", metadata);
				assertWebMethod("m_03_02_b", metadata);
				assertWebMethod("public java.lang.Object internal.remoteproxy.legal.OnlyWebMethodExtend_03_03.m_03_03_a(boolean,java.lang.String,java.lang.Object)", "m_03_03_a", metadata);
				assertWebMethod("m_03_03_b", metadata);
				assertWebMethod("public static int internal.remoteproxy.legal.OnlyWebMethodExtend_03_03.m_03_03_c(int,int)", "m_03_03_c", metadata);
			}
		});

		assertFault(OnlyWebMethodExtend_03_04.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_05\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_05.m_03_01_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_05\", \"m_03_01_a\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_05.m_03_01_b = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_05\", \"m_03_01_b\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_05.m_03_04_a = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_05\", \"m_03_04_a\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_05.m_03_04_b = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_05\", \"m_03_04_b\", [], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_05.m_03_05_a = function(arg0, arg1, arg2, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_05\", \"m_03_05_a\", [arg0, arg1, arg2], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodExtend_03_05.m_03_05_c = function(arg0, arg1, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_05\", \"m_03_05_c\", [arg0, arg1], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_05\");internal.remoteproxy.legal.OnlyWebMethodExtend_03_05.m_03_01_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_05\",\"m_03_01_a\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_03_05.m_03_01_b=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_05\",\"m_03_01_b\",[a],b)};internal.remoteproxy.legal.OnlyWebMethodExtend_03_05.m_03_04_a=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_05\",\"m_03_04_a\",[a],b)};internal.remoteproxy.legal.OnlyWebMethodExtend_03_05.m_03_04_b=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_05\",\"m_03_04_b\",[],a)};internal.remoteproxy.legal.OnlyWebMethodExtend_03_05.m_03_05_a=function(c,b,a,d){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_05\",\"m_03_05_a\",[c,b,a],d)};internal.remoteproxy.legal.OnlyWebMethodExtend_03_05.m_03_05_c=function(b,a,c){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodExtend_03_05\",\"m_03_05_c\",[b,a],c)};");
		assertResult(readable, minified, OnlyWebMethodExtend_03_05.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(6, metadata.getWebMethods().length);
				assertWebMethod("public int internal.remoteproxy.legal.OnlyWebMethodExtend_03_01.m_03_01_a()", "m_03_01_a", metadata);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethodExtend_03_01.m_03_01_b(char)", "m_03_01_b", metadata);
				assertWebMethod("public static java.lang.String internal.remoteproxy.legal.OnlyWebMethodExtend_03_04.m_03_04_a(boolean)", "m_03_04_a", metadata);
				assertWebMethod("public void internal.remoteproxy.legal.OnlyWebMethodExtend_03_04.m_03_04_b()", "m_03_04_b", metadata);
				assertWebMethod("m_03_04_c", metadata);
				assertWebMethod("public java.lang.Object internal.remoteproxy.legal.OnlyWebMethodExtend_03_05.m_03_05_a(boolean,java.lang.String,java.lang.Object)", "m_03_05_a", metadata);
				assertWebMethod("m_03_05_b", metadata);
				assertWebMethod("public static int internal.remoteproxy.legal.OnlyWebMethodExtend_03_05.m_03_05_c(int,int)", "m_03_05_c", metadata);
			}
		});
	}

	@Test
	public void testOnlyWebMethodOverride() throws Exception {
		assertFault(OnlyWebMethodOverride_01_01.class);

		StringBuffer readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_01_02\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodOverride_01_02.m_01_01 = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_01_02\", \"m_01_01\", [arg0], opts);\n");
		readable.append("};");
		StringBuffer minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_01_02\");internal.remoteproxy.legal.OnlyWebMethodOverride_01_02.m_01_01=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_01_02\",\"m_01_01\",[a],b)};");
		assertResult(readable, minified, OnlyWebMethodOverride_01_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(1, metadata.getWebMethods().length);
				assertWebMethod("public void internal.remoteproxy.legal.OnlyWebMethodOverride_01_02.m_01_01(int)", "m_01_01", metadata);
			}
		});

		assertFault(OnlyWebMethodOverride_01_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_01_04\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodOverride_01_04.m_01_01 = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_01_04\", \"m_01_01\", [arg0], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_01_04\");internal.remoteproxy.legal.OnlyWebMethodOverride_01_04.m_01_01=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_01_04\",\"m_01_01\",[a],b)};");
		assertResult(readable, minified, OnlyWebMethodOverride_01_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(1, metadata.getWebMethods().length);
				assertWebMethod("public void internal.remoteproxy.legal.OnlyWebMethodOverride_01_04.m_01_01(int)", "m_01_01", metadata);
			}
		});

		assertFault(OnlyWebMethodOverride_02_01.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_02_02\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodOverride_02_02.m_02_01 = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_02_02\", \"m_02_01\", [arg0], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_02_02\");internal.remoteproxy.legal.OnlyWebMethodOverride_02_02.m_02_01=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_02_02\",\"m_02_01\",[a],b)};");
		assertResult(readable, minified, OnlyWebMethodOverride_02_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(1, metadata.getWebMethods().length);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethodOverride_02_02.m_02_01(int)", "m_02_01", metadata);
			}
		});

		assertFault(OnlyWebMethodOverride_02_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_02_04\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodOverride_02_04.m_02_01 = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_02_04\", \"m_02_01\", [arg0], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_02_04\");internal.remoteproxy.legal.OnlyWebMethodOverride_02_04.m_02_01=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_02_04\",\"m_02_01\",[a],b)};");
		assertResult(readable, minified, OnlyWebMethodOverride_02_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(1, metadata.getWebMethods().length);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethodOverride_02_04.m_02_01(int)", "m_02_01", metadata);
			}
		});

		assertFault(OnlyWebMethodOverride_03_01.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_03_02\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodOverride_03_02.m_03_01 = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_03_02\", \"m_03_01\", [arg0], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_03_02\");internal.remoteproxy.legal.OnlyWebMethodOverride_03_02.m_03_01=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_03_02\",\"m_03_01\",[a],b)};");
		assertResult(readable, minified, OnlyWebMethodOverride_03_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(1, metadata.getWebMethods().length);
				assertWebMethod("public void internal.remoteproxy.legal.OnlyWebMethodOverride_03_02.m_03_01(int)", "m_03_01", metadata);
			}
		});

		assertFault(OnlyWebMethodOverride_03_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_03_04\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodOverride_03_04.m_03_01 = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_03_04\", \"m_03_01\", [arg0], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_03_04\");internal.remoteproxy.legal.OnlyWebMethodOverride_03_04.m_03_01=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_03_04\",\"m_03_01\",[a],b)};");
		assertResult(readable, minified, OnlyWebMethodOverride_03_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(1, metadata.getWebMethods().length);
				assertWebMethod("public void internal.remoteproxy.legal.OnlyWebMethodOverride_03_04.m_03_01(int)", "m_03_01", metadata);
			}
		});

		assertFault(OnlyWebMethodOverride_04_01.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_04_02\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodOverride_04_02.m_04_01 = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_04_02\", \"m_04_01\", [arg0], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_04_02\");internal.remoteproxy.legal.OnlyWebMethodOverride_04_02.m_04_01=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_04_02\",\"m_04_01\",[a],b)};");
		assertResult(readable, minified, OnlyWebMethodOverride_04_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(1, metadata.getWebMethods().length);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethodOverride_04_02.m_04_01(int)", "m_04_01", metadata);
			}
		});

		assertFault(OnlyWebMethodOverride_04_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_04_04\");\n\n");
		readable.append("internal.remoteproxy.legal.OnlyWebMethodOverride_04_04.m_04_01 = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_04_04\", \"m_04_01\", [arg0], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_04_04\");internal.remoteproxy.legal.OnlyWebMethodOverride_04_04.m_04_01=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.OnlyWebMethodOverride_04_04\",\"m_04_01\",[a],b)};");
		assertResult(readable, minified, OnlyWebMethodOverride_04_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(1, metadata.getWebMethods().length);
				assertWebMethod("public static void internal.remoteproxy.legal.OnlyWebMethodOverride_04_04.m_04_01(int)", "m_04_01", metadata);
			}
		});

		assertFault(OnlyWebMethodOverride_05_01.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_05_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_05_02\");");
		assertResult(readable, minified, OnlyWebMethodOverride_05_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);
			}
		});

		assertFault(OnlyWebMethodOverride_05_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_05_04\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_05_04\");");
		assertResult(readable, minified, OnlyWebMethodOverride_05_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);
			}
		});

		assertFault(OnlyWebMethodOverride_06_01.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_06_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_06_02\");");
		assertResult(readable, minified, OnlyWebMethodOverride_06_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);
			}
		});

		assertFault(OnlyWebMethodOverride_06_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_06_04\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyWebMethodOverride_06_04\");");
		assertResult(readable, minified, OnlyWebMethodOverride_06_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);
			}
		});
	}

	@Test
	public void testOnlyExceptionHandler() throws Exception {
		StringBuffer readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandler_01_01\");");
		StringBuffer minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandler_01_01\");");
		assertResult(readable, minified, OnlyExceptionHandler_01_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandler_01_01.e_01_01(java.lang.ClassNotFoundException)", ClassNotFoundException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandler_01_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandler_01_02\");");
		assertResult(readable, minified, OnlyExceptionHandler_01_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandler_01_02.e_01_02_a(java.lang.ArithmeticException)", ArithmeticException.class, metadata);
				assertExceptionHandler(IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandler_01_02.e_01_02_c(java.lang.NoSuchMethodException) throws java.io.IOException", NoSuchMethodException.class, metadata);
				assertExceptionHandler("public java.lang.String internal.remoteproxy.legal.OnlyExceptionHandler_01_02.e_01_02_d(java.lang.ClassNotFoundException)", ClassNotFoundException.class, metadata);
				assertExceptionHandler("public boolean internal.remoteproxy.legal.OnlyExceptionHandler_01_02.e_01_02_e(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler(IOException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandler_02_01\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandler_02_01\");");
		assertResult(readable, minified, OnlyExceptionHandler_02_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandler_02_01.e_02_01(java.lang.ClassNotFoundException)", ClassNotFoundException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandler_02_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandler_02_02\");");
		assertResult(readable, minified, OnlyExceptionHandler_02_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandler_02_02.e_02_02_a(java.lang.ArithmeticException)", ArithmeticException.class, metadata);
				assertExceptionHandler(IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandler_02_02.e_02_02_c(java.lang.NoSuchMethodException) throws java.io.IOException", NoSuchMethodException.class, metadata);
				assertExceptionHandler("public static java.lang.String internal.remoteproxy.legal.OnlyExceptionHandler_02_02.e_02_02_d(java.lang.ClassNotFoundException)", ClassNotFoundException.class, metadata);
				assertExceptionHandler("public static boolean internal.remoteproxy.legal.OnlyExceptionHandler_02_02.e_02_02_e(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler(IOException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandler_03_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandler_03_02\");");
		assertResult(readable, minified, OnlyExceptionHandler_03_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandler_03_02.e_03_02_a(java.lang.ArithmeticException)", ArithmeticException.class, metadata);
				assertExceptionHandler(IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandler_03_02.e_03_02_c(java.lang.NoSuchMethodException) throws java.io.IOException", NoSuchMethodException.class, metadata);
				assertExceptionHandler("public java.lang.String internal.remoteproxy.legal.OnlyExceptionHandler_03_02.e_03_02_d(java.lang.ClassNotFoundException)", ClassNotFoundException.class, metadata);
				assertExceptionHandler("public static boolean internal.remoteproxy.legal.OnlyExceptionHandler_03_02.e_03_02_e(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler(IOException.class, metadata);
			}
		});
	}

	@Test
	public void testOnlyExceptionHandlerOverload() throws Exception {
		StringBuffer readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverload_01_01\");");
		StringBuffer minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverload_01_01\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverload_01_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverload_01_01.e_01_01(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
				assertExceptionHandler(SQLException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverload_01_01.e_01_01(java.io.IOException)", IOException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverload_01_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverload_01_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverload_01_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverload_01_02.e_01_02(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
				assertExceptionHandler(SQLException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverload_01_02.e_01_02(java.io.IOException)", IOException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverload_01_03\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverload_01_03\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverload_01_03.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverload_01_03.e_01_03(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
				assertExceptionHandler(SQLException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverload_01_03.e_01_03(java.io.IOException)", IOException.class, metadata);
			}
		});
	}

	@Test
	public void testOnlyExceptionHandlerExtend() throws Exception {
		StringBuffer readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_01\");");
		StringBuffer minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_01\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtend_01_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler(ArithmeticException.class, metadata);
				assertExceptionHandler("public int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_01.e_01_01_a(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_01.e_01_01_b(java.lang.NoSuchMethodException)", NoSuchMethodException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtend_01_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler(ArithmeticException.class, metadata);
				assertExceptionHandler("public int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_01.e_01_01_a(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_01.e_01_01_b(java.lang.NoSuchMethodException)", NoSuchMethodException.class, metadata);
				assertExceptionHandler("public java.lang.String internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_02.e_01_02_a(java.lang.ClassNotFoundException)", ClassNotFoundException.class, metadata);
				assertExceptionHandler(IllegalStateException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_03\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_03\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtend_01_03.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler(ArithmeticException.class, metadata);
				assertExceptionHandler("public int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_01.e_01_01_a(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_01.e_01_01_b(java.lang.NoSuchMethodException)", NoSuchMethodException.class, metadata);
				assertExceptionHandler("public java.lang.String internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_02.e_01_02_a(java.lang.ClassNotFoundException)", ClassNotFoundException.class, metadata);
				assertExceptionHandler(IllegalStateException.class, metadata);
				assertExceptionHandler("public java.lang.Object internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_03.e_01_03_a(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler(IOException.class, metadata);
				assertExceptionHandler("public int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_03.e_01_03_c(java.lang.InterruptedException)", InterruptedException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerExtend_01_04.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_05\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_05\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtend_01_05.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler(ArithmeticException.class, metadata);
				assertExceptionHandler("public int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_01.e_01_01_a(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_01.e_01_01_b(java.lang.NoSuchMethodException)", NoSuchMethodException.class, metadata);
				assertExceptionHandler("public java.lang.String internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_04.e_01_04_a(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_04.e_01_04_b(java.lang.IllegalAccessException)", IllegalAccessException.class, metadata);
				assertExceptionHandler(ClassCastException.class, metadata);
				assertExceptionHandler("public java.lang.Object internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_05.e_01_05_a(java.sql.SQLException)", SQLException.class, metadata);
				assertExceptionHandler(NoSuchElementException.class, metadata);
				assertExceptionHandler("public int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_01_05.e_01_05_c(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_01\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_01\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtend_02_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler(ArithmeticException.class, metadata);
				assertExceptionHandler("public static int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_01.e_02_01_a(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_01.e_02_01_b(java.lang.NoSuchMethodException)", NoSuchMethodException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtend_02_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler(ArithmeticException.class, metadata);
				assertExceptionHandler("public static int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_01.e_02_01_a(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_01.e_02_01_b(java.lang.NoSuchMethodException)", NoSuchMethodException.class, metadata);
				assertExceptionHandler("public static java.lang.String internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_02.e_02_02_a(java.lang.ClassNotFoundException)", ClassNotFoundException.class, metadata);
				assertExceptionHandler(IllegalStateException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_03\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_03\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtend_02_03.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler(ArithmeticException.class, metadata);
				assertExceptionHandler("public static int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_01.e_02_01_a(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_01.e_02_01_b(java.lang.NoSuchMethodException)", NoSuchMethodException.class, metadata);
				assertExceptionHandler("public static java.lang.String internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_02.e_02_02_a(java.lang.ClassNotFoundException)", ClassNotFoundException.class, metadata);
				assertExceptionHandler(IllegalStateException.class, metadata);
				assertExceptionHandler("public static java.lang.Object internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_03.e_02_03_a(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler(IOException.class, metadata);
				assertExceptionHandler("public static int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_03.e_02_03_c(java.lang.InterruptedException)", InterruptedException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerExtend_02_04.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_05\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_05\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtend_02_05.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler(ArithmeticException.class, metadata);
				assertExceptionHandler("public static int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_01.e_02_01_a(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_01.e_02_01_b(java.lang.NoSuchMethodException)", NoSuchMethodException.class, metadata);
				assertExceptionHandler("public static java.lang.String internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_04.e_02_04_a(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_04.e_02_04_b(java.lang.IllegalAccessException)", IllegalAccessException.class, metadata);
				assertExceptionHandler(ClassCastException.class, metadata);
				assertExceptionHandler("public static java.lang.Object internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_05.e_02_05_a(java.sql.SQLException)", SQLException.class, metadata);
				assertExceptionHandler(NoSuchElementException.class, metadata);
				assertExceptionHandler("public static int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_02_05.e_02_05_c(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_01\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_01\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtend_03_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler(ArithmeticException.class, metadata);
				assertExceptionHandler("public int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_01.e_03_01_a(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_01.e_03_01_b(java.lang.NoSuchMethodException)", NoSuchMethodException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtend_03_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler(ArithmeticException.class, metadata);
				assertExceptionHandler("public int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_01.e_03_01_a(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_01.e_03_01_b(java.lang.NoSuchMethodException)", NoSuchMethodException.class, metadata);
				assertExceptionHandler("public static java.lang.String internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_02.e_03_02_a(java.lang.ClassNotFoundException)", ClassNotFoundException.class, metadata);
				assertExceptionHandler(IllegalStateException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_03\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_03\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtend_03_03.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler(ArithmeticException.class, metadata);
				assertExceptionHandler("public int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_01.e_03_01_a(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_01.e_03_01_b(java.lang.NoSuchMethodException)", NoSuchMethodException.class, metadata);
				assertExceptionHandler("public static java.lang.String internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_02.e_03_02_a(java.lang.ClassNotFoundException)", ClassNotFoundException.class, metadata);
				assertExceptionHandler(IllegalStateException.class, metadata);
				assertExceptionHandler("public java.lang.Object internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_03.e_03_03_a(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler(IOException.class, metadata);
				assertExceptionHandler("public static int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_03.e_03_03_c(java.lang.InterruptedException)", InterruptedException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerExtend_03_04.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_05\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_05\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtend_03_05.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler(ArithmeticException.class, metadata);
				assertExceptionHandler("public int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_01.e_03_01_a(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_01.e_03_01_b(java.lang.NoSuchMethodException)", NoSuchMethodException.class, metadata);
				assertExceptionHandler("public static java.lang.String internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_04.e_03_04_a(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_04.e_03_04_b(java.lang.IllegalAccessException)", IllegalAccessException.class, metadata);
				assertExceptionHandler(ClassCastException.class, metadata);
				assertExceptionHandler("public java.lang.Object internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_05.e_03_05_a(java.sql.SQLException)", SQLException.class, metadata);
				assertExceptionHandler(NoSuchElementException.class, metadata);
				assertExceptionHandler("public static int internal.remoteproxy.legal.OnlyExceptionHandlerExtend_03_05.e_03_05_c(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
			}
		});
	}

	@Test
	public void testOnlyExceptionHandlerExtendOverload() throws Exception {
		StringBuffer readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_01_01\");");
		StringBuffer minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_01_01\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtendOverload_01_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_01_01.e_01_01(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_01_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_01_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtendOverload_01_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_01_01.e_01_01(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
				assertExceptionHandler(SQLException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_01_02.e_01_02(java.io.IOException)", IOException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerExtendOverload_01_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_01_04\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_01_04\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtendOverload_01_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_01_01.e_01_01(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
				assertExceptionHandler(SQLException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_01_04.e_01_04(java.io.IOException)", IOException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_02_01\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_02_01\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtendOverload_02_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_02_01.e_02_01(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_02_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_02_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtendOverload_02_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_02_01.e_02_01(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
				assertExceptionHandler(SQLException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_02_02.e_02_02(java.io.IOException)", IOException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerExtendOverload_02_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_02_04\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_02_04\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtendOverload_02_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_02_01.e_02_01(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
				assertExceptionHandler(SQLException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_02_04.e_02_04(java.io.IOException)", IOException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_03_01\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_03_01\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtendOverload_03_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_03_01.e_03_01(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_03_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_03_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtendOverload_03_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_03_01.e_03_01(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
				assertExceptionHandler(SQLException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_03_02.e_03_02(java.io.IOException)", IOException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerExtendOverload_03_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_03_04\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_03_04\");");
		assertResult(readable, minified, OnlyExceptionHandlerExtendOverload_03_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_03_01.e_03_01(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
				assertExceptionHandler(SQLException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerExtendOverload_03_04.e_03_04(java.io.IOException)", IOException.class, metadata);
			}
		});
	}

	@Test
	public void testOnlyExceptionHandlerOverride() throws Exception {
		assertFault(OnlyExceptionHandlerOverride_01_01.class);

		StringBuffer readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_01_02\");");
		StringBuffer minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_01_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverride_01_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverride_01_02.e_01_01(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerOverride_01_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_01_04\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_01_04\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverride_01_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverride_01_04.e_01_01(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerOverride_02_01.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_02_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_02_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverride_02_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverride_02_02.e_02_01(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerOverride_02_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_02_04\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_02_04\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverride_02_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverride_02_04.e_02_01(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerOverride_03_01.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_03_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_03_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverride_03_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverride_03_02.e_03_01(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerOverride_03_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_03_04\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_03_04\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverride_03_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverride_03_04.e_03_01(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerOverride_04_01.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_04_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_04_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverride_04_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverride_04_02.e_04_01(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerOverride_04_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_04_04\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_04_04\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverride_04_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverride_04_04.e_04_01(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerOverride_05_01.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_05_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_05_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverride_05_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);
			}
		});

		assertFault(OnlyExceptionHandlerOverride_05_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_05_04\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_05_04\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverride_05_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);
			}
		});

		assertFault(OnlyExceptionHandlerOverride_06_01.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_06_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_06_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverride_06_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);
			}
		});

		assertFault(OnlyExceptionHandlerOverride_06_03.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_06_04\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverride_06_04\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverride_06_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);
			}
		});
	}

	@Test
	public void testOnlyExceptionHandlerOverrideExtra() throws Exception {
		StringBuffer readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_01_01\");");
		StringBuffer minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_01_01\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverrideExtra_01_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_01_01.e_01_01_a(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_01_01.e_01_01_b(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(IOException.class, metadata);
				assertExceptionHandler(Exception.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_01_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_01_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverrideExtra_01_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_01_01.e_01_01_a(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_01_01.e_01_01_b(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_01_02.e_01_01_a(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_01_02.e_01_01_b(java.lang.Exception)", Exception.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_02_01\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_02_01\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverrideExtra_02_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_02_01.e_02_01_a(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_02_01.e_02_01_b(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(IOException.class, metadata);
				assertExceptionHandler(Exception.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_02_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_02_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverrideExtra_02_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_02_01.e_02_01_a(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_02_01.e_02_01_b(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_02_02.e_02_01_a(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_02_02.e_02_01_b(java.lang.Exception)", Exception.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_03_01\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_03_01\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverrideExtra_03_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_03_01.e_03_01_a(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_03_01.e_03_01_b(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(IOException.class, metadata);
				assertExceptionHandler(Exception.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_03_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_03_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverrideExtra_03_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_03_01.e_03_01_a(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_03_01.e_03_01_b(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_03_02.e_03_01_a(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_03_02.e_03_01_b(java.lang.Exception)", Exception.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_04_01\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_04_01\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverrideExtra_04_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_04_01.e_04_01_a(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_04_01.e_04_01_b(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler(IOException.class, metadata);
				assertExceptionHandler(Exception.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_04_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_04_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerOverrideExtra_04_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_04_01.e_04_01_a(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_04_01.e_04_01_b(java.lang.IllegalArgumentException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_04_02.e_04_01_a(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerOverrideExtra_04_02.e_04_01_b(java.lang.Exception)", Exception.class, metadata);
			}
		});
	}

	@Test
	public void testOnlyExceptionHandlerHierarchy() throws Exception {
		StringBuffer readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_01\");");
		StringBuffer minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_01\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_01_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_01.e_01_01_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_01.e_01_01_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_01.e_01_01_d(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_01.e_01_01_e(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_01.e_01_01_f(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_01.e_01_01_g(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_01.e_01_01_h(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_01.e_01_01_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_01.e_01_01_g(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_01.e_01_01_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_01_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", NotActiveException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_03\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_03\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_01_03.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_03.e_01_03_a(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_03.e_01_03_b(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_03.e_01_03_c(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_03.e_01_03_d(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_03.e_01_03_e(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_03.e_01_03_d(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_04\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_04\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_01_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", NotActiveException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerHierarchy_01_05.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_06\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_06\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_01_06.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_06.e_01_06_a(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_06.e_01_06_b(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_06.e_01_06_c(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_06.e_01_06_d(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_06.e_01_06_e(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_06.e_01_06_d(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_07\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_07\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_01_07.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_07.e_01_07_a(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_07.e_01_07_b(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_07.e_01_07_c(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_07.e_01_07_d(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_07.e_01_07_e(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_07.e_01_07_d(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_02.e_01_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_01_08.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", NotActiveException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_09\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_09\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_01_09.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_09.e_01_09_b(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_09.e_01_09_c(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_09.e_01_09_d(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_09.e_01_09_e(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_09.e_01_09_f(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_09.e_01_09_e(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_10\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_10\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_01_10.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", NotActiveException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerHierarchy_01_11.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_12\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_12\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_01_12.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_12.e_01_12_b(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_12.e_01_12_c(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_12.e_01_12_d(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_12.e_01_12_e(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_12.e_01_12_f(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_12.e_01_12_e(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_13\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_13\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_01_13.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_13.e_01_13_b(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_13.e_01_13_c(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_13.e_01_13_d(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_13.e_01_13_e(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_13.e_01_13_f(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_13.e_01_13_e(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_01_08.e_01_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_01\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_01\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_02_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_01.e_02_01_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_01.e_02_01_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_01.e_02_01_d(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_01.e_02_01_e(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_01.e_02_01_f(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_01.e_02_01_g(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_01.e_02_01_h(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_01.e_02_01_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_01.e_02_01_g(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_01.e_02_01_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_02_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_03\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_03\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_02_03.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_03.e_02_03_a(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_03.e_02_03_b(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_03.e_02_03_c(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_03.e_02_03_d(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_03.e_02_03_e(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_03.e_02_03_d(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_04\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_04\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_02_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerHierarchy_02_05.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_06\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_06\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_02_06.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_06.e_02_06_a(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_06.e_02_06_b(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_06.e_02_06_c(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_06.e_02_06_d(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_06.e_02_06_e(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_06.e_02_06_d(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_07\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_07\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_02_07.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_07.e_02_07_a(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_07.e_02_07_b(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_07.e_02_07_c(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_07.e_02_07_d(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_07.e_02_07_e(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_07.e_02_07_d(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_02.e_02_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_02_08.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_09\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_09\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_02_09.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_09.e_02_09_b(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_09.e_02_09_c(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_09.e_02_09_d(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_09.e_02_09_e(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_09.e_02_09_f(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_09.e_02_09_e(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_10\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_10\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_02_10.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerHierarchy_02_11.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_12\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_12\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_02_12.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_12.e_02_12_b(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_12.e_02_12_c(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_12.e_02_12_d(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_12.e_02_12_e(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_12.e_02_12_f(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_12.e_02_12_e(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_13\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_13\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_02_13.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_13.e_02_13_b(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_13.e_02_13_c(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_13.e_02_13_d(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_13.e_02_13_e(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_13.e_02_13_f(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_13.e_02_13_e(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_02_08.e_02_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_01\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_01\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_03_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_01.e_03_01_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_01.e_03_01_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_01.e_03_01_d(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_01.e_03_01_e(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_01.e_03_01_f(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_01.e_03_01_g(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_01.e_03_01_h(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_01.e_03_01_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_01.e_03_01_g(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_01.e_03_01_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_03_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_03\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_03\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_03_03.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_03.e_03_03_a(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_03.e_03_03_b(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_03.e_03_03_c(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_03.e_03_03_d(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_03.e_03_03_e(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_03.e_03_03_d(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_04\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_04\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_03_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerHierarchy_03_05.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_06\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_06\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_03_06.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_06.e_03_06_a(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_06.e_03_06_b(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_06.e_03_06_c(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_06.e_03_06_d(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_06.e_03_06_e(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_06.e_03_06_d(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_07\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_07\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_03_07.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_07.e_03_07_a(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_07.e_03_07_b(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_07.e_03_07_c(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_07.e_03_07_d(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_07.e_03_07_e(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_07.e_03_07_d(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_02.e_03_02_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_03_08.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_09\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_09\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_03_09.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_09.e_03_09_b(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_09.e_03_09_c(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_09.e_03_09_d(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_09.e_03_09_e(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_09.e_03_09_f(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_09.e_03_09_e(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_10\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_10\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_03_10.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", IOException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		assertFault(OnlyExceptionHandlerHierarchy_03_11.class);

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_12\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_12\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_03_12.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_12.e_03_12_b(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_12.e_03_12_c(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_12.e_03_12_d(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_12.e_03_12_e(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_12.e_03_12_f(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_12.e_03_12_e(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_13\");");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_13\");");
		assertResult(readable, minified, OnlyExceptionHandlerHierarchy_03_13.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", Exception.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_13.e_03_13_b(java.lang.IndexOutOfBoundsException)", IndexOutOfBoundsException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_13.e_03_13_c(java.lang.NumberFormatException)", NumberFormatException.class, metadata);
				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_13.e_03_13_d(java.io.FileNotFoundException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_13.e_03_13_e(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_13.e_03_13_f(java.lang.ArrayIndexOutOfBoundsException)", ArrayIndexOutOfBoundsException.class, metadata);

				assertExceptionHandler("public void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_a(java.lang.RuntimeException)", IllegalArgumentException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_13.e_03_13_e(java.io.IOException)", NotActiveException.class, metadata);
				assertExceptionHandler("public static void internal.remoteproxy.legal.OnlyExceptionHandlerHierarchy_03_08.e_03_08_b(java.lang.Exception)", SQLException.class, metadata);
			}
		});
	}

	@Test
	public void testEmptyRemoteProxy() throws Exception {
		StringBuffer readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.EmptyRemoteProxy\");");
		StringBuffer minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.EmptyRemoteProxy\");");
		assertResult(readable, minified, EmptyRemoteProxy.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(0, metadata.getWebMethods().length);
			}
		});
	}

	@Test
	public void testMixedWebMethodAndExceptionHandler() throws Exception {
		StringBuffer readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01\");\n\n");
		readable.append("internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01.m_01_a = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01\", \"m_01_a\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01.m_01_c = function(arg0, arg1, arg2, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01\", \"m_01_c\", [arg0, arg1, arg2], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01.m_01_d = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01\", \"m_01_d\", [], opts);\n");
		readable.append("};");
		StringBuffer minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01\");internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01.m_01_a=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01\",\"m_01_a\",[a],b)};internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01.m_01_c=function(c,b,a,d){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01\",\"m_01_c\",[c,b,a],d)};internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01.m_01_d=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01\",\"m_01_d\",[],a)};");
		assertResult(readable, minified, MixedWebMethodAndExceptionHandler_01.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(3, metadata.getWebMethods().length);
				assertWebMethod("e_01_a", metadata);
				assertWebMethod("e_01_b", metadata);
				assertWebMethod("public void internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01.m_01_a(int)", "m_01_a", metadata);
				assertWebMethod("m_01_b", metadata);
				assertWebMethod("public static int internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01.m_01_c(java.util.Map,char,java.lang.Object) throws java.lang.IllegalArgumentException", "m_01_c", metadata);
				assertWebMethod("public java.lang.Object internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01.m_01_d()", "m_01_d", metadata);
				assertWebMethod("m_01_e", metadata);

				assertExceptionHandler("public static int internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01.e_01_a(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public java.util.List internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01.e_01_b(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public static int internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01.e_01_a(java.io.IOException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public java.util.List internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01.e_01_b(java.lang.RuntimeException)", IllegalStateException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
				assertExceptionHandler(Exception.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02\");\n\n");
		readable.append("internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02.m_02_a = function(arg0, arg1, arg2, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02\", \"m_02_a\", [arg0, arg1, arg2], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02\");internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02.m_02_a=function(c,b,a,d){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02\",\"m_02_a\",[c,b,a],d)};");
		assertResult(readable, minified, MixedWebMethodAndExceptionHandler_02.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(1, metadata.getWebMethods().length);
				assertWebMethod("e_02_a", metadata);
				assertWebMethod("e_04_a", metadata);
				assertWebMethod("public static int internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02.m_02_a(java.util.Map,char,java.lang.Object) throws java.lang.IllegalArgumentException", "m_02_a", metadata);
				assertWebMethod("m_02_b", metadata);
				assertWebMethod("m_03_a", metadata);
				assertWebMethod("m_04_a", metadata);
				assertWebMethod("m_04_b", metadata);

				assertExceptionHandler(IOException.class, metadata);
				assertExceptionHandler("public java.util.List internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02.e_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler(FileNotFoundException.class, metadata);
				assertExceptionHandler("public java.util.List internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02.e_02_a(java.lang.RuntimeException)", IllegalStateException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
				assertExceptionHandler(Exception.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_03\");\n\n");
		readable.append("internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_03.m_02_a = function(arg0, arg1, arg2, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_03\", \"m_02_a\", [arg0, arg1, arg2], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_03.m_03_a = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_03\", \"m_03_a\", [arg0], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_03\");internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_03.m_02_a=function(c,b,a,d){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_03\",\"m_02_a\",[c,b,a],d)};internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_03.m_03_a=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_03\",\"m_03_a\",[a],b)};");
		assertResult(readable, minified, MixedWebMethodAndExceptionHandler_03.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(2, metadata.getWebMethods().length);
				assertWebMethod("e_02_a", metadata);
				assertWebMethod("e_04_a", metadata);
				assertWebMethod("public static int internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02.m_02_a(java.util.Map,char,java.lang.Object) throws java.lang.IllegalArgumentException", "m_02_a", metadata);
				assertWebMethod("m_02_b", metadata);
				assertWebMethod("public void internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_03.m_03_a(int)", "m_03_a", metadata);
				assertWebMethod("m_04_a", metadata);
				assertWebMethod("m_04_b", metadata);

				assertExceptionHandler(IOException.class, metadata);
				assertExceptionHandler("public java.util.List internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02.e_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler(FileNotFoundException.class, metadata);
				assertExceptionHandler("public java.util.List internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02.e_02_a(java.lang.RuntimeException)", IllegalStateException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
				assertExceptionHandler(Exception.class, metadata);
			}
		});

		readable = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04\");\n\n");
		readable.append("internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04.m_02_a = function(arg0, arg1, arg2, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04\", \"m_02_a\", [arg0, arg1, arg2], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04.m_03_a = function(arg0, opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04\", \"m_03_a\", [arg0], opts);\n");
		readable.append("};\n\n");
		readable.append("internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04.m_04_a = function(opts) {\n\t");
		readable.append("return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04\", \"m_04_a\", [], opts);\n");
		readable.append("};");
		minified = new StringBuffer("xeno.remoting.web.Engine.registerClass(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04\");internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04.m_02_a=function(c,b,a,d){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04\",\"m_02_a\",[c,b,a],d)};internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04.m_03_a=function(a,b){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04\",\"m_03_a\",[a],b)};internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04.m_04_a=function(a){return xeno.remoting.web.Engine.processRemoteCall(\"internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04\",\"m_04_a\",[],a)};");
		assertResult(readable, minified, MixedWebMethodAndExceptionHandler_04.class, new Spec() {

			@Override
			public void run(RemoteProxyMetadata metadata) throws Exception {
				Assert.assertEquals(3, metadata.getWebMethods().length);
				assertWebMethod("e_02_a", metadata);
				assertWebMethod("e_04_a", metadata);
				assertWebMethod("public static int internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02.m_02_a(java.util.Map,char,java.lang.Object) throws java.lang.IllegalArgumentException", "m_02_a", metadata);
				assertWebMethod("m_02_b", metadata);
				assertWebMethod("public void internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_03.m_03_a(int)", "m_03_a", metadata);
				assertWebMethod("public java.lang.Object internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04.m_04_a()", "m_04_a", metadata);
				assertWebMethod("m_04_b", metadata);

				assertExceptionHandler("public java.util.List internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04.e_04_a(java.io.IOException)", IOException.class, metadata);
				assertExceptionHandler("public java.util.List internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02.e_02_a(java.lang.RuntimeException)", RuntimeException.class, metadata);
				assertExceptionHandler("public java.util.List internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_04.e_04_a(java.io.IOException)", FileNotFoundException.class, metadata);
				assertExceptionHandler("public java.util.List internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_02.e_02_a(java.lang.RuntimeException)", IllegalStateException.class, metadata);
				assertExceptionHandler(ClassNotFoundException.class, metadata);
				assertExceptionHandler(Exception.class, metadata);
			}
		});
	}

	private interface Spec {
		public void run(RemoteProxyMetadata metadata) throws Exception;
	}

	private void assertResult(StringBuffer readable, StringBuffer minified, Class clazz, Spec spec) throws Exception {
		RemoteProxyMetadata metadata = new RemoteProxyMetadata(clazz, false);
		Assert.assertEquals(clazz.getName(), metadata.getTargetClass().getName());
		Assert.assertEquals(clazz, metadata.getTargetClass());
		Assert.assertNull(metadata.getWebMethod(null));
		Assert.assertNull(metadata.getExceptionHandler(null));
		Assert.assertNull(metadata.getExceptionHandler((Object) null));
		Assert.assertEquals(readable.toString(), metadata.getJavaScriptContent());
		spec.run(metadata);

		metadata = new RemoteProxyMetadata(clazz, true);
		Assert.assertEquals(clazz.getName(), metadata.getTargetClass().getName());
		Assert.assertEquals(clazz, metadata.getTargetClass());
		Assert.assertNull(metadata.getWebMethod(null));
		Assert.assertNull(metadata.getExceptionHandler(null));
		Assert.assertNull(metadata.getExceptionHandler((Object) null));
		Assert.assertEquals(minified.toString(), metadata.getJavaScriptContent());
		spec.run(metadata);
	}

	private void assertFault(Class clazz) throws Exception {

		try {
			new RemoteProxyMetadata(clazz, false);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}

		try {
			new RemoteProxyMetadata(clazz, true);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'clazz' is not a remote proxy", ex.getMessage());
		}
	}

	private void assertWebMethod(String name, RemoteProxyMetadata metadata) throws Exception {
		Assert.assertNull(metadata.getWebMethod(name));
	}

	private void assertWebMethod(String signature, String name, RemoteProxyMetadata metadata) throws Exception {
		Assert.assertEquals(signature, metadata.getWebMethod(name).toGenericString());
	}

	private void assertExceptionHandler(Class clazz, RemoteProxyMetadata metadata) throws Exception {
		Assert.assertNull(metadata.getExceptionHandler(clazz));
		Assert.assertNull(metadata.getExceptionHandler(clazz.newInstance()));
	}

	private void assertExceptionHandler(String signature, Class clazz, RemoteProxyMetadata metadata) throws Exception {
		Assert.assertEquals(signature, metadata.getExceptionHandler(clazz).toGenericString());
		Assert.assertEquals(signature, metadata.getExceptionHandler(clazz.newInstance()).toGenericString());
	}
}
