package com.arsoft.projects.common.business.market.entities;

import java.util.ArrayList;
import java.util.List;

public enum ArScripFileDataEnum {
	
	
	FILE_DAY_DATA("Day Data","Day_Data"),
	FILE_WEEK_DATA("Week Data","Week_Data"),
	FILE_MONTH_DATA("Month Data","Month_Data"),
	FILE_YEAR_DATA("Year Data","Year_Data"),
	FILE_CURRENT_DATA("Current Data","Current_Data"),
	FILE_DAY_DATA_COMPLETE("Complete Day Data","Complete_Day_Data");
	
	private String fileType;
	private String fileName;
	
	private ArScripFileDataEnum(String fileType, String fileName) {
		this.fileType = fileType;
		this.fileName = fileName;
	}
	
	public String getFileType() {
		return this.fileType;
	}	
	
	public String getFileName() {
		return this.fileName;
	}
	
	public static List<ArScripFileDataEnum> getAllArScripFileDataEnum() {
		List<ArScripFileDataEnum> ArScripFileDataEnums  = null;
		for (ArScripFileDataEnum ArScripFileDataEnum : ArScripFileDataEnum.values()) {
			if (ArScripFileDataEnums == null) {
				ArScripFileDataEnums = new ArrayList<>();
			}
			ArScripFileDataEnums.add(ArScripFileDataEnum);
		}
		return ArScripFileDataEnums;
	}
	
	/**
	 * Returns true if the given enum constant is present, else returns false
	 * @param enumName Name of the parameter to be searched for
	 * @return true if the given enum constant is present, else returns false
	 */
	public static boolean isHavingEnum(String enumName) { 
		for (ArScripFileDataEnum ArScripFileDataEnum : ArScripFileDataEnum.values()) {
	        if (ArScripFileDataEnum.name().equals(enumName)) {
	            return true;
	        }
	    }
		return false;
	}
	
	/**
	 * Returns true if the given fileType is present in the enum, else returns false
	 * @param fileType File Type to be searched for
	 * @return true if the given fileType is present in the enum, else returns false
	 */
	public static boolean isHavingFileType(String fileType) { 
		for (ArScripFileDataEnum ArScripFileDataEnum : ArScripFileDataEnum.values()) {
			if (fileType == null && ArScripFileDataEnum.getFileType() == null) {
				return true;
			}
			if(ArScripFileDataEnum.getFileType() == null || fileType == null) {
				continue;
			}
	        if (ArScripFileDataEnum.getFileType().toLowerCase().equals(fileType.toLowerCase())) {
	            return true;
	        }
	    }
		return false;
	}
	
	/**
	 * Returns true if the given fileName is present in the enum, else returns false
	 * @param fileName File Name to be searched for
	 * @return true if the given fileName is present in the enum, else returns false
	 */
	public static boolean isHavingFileName(String fileName) { 
		for (ArScripFileDataEnum ArScripFileDataEnum : ArScripFileDataEnum.values()) {
			if (fileName == null && ArScripFileDataEnum.getFileName() == null) {
				return true;
			}
			if(ArScripFileDataEnum.getFileName() == null || fileName == null) {
				continue;
			}
	        if (ArScripFileDataEnum.getFileName().toLowerCase().equals(fileName.toLowerCase())) {
	            return true;
	        }
	    }
		return false;
	}
		
}
