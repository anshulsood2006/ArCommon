package com.arsoft.projects.common.business.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Time")
@XmlType(propOrder= {"hour", "minute", "second", "amPm", "timeZone"})
public class ArTime {
	
	private int hour;
	private int minute;
	private int second;
	private ArAmPmEnum amPm;
	private ArTimeZoneEnum timeZone = ArTimeZoneEnum.IST;
	
	public ArTime() {
		
	}
	
	public ArTime(int hour, ArAmPmEnum amPm) {
		this.hour = hour;
		this.amPm = amPm;
	}
	
	public ArTime(int hour, int minute, ArAmPmEnum amPm) {
		this.hour = hour;
		this.minute = minute;
		this.amPm = amPm;
	}
	
	public ArTime(int hour, int minute, int second, ArAmPmEnum amPm) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.amPm = amPm;
	}
	
	public ArTime(int hour, ArAmPmEnum amPm, ArTimeZoneEnum timezone) {
		this.hour = hour;
		this.amPm = amPm;
		this.timeZone = timezone;
	}
	
	public ArTime(int hour, int minute, ArAmPmEnum amPm, ArTimeZoneEnum timezone) {
		this.hour = hour;
		this.minute = minute;
		this.amPm = amPm;
		this.timeZone = timezone;
	}
	
	public ArTime(int hour, int minute, int second, ArAmPmEnum amPm, ArTimeZoneEnum timezone) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.amPm = amPm;
		this.timeZone = timezone;
	}

	public int getHour() {
		return hour;
	}

	@XmlElement(name="Hour")
	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	@XmlElement(name="Minute")
	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	@XmlElement(name="Second")
	public void setSecond(int second) {
		this.second = second;
	}

	public ArAmPmEnum getAmPm() {
		return amPm;
	}

	@XmlElement(name="AmPm")
	public void setAmPm(ArAmPmEnum amPm) {
		this.amPm = amPm;
	}

	public ArTimeZoneEnum getTimeZone() {
		return timeZone;
	}

	@XmlElement(name="TimeZone")
	public void setTimeZone(ArTimeZoneEnum timeZone) {
		this.timeZone = timeZone;
	}
	
	public String toString(){
		return "Hour: "+this.hour+", Minute: "+this.minute+", Second: "+this.second+", AmPm: "+this.amPm+", Timezone: "+this.timeZone;
	}
	
	public String getHourAsString() {
		return hour < 10 ? "0" + hour : String.valueOf(hour);
	}
	
	public String getMinuteAsString() {
		return  minute < 10 ? "0" + minute : String.valueOf(minute);
	}
	
	public String getSecondAsString() {
		return second < 10 ? "0" + second : String.valueOf(second);
	}
	
}
