package com.arsoft.projects.common.business.market.factory;

import java.text.ParseException;

import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripCompleteDayDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripCurrentDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDayDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripMonthDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripWeekDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripYearDataFileFooter;

public class ArScripDataFileFooterFactory {

	public static String getArScripFileDataFooterAsString(String scrip, ArDateTime createdDateTime, ArDateTime updatedDateTime, ArScripDataFileEnum arScripDataFileEnum) throws ParseException{
		return null;
	}
	
	public static ArScripDataFileFooter getArScripDataFileFooter(ArScrip scrip, ArDateTime createdDateTime, ArDateTime updatedDateTime, ArScripDataFileEnum arScripDataFileEnum) {
		switch(arScripDataFileEnum){
		case MONTH_DATA_FILE:
			return new ArScripMonthDataFileFooter(scrip);
		case WEEK_DATA_FILE:
			return new ArScripWeekDataFileFooter(scrip);
		case YEAR_DATA_FILE:
			return new ArScripYearDataFileFooter(scrip);
		case DAY_DATA_FILE:
			return new ArScripDayDataFileFooter(scrip);
		case CURRENT_DATA_FILE:
			return new ArScripCurrentDataFileFooter(scrip);
		case COMPLETE_DAY_DATE_FILE:
			return new ArScripCompleteDayDataFileFooter(scrip);
		default:
			return null;
		}
	}

	
}
