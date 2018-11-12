package com.arsoft.projects.common.webservice.rest.environment;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.arsoft.projects.arcommon.ArList;

@XmlRootElement(name="PropertyList")
public class ArEnvironmentPropertyList implements ArList<ArEnvironmentProperty>{

	private List<ArEnvironmentProperty> arEnvironmentPropertyList;
	
	public ArEnvironmentPropertyList() {
		
	}

	public List<ArEnvironmentProperty> getArEnvironmentPropertyList() {
		return arEnvironmentPropertyList;
	}

	@XmlElement(name="Property")
	public void setArEnvironmentPropertyList(List<ArEnvironmentProperty> arEnvironmentPropertyList) {
		this.arEnvironmentPropertyList = arEnvironmentPropertyList;
	}
	
}
