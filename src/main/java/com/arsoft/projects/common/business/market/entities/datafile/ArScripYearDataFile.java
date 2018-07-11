package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;

public class ArScripYearDataFile extends ArScripDataFile{

	public ArScripYearDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		super(arScripDataFileHeader, arScripFileDataFooter);
	}

	public ArScripYearDataFile(ArScrip arScrip) {
		
	}

	public static ArScripDataFile getArScripDataFile(ArScrip arScrip) {
		return new ArScripYearDataFile(arScrip);
	}
}
