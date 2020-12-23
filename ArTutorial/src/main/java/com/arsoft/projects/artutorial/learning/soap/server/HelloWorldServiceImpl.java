package com.arsoft.projects.artutorial.learning.soap.server;

import javax.jws.WebService;

@WebService(endpointInterface = "com.arsoft.projects.artutorial.learning.soap.server.HelloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

	public String sayHello(String name) {
		return "Hello " + name + "!!";
	}
}
