package com.arsoft.projects.common.environment;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArEnvironmentActionEnumTest{
	
	@Test
	public void isHavingEnum() {
		assertEquals(true, ArEnvironmentActionEnum.isHavingEnum("GET_DATABASE"));
		assertEquals(true, ArEnvironmentActionEnum.isHavingEnum("GET_PROPERTY_VALUE"));
		assertEquals(true, ArEnvironmentActionEnum.isHavingEnum("GET_TABLE_NAME"));
		assertEquals(true, ArEnvironmentActionEnum.isHavingEnum(ArEnvironmentActionEnum.GET_PROPERTY_VALUE.name()));
		assertEquals(true, ArEnvironmentActionEnum.isHavingEnum(ArEnvironmentActionEnum.GET_DATABASE.name()));
		assertEquals(true, ArEnvironmentActionEnum.isHavingEnum(ArEnvironmentActionEnum.GET_TABLE_NAME.name()));
		assertEquals(false, ArEnvironmentActionEnum.isHavingEnum(null));
		assertEquals(false, ArEnvironmentActionEnum.isHavingEnum(""));
	}
	
	@Test
	public void isHavingEnumValue() {
		assertEquals(true, ArEnvironmentActionEnum.isHavingEnumValue(ArEnvironmentActionEnum.GET_PROPERTY_VALUE.getValue()));
		assertEquals(true, ArEnvironmentActionEnum.isHavingEnumValue(ArEnvironmentActionEnum.GET_TABLE_NAME.getValue()));
		assertEquals(true, ArEnvironmentActionEnum.isHavingEnumValue("get_database"));
		assertEquals(true, ArEnvironmentActionEnum.isHavingEnumValue("GET_PROPERTY_VALUE"));
		assertEquals(true, ArEnvironmentActionEnum.isHavingEnumValue("GET_TABLE_NAME"));
		assertEquals(true, ArEnvironmentActionEnum.isHavingEnumValue("get_property_value"));
		assertEquals(true, ArEnvironmentActionEnum.isHavingEnumValue("get_table_name"));
		assertEquals(false, ArEnvironmentActionEnum.isHavingEnumValue(null));
	}
	
	@Test
	public void getAllArEnvironmentActionEnum() {
		List<ArEnvironmentActionEnum> all = new ArrayList<ArEnvironmentActionEnum>();
		all.add(ArEnvironmentActionEnum.GET_PROPERTY_VALUE);
		all.add(ArEnvironmentActionEnum.GET_DATABASE);
		all.add(ArEnvironmentActionEnum.GET_TABLE_NAME);
		assertEquals(all, ArEnvironmentActionEnum.getAllArEnvironmentActionEnum());
	}
	
}
