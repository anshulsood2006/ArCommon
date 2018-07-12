package com.arsoft.projects.common.business.market.factory;

import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripCompleteDayDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripCurrentDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDayDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripMonthDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripWeekDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripYearDataFile;

public class ArScripDataFileFactory {

	public static ArScripDataFile getArScripDataFile(ArScrip arScrip, ArScripDataFileEnum arScripDataFileEnum) {
		switch(arScripDataFileEnum){
			case MONTH_DATA_FILE:
				return ArScripMonthDataFile.getArScripDataFile(arScrip);
			case WEEK_DATA_FILE:
				return ArScripWeekDataFile.getArScripDataFile(arScrip);
			case YEAR_DATA_FILE:
				return ArScripYearDataFile.getArScripDataFile(arScrip);
			case DAY_DATA_FILE:
				return ArScripDayDataFile.getArScripDataFile(arScrip);
			case CURRENT_DATA_FILE:
				return ArScripCurrentDataFile.getArScripDataFile(arScrip);
			case COMPLETE_DAY_DATE_FILE:
				return ArScripCompleteDayDataFile.getArScripDataFile(arScrip);
			default:
				return null;
		}
	}
	
}
