package com.arsoft.projects.common.business.market.entities;

import java.text.ParseException;

import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.market.factory.ArScripFileDataHeaderFactory;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.utility.datatime.ArCalendarUtil;

public abstract class ArScripFileData {
	
	private String header;
	private String scrip;
	private ArDateTime createdDateTime;
	private ArDateTime updatedDateTime;
	private ArScripFileDataEnum fileType;
	
	public ArScripFileData(String scrip, ArDateTime createdDateTime, ArDateTime updatedDateTime, ArScripFileDataEnum fileType) throws ParseException {
		this.scrip = scrip;
		this.createdDateTime = createdDateTime;
		this.updatedDateTime = updatedDateTime;
		this.fileType = fileType;
		this.header = ArScripFileDataHeaderFactory.getHeader(scrip, createdDateTime, updatedDateTime, fileType);
	}
	
	/**
	 * Returns the name of the file to be created. The format of the name is SCRIP_FILE_NAME_DD_MM_YYYY
	 * @param scrip
	 * @param createdDateTime
	 * @param arScripFileDataEnum
	 * @return name of the file to be created
	 * @throws ParseException 
	 * 
	 */
	public static final String getScripDataFileName(String scrip, ArDateTime createdDateTime, ArScripFileDataEnum arScripFileDataEnum) throws ParseException{
		ArDate date = createdDateTime.getArDate();
		String postFix = "";
		switch(arScripFileDataEnum){
			case FILE_MONTH_DATA:
				postFix = ArStringConstant.UNDERSCORE + date.getMonthAsString() + ArStringConstant.UNDERSCORE + createdDateTime.getArDate().getYear();
				break;
			case FILE_WEEK_DATA:
				postFix = ArStringConstant.UNDERSCORE + ArCalendarUtil.getCurrentWeekOfYear(createdDateTime.getArDate()) + ArStringConstant.UNDERSCORE + createdDateTime.getArDate().getYear();
				break;
			case FILE_YEAR_DATA:
				postFix = ArStringConstant.UNDERSCORE + createdDateTime.getArDate().getYear();
				break;
			default:
				postFix = ArStringConstant.UNDERSCORE + date.getDayAsString() + ArStringConstant.UNDERSCORE + date.getMonthAsString() + ArStringConstant.UNDERSCORE + createdDateTime.getArDate().getYear();
				break;
		}
		return scrip + ArStringConstant.UNDERSCORE + arScripFileDataEnum.getFileName() + postFix;
	}
}
