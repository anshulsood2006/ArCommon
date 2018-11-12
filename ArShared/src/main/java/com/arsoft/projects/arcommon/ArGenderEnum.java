package com.arsoft.projects.arcommon;

import java.util.ArrayList;
import java.util.List;

public enum ArGenderEnum {
	
	MALE("MALE"),
	FEMALE("FEMALE"),
	OTHER("OTHER");
	
	private String gender;
	
	private ArGenderEnum(String gender) {
		this.gender = gender;
	}
	
	public String getValue() {
		return this.gender;
	}
	
	public static List<ArGenderEnum> getAllArGender() {
		List<ArGenderEnum> arGenderEnums  = null;
		for (ArGenderEnum arGenderEnum : ArGenderEnum.values()) {
			if (arGenderEnums == null) {
				arGenderEnums = new ArrayList<>();
			}
			arGenderEnums.add(arGenderEnum);
		}
		return arGenderEnums;
	}
	
	public static boolean isHavingEnum(String enumName) { 
		for (ArGenderEnum arGenderEnum : ArGenderEnum.values()) {
	        if (arGenderEnum.name().equals(enumName)) {
	            return true;
	        }
	    }
		return false;
	}
	
	public static boolean isHavingEnumValue(String enumValue) { 
		for (ArGenderEnum arGenderEnum : ArGenderEnum.values()) {
			if (enumValue == null && arGenderEnum.getValue() == null) {
				return true;
			}
			if(arGenderEnum.getValue() == null || enumValue == null) {
				continue;
			}
	        if (arGenderEnum.getValue().toLowerCase().equals(enumValue.toLowerCase())) {
	            return true;
	        }
	    }
		return false;
	}
}
