package com.arsoft.projects.common.business.market.entities.filedata.footer;

import com.arsoft.projects.common.business.entity.ArDateTime;

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
