package com.arsoft.projects.common.business.market.entities.filedata.footer;

import com.arsoft.projects.common.business.market.entities.filedata.ArScripDataFileEnum;
import com.arsoft.projects.common.exception.ArException;

public abstract class ArScripDataFileFooter {
	
	private String scrip;
	private ArScripDataFileEnum arScripDataFileEnum;

	public String getScrip() {
		return scrip;
	}

	public void setScrip(String scrip) {
		this.scrip = scrip;
	}

	public ArScripDataFileEnum getArScripDataFileEnum() {
		return arScripDataFileEnum;
	}

	public void setArScripDataFileEnum(ArScripDataFileEnum arScripDataFileEnum) {
		this.arScripDataFileEnum = arScripDataFileEnum;
	}

	public ArScripDataFileFooter (String scrip, ArScripDataFileEnum arScripDataFileEnum) {
		this.scrip = scrip;
		this.arScripDataFileEnum = arScripDataFileEnum;
	}
	
	public abstract String getArScripDataFileFooterAsString() throws ArException;
	
}
