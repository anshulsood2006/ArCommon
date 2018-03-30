package com.arsoft.projects.common.business.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DateTimeStamp")
public class ArDateTime {
	
	private ArDate date;
	private ArTime time;
	
	public ArDateTime() {
		
	}

	public ArDate getDate() {
		return date;
	}

	@XmlElement(name="Date")
	public void setDate(ArDate date) {
		this.date = date;
	}

	public ArTime getTime() {
		return time;
	}

	@XmlElement(name="Time")
	public void setTime(ArTime time) {
		this.time = time;
	}

}
