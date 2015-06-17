package xeno.remoting.web;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("rawtypes")
public class RemoteProxyUtils_extractFromJars_Test {

	@Test
	public void testAbnormal() throws IOException, ClassNotFoundException {

		try {
			RemoteProxyUtils.extractFromJars(null, null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'directory' is null", ex.getMessage());
		}

		try {
			RemoteProxyUtils.extractFromJars(null, new ArrayList<String>());
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'directory' is null", ex.getMessage());
		}

		Assert.assertEquals(0, RemoteProxyUtils.extractFromJars(new File("C:\\" + UUID.randomUUID().toString()), null).size());
		Assert.assertEquals(0, RemoteProxyUtils.extractFromJars(new File("C:\\" + UUID.randomUUID().toString()), new ArrayList<String>()).size());
		Assert.assertEquals(0, RemoteProxyUtils.extractFromJars(new File("C:\\" + UUID.randomUUID().toString() + ".txt"), null).size());
		Assert.assertEquals(0, RemoteProxyUtils.extractFromJars(new File("C:\\" + UUID.randomUUID().toString() + ".txt"), new ArrayList<String>()).size());
	}

	@Test
	public void testNormal1() throws ClassNotFoundException, IOException, URISyntaxException {
		File base = new File(Thread.currentThread().getClass().getResource("/").toURI());
		File dir = new File(base, "libs");

		List<String> excludes = new ArrayList<String>();
		excludes.add("internal.*");

		Set<Class> classes = RemoteProxyUtils.extractFromJars(dir, excludes);
		Set<String> names = new HashSet<String>();

		for (Class clazz : classes) {
			names.add(clazz.getName());
		}

		Assert.assertEquals(684, names.size());

		// external.remoteproxy.handler.*
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.handler.instance.*
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.handler.network.*
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.*
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.instance.*
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.network.*
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_12"));
	}

	@Test
	public void testNormal2() throws ClassNotFoundException, IOException, URISyntaxException {
		File base = new File(Thread.currentThread().getClass().getResource("/").toURI());
		File dir = new File(base, "libs");
		Assert.assertTrue(dir.exists() && dir.isDirectory());

		List<String> excludes = new ArrayList<String>();
		excludes.add("internal.*");
		excludes.add("external.remoteproxy.*");

		Set<Class> classes = RemoteProxyUtils.extractFromJars(dir, excludes);
		Assert.assertEquals(0, classes.size());
	}

	@Test
	public void testNormal3() throws ClassNotFoundException, IOException, URISyntaxException {
		File base = new File(Thread.currentThread().getClass().getResource("/").toURI());
		File dir = new File(base, "libs");
		Assert.assertTrue(dir.exists() && dir.isDirectory());

		List<String> excludes = new ArrayList<String>();
		excludes.add("internal.*");
		excludes.add("external.remoteproxy.handler.instance.*");
		excludes.add("external.remoteproxy.service.network.*");

		Set<Class> classes = RemoteProxyUtils.extractFromJars(dir, excludes);
		Set<String> names = new HashSet<String>();

		for (Class clazz : classes) {
			names.add(clazz.getName());
		}

		Assert.assertEquals(456, names.size());

		// external.remoteproxy.handler.*
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.handler.instance.*
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.handler.network.*
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.*
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.instance.*
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.network.*
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_01_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_01_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_01_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_01_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_01_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_12"));
	}

	@Test
	public void testNormal4() throws ClassNotFoundException, IOException, URISyntaxException {
		File base = new File(Thread.currentThread().getClass().getResource("/").toURI());
		File dir = new File(base, "libs");
		Assert.assertTrue(dir.exists() && dir.isDirectory());

		List<String> excludes = new ArrayList<String>();
		excludes.add("internal.*");
		excludes.add("external.remote.proxy.*");

		Set<Class> classes = RemoteProxyUtils.extractFromJars(dir, excludes);
		Set<String> names = new HashSet<String>();

		for (Class clazz : classes) {
			names.add(clazz.getName());
		}

		Assert.assertEquals(684, names.size());

		// external.remoteproxy.handler.*
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.handler.instance.*
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.handler.network.*
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.*
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.instance.*
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.network.*
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_12"));
	}

	@Test
	public void testNormal5() throws ClassNotFoundException, IOException, URISyntaxException {
		File base = new File(Thread.currentThread().getClass().getResource("/").toURI());
		File dir = new File(base, "libs");
		Assert.assertTrue(dir.exists() && dir.isDirectory());

		List<String> excludes = new ArrayList<String>();
		excludes.add("internal.*");
		excludes.add("external.remoteproxy.handler.RemoteProxy_01_02");
		excludes.add("external.remoteproxy.service.network.RemoteProxy_01_04");

		Set<Class> classes = RemoteProxyUtils.extractFromJars(dir, excludes);
		Set<String> names = new HashSet<String>();

		for (Class clazz : classes) {
			names.add(clazz.getName());
		}

		Assert.assertEquals(682, names.size());

		// external.remoteproxy.handler.*
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.handler.instance.*
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.handler.network.*
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.*
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.instance.*
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.network.*
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_12"));
	}

	@Test
	public void testNormal6() throws ClassNotFoundException, IOException, URISyntaxException {
		File base = new File(Thread.currentThread().getClass().getResource("/").toURI());
		File dir = new File(base, "deps");

		List<String> excludes = new ArrayList<String>();
		excludes.add("internal.*");

		Set<Class> classes = RemoteProxyUtils.extractFromJars(dir, excludes);
		Set<String> names = new HashSet<String>();

		for (Class clazz : classes) {
			names.add(clazz.getName());
		}

		Assert.assertEquals(342, names.size());

		// external.remoteproxy.handler.*
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_01_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_01_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_01_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_01_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_01_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_02_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.handler.instance.*
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.handler.instance.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.instance.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.handler.network.*
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_02_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.handler.network.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.*
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.instance.*
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_02_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.instance.RemoteProxy_05_04$InnerRemoteProxy_12"));

		// external.remoteproxy.service.network.*
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_01_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_02_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_06"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_04_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_05_06"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_03_04$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_01$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_02$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_03$InnerRemoteProxy_12"));

		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_01"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_02"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_03"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_04"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_05"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_06"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_07"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_08"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_09"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_10"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_11"));
		Assert.assertTrue(names.contains("external.remoteproxy.service.network.RemoteProxy_04_04$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_01$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_02$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_03$InnerRemoteProxy_12"));

		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_01"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_02"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_03"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_04"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_05"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_06"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_07"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_08"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_09"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_10"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_11"));
		Assert.assertFalse(names.contains("external.remoteproxy.service.network.RemoteProxy_05_04$InnerRemoteProxy_12"));
	}
}
