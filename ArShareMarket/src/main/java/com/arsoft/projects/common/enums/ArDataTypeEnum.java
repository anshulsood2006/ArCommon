package com.arsoft.projects.common.enums;

public enum ArDataTypeEnum {
	
	BOOLEAN("false", 1),
	BYTE("0", 8),
	CHAR("\u0000", 16),
	SHORT("0", 16),
	INT("0", 32),
	FLOAT("0.0", 32),
	LONG("0", 64),
	DOUBLE("0.0", 64);
	
	private String defaultValue;
	private int sizeInBits;
	
	private ArDataTypeEnum(String defaultValue, int sizeInBits){
		System.out.println("Constructor called for "+this.name());
		this.defaultValue = defaultValue;
		this.sizeInBits = sizeInBits;
	}
	
	public String getDefaultValue() {
		return this.defaultValue;
	}
	
	public int getSizeInBits() {
		return this.sizeInBits;
	}

	public static void main(String[] args) {
		ArDataTypeEnum[] values = ArDataTypeEnum.values();
		System.out.println(values[0].name());
		System.out.println(ArDataTypeEnum.valueOf("SHORT").ordinal());
		Integer i1 = 260; 
		Integer i2 = 260; 
		if (i1 == i2) { 
			System.out.println("i1 and i2 is equal"); 
		} else { 
			System.out.println("i1 and i2 is not equal "); 
		}
		Integer i3 = 100; 
		Integer i4 = 100; 
		if (i3 == i4) { 
			System.out.println("i1 and i2 is equal"); 
		} else { 
			System.out.println("i1 and i2 is not equal "); 
		}
	}
}	
