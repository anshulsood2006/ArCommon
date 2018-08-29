package com.arsoft.projects.common.business.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="OperationInfo")
@XmlType(propOrder= {"daysOfOperation","startTiming","closeTiming"})
public class ArOperationTimeInfo{
	
	private ArTime startTiming;
	private ArTime closeTiming;
	private List<ArDayEnum> daysOfOperation;
	
	public ArOperationTimeInfo() {
		
	}
	
	public ArTime getStartTiming() {
		return startTiming;
	}
	
	@XmlElement(name="StartTime")
	public void setStartTiming(ArTime startTiming) {
		this.startTiming = startTiming;
	}
	
	public ArTime getCloseTiming() {
		return closeTiming;
	}
	
	@XmlElement(name="CloseTime")
	public void setCloseTiming(ArTime closeTiming) {
		this.closeTiming = closeTiming;
	}

	public List<ArDayEnum> getDaysOfOperation() {
		return daysOfOperation;
	}

	@XmlElement(name="DaysOfOperation")
	public void setDaysOfOperation(List<ArDayEnum> daysOfOperation) {
		this.daysOfOperation = daysOfOperation;
	}
	
}
