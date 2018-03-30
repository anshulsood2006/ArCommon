package com.arsoft.projects.common.business.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ConsumerInfo")
public class ArConsumerEntityInfo{
	
	private ArEntityInfo consumerInfo;

	public ArConsumerEntityInfo() {
		
	}

	public ArEntityInfo getConsumerInfo() {
		return consumerInfo;
	}

	@XmlElement(name="Consumer")
	public void setConsumerInfo(ArEntityInfo consumerInfo) {
		this.consumerInfo = consumerInfo;
	}
	
}
