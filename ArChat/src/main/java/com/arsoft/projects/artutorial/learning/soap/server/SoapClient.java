package com.arsoft.projects.artutorial.learning.soap.server;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SoapClient {
	public static void main(String[] args) throws MalformedURLException {
		URL webserviceURL = new URL("http://localhost:8888/ws/hello?wsdl");
		QName qname = new QName("http://server.soap.learning.artutorial.projects.arsoft.com/",
				"HelloWorldServiceImplService");
		Service service = Service.create(webserviceURL, qname);
		HelloWorldService helloWorldService = service.getPort(HelloWorldService.class);
		String message = helloWorldService.sayHello("Anshul Sood");
		System.out.println(message);
	}
}
