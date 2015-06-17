package test.xeno.remoting;

import org.junit.After;
import org.junit.Before;

public class LoggingTestCase {
	private static final String COMMONS_LOGGING_TYPE_KEY = "org.apache.commons.logging.Log";
	private static final String COMMONS_LOGGING_LEVEL_KEY = "org.apache.commons.logging.simplelog.defaultlog";

	@Before
	public void before() {
		System.setProperty(COMMONS_LOGGING_TYPE_KEY, "org.apache.commons.logging.impl.SimpleLog");
		System.setProperty(COMMONS_LOGGING_LEVEL_KEY, "fatal");
	}

	@After
	public void after() {
		System.clearProperty(COMMONS_LOGGING_TYPE_KEY);
		System.clearProperty(COMMONS_LOGGING_LEVEL_KEY);
	}
}
