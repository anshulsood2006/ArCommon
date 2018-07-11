package com.arsoft.projects.common.business.market.factory;

import java.text.ParseException;

import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.utility.datatime.ArCalendarUtil;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripDataFileHeaderFactory {
	
	/**
	 * Returns the file header in the below format
	 * SCRIP||FILENAME||FILETYPE||CREATEDTIMESTAMP||LASTUPDATEDTIMESTAMP
	 * e.g. SBIN|SBIN_Current_Data_05_07_2018|Current Data|05_07_2018@12_08_56|05_07_2018@14_22_33
	 * @param scrip
	 * @param createdDateTime
	 * @param updatedDateTime
	 * @param fileType
	 * @return
	 * @throws ParseException 
	 */	
	public static String getArScripFileDataHeaderAsString(ArScrip arScrip, ArDateTime updatedDateTime, ArScripDataFileEnum arScripDataFileEnum) throws ParseException{
		return arScrip.getName() + ArStringConstant.DOUBLE_PIPE + getScripDataFileName(arScrip, arScripDataFileEnum) + ArStringConstant.DOUBLE_PIPE + arScripDataFileEnum.getFileType() + ArStringConstant.DOUBLE_PIPE + ArDateTimeUtil.getUnderScoredDate(arScrip.getTimeOfRecord().getArDate()) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(arScrip.getTimeOfRecord().getArTime()) + ArStringConstant.DOUBLE_PIPE + ArDateTimeUtil.getUnderScoredDate(updatedDateTime.getArDate()) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(updatedDateTime.getArTime());
	}
	
	public static ArScripDataFileHeader getArScripDataFileHeader(ArScrip arScrip, ArDateTime updatedDateTime, ArScripDataFileEnum arScripDataFileEnum) {
		return ArScripDataFileHeader.getArScripDataFileHeader(arScrip, updatedDateTime, arScripDataFileEnum);
	}
	
	/**
	 * Returns the name of the file to be created. The format of the name is SCRIP_FILE_NAME_DD_MM_YYYY
	 * @param scrip
	 * @param createdDateTime
	 * @param arScripDataFileEnum
	 * @return name of the file to be created
	 * @throws ParseException 
	 * 
	 */
	public static final String getScripDataFileName(ArScrip arScrip, ArScripDataFileEnum arScripDataFileEnum) throws ParseException{
		ArDate date = arScrip.getTimeOfRecord().getArDate();
		String postFix = "";
		switch(arScripDataFileEnum){
			case MONTH_DATA_FILE:
				postFix = ArStringConstant.UNDERSCORE + date.getMonthAsString() + ArStringConstant.UNDERSCORE + date.getYear();
				break;
			case WEEK_DATA_FILE:
				postFix = ArStringConstant.UNDERSCORE + ArCalendarUtil.getCurrentWeekOfYear(date) + ArStringConstant.UNDERSCORE + date.getYear();
				break;
			case YEAR_DATA_FILE:
				postFix = ArStringConstant.UNDERSCORE + date.getYear();
				break;
			default:
				postFix = ArStringConstant.UNDERSCORE + date.getDayAsString() + ArStringConstant.UNDERSCORE + date.getMonthAsString() + ArStringConstant.UNDERSCORE + date.getYear();
				break;
		}
		return arScrip.getName() + ArStringConstant.UNDERSCORE + arScripDataFileEnum.getFileName() + postFix;
	}
}
