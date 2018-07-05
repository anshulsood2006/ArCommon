package com.arsoft.projects.common.business.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Date")
@XmlType(propOrder= {"day","month","year"})
public class ArDate {
	
	private int day;
	private ArMonthEnum month;
	private int year;
	
	public ArDate() {
		
	}
	
	public ArDate(int day, ArMonthEnum month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}
	
	@XmlElement(name="Day")
	public void setDay(int day) {
		this.day = day;
	}

	public ArMonthEnum getMonth() {
		return month;
	}

	@XmlElement(name="Month")
	public void setMonth(ArMonthEnum month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	@XmlElement(name="Year")
	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString(){
		return "Day: "+this.day+", Month: "+this.month+", Year: "+this.year;
	}
	
	
	public String getDayAsString() {
		return day < 10 ? "0" + day : String.valueOf(day);
	}
	
	public String getMonthAsString() {
		return Integer.parseInt(month.getValue()) < 10 ? "0" + month.getValue() : String.valueOf(month.getValue());
	}


}
