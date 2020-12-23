package com.arsoft.projects.artutorial.learning.soap.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWorldService {
	@WebMethod
	public String sayHello(String name);
}
