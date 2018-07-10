package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;

public class ArScripWeekDataFile extends ArScripDataFile{

	public ArScripWeekDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		super(arScripDataFileHeader, arScripFileDataFooter);
	}

	public ArScripWeekDataFile() {
		
	}

	public static ArScripDataFile getArScripDataFile() {
		return new ArScripWeekDataFile();
	}
}
