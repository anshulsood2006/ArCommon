package com.arsoft.projects.common.business.market.entities;

import com.arsoft.projects.arshared.ArDateTime;

public class ArPriceData {
	
	private double price;
	private ArDateTime arDateTime;
	
	public ArPriceData(double price, ArDateTime arDateTime) {
		this.price = price;
		this.arDateTime = arDateTime;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ArDateTime getArDateTime() {
		return arDateTime;
	}

	public void setArDateTime(ArDateTime arDateTime) {
		this.arDateTime = arDateTime;
	}

	public String toString() {
		return "[ArPriceData : Price: "+this.price+" ArDateTime: "+this.arDateTime+"]";
	}
	
}
