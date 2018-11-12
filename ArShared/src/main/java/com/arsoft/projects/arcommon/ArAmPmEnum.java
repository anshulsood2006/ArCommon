package com.arsoft.projects.arcommon;

import java.util.ArrayList;
import java.util.List;

public enum ArAmPmEnum {
	
	AM("AM"),
	PM("PM");
	
	private String amPm;
	
	private ArAmPmEnum(String amPm) {
		this.amPm = amPm;
	}
	
	public String getValue() {
		return this.amPm;
	}
	
	public static List<ArAmPmEnum> getAllArAmPm() {
		List<ArAmPmEnum> arAmPmEnums  = null;
		for (ArAmPmEnum arAmPmEnum : ArAmPmEnum.values()) {
			if (arAmPmEnums == null) {
				arAmPmEnums = new ArrayList<>();
			}
			arAmPmEnums.add(arAmPmEnum);
		}
		return arAmPmEnums;
	}
	
	public static boolean isHavingEnum(String enumName) { 
		for (ArAmPmEnum arAmPmEnum : ArAmPmEnum.values()) {
	        if (arAmPmEnum.name().equals(enumName)) {
	            return true;
	        }
	    }
		return false;
	}
	
	public static boolean isHavingEnumValue(String enumValue) { 
		for (ArAmPmEnum arAmPmEnum : ArAmPmEnum.values()) {
			if (enumValue == null && arAmPmEnum.getValue() == null) {
				return true;
			}
			if(arAmPmEnum.getValue() == null || enumValue == null) {
				continue;
			}
	        if (arAmPmEnum.getValue().toLowerCase().equals(enumValue.toLowerCase())) {
	            return true;
	        }
	    }
		return false;
	}
}
