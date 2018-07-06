package com.arsoft.projects.common.business.market.factory;

import java.text.ParseException;

import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.market.entities.ArScripFileData;
import com.arsoft.projects.common.business.market.entities.ArScripFileDataEnum;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripFileDataHeaderFactory {
	
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
	public static String getHeader(String scrip, ArDateTime createdDateTime, ArDateTime updatedDateTime, ArScripFileDataEnum arScripFileDataEnum) throws ParseException{
		return scrip + ArStringConstant.DOUBLE_PIPE + ArScripFileData.getScripDataFileName(scrip, createdDateTime, arScripFileDataEnum) + ArStringConstant.DOUBLE_PIPE + arScripFileDataEnum.getFileType() + ArStringConstant.DOUBLE_PIPE + ArDateTimeUtil.getUnderScoredDate(createdDateTime.getArDate()) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(createdDateTime.getArTime()) + ArStringConstant.DOUBLE_PIPE + ArDateTimeUtil.getUnderScoredDate(updatedDateTime.getArDate()) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(updatedDateTime.getArTime());
	}
}
