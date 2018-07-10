package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;

public class ArScripCurrentDataFile extends ArScripDataFile{

	public ArScripCurrentDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		super(arScripDataFileHeader, arScripFileDataFooter);
	}

	public ArScripCurrentDataFile() {
		
	}

	public static ArScripDataFile getArScripDataFile() {
		return new ArScripCurrentDataFile();
	}

}
