package com.arsoft.projects.common.business.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Entity")
@XmlType(propOrder= {"firstName", "middleName", "lastName", "gender", "dateOfBirth", "dateOfRegisteration", "kycInfo"})
public class ArEntityInfo extends ArInfoBase {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private ArGenderEnum gender;
	private ArDate dateOfBirth;
	private ArDate dateOfRegisteration;
	private ArKycInfo kycInfo;
	
	public ArEntityInfo() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	@XmlElement(name="FirstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	@XmlElement(name="MiddleName")
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	@XmlElement(name="LastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ArGenderEnum getGender() {
		return gender;
	}

	@XmlElement(name="Gender")
	public void setGender(ArGenderEnum gender) {
		this.gender = gender;
	}

	public ArDate getDateOfBirth() {
		return dateOfBirth;
	}

	@XmlElement(name="DateOfBirth")
	public void setDateOfBirth(ArDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public ArDate getDateOfRegisteration() {
		return dateOfRegisteration;
	}

	@XmlElement(name="DateOfRegisteration")
	public void setDateOfRegisteration(ArDate dateOfRegisteration) {
		this.dateOfRegisteration = dateOfRegisteration;
	}

	public ArKycInfo getKycInfo() {
		return kycInfo;
	}

	@XmlElement(name="KYC")
	public void setKycInfo(ArKycInfo kycInfo) {
		this.kycInfo = kycInfo;
	}

}
