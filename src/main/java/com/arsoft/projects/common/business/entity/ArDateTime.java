package com.arsoft.projects.common.business.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DateTimeStamp")
public class ArDateTime {
	
	private ArDate arDate;
	private ArTime arTime;
	
	public ArDateTime() {
		
	}

	public ArDate getArDate() {
		return arDate;
	}

	@XmlElement(name="ArDate")
	public void setArDate(ArDate arDate) {
		this.arDate = arDate;
	}

	public ArTime getArTime() {
		return arTime;
	}

	@XmlElement(name="ArTime")
	public void setArTime(ArTime arTime) {
		this.arTime = arTime;
	}
	
	public String toString(){
		return "ArDate: "+this.arDate +", ArTime: "+this.arTime;
	}

}