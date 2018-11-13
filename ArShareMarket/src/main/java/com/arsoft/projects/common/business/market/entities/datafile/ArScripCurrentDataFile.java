package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.arshared.ArDateTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.business.market.factory.ArScripDataFileFooterFactory;
import com.arsoft.projects.common.business.market.factory.ArScripDataFileHeaderFactory;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripCurrentDataFile extends ArScripDataFile{

	public ArScripCurrentDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		super(arScripDataFileHeader, arScripFileDataFooter);
	}

	public ArScripCurrentDataFile(ArScrip arScrip) {
		ArDateTime updatedDateTime = ArDateTimeUtil.getCurrentArDateTime();
		this.arScripDataFileHeader = ArScripDataFileHeaderFactory.getArScripDataFileHeader(arScrip, updatedDateTime, ArScripDataFileEnum.CURRENT_DATA_FILE);
		this.arScripDataFileFooter = ArScripDataFileFooterFactory.getArScripDataFileFooter(arScrip, ArScripDataFileEnum.CURRENT_DATA_FILE);
	}

	public static ArScripDataFile getArScripDataFile(ArScrip arScrip) {
		return new ArScripCurrentDataFile(arScrip);
	}

	public String toString(){
		return "Current Data File Header: "+this.arScripDataFileHeader +",\nCurrent Data File Footer: "+this.arScripDataFileFooter;
	}
}
