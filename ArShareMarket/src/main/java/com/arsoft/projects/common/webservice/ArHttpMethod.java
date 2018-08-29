package com.arsoft.projects.common.webservice;

public enum ArHttpMethod {
	
	GET("GET"),
	POST("POST"),
	HEAD ("HEAD"),
	PUT ("PUT"),
	DELETE ("DELETE"),
	CONNECT ("CONNECT"),
	OPTIONS ("OPTIONS"),
	TRACE ("TRACE");
	
	private String httpMethod;
	
	private ArHttpMethod(String httpMethod){
		this.httpMethod = httpMethod;
	}
	
	public String getHttpMethod(){
		return this.httpMethod;
	}
}

