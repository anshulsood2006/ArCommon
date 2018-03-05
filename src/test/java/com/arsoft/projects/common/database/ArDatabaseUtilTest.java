package com.arsoft.projects.common.database;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.arsoft.projects.common.exception.ArException;

public class ArDatabaseUtilTest {
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test(expected = ArException.class)
	public void getSessionFactoryNullResource() throws ArException {
		ArDatabaseUtil.getSessionFactory(null);
	}
	
	@Test
	public void getSessionFactoryNullResourceText() throws ArException {
		expectedEx.expect(ArException.class);
		expectedEx.expectMessage("Resource can not be null");
		ArDatabaseUtil.getSessionFactory(null);
	}
	
	@Test(expected = ArException.class)
	public void shutdownNullResource() throws ArException {
		ArDatabaseUtil.shutdown(null);
	}
	
	@Test
	public void shutdownNullResourceText() throws ArException {
		expectedEx.expect(ArException.class);
		expectedEx.expectMessage("Resource can not be null");
		ArDatabaseUtil.shutdown(null);
	}
	
	@Test(expected = ArException.class)
	public void getSessionFactoryInvalidResource() throws ArException {
		ArDatabaseUtil.getSessionFactory("invalid");
	}
	
	@Test
	public void getSessionFactoryInvalidResourceText() throws ArException {
		String resource = "resource";
		expectedEx.expect(ArException.class);
		expectedEx.expectMessage("Resource "+resource+" not found on the classpath");
		ArDatabaseUtil.getSessionFactory("resource");
	}
	
	@Test
	public void getSessionFactoryInValidResource() throws ArException {
		String resource = "src/main/webapp/WEB-INF/configuration/dukaan.cfg.xml";
		expectedEx.expect(ArException.class);
		expectedEx.expectMessage("Resource "+resource+" not found on the classpath");
		ArDatabaseUtil.getSessionFactory(resource);
	}
	
	/*@Test
	public void getSessionFactoryValidResource() throws ArException {
		String resource = "dukaan.cfg.xml";
		SessionFactory sf = ArDatabaseUtil.getSessionFactory(resource);
		assertNotNull(sf);
	}*/

}
