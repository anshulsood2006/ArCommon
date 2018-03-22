package com.arsoft.projects.common.webservice.rest.dukaan;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Product")
public class ArDukaanProduct {
	
	public String id;
	public String name;
	public double price;
	public double mrp;
	public int quantity;
	
	public ArDukaanProduct() {
		
	}

	public String getId() {
		return id;
	}

	@XmlElement(name="Id")
	public void setId(String id) {
		this.id = id;
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

	@XmlElement(name="Price")
	public void setPrice(double price) {
		this.price = price;
	}

	public double getMrp() {
		return mrp;
	}

	@XmlElement(name="MRP")
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public int getQuantity() {
		return quantity;
	}

	@XmlElement(name="Quantity")
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return "Name: "+this.name+" MRP: "+this.mrp;
	}
}
