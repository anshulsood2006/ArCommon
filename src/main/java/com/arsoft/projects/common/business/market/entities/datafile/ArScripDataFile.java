package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.business.market.factory.ArScripFileDataHeaderFactory;

public abstract class ArScripDataFile {
	
	public ArScripDataFileHeader arScripDataFileHeader;
	public ArScripDataFileFooter arScripDataFileFooter;
	
	public ArScripDataFileHeader getArScripDataFileHeader() {
		return arScripDataFileHeader;
	}

	public void setArScripDataFileHeader(ArScripDataFileHeader arScripDataFileHeader) {
		this.arScripDataFileHeader = arScripDataFileHeader;
	}

	public ArScripDataFileFooter getArScripDataFileFooter() {
		return arScripDataFileFooter;
	}

	public void setArScripDataFileFooter(ArScripDataFileFooter arScripDataFileFooter) {
		this.arScripDataFileFooter = arScripDataFileFooter;
	}



	public ArScripDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		this.arScripDataFileHeader = ArScripFileDataHeaderFactory.getArScripDataFileHeader(arScripDataFileHeader.getScrip(), arScripDataFileHeader.getCreatedDateTime(), arScripDataFileHeader.getUpdatedDateTime(), arScripDataFileHeader.getArScripFileDataEnum());
		//this.arScripDataFileFooter = ArScripFileDataFooterFactory.getArScripFileDataFooter(arScripFileDataHeader.getScrip(), arScripFileDataHeader.getArScripFileDataEnum(), arScripFileDataFooter);
	}
}
