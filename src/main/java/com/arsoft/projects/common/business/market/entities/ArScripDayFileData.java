package com.arsoft.projects.common.business.market.entities;

import java.text.ParseException;

import com.arsoft.projects.common.business.entity.ArDateTime;

public class ArScripDayFileData extends ArScripFileData{

	public ArScripDayFileData(String scrip, ArDateTime createdDateTime, ArDateTime updatedDateTime, ArScripFileDataEnum fileName) throws ParseException {
		super(scrip, createdDateTime, updatedDateTime, fileName);
	}
	
	
}
