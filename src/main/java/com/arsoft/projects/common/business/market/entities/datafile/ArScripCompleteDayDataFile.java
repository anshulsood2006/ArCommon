package com.arsoft.projects.common.business.market.entities.datafile;

import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripCompleteDayDataFile extends ArScripDataFile{

	public ArScripCompleteDayDataFile(ArScripDataFileHeader arScripDataFileHeader, ArScripDataFileFooter arScripFileDataFooter) {
		super(arScripDataFileHeader, arScripFileDataFooter);
	}
	
	public ArScripCompleteDayDataFile() {
		ArDateTime arDateTime = ArDateTimeUtil.getCurrentArDateTime();
	}
	
	public static ArScripCompleteDayDataFile getArScripDataFile() {
		return new ArScripCompleteDayDataFile();
	}
	
}
