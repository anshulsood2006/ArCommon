package com.arsoft.projects.common.business.market.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.arsoft.projects.arcommon.ArDateTime;
import com.arsoft.projects.common.equity.ArBourse;

/**
 * This class stores complete information about a particular scrip
 * @author anshulsood
 *
 */
@XmlRootElement(name="Scrip")
public class ArScrip {
	
	/**
	 * This variable stores the abbreviated name of the scrip
	 */
	private String name;
	
	/**
	 * This variable stores the complete name of the scrip
	 */
	
	private String completeName;
	
	/**
	 * This variable stores the name of bourse on which the scrip is being trade
	 */
	private ArBourse bourse;
	
	/**
	 * This variable stores the current price on which the scrip is being traded
	 */
	private double price;
	
	/**
	 * This variable stores the timestamp on which the scrip is being trade
	 */
	
	private ArDateTime timeOfRecord;
	
	public ArScrip(){
		
	}
	
	public ArScrip(String name, String completeName, ArBourse bourse, double price, ArDateTime timeOfRecord){
		this.name = name;
		this.completeName = completeName;
		this.bourse = bourse;
		this.price = price;
		this.timeOfRecord = timeOfRecord;
	}
	
	public String toString(){
		return "Scrip [ Name: "+ this.name + " , Complete Name: "+this.completeName +", Bourse Name: "+this.bourse + " , Price: "+
				this.price + " , Time of Record: "+this.timeOfRecord +"]";
	}

 
	public String getName() {
		return name;
	}

	@XmlElement(name = "Name")
	public void setName(String name) {
		this.name = name;
	}

	public String getCompleteName() {
		return completeName;
	}

	@XmlElement(name = "CompleteName")
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public ArBourse getBourse() {
		return bourse;
	}

	@XmlElement(name = "Bourse")
	public void setBourse(ArBourse bourse) {
		this.bourse = bourse;
	}

	public double getPrice() {
		return price;
	}

	@XmlElement(name = "Price")
	public void setPrice(double price) {
		this.price = price;
	}

	public ArDateTime getTimeOfRecord() {
		return timeOfRecord;
	}

	@XmlElement(name = "Time")
	public void setTimeOfRecord(ArDateTime timeOfRecord) {
		this.timeOfRecord = timeOfRecord;
	}
	
}
