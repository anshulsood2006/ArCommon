package com.arsoft.projects.arcommon;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Business")
@XmlType(propOrder = {"businessName", "businessOwnerInfo", "businessOperationTimeInfo", "businessKycInfo", "businessDateOfRegisteration", "productList"})
public class ArBusinessEntityInfo extends ArInfoBase{
	
	private ArEntityInfo businessOwnerInfo;
	private String businessName;
	private ArDate businessDateOfRegisteration;
	private ArKycInfo businessKycInfo;
	private ArOperationTimeInfo businessOperationTimeInfo;
	private List<ArProduct> productList;
	
	public ArBusinessEntityInfo() {
		
	}

	public ArEntityInfo getBusinessOwnerInfo() {
		return businessOwnerInfo;
	}
	
	@XmlElement(name="Owner")
	public void setBusinessOwnerInfo(ArEntityInfo businessOwnerInfo) {
		this.businessOwnerInfo = businessOwnerInfo;
	}

	public String getBusinessName() {
		return businessName;
	}

	@XmlElement(name="Name")
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public ArDate getBusinessDateOfRegisteration() {
		return businessDateOfRegisteration;
	}

	@XmlElement(name="DateOfInception")
	public void setBusinessDateOfRegisteration(ArDate businessDateOfRegisteration) {
		this.businessDateOfRegisteration = businessDateOfRegisteration;
	}

	public ArKycInfo getBusinessKycInfo() {
		return businessKycInfo;
	}
	
	@XmlElement(name="KYC")
	public void setBusinessKycInfo(ArKycInfo businessKycInfo) {
		this.businessKycInfo = businessKycInfo;
	}

	public ArOperationTimeInfo getBusinessOperationTimeInfo() {
		return businessOperationTimeInfo;
	}

	@XmlElement(name="OperationTiming")
	public void setBusinessOperationTimeInfo(ArOperationTimeInfo businessOperationTimeInfo) {
		this.businessOperationTimeInfo = businessOperationTimeInfo;
	}

	public List<ArProduct> getProductList() {
		return productList;
	}

	@XmlElementWrapper(name="ServiceList")
	@XmlElement(name="Service")
	public void setProductList(List<ArProduct> productList) {
		this.productList = productList;
	}
	
	
	
}
