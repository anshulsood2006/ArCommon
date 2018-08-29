package com.arsoft.projects.common.business.market.service;

import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripCompleteDayDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripCurrentDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDayDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripMonthDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripWeekDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripYearDataFile;
import com.arsoft.projects.common.business.market.interfaces.ArScripDataFileCreator_IF;

public class ArScripDataFileCreator implements ArScripDataFileCreator_IF{
	
	public ArScripDataFile createArScripCompleteDayDataFile(ArScrip arScrip) {
		ArScripDataFile arScripDataFile = ArScripCompleteDayDataFile.getArScripDataFile(arScrip);
		return arScripDataFile;
	}
	
	public ArScripDataFile createArScripCurrentDataFile(ArScrip arScrip) {
		ArScripDataFile arScripDataFile = ArScripCurrentDataFile.getArScripDataFile(arScrip);
		return arScripDataFile;
	}
	
	public ArScripDataFile createArScripDayDataFile(ArScrip arScrip) {
		ArScripDataFile arScripDataFile = ArScripDayDataFile.getArScripDataFile(arScrip);
		return arScripDataFile;
	}
	
	public ArScripDataFile createArScripMonthDataFile(ArScrip arScrip) {
		ArScripDataFile arScripDataFile = ArScripMonthDataFile.getArScripDataFile(arScrip);
		return arScripDataFile;
	}
	
	public ArScripDataFile createArScripWeekDataFile(ArScrip arScrip) {
		ArScripDataFile arScripDataFile = ArScripWeekDataFile.getArScripDataFile(arScrip);
		return arScripDataFile;
	}
	
	public ArScripDataFile createArScripYearDataFile(ArScrip arScrip) {
		ArScripDataFile arScripDataFile = ArScripYearDataFile.getArScripDataFile(arScrip);
		return arScripDataFile;
	}
	
}
