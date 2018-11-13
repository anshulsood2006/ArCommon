package com.arsoft.projects.arshared;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AddressList")
public class ArAddressInfoList  implements ArList<ArAddressInfo>{
	
	private List<ArAddressInfo> arAddressInfoList;
	
	public ArAddressInfoList() {
		
	}
	
	public List<ArAddressInfo> getArAddressInfoList() {
		return arAddressInfoList;
	}

	@XmlElement(name="Address")
	public void setArAddressInfoList(List<ArAddressInfo> arAddressInfoList) {
		this.arAddressInfoList = arAddressInfoList;
	}
}
