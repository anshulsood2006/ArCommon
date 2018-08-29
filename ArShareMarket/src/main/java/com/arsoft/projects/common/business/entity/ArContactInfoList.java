package com.arsoft.projects.common.business.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.arsoft.projects.common.webservice.rest.ArList;

@XmlRootElement(name = "ContactList")
public class ArContactInfoList implements ArList<ArContactInfo>{
private List<ArContactInfo> arContactInfoList;
	
	public ArContactInfoList() {
		
	}
	
	public List<ArContactInfo> getArContactInfoList() {
		return arContactInfoList;
	}

	@XmlElement(name="Contact")
	public void setArContactInfoList(List<ArContactInfo> arContactInfoList) {
		this.arContactInfoList = arContactInfoList;
	}
}