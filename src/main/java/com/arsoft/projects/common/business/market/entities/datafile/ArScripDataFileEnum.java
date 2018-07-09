package com.arsoft.projects.common.business.market.entities.datafile;

import java.util.ArrayList;
import java.util.List;

public enum ArScripDataFileEnum {
	
	
	DAY_DATA_FILE("Day Data","Day_Data"),
	WEEK_DATA_FILE("Week Data","Week_Data"),
	MONTH_DATA_FILE("Month Data","Month_Data"),
	YEAR_DATA_FILE("Year Data","Year_Data"),
	CURRENT_DATA_FILE("Current Data","Current_Data"),
	COMPLETE_DAY_DATE_FILE("Complete Day Data","Complete_Day_Data");
	
	private String fileType;
	private String fileName;
	
	private ArScripDataFileEnum(String fileType, String fileName) {
		this.fileType = fileType;
		this.fileName = fileName;
	}
	
	public String getFileType() {
		return this.fileType;
	}	
	
	public String getFileName() {
		return this.fileName;
	}
	
	public static List<ArScripDataFileEnum> getAllArScripDataFileEnum() {
		List<ArScripDataFileEnum> ArScripFileDataEnums  = null;
		for (ArScripDataFileEnum ArScripFileDataEnum : ArScripDataFileEnum.values()) {
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
		for (ArScripDataFileEnum ArScripFileDataEnum : ArScripDataFileEnum.values()) {
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
		for (ArScripDataFileEnum ArScripFileDataEnum : ArScripDataFileEnum.values()) {
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
		for (ArScripDataFileEnum arScripFileDataEnum : ArScripDataFileEnum.values()) {
			if (fileName == null && arScripFileDataEnum.getFileName() == null) {
				return true;
			}
			if(arScripFileDataEnum.getFileName() == null || fileName == null) {
				continue;
			}
	        if (arScripFileDataEnum.getFileName().toLowerCase().equals(fileName.toLowerCase())) {
	            return true;
	        }
	    }
		return false;
	}
	
	/**
	 * Returns the ArScripFileDataEnum corresponding to the given fileType
	 * @param fileType
	 * @return the ArScripFileDataEnum corresponding to the given fileType
	 */
	public static ArScripDataFileEnum getArScripFileDataEnumByFileType(String fileType) {
		for (ArScripDataFileEnum arScripFileDataEnum : ArScripDataFileEnum.values()) {
			if (fileType == null && arScripFileDataEnum.getFileType()== null) {
				return null;
			}
			if(arScripFileDataEnum.getFileType() == null || fileType == null) {
				continue;
			}
	        if (arScripFileDataEnum.getFileType().toLowerCase().equals(fileType.toLowerCase())) {
	            return arScripFileDataEnum;
	        }
	    }
		return null;
	}
	
	/**
	 * Returns the ArScripFileDataEnum corresponding to the given fileName
	 * @param fileName
	 * @return the ArScripFileDataEnum corresponding to the given fileName
	 */
	public static ArScripDataFileEnum getArScripFileDataEnumByFileName(String fileName) {
		for (ArScripDataFileEnum arScripFileDataEnum : ArScripDataFileEnum.values()) {
			if (fileName == null && arScripFileDataEnum.getFileName()== null) {
				return null;
			}
			if(arScripFileDataEnum.getFileName() == null || fileName == null) {
				continue;
			}
	        if (arScripFileDataEnum.getFileName().toLowerCase().equals(fileName.toLowerCase())) {
	            return arScripFileDataEnum;
	        }
	    }
		return null;
	}
		
}
