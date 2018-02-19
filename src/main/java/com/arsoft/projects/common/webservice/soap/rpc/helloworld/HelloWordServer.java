package com.arsoft.projects.common.webservice.soap.rpc.helloworld;

import javax.xml.ws.Endpoint;

public class HelloWordServer {
	
	public static void main(String[] args) {  
		Endpoint.publish("http://localhost:7779/hello", new HelloWorldImpl());  
	}
	
}
