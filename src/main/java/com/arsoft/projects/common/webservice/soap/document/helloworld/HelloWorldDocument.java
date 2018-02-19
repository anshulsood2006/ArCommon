package com.arsoft.projects.common.webservice.soap.document.helloworld;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)  
public interface HelloWorldDocument {
	@WebMethod
	String sayHello(String name); 
}
