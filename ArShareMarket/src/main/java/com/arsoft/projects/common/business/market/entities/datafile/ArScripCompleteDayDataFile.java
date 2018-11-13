package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.arshared.ArDateTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.business.market.factory.ArScripDataFileFooterFactory;
import com.arsoft.projects.common.business.market.factory.ArScripDataFileHeaderFactory;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripCompleteDayDataFile extends ArScripDataFile{

	public ArScripCompleteDayDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		super(arScripDataFileHeader, arScripFileDataFooter);
	}
	
	public ArScripCompleteDayDataFile(ArScrip arScrip) {
		ArDateTime updatedDateTime = ArDateTimeUtil.getCurrentArDateTime();
		this.arScripDataFileHeader = ArScripDataFileHeaderFactory.getArScripDataFileHeader(arScrip, updatedDateTime, ArScripDataFileEnum.COMPLETE_DAY_DATE_FILE);
		this.arScripDataFileFooter = ArScripDataFileFooterFactory.getArScripDataFileFooter(arScrip, ArScripDataFileEnum.COMPLETE_DAY_DATE_FILE);
	}
	
	public static ArScripCompleteDayDataFile getArScripDataFile(ArScrip arScrip) {
		return new ArScripCompleteDayDataFile(arScrip);
	}
	
	public String toString(){
		return "Complete Day Data File Header: "+this.arScripDataFileHeader +",\nComplete Day Data File Footer: "+this.arScripDataFileFooter;
	}
	
}
