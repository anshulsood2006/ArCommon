package com.arsoft.projects.common.business.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.arsoft.projects.common.webservice.rest.ArList;

@XmlRootElement(name = "ProductList")
public class ArProductList implements ArList<ArProduct>{
	
	private List<ArProduct> arDukaanProductList;
	
	public ArProductList() {
		
	}
	
	public List<ArProduct> getArDukaanProductList() {
		return arDukaanProductList;
	}

	@XmlElement(name="Product")
	public void setArDukaanProductList(List<ArProduct> arDukaanProductList) {
		this.arDukaanProductList = arDukaanProductList;
	}
	
}
