package com.arsoft.projects.common.webservice.rest.environment;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;


public class ArEnvironmentServiceTest {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}
	
	@Test
	public void getDetailActionMissing() {
		Response z = get("/arcommon/services/getEnvironmentDetail");
		assertEquals("Parameter 'action' is required in query string",z.getBody().asString());
	}
	
	@Test
	public void getDetailEntityNameMissing() {
		Response z = get("/arcommon/services/getEnvironmentDetail?action=abc");
		assertEquals("Parameter 'entityName' is required in query string",z.getBody().asString());
	}
	
	@Test
	public void getDetailInvalidAction() {
		Response z = get("/arcommon/services/getEnvironmentDetail?action=GET_DATA&entityName=asd");
		assertEquals("Invalid Value for parameter 'action'.\n\nValid Values are: [GET_PROPERTY_VALUE, GET_DATABASE, GET_TABLE_NAME]", z.getBody().asString());
	}
	
	@Test
	public void getDetailActionGetPropertyValueAll() {
		Response z = get("/arcommon/services/getEnvironmentDetail?action=GET_PROPERTY_VALUE&entityName=ALL");
		assertEquals("<table border=\"1\"><tr><th>Property Name</th><th>Property Value</th></tr><tr><td>test.extra.in.internal</td><td>/WEB-INF/configuration</td></tr><tr><td>environment</td><td>PROD</td></tr><tr><td>dukaan.name</td><td>Apki Apni Dukaan</td></tr><tr><td>dukaan.order.receiver.emails</td><td>anshulsood2006@gmail.com</td></tr><tr><td>dukaan.hibernate.file.location</td><td>/WEB-INF/configuration/dukaan.cfg.xml</td></tr><tr><td>dukaan.database.name</td><td>dukaan</td></tr><tr><td>test.overridden.in.external</td><td>overridden</td></tr><tr><td>test.only.in.internal</td><td>internal</td></tr><tr><td>class.creation.config</td><td>/WEB-INF/configuration/create_class.xml</td></tr></table>", z.getBody().asString());
	}
	
	@Test
	public void getDetailActionGetPropertyValue() {
		Response z = get("/arcommon/services/getEnvironmentDetail?action=GET_PROPERTY_VALUE&entityName=test.overridden.in.external");
		assertEquals("<table border=\"1\"><tr><th>Property Name</th><th>Property Value</th></tr><tr><td>test.overridden.in.external</td><td>overridden</td></tr></table>", z.getBody().asString());
	}

}
