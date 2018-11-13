package com.arsoft.projects.arshared;

import java.util.ArrayList;
import java.util.List;

public enum ArMonthEnum {
	
	JANUARY("1"),
	FEBRUARY("2"),
	MARCH("3"),
	APRIL("4"), 
	MAY("5"), 
	JUNE("6"), 
	JULY("7"),
	AUGUST("8"),
	SEPTEMBER("9"),
	OCTOBER("10"),
	NOVEMBER("11"),
	DECEMBER("12");
	
	private String month;
	
	private ArMonthEnum(String month) {
		this.month = month;
	}
	
	public String getValue() {
		return this.month;
	}
	
	public static List<ArMonthEnum> getAllArMonthEnum() {
		List<ArMonthEnum> arMonthEnums  = null;
		for (ArMonthEnum arMonthEnum : ArMonthEnum.values()) {
			if (arMonthEnums == null) {
				arMonthEnums = new ArrayList<>();
			}
			arMonthEnums.add(arMonthEnum);
		}
		return arMonthEnums;
	}
	
	public static boolean isHavingEnum(String enumName) { 
		for (ArMonthEnum arMonthEnum : ArMonthEnum.values()) {
	        if (arMonthEnum.name().equals(enumName)) {
	            return true;
	        }
	    }
		return false;
	}
	
	public static boolean isHavingEnumValue(String enumValue) {
		for (ArMonthEnum arMonthEnum : ArMonthEnum.values()) {
			if (enumValue == null && arMonthEnum.getValue() == null) {
				return true;
			}
			if(arMonthEnum.getValue() == null || enumValue == null) {
				continue;
			}
	        if (arMonthEnum.getValue().toLowerCase().equals(enumValue.toLowerCase())) {
	            return true;
	        }
	    }
		return false;
	}
	
	public static ArMonthEnum getArMonthEnum(String enumValue){
		for (ArMonthEnum arMonthEnum : ArMonthEnum.values()) {
	        if (arMonthEnum.getValue().toLowerCase().equals(enumValue.toLowerCase())) {
	            return arMonthEnum;
	        }
	    }
		return null;
	}
}
