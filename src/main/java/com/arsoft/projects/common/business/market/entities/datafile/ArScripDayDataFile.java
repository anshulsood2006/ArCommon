package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;

public class ArScripDayDataFile extends ArScripDataFile{

	public ArScripDayDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		super(arScripDataFileHeader, arScripFileDataFooter);
	}

	public ArScripDayDataFile(ArScrip arScrip) {
		
	}

	public static ArScripDataFile getArScripDataFile(ArScrip arScrip) {
		return new ArScripDayDataFile(arScrip);
	}
	
	public String toString(){
		return "Day Data File Header: "+this.arScripDataFileHeader +", Day Data File Footer: "+this.arScripDataFileFooter;
	}
}
