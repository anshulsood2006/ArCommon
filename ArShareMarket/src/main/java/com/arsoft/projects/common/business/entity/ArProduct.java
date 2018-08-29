package com.arsoft.projects.common.business.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Product")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ArProduct {
	
	public String name;
	public double price;
	
	public ArProduct() {
		
	}

	public String getName() {
		return name;
	}

	@XmlElement(name="Name")
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	@XmlElement(name="Cost")
	public void setPrice(double price) {
		this.price = price;
	}

}
