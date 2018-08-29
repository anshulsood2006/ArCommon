package com.arsoft.projects.common.environment;

import java.util.ArrayList;
import java.util.List;

public enum ArEnvironmentActionEnum{
	
	GET_PROPERTY_VALUE("get_property_value"),
	GET_DATABASE("get_database"),
	GET_TABLE_NAME("get_table_name");
	
	
	private String environmentAction;
	
	private ArEnvironmentActionEnum(String environmentAction) {
		this.environmentAction = environmentAction;
	}
	
	public String getValue() {
		return this.environmentAction;
	}
	
	public static List<ArEnvironmentActionEnum> getAllArEnvironmentActionEnum() {
		List<ArEnvironmentActionEnum> arEnvironmentActionEnums  = null;
		for (ArEnvironmentActionEnum arEnvironmentActionEnum : ArEnvironmentActionEnum.values()) {
			if (arEnvironmentActionEnums == null) {
				arEnvironmentActionEnums = new ArrayList<>();
			}
			arEnvironmentActionEnums.add(arEnvironmentActionEnum);
		}
		return arEnvironmentActionEnums;
	}
	
	public static boolean isHavingEnum(String enumName) { 
		for (ArEnvironmentActionEnum arEnvironmentActionEnum : ArEnvironmentActionEnum.values()) {
	        if (arEnvironmentActionEnum.name().equals(enumName)) {
	            return true;
	        }
	    }
		return false;
	}
	
	public static boolean isHavingEnumValue(String enumValue) { 
		for (ArEnvironmentActionEnum arEnvironmentActionEnum : ArEnvironmentActionEnum.values()) {
			if (enumValue == null && arEnvironmentActionEnum.getValue() == null) {
				return true;
			}
			if(arEnvironmentActionEnum.getValue() == null || enumValue == null) {
				continue;
			}
	        if (arEnvironmentActionEnum.getValue().toLowerCase().equals(enumValue.toLowerCase())) {
	            return true;
	        }
	    }
		return false;
	}
}
