package com.arsoft.projects.common.webservice.rest.sharemarket;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.webservice.rest.ArList;

/**
 * This class stores complete information about a particular scrip
 * @author anshulsood
 *
 */
@XmlRootElement(name="ScripList")
public class ArScripList implements ArList<ArScrip>{
	
	private List<ArScrip> arScripList;

	public ArScripList() {
		
	}
	
	public List<ArScrip> getArScripList() {
		return arScripList;
	}

	@XmlElement(name="Scrip")
	public void setArScripList(List<ArScrip> arScripList) {
		this.arScripList = arScripList;
	}
	
}
