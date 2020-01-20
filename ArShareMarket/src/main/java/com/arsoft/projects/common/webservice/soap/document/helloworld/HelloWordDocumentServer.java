package com.arsoft.projects.common.webservice.soap.document.helloworld;

import javax.xml.ws.Endpoint;

public class HelloWordDocumentServer {
	
	public static void main(String[] args) {  
		Endpoint.publish("http://arjboss:7778/hello", new HelloWorldDocumentImpl());  
	}
	
}
