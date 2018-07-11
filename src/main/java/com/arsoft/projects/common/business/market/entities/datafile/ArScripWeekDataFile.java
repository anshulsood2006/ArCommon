package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;

public class ArScripWeekDataFile extends ArScripDataFile{

	public ArScripWeekDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		super(arScripDataFileHeader, arScripFileDataFooter);
	}

	public ArScripWeekDataFile(ArScrip arScrip) {
		
	}

	public static ArScripDataFile getArScripDataFile(ArScrip arScrip) {
		return new ArScripWeekDataFile(arScrip);
	}
}
