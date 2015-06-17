package org.showcase.web.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.showcase.exception.MyException;
import org.showcase.model.Account;
import org.showcase.model.Document;
import org.showcase.model.Folder;
import org.showcase.model.NormalModel_01;
import org.showcase.model.NormalModel_02;
import org.showcase.model.NormalModel_03;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
@SuppressWarnings({ "unchecked", "rawtypes" })
public class GenericService {

	@ExceptionHandler
	public Map handleException(Exception ex) {
		Map m = new HashMap();
		m.put("a", 1);
		m.put("b", "bb");

		return m;
	}

	@ExceptionHandler
	public int handleException(MyException ex) {
		return 3;
	}

	@ExceptionHandler
	public static String handleException(IOException ex) {
		return "io exception";
	}

	@ExceptionHandler
	public String handleException(InvocationTargetException ex) {
		return "OK";
	}

	@ExceptionHandler
	public void handleException(ArrayIndexOutOfBoundsException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public Object handleException(SQLException ex) {
		return new Object();
	}

	@WebMethod
	public Object t1(Object o) {
		return o;
	}

	@WebMethod
	public String t2(Folder o) {
		return "" + o;
	}

	@WebMethod
	public String t3(Document o) {
		return "" + o;
	}

	@WebMethod
	public void t4() {
		// Does nothing.
	}

	@WebMethod
	public Account t5(Account o) {
		return o;
	}

	@WebMethod
	public int c1(int i) {
		return 100;
	}

	@WebMethod
	public String c2(int i, String s) {
		return "c2";
	}

	@WebMethod
	public void c3(int i) {
		// Does nothing.
	}

	@WebMethod
	public void c4(String s, int i) {
		// Does nothing.
	}

	@WebMethod
	public Map c5() {
		Map m = new HashMap();
		m.put("a", 1);
		m.put("b", true);
		m.put("c", "cc");

		return m;
	}

	@WebMethod
	public NormalModel_01 c6(NormalModel_01 m) {
		return m;
	}

	@WebMethod
	public NormalModel_02 c7(NormalModel_02 m) {
		return m;
	}

	@WebMethod
	public Map c8(NormalModel_01 m1, int i, NormalModel_02 m2) {
		Map m = new HashMap();
		m.put("i", i);
		m.put("m1", m1);
		m.put("m2", m2);

		return m;
	}

	@WebMethod
	public NormalModel_03 c9(NormalModel_03 m) {
		return m;
	}

	@WebMethod
	public static int c10(int a, int b) {
		return a + b;
	}

	@WebMethod
	public void e1() throws MyException {
		throw new MyException();
	}

	@WebMethod
	public void e2() {
		throw new IllegalArgumentException("illegal argument exception message");
	}

	@WebMethod
	public void e3() throws IOException {
		throw new IOException("io exception message");
	}

	@WebMethod
	public void e4() throws InvocationTargetException {
		throw new InvocationTargetException(null, "invocation target exception message");
	}

	@WebMethod
	public void e5() {
		throw new ArrayIndexOutOfBoundsException("c");
	}

	@WebMethod
	public void e6() throws SQLException {
		throw new SQLException("c");
	}
}
