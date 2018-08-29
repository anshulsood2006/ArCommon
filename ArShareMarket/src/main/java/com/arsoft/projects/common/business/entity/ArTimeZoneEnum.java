package com.arsoft.projects.common.business.entity;

import java.util.ArrayList;
import java.util.List;

public enum ArTimeZoneEnum {
	IST("IST"),
	GMT("GMT");
	
	private String timeZone;
	
	private ArTimeZoneEnum(String timeZone) {
		this.timeZone = timeZone;
	}
	
	public String getValue() {
		return this.timeZone;
	}
	
	public static List<ArTimeZoneEnum> getAllArTimeZone() {
		List<ArTimeZoneEnum> arTimeZoneEnums  = null;
		for (ArTimeZoneEnum arTimeZoneEnum : ArTimeZoneEnum.values()) {
			if (arTimeZoneEnums == null) {
				arTimeZoneEnums = new ArrayList<>();
			}
			arTimeZoneEnums.add(arTimeZoneEnum);
		}
		return arTimeZoneEnums;
	}
	
	public static boolean isHavingEnum(String enumName) { 
		for (ArTimeZoneEnum arDayEnum : ArTimeZoneEnum.values()) {
	        if (arDayEnum.name().equals(enumName)) {
	            return true;
	        }
	    }
		return false;
	}
	
	public static boolean isHavingEnumValue(String enumValue) { 
		for (ArTimeZoneEnum arTimeZoneEnum : ArTimeZoneEnum.values()) {
			if (enumValue == null && arTimeZoneEnum.getValue() == null) {
				return true;
			}
			if(arTimeZoneEnum.getValue() == null || enumValue == null) {
				continue;
			}
	        if (arTimeZoneEnum.getValue().toLowerCase().equals(enumValue.toLowerCase())) {
	            return true;
	        }
	    }
		return false;
	}
}
