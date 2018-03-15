package com.arsoft.projects.common.webservice.rest.dukaan;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.arsoft.projects.common.webservice.rest.ArList;

@XmlRootElement(name = "ProductList")
public class ArDukaanProductList implements ArList<ArDukaanProduct>{
	
	private List<ArDukaanProduct> arDukaanProductList;
	
	public ArDukaanProductList() {
		
	}
	
	public List<ArDukaanProduct> getArDukaanProductList() {
		return arDukaanProductList;
	}

	@XmlElement(name="Product")
	public void setArDukaanProductList(List<ArDukaanProduct> arDukaanProductList) {
		this.arDukaanProductList = arDukaanProductList;
	}
	
}
