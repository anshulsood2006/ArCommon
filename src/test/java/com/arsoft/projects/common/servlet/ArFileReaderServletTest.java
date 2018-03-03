package com.arsoft.projects.common.servlet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ArFileReaderServletTest {

	public String expected = "environment:PROD\r\n" + 
			"\r\n" + 
			"##Properties for Dukaan Project\r\n" + 
			"dukaan.order.receiver.emails:anshulsood2006@gmail.com\r\n" + 
			"dukaan.name:Apki Apni Dukaan\r\n" + 
			"dukaan.database.name:dukaan\r\n" + 
			"dukaan.hibernate.file.location:/WEB-INF/configuration/dukaan.cfg.xml\r\n" + 
			"\r\n" + 
			"test.extra.in.internal:/WEB-INF/configuration\r\n" + 
			"test.overridden.in.external:overridden\r\n" + 
			"test.only.in.internal:internal";
	@Mock
	HttpServletRequest request;
	
	@Mock
	GenericServlet servlet;
	
	@Mock
	ServletContext context;
	
	@Mock
	ServletConfig config;
	
	@Mock
	InputStream stream;

	@Mock
	HttpServletResponse response;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testExternalFile() throws Exception {
		when(request.getParameter("path")).thenReturn("D:/configuration/config.properties");
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		when(response.getWriter()).thenReturn(pw);
		new ArFileReaderServlet().doGet(request, response);
		String result = sw.getBuffer().toString().trim();
		assertEquals(expected.replaceAll("\n", "").replaceAll("\r", ""), result.replaceAll("\n", "").replaceAll("\r", ""));
	}
	
	@Test
	public void testInternalFile() throws Exception {
		ArFileReaderServlet mock = new ArFileReaderServlet();
		mock.init(config);
		when(request.getParameter("path")).thenReturn("/WEB-INF/configuration/config.properties");
		when(mock.getServletContext()).thenReturn(context);
		when(mock.getServletContext().getResourceAsStream("/WEB-INF/configuration/config.properties")).thenReturn(stream);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		when(response.getWriter()).thenReturn(pw);
		mock.doGet(request, response);
		String result = sw.getBuffer().toString().trim();
		//assertEquals(expected.replaceAll("\n", "").replaceAll("\r", ""), result.replaceAll("\n", "").replaceAll("\r", ""));
	}
}
