package com.arsoft.projects.common.business.market.entities;

import com.arsoft.projects.common.business.entity.ArAmPmEnum;
import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.entity.ArMonthEnum;
import com.arsoft.projects.common.business.entity.ArTime;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.string.ArStringUtil;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripFileDataHeader {
	
	private String scrip;
	private ArDateTime createdDateTime;
	private ArDateTime updatedDateTime;
	private ArScripFileDataEnum arScripFileDataEnum;
	
	public String getScrip() {
		return scrip;
	}

	public void setScrip(String scrip) {
		this.scrip = scrip;
	}

	public ArDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(ArDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public ArDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(ArDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public ArScripFileDataEnum getArScripFileDataEnum() {
		return arScripFileDataEnum;
	}

	public void setArScripFileDataEnum(ArScripFileDataEnum arScripFileDataEnum) {
		this.arScripFileDataEnum = arScripFileDataEnum;
	}

	public ArScripFileDataHeader(){
		
	}
	
	public ArScripFileDataHeader(String scrip, ArDateTime createdDateTime, ArDateTime updatedDateTime, ArScripFileDataEnum arScripFileDataEnum){
		this.scrip = scrip;
		this.createdDateTime = createdDateTime;
		this.updatedDateTime = updatedDateTime;
		this.arScripFileDataEnum = arScripFileDataEnum;
	}
	
	public static String getArScripFileDataHeaderAsString(ArScripFileDataHeader arScripFileDataHeader){
		return arScripFileDataHeader.getScrip() + ArStringConstant.DOUBLE_PIPE + ArScripFileData.getScripDataFileName(arScripFileDataHeader.getScrip(), arScripFileDataHeader.getCreatedDateTime(), arScripFileDataHeader.getArScripFileDataEnum()) + ArStringConstant.DOUBLE_PIPE + arScripFileDataHeader.getArScripFileDataEnum().getFileType() + ArStringConstant.DOUBLE_PIPE + ArDateTimeUtil.getUnderScoredDate(arScripFileDataHeader.getCreatedDateTime().getArDate()) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(arScripFileDataHeader.getCreatedDateTime().getArTime()) + ArStringConstant.DOUBLE_PIPE + ArDateTimeUtil.getUnderScoredDate(arScripFileDataHeader.getUpdatedDateTime().getArDate()) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(arScripFileDataHeader.getUpdatedDateTime().getArTime());
	}
	
	/**
	 * Returns the ArScripFileDataHeader object corresponding to the given String
	 * @param headerString The header in string format
	 * @return
	 * @throws ArException 
	 */
	public static ArScripFileDataHeader getArScripFileDataHeader(String headerString) throws ArException{
		ArScripFileDataHeader arScripFileDataHeader = new ArScripFileDataHeader();
		String[] parts = ArStringUtil.splitString(headerString, ArStringConstant.DOUBLE_PIPE);
        if (parts == null || parts.length != 5){
        	throw new ArException("ArScripFileDataHeader: Invalid Header String");
        }
        
        arScripFileDataHeader.setScrip(parts[0]);
        arScripFileDataHeader.setArScripFileDataEnum(ArScripFileDataEnum.getArScripFileDataEnumByFileType(parts[2]));
        
        String[] createdDateArray = ArStringUtil.splitString(parts[3], ArStringConstant.AT_THE_RATE);
        if (createdDateArray == null || createdDateArray.length != 2){
        	throw new ArException("ArScripFileDataHeader: Invalid Created Date Format in Header String");
        }
        String[] createdDateArraySplitted = ArStringUtil.splitString(createdDateArray[0], ArStringConstant.UNDERSCORE);
        if (createdDateArraySplitted == null || createdDateArraySplitted.length != 3){
        	throw new ArException("ArScripFileDataHeader: Invalid Created Date Date Format in Header String");
        }
        int day = Integer.parseInt(createdDateArraySplitted[0]);
        String monthString = createdDateArraySplitted[1];
        if(monthString.startsWith("0")) {
        	monthString = monthString.substring(1);
        }
        ArMonthEnum month = ArMonthEnum.getArMonthEnum(monthString);
		int year = Integer.parseInt(createdDateArraySplitted[2]);
		ArDate arDate = new ArDate(day, month, year);
        String[] createdTimeArraySplitted = ArStringUtil.splitString(createdDateArray[1], ArStringConstant.UNDERSCORE);
        if (createdTimeArraySplitted == null || createdDateArraySplitted.length != 3){
        	throw new ArException("ArScripFileDataHeader: Invalid Created Date Time Format in Header String");
        }
        int hour = Integer.parseInt(createdTimeArraySplitted[0]);
		int minute = Integer.parseInt(createdTimeArraySplitted[1]);
		int second = Integer.parseInt(createdTimeArraySplitted[2]);
		ArAmPmEnum amPm = hour < 12 ? ArAmPmEnum.AM: ArAmPmEnum.PM;
		ArTime arTime = new ArTime(hour, minute, second, amPm);
		ArDateTime createdDateTime = new ArDateTime();
        createdDateTime.setArDate(arDate);
        createdDateTime.setArTime(arTime);
        arScripFileDataHeader.setCreatedDateTime(createdDateTime);
        
        String[] updatedDateArray = ArStringUtil.splitString(parts[4], ArStringConstant.AT_THE_RATE);
        if (updatedDateArray == null || updatedDateArray.length != 2){
        	throw new ArException("ArScripFileDataHeader: Invalid Updated Date Format in Header String");
        }
        String[] updatedDateArraySplitted = ArStringUtil.splitString(updatedDateArray[0], ArStringConstant.UNDERSCORE);
        if (updatedDateArraySplitted == null || updatedDateArraySplitted.length != 3){
        	throw new ArException("ArScripFileDataHeader: Invalid Updated Date Date Format in Header String");
        }
        day = Integer.parseInt(updatedDateArraySplitted[0]);
        monthString = createdDateArraySplitted[1];
        if(monthString.startsWith("0")) {
        	monthString = monthString.substring(1);
        }
        month = ArMonthEnum.getArMonthEnum(monthString);
		year = Integer.parseInt(updatedDateArraySplitted[2]);
		arDate = new ArDate(day, month, year);
        String[] updatedTimeArraySplitted = ArStringUtil.splitString(updatedDateArray[1], ArStringConstant.UNDERSCORE);
        if (updatedTimeArraySplitted == null || updatedTimeArraySplitted.length != 3){
        	throw new ArException("ArScripFileDataHeader: Invalid Updated Date Time Format in Header String");
        }
        hour = Integer.parseInt(updatedTimeArraySplitted[0]);
		minute = Integer.parseInt(updatedTimeArraySplitted[1]);
		second = Integer.parseInt(updatedTimeArraySplitted[2]);
		amPm = hour < 12 ? ArAmPmEnum.AM: ArAmPmEnum.PM;
		arTime = new ArTime(hour, minute, second, amPm);
        ArDateTime updatedDateTime = new ArDateTime();
        updatedDateTime.setArDate(arDate);
        updatedDateTime.setArTime(arTime);
        arScripFileDataHeader.setUpdatedDateTime(updatedDateTime);
       
        return arScripFileDataHeader;
	}
}
