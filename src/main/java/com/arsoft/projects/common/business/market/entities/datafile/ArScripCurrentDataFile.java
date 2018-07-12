package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;

public class ArScripCurrentDataFile extends ArScripDataFile{

	public ArScripCurrentDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		super(arScripDataFileHeader, arScripFileDataFooter);
	}

	public ArScripCurrentDataFile(ArScrip arScrip) {
	
	}

	public static ArScripDataFile getArScripDataFile(ArScrip arScrip) {
		return new ArScripCurrentDataFile(arScrip);
	}

	public String toString(){
		return "Current Data File Header: "+this.arScripDataFileHeader +", Current Data File Footer: "+this.arScripDataFileFooter;
	}
}
