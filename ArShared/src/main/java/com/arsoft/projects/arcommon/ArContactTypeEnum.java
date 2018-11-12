package com.arsoft.projects.arcommon;

import java.util.ArrayList;
import java.util.List;

public enum ArContactTypeEnum {
	
	EMAIL("EMAIL"),
	MOBILE("MOBILE"),
	LANDLINE("LANDLINE");
	
	private String contactType;
	
	private ArContactTypeEnum(String contactType) {
		this.contactType = contactType;
	}
	
	public String getValue() {
		return this.contactType;
	}
	
	public static List<ArContactTypeEnum> getAllContactType() {
		List<ArContactTypeEnum> arContactTypeEnums  = null;
		for (ArContactTypeEnum arContactTypeEnum : ArContactTypeEnum.values()) {
			if (arContactTypeEnums == null) {
				arContactTypeEnums = new ArrayList<>();
			}
			arContactTypeEnums.add(arContactTypeEnum);
		}
		return arContactTypeEnums;
	}
	
	public static boolean isHavingEnum(String enumName) { 
		for (ArContactTypeEnum ArContactTypeEnum : ArContactTypeEnum.values()) {
	        if (ArContactTypeEnum.name().equals(enumName)) {
	            return true;
	        }
	    }
		return false;
	}
	
	public static boolean isHavingEnumValue(String enumValue) { 
		for (ArContactTypeEnum arContactTypeEnum : ArContactTypeEnum.values()) {
			if (enumValue == null && arContactTypeEnum.getValue() == null) {
				return true;
			}
			if(arContactTypeEnum.getValue() == null || enumValue == null) {
				continue;
			}
	        if (arContactTypeEnum.getValue().toLowerCase().equals(enumValue.toLowerCase())) {
	            return true;
	        }
	    }
		return false;
	}
}
