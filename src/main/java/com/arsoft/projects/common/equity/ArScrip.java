package com.arsoft.projects.common.equity;

import java.util.Date;

/**
 * This class stores complete information about a particular scrip
 * @author anshulsood
 *
 */
public class ArScrip {
	
	/**
	 * This variable stores the abbreviated name of the scrip
	 */
	public String name;
	
	/**
	 * This variable stores the complete name of the scrip
	 */
	
	public String completeName;
	
	/**
	 * This variable stores the name of bourse on which the scrip is being trade
	 */
	public ArBourse bourse;
	
	/**
	 * This variable stores the current price on which the scrip is being traded
	 */
	public double price;
	
	/**
	 * This variable stores the timestamp on which the scrip is being trade
	 */
	
	public Date timeOfRecord;
	
	
	public ArScrip(String name, String completeName, ArBourse bourse, double price, Date timeOfRecord){
		this.name = name;
		this.completeName = completeName;
		this.bourse = bourse;
		this.price = price;
		this.timeOfRecord = timeOfRecord;		
	}
	
	public String toString(){
		return "Scrip [ Name: "+ this.name + " , Complete Name: "+this.completeName +", Bourse Name: "+this.bourse + " , Price: "+
				this.price + " , Time: "+this.timeOfRecord;
	}

 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public ArBourse getBourse() {
		return bourse;
	}

	public void setBourse(ArBourse bourse) {
		this.bourse = bourse;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getTimeOfRecord() {
		return timeOfRecord;
	}

	public void setTimeOfRecord(Date timeOfRecord) {
		this.timeOfRecord = timeOfRecord;
	}
	
}
