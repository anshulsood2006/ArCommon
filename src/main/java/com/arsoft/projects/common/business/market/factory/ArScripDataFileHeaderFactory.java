package com.arsoft.projects.common.business.market.factory;

import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;

public class ArScripDataFileHeaderFactory {
	

	
	public static ArScripDataFileHeader getArScripDataFileHeader(ArScrip arScrip, ArDateTime updatedDateTime, ArScripDataFileEnum arScripDataFileEnum) {
		return ArScripDataFileHeader.getArScripDataFileHeader(arScrip, updatedDateTime, arScripDataFileEnum);
	}
	
}
