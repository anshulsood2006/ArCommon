package com.arsoft.projects.common.business.market.factory;

import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.market.entities.ArScripFileDataEnum;
import com.arsoft.projects.common.business.market.entities.ArScripFileDataHeader;

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
	 */
	public static String getHeader(String scrip, ArDateTime createdDateTime, ArDateTime updatedDateTime, ArScripFileDataEnum arScripFileDataEnum) {
		ArScripFileDataHeader arScripFileDataHeader = new ArScripFileDataHeader(scrip, createdDateTime, updatedDateTime, arScripFileDataEnum);
		return ArScripFileDataHeader.getArScripFileDataHeaderAsString(arScripFileDataHeader);
	}
	
	
}
