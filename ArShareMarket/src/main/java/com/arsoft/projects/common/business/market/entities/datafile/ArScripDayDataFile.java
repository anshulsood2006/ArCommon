package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.business.market.factory.ArScripDataFileFooterFactory;
import com.arsoft.projects.common.business.market.factory.ArScripDataFileHeaderFactory;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripDayDataFile extends ArScripDataFile{

	public ArScripDayDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		super(arScripDataFileHeader, arScripFileDataFooter);
	}

	public ArScripDayDataFile(ArScrip arScrip) {
		ArDateTime updatedDateTime = ArDateTimeUtil.getCurrentArDateTime();
		this.arScripDataFileHeader = ArScripDataFileHeaderFactory.getArScripDataFileHeader(arScrip, updatedDateTime, ArScripDataFileEnum.DAY_DATA_FILE);
		this.arScripDataFileFooter = ArScripDataFileFooterFactory.getArScripDataFileFooter(arScrip, ArScripDataFileEnum.DAY_DATA_FILE);
	
	}

	public static ArScripDataFile getArScripDataFile(ArScrip arScrip) {
		return new ArScripDayDataFile(arScrip);
	}
	
	public String toString(){
		return "Day Data File Header: "+this.arScripDataFileHeader +",\nDay Data File Footer: "+this.arScripDataFileFooter;
	}
}
