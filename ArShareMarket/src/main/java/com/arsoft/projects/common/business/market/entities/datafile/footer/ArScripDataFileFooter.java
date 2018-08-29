package com.arsoft.projects.common.business.market.entities.datafile.footer;

import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.exception.ArException;

public abstract class ArScripDataFileFooter {
	
	private ArScrip arScrip;
	private ArScripDataFileEnum arScripDataFileEnum;

	public ArScrip getArScrip() {
		return arScrip;
	}

	public void setArScrip(ArScrip arScrip, ArScripDataFileEnum arScripDataFileEnum) {
		this.arScrip = arScrip;
		this.arScripDataFileEnum = arScripDataFileEnum;
	}

	public ArScripDataFileEnum getArScripDataFileEnum() {
		return arScripDataFileEnum;
	}

	public void setArScripDataFileEnum(ArScripDataFileEnum arScripDataFileEnum) {
		this.arScripDataFileEnum = arScripDataFileEnum;
	}
	
	public ArScripDataFileFooter (ArScrip arScrip, ArScripDataFileEnum arScripDataFileEnum) {
		this.arScrip = arScrip;
		this.arScripDataFileEnum = arScripDataFileEnum;
	}
	
	public ArScripDataFileFooter(String footerString, ArScrip arScrip) throws ArException {
		this.arScrip = arScrip;
	}
	
	public ArScripDataFileFooter() {
		
	}
	
	public abstract String getArScripDataFileFooterAsString() throws ArException;
	
	public String toString() {
		return "Scrip: "+this.getArScrip()+", Current Price: "+this.getArScripDataFileEnum();
	}
}
