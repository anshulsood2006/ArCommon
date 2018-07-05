package com.arsoft.projects.common.business.market.entities;

import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.market.factory.ArScripFileDataHeaderFactory;
import com.arsoft.projects.common.string.ArStringConstant;

public abstract class ArScripFileData {
	
	private String header;
	private String scrip;
	private ArDateTime createdDateTime;
	private ArDateTime updatedDateTime;
	private ArScripFileDataEnum fileType;
	
	public ArScripFileData(String scrip, ArDateTime createdDateTime, ArDateTime updatedDateTime, ArScripFileDataEnum fileType) {
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
	 * 
	 */
	public static final String getScripDataFileName(String scrip, ArDateTime createdDateTime, ArScripFileDataEnum arScripFileDataEnum){
		ArDate date = createdDateTime.getArDate();
		return scrip + ArStringConstant.UNDERSCORE + arScripFileDataEnum.getFileName() + ArStringConstant.UNDERSCORE + date.getDayAsString() + ArStringConstant.UNDERSCORE + date.getMonthAsString() + ArStringConstant.UNDERSCORE + createdDateTime.getArDate().getYear();
	}
}
