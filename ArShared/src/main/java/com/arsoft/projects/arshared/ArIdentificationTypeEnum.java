package com.arsoft.projects.arshared;

import java.util.ArrayList;
import java.util.List;

public enum ArIdentificationTypeEnum {
	PAN("PAN"),
	ADHAAR("ADHAAR"),
	TIN("TIN");
	
	private String identificationType;
	
	private ArIdentificationTypeEnum(String identificationType) {
		this.identificationType = identificationType;
	}
	
	public String getValue() {
		return this.identificationType;
	}
	
	public static List<ArIdentificationTypeEnum> getAllArIdentificationType() {
		List<ArIdentificationTypeEnum> arIdentificationTypes  = null;
		for (ArIdentificationTypeEnum arIdentificationType : ArIdentificationTypeEnum.values()) {
			if (arIdentificationTypes == null) {
				arIdentificationTypes = new ArrayList<>();
			}
			arIdentificationTypes.add(arIdentificationType);
		}
		return arIdentificationTypes;
	}
	
	public static boolean isHavingEnum(String enumName) { 
		for (ArIdentificationTypeEnum ArIdentificationType : ArIdentificationTypeEnum.values()) {
	        if (ArIdentificationType.name().equals(enumName)) {
	            return true;
	        }
	    }
		return false;
	}
	
	public static boolean isHavingEnumValue(String enumValue) { 
		for (ArIdentificationTypeEnum arIdentificationType : ArIdentificationTypeEnum.values()) {
			if (enumValue == null && arIdentificationType.getValue() == null) {
				return true;
			}
			if(arIdentificationType.getValue() == null || enumValue == null) {
				continue;
			}
	        if (arIdentificationType.getValue().toLowerCase().equals(enumValue.toLowerCase())) {
	            return true;
	        }
	    }
		return false;
	}
}
