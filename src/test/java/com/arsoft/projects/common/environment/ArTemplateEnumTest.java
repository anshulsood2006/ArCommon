package com.arsoft.projects.common.environment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArTemplateEnumTest {
	
	@Test
	public void isHavingEnumValue() {
		assertEquals(false, ArTemplateEnum.isHavingEnum("GET_NAME"));
		assertEquals(true, ArTemplateEnum.isHavingEnum(ArTemplateEnum.GET_VALUE.name()));
		assertEquals(true, ArTemplateEnum.isHavingEnumValue(ArTemplateEnum.GET_VALUE.getValue().toLowerCase()));
		assertEquals(true, ArTemplateEnum.isHavingEnumValue(ArTemplateEnum.GET_VALUE.getValue().toLowerCase()));
		assertEquals(true, ArTemplateEnum.isHavingEnumValue(null));
	}
	
	@Test
	public void isHavingEnumValueNull() {
		assertEquals(true, ArTemplateEnum.isHavingEnumValue(null));
		assertEquals(true, ArTemplateEnum.isHavingEnumValue(ArTemplateEnum.NULL_VALUE.getValue()));
	}
}
