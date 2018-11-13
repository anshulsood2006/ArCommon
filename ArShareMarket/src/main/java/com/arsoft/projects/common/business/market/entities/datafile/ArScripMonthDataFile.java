package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.arshared.ArDateTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.business.market.factory.ArScripDataFileFooterFactory;
import com.arsoft.projects.common.business.market.factory.ArScripDataFileHeaderFactory;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripMonthDataFile extends ArScripDataFile{

	public ArScripMonthDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		super(arScripDataFileHeader, arScripFileDataFooter);
	}
	
	public ArScripMonthDataFile(ArScrip arScrip) {
		ArDateTime updatedDateTime = ArDateTimeUtil.getCurrentArDateTime();
		this.arScripDataFileHeader = ArScripDataFileHeaderFactory.getArScripDataFileHeader(arScrip, updatedDateTime, ArScripDataFileEnum.MONTH_DATA_FILE);
		this.arScripDataFileFooter = ArScripDataFileFooterFactory.getArScripDataFileFooter(arScrip, ArScripDataFileEnum.MONTH_DATA_FILE);
	
	}

	public static ArScripDataFile getArScripDataFile(ArScrip arScrip) {
		return new ArScripMonthDataFile(arScrip);
	}
	
	public String toString(){
		return "Month Data File Header: "+this.arScripDataFileHeader +",\nMonth Data File Footer: "+this.arScripDataFileFooter;
	}

}
