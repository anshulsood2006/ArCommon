package com.arsoft.projects.common.business.market.entities.datafile.header;

import com.arsoft.projects.common.business.entity.ArAmPmEnum;
import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.entity.ArMonthEnum;
import com.arsoft.projects.common.business.entity.ArTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.equity.ArBourse;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.string.ArStringUtil;

public class ArScripDataFileHeader {
	
	private ArScrip arScrip;
	private ArDateTime updatedDateTime;
	private ArScripDataFileEnum arScripDataFileEnum;
	
	public ArScrip getArScrip() {
		return arScrip;
	}

	public void setArScrip(ArScrip arScrip) {
		this.arScrip = arScrip;
	}

	public ArDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(ArDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public ArScripDataFileEnum getArScripDataFileEnum() {
		return arScripDataFileEnum;
	}

	public void setArScripFileDataEnum(ArScripDataFileEnum arScripDataFileEnum) {
		this.arScripDataFileEnum = arScripDataFileEnum;
	}

	public ArScripDataFileHeader(){
		
	}
	
	public static ArScripDataFileHeader getArScripDataFileHeader(){
		return new ArScripDataFileHeader();
	}
	
	public ArScripDataFileHeader(ArScrip arScrip, ArDateTime updatedDateTime, ArScripDataFileEnum arScripDataFileEnum){
		this.arScrip = arScrip;
		this.updatedDateTime = updatedDateTime;
		this.arScripDataFileEnum = arScripDataFileEnum;
	}
	
	/**
	 * 
	 * @param scrip
	 * @param createdDateTime
	 * @param updatedDateTime
	 * @param arScripFileDataEnum
	 * @return
	 */
	public static ArScripDataFileHeader getArScripDataFileHeader(ArScrip arScrip, ArDateTime updatedDateTime, ArScripDataFileEnum arScripFileDataEnum){
		return new ArScripDataFileHeader(arScrip, updatedDateTime, arScripFileDataEnum);
	}
	
	/**
	 * Returns the ArScripDataFileHeader object corresponding to the given headerString
	 * @param headerString The header in string format
	 * @return
	 * @throws ArException 
	 */
	public static ArScripDataFileHeader getArScripDataFileHeader(String headerString) throws ArException{
		if (headerString == null || headerString.length() == 0){
        	throw new ArException("ArScripDataFileHeader: Null Header String");
        }
		
		ArScripDataFileHeader arScripDataFileHeader = new ArScripDataFileHeader();
		String[] parts = ArStringUtil.splitString(headerString, ArStringConstant.DOUBLE_PIPE);
        if (parts == null || parts.length != 5){
        	throw new ArException("ArScripDataFileHeader: Invalid Header String");
        }
        
        String name = parts[0];
        
        arScripDataFileHeader.setArScripFileDataEnum(ArScripDataFileEnum.getArScripFileDataEnumByFileType(parts[2]));
        
        String[] createdDateArray = ArStringUtil.splitString(parts[3], ArStringConstant.AT_THE_RATE);
        if (createdDateArray == null || createdDateArray.length != 2){
        	throw new ArException("ArScripDataFileHeader: Invalid Created Date Format in Header String");
        }
        String[] createdDateArraySplitted = ArStringUtil.splitString(createdDateArray[0], ArStringConstant.UNDERSCORE);
        if (createdDateArraySplitted == null || createdDateArraySplitted.length != 3){
        	throw new ArException("ArScripDataFileHeader: Invalid Created Date Date Format in Header String");
        }
        int day = Integer.parseInt(createdDateArraySplitted[0]);
        String monthString = createdDateArraySplitted[1];
        if(monthString.startsWith("0")) {
        	monthString = monthString.substring(1);
        }
        ArMonthEnum month = ArMonthEnum.getArMonthEnum(monthString);
		int year = Integer.parseInt(createdDateArraySplitted[2]);
		ArDate arDate = ArDate.getArDate(day, month, year);
        String[] createdTimeArraySplitted = ArStringUtil.splitString(createdDateArray[1], ArStringConstant.UNDERSCORE);
        if (createdTimeArraySplitted == null || createdDateArraySplitted.length != 3){
        	throw new ArException("ArScripDataFileHeader: Invalid Created Date Time Format in Header String");
        }
        int hour = Integer.parseInt(createdTimeArraySplitted[0]);
		int minute = Integer.parseInt(createdTimeArraySplitted[1]);
		int second = Integer.parseInt(createdTimeArraySplitted[2]);
		ArAmPmEnum amPm = hour < 12 ? ArAmPmEnum.AM: ArAmPmEnum.PM;
		ArTime arTime = ArTime.getArTime(hour, minute, second, amPm);
		ArDateTime createdDateTime = ArDateTime.getArDateTime();
        createdDateTime.setArDate(arDate);
        createdDateTime.setArTime(arTime);
        ArScrip arScrip = new ArScrip(name, name, ArBourse.NSE, 0, createdDateTime);
        arScripDataFileHeader.setArScrip(arScrip);
        
        String[] updatedDateArray = ArStringUtil.splitString(parts[4], ArStringConstant.AT_THE_RATE);
        if (updatedDateArray == null || updatedDateArray.length != 2){
        	throw new ArException("ArScripDataFileHeader: Invalid Updated Date Format in Header String");
        }
        String[] updatedDateArraySplitted = ArStringUtil.splitString(updatedDateArray[0], ArStringConstant.UNDERSCORE);
        if (updatedDateArraySplitted == null || updatedDateArraySplitted.length != 3){
        	throw new ArException("ArScripDataFileHeader: Invalid Updated Date Date Format in Header String");
        }
        day = Integer.parseInt(updatedDateArraySplitted[0]);
        monthString = createdDateArraySplitted[1];
        if(monthString.startsWith("0")) {
        	monthString = monthString.substring(1);
        }
        month = ArMonthEnum.getArMonthEnum(monthString);
		year = Integer.parseInt(updatedDateArraySplitted[2]);
		arDate = ArDate.getArDate(day, month, year);
        String[] updatedTimeArraySplitted = ArStringUtil.splitString(updatedDateArray[1], ArStringConstant.UNDERSCORE);
        if (updatedTimeArraySplitted == null || updatedTimeArraySplitted.length != 3){
        	throw new ArException("ArScripDataFileHeader: Invalid Updated Date Time Format in Header String");
        }
        hour = Integer.parseInt(updatedTimeArraySplitted[0]);
		minute = Integer.parseInt(updatedTimeArraySplitted[1]);
		second = Integer.parseInt(updatedTimeArraySplitted[2]);
		amPm = hour < 12 ? ArAmPmEnum.AM: ArAmPmEnum.PM;
		arTime = ArTime.getArTime(hour, minute, second, amPm);
        ArDateTime updatedDateTime = ArDateTime.getArDateTime();
        updatedDateTime.setArDate(arDate);
        updatedDateTime.setArTime(arTime);
        arScripDataFileHeader.setUpdatedDateTime(updatedDateTime);
       
        return arScripDataFileHeader;
	}
	
	public String toString() {
		return "Scrip: "+this.getArScrip()+", Updated Time: "+this.getUpdatedDateTime()+", : "+this.getArScripDataFileEnum();
	}
}
