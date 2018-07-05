package com.arsoft.projects.common.business.market.entities;

import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.string.ArStringConstant;
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
	
	public String toString(){
		return scrip + ArStringConstant.DOUBLE_PIPE + ArScripFileData.getScripDataFileName(scrip, createdDateTime, arScripFileDataEnum) + ArStringConstant.DOUBLE_PIPE + arScripFileDataEnum.getFileType() + ArStringConstant.DOUBLE_PIPE + ArDateTimeUtil.getUnderScoredDate(createdDateTime.getDate()) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(createdDateTime.getTime()) + ArStringConstant.DOUBLE_PIPE + ArDateTimeUtil.getUnderScoredDate(updatedDateTime.getDate()) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(updatedDateTime.getTime());
	}
	
	/**
	 * Returns the ArScripFileDataHeader object corresponding to the given String
	 * @param headerString The header in string format
	 * @return
	 */
	public static ArScripFileDataHeader getArScripFileDataHeader(String headerString){
		ArScripFileDataHeader arScripFileDataHeader = new ArScripFileDataHeader();
		return arScripFileDataHeader;
	}
}
