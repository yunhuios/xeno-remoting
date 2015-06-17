package xeno.remoting.web;

import internal.remoteproxy.legal.EmptyRemoteProxy;
import internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01;
import internal.remoteproxy.legal.OnlyExceptionHandler_01_02;
import internal.remoteproxy.legal.OnlyWebMethod_01_02;

import org.junit.Assert;
import org.junit.Test;

public class RemoteProxyMetadata_toString_Test {

	@Test
	public void testIt() throws Exception {
		Assert.assertEquals("[name=internal.remoteproxy.legal.EmptyRemoteProxy,targetClass=internal.remoteproxy.legal.EmptyRemoteProxy,webMethods=0,exceptionHandlers=0]", new RemoteProxyMetadata(EmptyRemoteProxy.class, false).toString());
		Assert.assertEquals("[name=internal.remoteproxy.legal.EmptyRemoteProxy,targetClass=internal.remoteproxy.legal.EmptyRemoteProxy,webMethods=0,exceptionHandlers=0]", new RemoteProxyMetadata(EmptyRemoteProxy.class, true).toString());
		Assert.assertEquals("[name=internal.remoteproxy.legal.OnlyWebMethod_01_02,targetClass=internal.remoteproxy.legal.OnlyWebMethod_01_02,webMethods=4,exceptionHandlers=0]", new RemoteProxyMetadata(OnlyWebMethod_01_02.class, false).toString());
		Assert.assertEquals("[name=internal.remoteproxy.legal.OnlyWebMethod_01_02,targetClass=internal.remoteproxy.legal.OnlyWebMethod_01_02,webMethods=4,exceptionHandlers=0]", new RemoteProxyMetadata(OnlyWebMethod_01_02.class, true).toString());
		Assert.assertEquals("[name=internal.remoteproxy.legal.OnlyExceptionHandler_01_02,targetClass=internal.remoteproxy.legal.OnlyExceptionHandler_01_02,webMethods=0,exceptionHandlers=4]", new RemoteProxyMetadata(OnlyExceptionHandler_01_02.class, false).toString());
		Assert.assertEquals("[name=internal.remoteproxy.legal.OnlyExceptionHandler_01_02,targetClass=internal.remoteproxy.legal.OnlyExceptionHandler_01_02,webMethods=0,exceptionHandlers=4]", new RemoteProxyMetadata(OnlyExceptionHandler_01_02.class, true).toString());
		Assert.assertEquals("[name=internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01,targetClass=internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01,webMethods=3,exceptionHandlers=2]", new RemoteProxyMetadata(MixedWebMethodAndExceptionHandler_01.class, false).toString());
		Assert.assertEquals("[name=internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01,targetClass=internal.remoteproxy.legal.MixedWebMethodAndExceptionHandler_01,webMethods=3,exceptionHandlers=2]", new RemoteProxyMetadata(MixedWebMethodAndExceptionHandler_01.class, true).toString());
	}
}
