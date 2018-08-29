package com.arsoft.projects.common.environment;

public enum ArTemplateEnum {
	
	GET_VALUE("GET_VALUE"),
	NULL_VALUE(null),
	EMPTY_VALUE("");
	
	
	private String templateEnumValue;
	
	private ArTemplateEnum(String templateEnumValue) {
		this.templateEnumValue = templateEnumValue;
	}
	
	public String getValue() {
		return this.templateEnumValue;
	}
	
	public static ArTemplateEnum[] getAllTemplateEnum() {
		return ArTemplateEnum.values();
	}
	
	public static boolean isHavingEnum(String enumName) { 
		for (ArTemplateEnum ArTemplateEnum : ArTemplateEnum.values()) {
	        if (ArTemplateEnum.name().equals(enumName)) {
	            return true;
	        }
	    }
		return false;
	}
	
	public static boolean isHavingEnumValue(String enumValue) { 
		for (ArTemplateEnum ArTemplateEnum : ArTemplateEnum.values()) {
			if (enumValue == null && ArTemplateEnum.getValue() == null) {
				return true;
			}
			if(ArTemplateEnum.getValue() == null || enumValue == null) {
				continue;
			}
	        if (ArTemplateEnum.getValue().toLowerCase().equals(enumValue.toLowerCase())) {
	            return true;
	        }
	    }
		return false;
	}
}
