package com.arsoft.projects.common.business.entity;

import java.util.ArrayList;
import java.util.List;

public enum ArDayEnum {
	
	SUNDAY("SUNDAY"),
	MONDAY("MONDAY"),
	TUESDAY("TUESDAY"),
	WEDNESDAY("WEDNESDAY"), 
	THURSDAY("THURSDAY"), 
	FRIDAY("FRIDAY"), 
	SATURDAY("SATURDAY");
	
	private String day;
	
	private ArDayEnum(String day) {
		this.day = day;
	}
	
	public String getValue() {
		return this.day;
	}
	
	public static List<ArDayEnum> getAllArDayEnum() {
		List<ArDayEnum> arDayEnums  = null;
		for (ArDayEnum arDayEnum : ArDayEnum.values()) {
			if (arDayEnums == null) {
				arDayEnums = new ArrayList<>();
			}
			arDayEnums.add(arDayEnum);
		}
		return arDayEnums;
	}
	
	public static boolean isHavingEnum(String enumName) { 
		for (ArDayEnum arDayEnum : ArDayEnum.values()) {
	        if (arDayEnum.name().equals(enumName)) {
	            return true;
	        }
	    }
		return false;
	}
	
	public static boolean isHavingEnumValue(String enumValue) { 
		for (ArDayEnum arDayEnum : ArDayEnum.values()) {
			if (enumValue == null && arDayEnum.getValue() == null) {
				return true;
			}
			if(arDayEnum.getValue() == null || enumValue == null) {
				continue;
			}
	        if (arDayEnum.getValue().toLowerCase().equals(enumValue.toLowerCase())) {
	            return true;
	        }
	    }
		return false;
	}
}
