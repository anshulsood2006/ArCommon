package com.arsoft.projects.common.business.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Contact")
@XmlType(propOrder= {"contactType","contactValue","primary"})
public class ArContactInfo extends ArInfoBase{
	
	private ArContactTypeEnum contactType;
	private String contactValue;
	private boolean primary;
	
	public ArContactInfo() {
		
	}
	
	public ArContactInfo(ArContactTypeEnum contactType, String contactValue) {
		this.contactType = contactType;
		this.contactValue = contactValue;
	}

	public ArContactTypeEnum getContactType() {
		return contactType;
	}

	@XmlElement(name="Type")
	public void setContactType(ArContactTypeEnum contactType) {
		this.contactType = contactType;
	}

	public String getContactValue() {
		return contactValue;
	}

	@XmlElement(name="Value")
	public void setContactValue(String contactValue) {
		this.contactValue = contactValue;
	}

	public boolean isPrimary() {
		return primary;
	}

	@XmlElement(name="Primary")
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	
}
