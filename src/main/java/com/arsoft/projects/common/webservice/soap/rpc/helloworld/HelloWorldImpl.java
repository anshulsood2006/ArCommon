package com.arsoft.projects.common.webservice.soap.rpc.helloworld;

import javax.jws.WebService;

@WebService(endpointInterface = "com.arsoft.projects.common.webservice.rest.soap.helloworld.HelloWorld")  
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String sayHello(String name) {
		return "Hello "+name;
	}

}
