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
	
	/**
	 * This variable stored the all time low details for the scrip
	 */
	
	public ArScrip allTimeLowDetail;
	
	/**
	 * This variable stored the all time high details for the scrip
	 */
	
	public ArScrip allTimeHighDetail;
	
	public ArScrip(String name, String completeName, ArBourse bourse, double price, Date timeOfRecord, ArScrip allTimeLowDetail, ArScrip allTimeHighDetail){
		this.name = name;
		this.completeName = completeName;
		this.bourse = bourse;
		this.price = price;
		this.timeOfRecord = timeOfRecord;
		if (allTimeLowDetail == null){
			this.allTimeHighDetail = this;
		}
		if (allTimeLowDetail == null){
			this.allTimeLowDetail = this;			
		}		
	}
	
	public String toString(){
		return "Scrip [ Name: "+ this.name + " , Complete Name: "+this.completeName +", Bourse Name: "+this.bourse + " , Price: "+
				this.price + " , Time: "+this.timeOfRecord + " , All Time High details: "+this.allTimeLowDetail + " , All Time Low details: "+this.allTimeHighDetail;
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

	public ArScrip getAllTimeLowDetail() {
		return allTimeLowDetail;
	}

	public void setAllTimeLowDetail(ArScrip allTimeLowDetail) {
		this.allTimeLowDetail = allTimeLowDetail;
	}

	public ArScrip getAllTimeHighDetail() {
		return allTimeHighDetail;
	}

	public void setAllTimeHighDetail(ArScrip allTimeHighDetail) {
		this.allTimeHighDetail = allTimeHighDetail;
	}
	
}
