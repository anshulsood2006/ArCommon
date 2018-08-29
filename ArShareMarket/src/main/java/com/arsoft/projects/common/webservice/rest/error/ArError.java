package com.arsoft.projects.common.webservice.rest.error;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Error")
public class ArError {
	
	
	private String errorCode;
	
	private String errorDescription;
	
	public ArError() {
		
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	@XmlElement(name="Code")
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	
	@XmlElement(name="Description")
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
}
