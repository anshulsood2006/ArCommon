package com.arsoft.projects.common.webservice.soap.document.helloworld;

import javax.jws.WebService;

@WebService(endpointInterface = "com.arsoft.projects.common.webservice.soap.document.helloworld.HelloWorldDocument")  
public class HelloWorldDocumentImpl implements HelloWorldDocument{

	@Override
	public String sayHello(String name) {
		return "Hello "+name;
	}

}
