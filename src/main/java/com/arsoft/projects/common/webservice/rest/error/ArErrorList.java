package com.arsoft.projects.common.webservice.rest.error;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.arsoft.projects.common.webservice.rest.ArList;

@XmlRootElement(name = "ErrorList")
public class ArErrorList implements ArList{
	
	private List<ArError> errorList;

	public List<ArError> getErrorList() {
		return errorList;
	}

	@XmlElement(name="Error")
	public void setErrorList(List<ArError> errorList) {
		this.errorList = errorList;
	}
	
}
