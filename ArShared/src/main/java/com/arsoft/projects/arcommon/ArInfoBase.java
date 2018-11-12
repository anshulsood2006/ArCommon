package com.arsoft.projects.arcommon;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder= {"id", "active", "createdDate", "lastUpdateDate"})
public abstract class ArInfoBase {
	
	private BigInteger id;
	private boolean active = true;
	private ArDateTime lastUpdateDate;
	private ArDateTime createdDate;
	
	public ArInfoBase() {
		
	}
	
	public BigInteger getId() {
		return id;
	}
	
	@XmlElement(name="Id")
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public boolean isActive() {
		return active;
	}
	
	@XmlElement(name="Active")
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public ArDateTime getLastUpdateDate() {
		return lastUpdateDate;
	}
	
	@XmlElement(name="LastUpdateDate")
	public void setLastUpdateDate(ArDateTime lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public ArDateTime getCreatedDate() {
		return createdDate;
	}
	
	@XmlElement(name="CreatedDate")
	public void setCreatedDate(ArDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
}
