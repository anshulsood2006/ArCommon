package com.arsoft.projects.common.business.market.factory;

import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.datafile.writer.ArScripCompleteDayDataFileWriter;
import com.arsoft.projects.common.business.market.entities.datafile.writer.ArScripCurrentDataFileWriter;
import com.arsoft.projects.common.business.market.entities.datafile.writer.ArScripDayDataFileWriter;
import com.arsoft.projects.common.business.market.entities.datafile.writer.ArScripMonthDataFileWriter;
import com.arsoft.projects.common.business.market.entities.datafile.writer.ArScripWeekDataFileWriter;
import com.arsoft.projects.common.business.market.entities.datafile.writer.ArScripYearDataFileWriter;
import com.arsoft.projects.common.business.market.interfaces.ArScripDataFileWriter_IF;

public class ArScripDataFileWriterFactory {
	
	public static ArScripDataFileWriter_IF getArScripDataFileWriter(ArScripDataFileEnum arScripDataFileEnum) {
		switch(arScripDataFileEnum){
		case MONTH_DATA_FILE:
			return ArScripMonthDataFileWriter.getArScripDataWriter();
		case WEEK_DATA_FILE:
			return ArScripWeekDataFileWriter.getArScripDataWriter();
		case YEAR_DATA_FILE:
			return ArScripYearDataFileWriter.getArScripDataWriter();
		case DAY_DATA_FILE:
			return ArScripDayDataFileWriter.getArScripDataWriter();
		case CURRENT_DATA_FILE:
			return ArScripCurrentDataFileWriter.getArScripDataWriter();
		case COMPLETE_DAY_DATE_FILE:
			return ArScripCompleteDayDataFileWriter.getArScripDataWriter();
		default:
			return null;
		}
	}	
}
