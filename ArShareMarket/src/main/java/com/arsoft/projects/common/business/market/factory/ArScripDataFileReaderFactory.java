package com.arsoft.projects.common.business.market.factory;

import java.text.ParseException;

import com.arsoft.projects.arshared.ArDateTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.datafile.reader.ArScripCompleteDayDataFileReader;
import com.arsoft.projects.common.business.market.entities.datafile.reader.ArScripCurrentDataFileReader;
import com.arsoft.projects.common.business.market.entities.datafile.reader.ArScripDayDataFileReader;
import com.arsoft.projects.common.business.market.entities.datafile.reader.ArScripMonthDataFileReader;
import com.arsoft.projects.common.business.market.entities.datafile.reader.ArScripWeekDataFileReader;
import com.arsoft.projects.common.business.market.entities.datafile.reader.ArScripYearDataFileReader;
import com.arsoft.projects.common.business.market.interfaces.ArScripDataFileReader_IF;

public class ArScripDataFileReaderFactory {

	public static String getArScripFileDataFooterAsString(String scrip, ArDateTime createdDateTime, ArDateTime updatedDateTime, ArScripDataFileEnum arScripDataFileEnum) throws ParseException{
		return null;
	}
	
	public static ArScripDataFileReader_IF getArScripDataFileReader(ArScripDataFileEnum arScripDataFileEnum) {
		switch(arScripDataFileEnum){
		case MONTH_DATA_FILE:
			return ArScripMonthDataFileReader.getArScripDataReader();
		case WEEK_DATA_FILE:
			return ArScripWeekDataFileReader.getArScripDataReader();
		case YEAR_DATA_FILE:
			return ArScripYearDataFileReader.getArScripDataReader();
		case DAY_DATA_FILE:
			return ArScripDayDataFileReader.getArScripDataReader();
		case CURRENT_DATA_FILE:
			return ArScripCurrentDataFileReader.getArScripDataReader();
		case COMPLETE_DAY_DATE_FILE:
			return ArScripCompleteDayDataFileReader.getArScripDataReader();
		default:
			return null;
		}
	}	
}
