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
	public String price;
	
	/**
	 * This variable stores the timestamp on which the scrip is being trade
	 */
	
	public Date timeStamp;
	
	/**
	 * This variable stored the all time low details for the scrip
	 */
	
	public ArScripTest allTimeLowDetail;
	
	/**
	 * This variable stored the all time high details for the scrip
	 */
	
	public ArScripTest allTimeHighDetail;
	
	public ArScrip(){
		
	}
	
	public String toString(){
		return "Scrip [ Name: "+ this.name + " , Complete Name: "+this.completeName +", Bourse Name: "+this.bourse + " , Price: "+
				this.price + " , Time: "+this.timeStamp + " , All Time High details: "+this.allTimeLowDetail + " , All Time Low details: "+this.allTimeHighDetail;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public ArScripTest getAllTimeLowDetail() {
		return allTimeLowDetail;
	}

	public void setAllTimeLowDetail(ArScripTest allTimeLowDetail) {
		this.allTimeLowDetail = allTimeLowDetail;
	}

	public ArScripTest getAllTimeHighDetail() {
		return allTimeHighDetail;
	}

	public void setAllTimeHighDetail(ArScripTest allTimeHighDetail) {
		this.allTimeHighDetail = allTimeHighDetail;
	}
	
}
