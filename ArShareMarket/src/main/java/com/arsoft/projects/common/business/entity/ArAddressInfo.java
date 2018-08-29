package com.arsoft.projects.common.business.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class stores the information about the address object
 * 
 * @author anshul.sood
 *
 */
@XmlRootElement(name="Address")
@XmlType(propOrder= {"addressLineOne","addressLineTwo","city","state","pinCode","country"})
public class ArAddressInfo extends ArInfoBase {
	
	private String addressLineOne;
	private String addressLineTwo;
	private String city;
	private String state;
	private int pinCode;
	private String country;
	
	public ArAddressInfo() {
		
	}
	
	public ArAddressInfo(String addressLineOne, String addressLineTwo, String city, String state, int pinCode, String country) {
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.country = country;
	}
	
	public String getAddressLineOne() {
		return addressLineOne;
	}
	
	@XmlElement(name="AddressLine1")
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	
	@XmlElement(name="AddressLine2")
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	
	public String getCity() {
		return city;
	}
	
	@XmlElement(name="City")
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	@XmlElement(name="State")
	public void setState(String state) {
		this.state = state;
	}
	public int getPinCode() {
		return pinCode;
	}
	
	@XmlElement(name="PinCode")
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	@XmlElement(name="Country")
	public void setCountry(String country) {
		this.country = country;
	}
	
}
