package com.arsoft.projects.common.business.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="KYC")
@XmlType(propOrder= {"listAddressInfo","listContactInfo","listIdentificationInfo"})
public class ArKycInfo {
	
	private List<ArAddressInfo> listAddressInfo;
	private List<ArContactInfo> listContactInfo;
	private List<ArIdentificationInfo> listIdentificationInfo;
	
	public ArKycInfo() {
		
	}
	
	public List<ArAddressInfo> getListAddressInfo() {
		return listAddressInfo;
	}

	@XmlElementWrapper (name="AddressList")
	@XmlElement(name="Address")
	public void setListAddressInfo(List<ArAddressInfo> listAddressInfo) {
		this.listAddressInfo = listAddressInfo;
	}

	public List<ArContactInfo> getListContactInfo() {
		return listContactInfo;
	}

	@XmlElementWrapper(name="ContactList")
	@XmlElement(name="Contact")
	public void setListContactInfo(List<ArContactInfo> listContactInfo) {
		this.listContactInfo = listContactInfo;
	}

	public List<ArIdentificationInfo> getListIdentificationInfo() {
		return listIdentificationInfo;
	}

	@XmlElementWrapper(name="IdentificationList")
	@XmlElement(name="Identification")
	public void setListIdentificationInfo(List<ArIdentificationInfo> listIdentificationInfo) {
		this.listIdentificationInfo = listIdentificationInfo;
	}
	
}	
