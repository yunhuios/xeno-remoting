package xeno.remoting.web;

import internal.remoteproxy.legal.EmptyRemoteProxy;
import internal.remoteproxy.legal.OnlyWebMethod_01_01;
import internal.remoteproxy.legal.OnlyWebMethod_01_02;

import org.junit.Assert;
import org.junit.Test;

public class RemoteProxyMetadata_equals_Test {

	@Test
	public void testDifferentTypes1() throws Exception {
		RemoteProxyMetadata o1 = new RemoteProxyMetadata(EmptyRemoteProxy.class, false);
		Object o2 = null;
		Assert.assertFalse(o1.equals(o2));
	}

	@Test
	public void testDifferentTypes2() throws Exception {
		RemoteProxyMetadata o1 = new RemoteProxyMetadata(EmptyRemoteProxy.class, false);
		Object o2 = new Object();
		Assert.assertFalse(o1.equals(o2));
	}

	@Test
	public void testSameObject() throws Exception {
		RemoteProxyMetadata o1 = new RemoteProxyMetadata(EmptyRemoteProxy.class, false);
		RemoteProxyMetadata o2 = o1;
		Assert.assertTrue(o1.equals(o2));
		Assert.assertTrue(o1.hashCode() == o2.hashCode());
	}

	@Test
	public void testSameType1() throws Exception {
		RemoteProxyMetadata o1 = new RemoteProxyMetadata(EmptyRemoteProxy.class, false);
		RemoteProxyMetadata o2 = new RemoteProxyMetadata(EmptyRemoteProxy.class, false);
		Assert.assertTrue(o1.equals(o2));
		Assert.assertTrue(o1.hashCode() == o2.hashCode());
	}

	@Test
	public void testSameType2() throws Exception {
		RemoteProxyMetadata o1 = new RemoteProxyMetadata(EmptyRemoteProxy.class, false);
		RemoteProxyMetadata o2 = new RemoteProxyMetadata(EmptyRemoteProxy.class, true);
		Assert.assertTrue(o1.equals(o2));
		Assert.assertTrue(o1.hashCode() == o2.hashCode());
	}

	@Test
	public void testSameType3() throws Exception {
		RemoteProxyMetadata o1 = new RemoteProxyMetadata(OnlyWebMethod_01_01.class, false);
		RemoteProxyMetadata o2 = new RemoteProxyMetadata(OnlyWebMethod_01_02.class, false);
		Assert.assertFalse(o1.equals(o2));
	}
}
