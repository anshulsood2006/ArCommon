package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;

public class ArScripMonthDataFile extends ArScripDataFile{

	public ArScripMonthDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		super(arScripDataFileHeader, arScripFileDataFooter);
	}
	
	public ArScripMonthDataFile() {
		
	}

	public static ArScripDataFile getArScripDataFile() {
		return new ArScripMonthDataFile();
	}

}
