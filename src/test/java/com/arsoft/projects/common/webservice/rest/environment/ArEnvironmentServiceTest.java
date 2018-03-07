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
	public void getDetail() {
		Response z = get("/arcommon/services/getEnvironmentDetail?action=GET_DATA&entityName=asd");
		System.out.println(z.getBody().asString());
		assertEquals("Invalid Value for parameter Action. Valid Values are: [GET_PROPERTY_VALUE, GET_DATABASE, GET_TABLE_NAME]", z.getBody().asString());
	}

}
