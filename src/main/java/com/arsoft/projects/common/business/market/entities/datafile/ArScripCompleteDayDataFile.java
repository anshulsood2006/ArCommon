package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.business.market.factory.ArScripDataFileHeaderFactory;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripCompleteDayDataFile extends ArScripDataFile{

	public ArScripCompleteDayDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		super(arScripDataFileHeader, arScripFileDataFooter);
	}
	
	public ArScripCompleteDayDataFile(ArScrip arScrip) {
		ArDateTime arDateTime = ArDateTimeUtil.getCurrentArDateTime();
		this.arScripDataFileHeader = ArScripDataFileHeaderFactory.getArScripDataFileHeader(arScrip.getName(), arScrip.getTimeOfRecord(), arDateTime, ArScripDataFileEnum.COMPLETE_DAY_DATE_FILE);
		//this.arScripDataFileHeader = ArScripDataFileFooterFactory.getArScripFileDataFooter(scrip, arScripDataFileEnum, arScripFileDataFooter);
	}
	
	public static ArScripCompleteDayDataFile getArScripDataFile(ArScrip arScrip) {
		return new ArScripCompleteDayDataFile(arScrip);
	}
	
}
