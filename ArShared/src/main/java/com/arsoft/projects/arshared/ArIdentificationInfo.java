package com.arsoft.projects.arshared;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Identification")
@XmlType(propOrder= {"identificationType","identificationValue"})
public class ArIdentificationInfo {
	
	private ArIdentificationTypeEnum identificationType;
	private String identificationValue;
	
	public ArIdentificationInfo() {
		
	}
	
	public ArIdentificationInfo(ArIdentificationTypeEnum identificationType, String identificationValue) {
		this.identificationType = identificationType;
		this.identificationValue = identificationValue;
	}

	public ArIdentificationTypeEnum getIdentificationType() {
		return identificationType;
	}

	@XmlElement(name="Type")
	public void setIdentificationType(ArIdentificationTypeEnum identificationType) {
		this.identificationType = identificationType;
	}

	public String getIdentificationValue() {
		return identificationValue;
	}

	@XmlElement(name="Value")
	public void setIdentificationValue(String identificationValue) {
		this.identificationValue = identificationValue;
	}
	
}
