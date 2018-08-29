package com.arsoft.projects.common.webservice.rest.environment;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Property")
public class ArEnvironmentProperty {
	
	private String name;
	
	private String value;
	
	public ArEnvironmentProperty() {
		
	}
	
	public String getName() {
		return name;
	}
	
	@XmlElement(name = "Name")
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	
	@XmlElement(name = "Value")
	public void setValue(String value) {
		this.value = value;
	}
	
}
