package com.arsoft.projects.common.webservice.soap.rpc.helloworld;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class HelloWorldClient {
	public static void main(String[] args) throws Exception {  
		URL url = new URL("http://arjboss:7779/hello?wsdl");  
		//1st argument service URI, refer to wsdl document above  
		//2nd argument is service name, refer to wsdl document above  
		QName qname = new QName("http://helloworld.rpc.soap.webservice.common.projects.arsoft.com/", "HelloWorldImplService");  
		Service service = Service.create(url, qname);  
		HelloWorld hello = service.getPort(HelloWorld.class);  
		System.out.println(hello.sayHello("Anshul Sood"));
	} 
}
