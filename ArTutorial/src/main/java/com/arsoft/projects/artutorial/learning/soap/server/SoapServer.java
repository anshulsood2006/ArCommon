package com.arsoft.projects.artutorial.learning.soap.server;

import javax.xml.ws.Endpoint;

import com.arsoft.projects.artutorial.learning.soap.Constant;

public class SoapServer {
	public static void main(String[] args) {
		Endpoint.publish(Constant.helloWorldSoapServiceUrl, new HelloWorldServiceImpl());
	}
}
