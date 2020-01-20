package com.arsoft.projects.common.webservice.soap.document.helloworld;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class HelloWorldDocumentClient {
	public static void main(String[] args) throws Exception {  
		URL url = new URL("http://arjboss:7778/hello?wsdl");  
		//1st argument service URI, refer to wsdl document above  
		//2nd argument is service name, refer to wsdl document above  
		QName qname = new QName("http://helloworld.document.soap.webservice.common.projects.arsoft.com/", "HelloWorldDocumentImplService");  
		Service service = Service.create(url, qname);  
		HelloWorldDocument hello = service.getPort(HelloWorldDocument.class);  
		System.out.println(hello.sayHello("Anshul Sood"));
	} 
}
