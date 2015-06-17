package xeno.remoting.web;

import internal.remoteproxy.legal.EmptyRemoteProxy;

import java.text.ParseException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("serial")
public class RemoteProxyJspTag_parseContent_Test extends ProxyJspTag {

	@Before
	public void beforeTest() throws Exception {
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(EmptyRemoteProxy.class, false));

		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.MockClass_04.class, false));

		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.MockClass_04.class, false));

		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.MockClass_04.class, false));

		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0101.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0101.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0101.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0102.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0102.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0102.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0103.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0103.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0103.MockClass_04.class, false));

		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0201.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0201.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0201.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0202.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0202.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0202.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0203.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0203.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0203.MockClass_04.class, false));

		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0301.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0301.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0301.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0302.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0302.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0302.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0303.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0303.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0303.MockClass_04.class, false));

		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0101.cat010101.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0101.cat010101.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0101.cat010101.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0101.cat010102.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0101.cat010102.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0101.cat010102.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0102.cat010201.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0102.cat010201.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0102.cat010201.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0102.cat010202.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0102.cat010202.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0102.cat010202.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0103.cat010301.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0103.cat010301.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0103.cat010301.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0103.cat010302.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0103.cat010302.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat01.cat0103.cat010302.MockClass_04.class, false));

		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0201.cat020101.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0201.cat020101.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0201.cat020101.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0201.cat020102.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0201.cat020102.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0201.cat020102.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0202.cat020201.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0202.cat020201.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0202.cat020201.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0202.cat020202.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0202.cat020202.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0202.cat020202.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0203.cat020301.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0203.cat020301.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0203.cat020301.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0203.cat020302.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0203.cat020302.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat02.cat0203.cat020302.MockClass_04.class, false));

		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0301.cat030101.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0301.cat030101.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0301.cat030101.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0301.cat030102.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0301.cat030102.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0301.cat030102.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0302.cat030201.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0302.cat030201.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0302.cat030201.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0302.cat030202.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0302.cat030202.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0302.cat030202.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0303.cat030301.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0303.cat030301.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0303.cat030301.MockClass_04.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0303.cat030302.MockClass_01.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0303.cat030302.MockClass_03.class, false));
		MessageServlet.registerRemoteProxyMetadata(new RemoteProxyMetadata(internal.remoteproxy.legal.cat03.cat0303.cat030302.MockClass_04.class, false));
	}

	@After
	public void afterTest() {
		MessageServlet.unregisterAllRemoteProxyMetadata();
	}

	@Test
	public void testNull() throws Exception {

		try {
			parseContent(null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'content' is null", ex.getMessage());
		}
	}

	@Test
	public void testEmpty() throws Exception {
		Assert.assertEquals(0, parseContent("").size());
	}

	@Test
	public void testBlank() throws Exception {
		Assert.assertEquals(0, parseContent(" ").size());
	}

	@Test
	public void testSyntaxError() throws ClassNotFoundException {

		try {
			parseContent("a");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Syntax error on token: a", ex.getMessage());
		}

		try {
			parseContent("a;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Syntax error on token: a;", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Syntax error on token: import internal.remoteproxy.legal.EmptyRemoteProxy", ex.getMessage());
		}

		try {
			parseContent("importa");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Syntax error on token: importa", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nb");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Syntax error on token: b", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nb;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Syntax error on token: b;", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimport b");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Syntax error on token: import b", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimportb");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Syntax error on token: importb", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;c");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Syntax error on token: c", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;c;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Syntax error on token: c;", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;import c");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Syntax error on token: import c", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;importc");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Syntax error on token: importc", ex.getMessage());
		}
	}

	@Test
	public void testInvalidPackageName() throws ClassNotFoundException {

		try {
			parseContent("import 2com.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: 2com.*", ex.getMessage());
		}

		try {
			parseContent("import com.2since10.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: com.2since10.*", ex.getMessage());
		}

		try {
			parseContent("import com.2since10.service.UserService.test.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: com.2since10.service.UserService.test.*", ex.getMessage());
		}

		try {
			parseContent("import com.since10.service..UserService.test.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: com.since10.service..UserService.test.*", ex.getMessage());
		}

		try {
			parseContent("import com.since10.service.UserService.test.*.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: com.since10.service.UserService.test.*.*", ex.getMessage());
		}

		try {
			parseContent("import .com.since10.service.UserService.test.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: .com.since10.service.UserService.test.*", ex.getMessage());
		}

		try {
			parseContent("import com.since10.*.UserService.test.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: com.since10.*.UserService.test.*", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimport 3com.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: 3com.*", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimport com.2since11.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: com.2since11.*", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimport com.2since11.service.UserService.test.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: com.2since11.service.UserService.test.*", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimport com.since11.service..UserService.test.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: com.since11.service..UserService.test.*", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimport .com.since11.service.UserService.test.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: .com.since11.service.UserService.test.*", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimport com.since11.*.UserService.test.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: com.since11.*.UserService.test.*", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;import 4com.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: 4com.*", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;import com.2since12.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: com.2since12.*", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;import com.2since12.service.UserService.test.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: com.2since12.service.UserService.test.*", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;import com.since12.service..UserService.test.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: com.since12.service..UserService.test.*", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;import .com.since12.service.UserService.test.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: .com.since12.service.UserService.test.*", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;import com.since12.*.UserService.test.*;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: com.since12.*.UserService.test.*", ex.getMessage());
		}
	}

	@Test
	public void testInvalidClassName() throws ClassNotFoundException {

		try {
			parseContent("import *;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: *", ex.getMessage());
		}

		try {
			parseContent("import 2com;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: 2com", ex.getMessage());
		}

		try {
			parseContent("import com.2since10;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.2since10", ex.getMessage());
		}

		try {
			parseContent("import com.2since10.service.UserService.test;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.2since10.service.UserService.test", ex.getMessage());
		}

		try {
			parseContent("import com.since10.service..UserService.test;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.since10.service..UserService.test", ex.getMessage());
		}

		try {
			parseContent("import .com.since10.service.UserService.test;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: .com.since10.service.UserService.test", ex.getMessage());
		}

		try {
			parseContent("import com.since10.service.UserService.test.;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.since10.service.UserService.test.", ex.getMessage());
		}

		try {
			parseContent("import com.since10.*.UserService.test;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.since10.*.UserService.test", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimport 3com;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: 3com", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimport com.2since11;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.2since11", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimport com.2since11.service.UserService.test;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.2since11.service.UserService.test", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimport com.since11.service..UserService.test;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.since11.service..UserService.test", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimport .com.since11.service.UserService.test;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: .com.since11.service.UserService.test", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimport com.since11.service.UserService.test.;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.since11.service.UserService.test.", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;\nimport com.since11.*.UserService.test;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.since11.*.UserService.test", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;import 4com;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: 4com", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;import com.2since12;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.2since12", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;import com.2since12.service.UserService.test;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.2since12.service.UserService.test", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;import com.since12.service..UserService.test;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.since12.service..UserService.test", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;import .com.since12.service.UserService.test;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: .com.since12.service.UserService.test", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;import com.since12.service.UserService.test.;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.since12.service.UserService.test.", ex.getMessage());
		}

		try {
			parseContent("import internal.remoteproxy.legal.EmptyRemoteProxy;import com.since12.*.UserService.test;");
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: com.since12.*.UserService.test", ex.getMessage());
		}
	}

	public void testSingle() throws Exception {
		StringBuffer content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.EmptyRemoteProxy;");

		List<KeyValue<Integer, RemoteProxyMetadata>> results = parseContent(content.toString());
		Assert.assertEquals(1, results.size());
		Assert.assertEquals(EmptyRemoteProxy.class, results.get(0).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.EmptyRemoteProxy;\n");
		content.append("import internal.remoteproxy.legal.EmptyRemoteProxy;");

		results = parseContent(content.toString());
		Assert.assertEquals(1, results.size());
		Assert.assertEquals(EmptyRemoteProxy.class, results.get(0).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.EmptyRemoteProxy;");
		content.append("import internal.remoteproxy.legal.EmptyRemoteProxy;");

		results = parseContent(content.toString());
		Assert.assertEquals(1, results.size());
		Assert.assertEquals(EmptyRemoteProxy.class, results.get(0).getValue().getTargetClass());
	}

	@Test
	public void testDuplicated() throws Exception {
		StringBuffer content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat02.MockClass_01;");
		content.append("import internal.remoteproxy.legal.cat02.*;");
		content.append("import internal.remoteproxy.legal.cat01.cat0102.MockClass_03;");
		content.append("import internal.remoteproxy.legal.cat03.cat0302.*;");
		content.append("import internal.remoteproxy.legal.cat03.cat0302.MockClass_04;");
		content.append("import internal.remoteproxy.legal.cat01.cat0102.MockClass_03;");

		List<KeyValue<Integer, RemoteProxyMetadata>> results = parseContent(content.toString());
		Assert.assertEquals(7, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.cat0102.MockClass_03.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_01.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_03.class, results.get(2).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_04.class, results.get(3).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat03.cat0302.MockClass_01.class, results.get(4).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat03.cat0302.MockClass_03.class, results.get(5).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat03.cat0302.MockClass_04.class, results.get(6).getValue().getTargetClass());
	}

	@Test
	public void testPackageDoesNotExist() throws Exception {
		StringBuffer content = new StringBuffer();
		content.append("import internal.remoteproxy.legal2.*;");

		try {
			parseContent(content.toString());
			Assert.fail();

		} catch (ClassNotFoundException ex) {
			Assert.assertEquals("No remote proxy metadata found for the package: internal.remoteproxy.legal2", ex.getMessage());
		}

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.*;\n");
		content.append("import internal.remoteproxy.legal3.*;");

		try {
			parseContent(content.toString());
			Assert.fail();

		} catch (ClassNotFoundException ex) {
			Assert.assertEquals("No remote proxy metadata found for the package: internal.remoteproxy.legal3", ex.getMessage());
		}

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.*;");
		content.append("import internal.remoteproxy.legal4.*;");

		try {
			parseContent(content.toString());
			Assert.fail();

		} catch (ClassNotFoundException ex) {
			Assert.assertEquals("No remote proxy metadata found for the package: internal.remoteproxy.legal4", ex.getMessage());
		}
	}

	@Test
	public void testClassDoesNotExist() throws Exception {
		StringBuffer content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.EmptyRemoteProxy2;");

		try {
			parseContent(content.toString());
			Assert.fail();

		} catch (ClassNotFoundException ex) {
			Assert.assertEquals("No remote proxy metadata found for the class: internal.remoteproxy.legal.EmptyRemoteProxy2", ex.getMessage());
		}

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.EmptyRemoteProxy;\n");
		content.append("import internal.remoteproxy.legal.EmptyRemoteProxy3;");

		try {
			parseContent(content.toString());
			Assert.fail();

		} catch (ClassNotFoundException ex) {
			Assert.assertEquals("No remote proxy metadata found for the class: internal.remoteproxy.legal.EmptyRemoteProxy3", ex.getMessage());
		}

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.EmptyRemoteProxy;");
		content.append("import internal.remoteproxy.legal.EmptyRemoteProxy4;");

		try {
			parseContent(content.toString());
			Assert.fail();

		} catch (ClassNotFoundException ex) {
			Assert.assertEquals("No remote proxy metadata found for the class: internal.remoteproxy.legal.EmptyRemoteProxy4", ex.getMessage());
		}
	}

	@Test
	public void testLineCommentsForPackage() throws Exception {
		StringBuffer content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.*;\n");
		content.append("import internal.remoteproxy.legal.cat02.*;\n");
		content.append("import internal.remoteproxy.legal.cat03.*;\n");

		List<KeyValue<Integer, RemoteProxyMetadata>> results = parseContent(content.toString());
		Assert.assertEquals(9, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_04.class, results.get(2).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_01.class, results.get(3).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_03.class, results.get(4).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_04.class, results.get(5).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat03.MockClass_01.class, results.get(6).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat03.MockClass_03.class, results.get(7).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat03.MockClass_04.class, results.get(8).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.*;\n");
		content.append("//import internal.remoteproxy.legal.cat02.*;\n");
		content.append("import internal.remoteproxy.legal.cat03.*;\n");

		results = parseContent(content.toString());
		Assert.assertEquals(6, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_04.class, results.get(2).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat03.MockClass_01.class, results.get(3).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat03.MockClass_03.class, results.get(4).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat03.MockClass_04.class, results.get(5).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.*;");
		content.append("//import internal.remoteproxy.legal.cat02.*;\n");
		content.append("import internal.remoteproxy.legal.cat03.*;\n");

		results = parseContent(content.toString());
		Assert.assertEquals(6, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_04.class, results.get(2).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat03.MockClass_01.class, results.get(3).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat03.MockClass_03.class, results.get(4).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat03.MockClass_04.class, results.get(5).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.*;");
		content.append("//import internal.remoteproxy.legal.cat02.*;");
		content.append("import internal.remoteproxy.legal.cat03.*;\n");

		results = parseContent(content.toString());
		Assert.assertEquals(3, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_04.class, results.get(2).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.*;");
		content.append("import internal.remoteproxy.legal.cat02.*;");
		content.append("//import internal.remoteproxy.legal.cat03.*;");

		results = parseContent(content.toString());
		Assert.assertEquals(6, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_04.class, results.get(2).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_01.class, results.get(3).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_03.class, results.get(4).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_04.class, results.get(5).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.*;");
		content.append("import internal.remoteproxy.legal.cat02.*; ");
		content.append("//import internal.remoteproxy.legal.cat03.*;");

		results = parseContent(content.toString());
		Assert.assertEquals(6, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_04.class, results.get(2).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_01.class, results.get(3).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_03.class, results.get(4).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_04.class, results.get(5).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.*;");
		content.append("import internal.remoteproxy.legal.cat02.*;");
		content.append("//import internal.remoteproxy.legal.cat03.*;");
		content.append("//import internal.remoteproxy.legal.cat01.cat0101.*;");
		content.append("//import internal.remoteproxy.legal.cat01.cat0102.*;");
		content.append("//import internal.remoteproxy.legal.cat01.cat0103.*;");

		results = parseContent(content.toString());
		Assert.assertEquals(6, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_04.class, results.get(2).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_01.class, results.get(3).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_03.class, results.get(4).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_04.class, results.get(5).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.*;");
		content.append("import internal.remoteproxy.legal.cat02.*;");
		content.append("//import internal.remoteproxy.legal.cat03.*;");
		content.append("import internal.remoteproxy.legal.cat01.cat0101.*;");
		content.append("import internal.remoteproxy.legal.cat01.cat0102.*;");
		content.append("import internal.remoteproxy.legal.cat01.cat0103.*;");

		results = parseContent(content.toString());
		Assert.assertEquals(6, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_04.class, results.get(2).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_01.class, results.get(3).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_03.class, results.get(4).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_04.class, results.get(5).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.*;");
		content.append("import internal.remoteproxy.legal.cat02.*;");
		content.append("//import internal.remoteproxy.legal.cat03.*;\n");
		content.append("import internal.remoteproxy.legal.cat01.cat0101.*;");
		content.append("import internal.remoteproxy.legal.cat01.cat0102.*;");
		content.append("import internal.remoteproxy.legal.cat01.cat0103.*;");

		results = parseContent(content.toString());
		Assert.assertEquals(15, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_04.class, results.get(2).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.cat0101.MockClass_01.class, results.get(3).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.cat0101.MockClass_03.class, results.get(4).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.cat0101.MockClass_04.class, results.get(5).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.cat0102.MockClass_01.class, results.get(6).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.cat0102.MockClass_03.class, results.get(7).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.cat0102.MockClass_04.class, results.get(8).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.cat0103.MockClass_01.class, results.get(9).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.cat0103.MockClass_03.class, results.get(10).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.cat0103.MockClass_04.class, results.get(11).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_01.class, results.get(12).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_03.class, results.get(13).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_04.class, results.get(14).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.*;");
		content.append("import internal.remoteproxy.legal-cat02.*;");

		try {
			parseContent(content.toString());
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid package name on token: internal.remoteproxy.legal-cat02.*", ex.getMessage());
		}

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.*;");
		content.append("//import internal.remoteproxy.legal-cat02.*;");

		results = parseContent(content.toString());
		Assert.assertEquals(3, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_04.class, results.get(2).getValue().getTargetClass());
	}

	@Test
	public void testLineCommentsForClass() throws Exception {
		StringBuffer content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.MockClass_01;\n");
		content.append("import internal.remoteproxy.legal.cat01.MockClass_03;\n");
		content.append("import internal.remoteproxy.legal.cat01.MockClass_04;\n");

		List<KeyValue<Integer, RemoteProxyMetadata>> results = parseContent(content.toString());
		Assert.assertEquals(3, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_04.class, results.get(2).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.MockClass_01;\n");
		content.append("//import internal.remoteproxy.legal.cat01.MockClass_03;\n");
		content.append("import internal.remoteproxy.legal.cat01.MockClass_04;\n");

		results = parseContent(content.toString());
		Assert.assertEquals(2, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_04.class, results.get(1).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.MockClass_01;");
		content.append("//import internal.remoteproxy.legal.cat01.MockClass_03;\n");
		content.append("import internal.remoteproxy.legal.cat01.MockClass_04;\n");

		results = parseContent(content.toString());
		Assert.assertEquals(2, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_04.class, results.get(1).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.MockClass_01;");
		content.append("//import internal.remoteproxy.legal.cat01.MockClass_03;");
		content.append("import internal.remoteproxy.legal.cat01.MockClass_04;\n");

		results = parseContent(content.toString());
		Assert.assertEquals(1, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.MockClass_01;");
		content.append("import internal.remoteproxy.legal.cat01.MockClass_03;");
		content.append("//import internal.remoteproxy.legal.cat01.MockClass_04;");

		results = parseContent(content.toString());
		Assert.assertEquals(2, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.MockClass_01;");
		content.append("import internal.remoteproxy.legal.cat01.MockClass_03; ");
		content.append("//import internal.remoteproxy.legal.cat01.MockClass_04;");

		results = parseContent(content.toString());
		Assert.assertEquals(2, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.MockClass_01;");
		content.append("import internal.remoteproxy.legal.cat01.MockClass_03;");
		content.append("//import internal.remoteproxy.legal.cat01.MockClass_04;");
		content.append("//import internal.remoteproxy.legal.cat02.MockClass_01;");
		content.append("//import internal.remoteproxy.legal.cat02.MockClass_03;");
		content.append("//import internal.remoteproxy.legal.cat02.MockClass_04;");

		results = parseContent(content.toString());
		Assert.assertEquals(2, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.MockClass_01;");
		content.append("import internal.remoteproxy.legal.cat01.MockClass_03;");
		content.append("//import internal.remoteproxy.legal.cat01.MockClass_04;");
		content.append("import internal.remoteproxy.legal.cat02.MockClass_01;");
		content.append("import internal.remoteproxy.legal.cat02.MockClass_03;");
		content.append("import internal.remoteproxy.legal.cat02.MockClass_04;");

		results = parseContent(content.toString());
		Assert.assertEquals(2, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.MockClass_01;");
		content.append("import internal.remoteproxy.legal.cat01.MockClass_03;");
		content.append("//import internal.remoteproxy.legal.cat01.MockClass_04;\n");
		content.append("import internal.remoteproxy.legal.cat02.MockClass_01;");
		content.append("import internal.remoteproxy.legal.cat02.MockClass_03;");
		content.append("import internal.remoteproxy.legal.cat02.MockClass_04;");

		results = parseContent(content.toString());
		Assert.assertEquals(5, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_01.class, results.get(2).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_03.class, results.get(3).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_04.class, results.get(4).getValue().getTargetClass());

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.MockClass_01;");
		content.append("import internal.remoteproxy.legal-cat01.MockClass_01;");

		try {
			parseContent(content.toString());
			Assert.fail();

		} catch (ParseException ex) {
			Assert.assertEquals("Invalid class name on token: internal.remoteproxy.legal-cat01.MockClass_01", ex.getMessage());
		}

		content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat01.MockClass_01;");
		content.append("//import internal.remoteproxy.legal-cat01.MockClass_01;");

		results = parseContent(content.toString());
		Assert.assertEquals(1, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.MockClass_01.class, results.get(0).getValue().getTargetClass());
	}

	@Test
	public void testExtractFromPackage() throws Exception {
		List<KeyValue<Integer, RemoteProxyMetadata>> results = parseContent("import internal.remoteproxy.legal.cat02.*;");
		Assert.assertEquals(3, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_04.class, results.get(2).getValue().getTargetClass());

		results = parseContent("import internal.remoteproxy.legal.cat02.cat0201.*;");
		Assert.assertEquals(3, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.cat0201.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.cat0201.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.cat0201.MockClass_04.class, results.get(2).getValue().getTargetClass());

		results = parseContent("import internal.remoteproxy.legal.cat02.cat0201.cat020101.*;");
		Assert.assertEquals(3, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.cat0201.cat020101.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.cat0201.cat020101.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.cat0201.cat020101.MockClass_04.class, results.get(2).getValue().getTargetClass());
	}

	@Test
	public void testSequence() throws Exception {
		StringBuffer content = new StringBuffer();
		content.append("import internal.remoteproxy.legal.cat02.MockClass_04;");
		content.append("import internal.remoteproxy.legal.cat02.MockClass_01;");
		content.append("import internal.remoteproxy.legal.cat02.MockClass_03;");
		content.append("import internal.remoteproxy.legal.cat01.cat0103.*;");

		List<KeyValue<Integer, RemoteProxyMetadata>> results = parseContent(content.toString());
		Assert.assertEquals(6, results.size());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.cat0103.MockClass_01.class, results.get(0).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.cat0103.MockClass_03.class, results.get(1).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat01.cat0103.MockClass_04.class, results.get(2).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_01.class, results.get(3).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_03.class, results.get(4).getValue().getTargetClass());
		Assert.assertEquals(internal.remoteproxy.legal.cat02.MockClass_04.class, results.get(5).getValue().getTargetClass());
	}
}
