package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;

public class ArScripMonthDataFile extends ArScripDataFile{

	public ArScripMonthDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		super(arScripDataFileHeader, arScripFileDataFooter);
	}
	
	public ArScripMonthDataFile(ArScrip arScrip) {
		
	}

	public static ArScripDataFile getArScripDataFile(ArScrip arScrip) {
		return new ArScripMonthDataFile(arScrip);
	}

}
