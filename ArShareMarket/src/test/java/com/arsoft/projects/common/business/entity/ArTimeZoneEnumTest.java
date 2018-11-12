package com.arsoft.projects.common.business.entity;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.arsoft.projects.arcommon.ArTimeZoneEnum;

public class ArTimeZoneEnumTest {
	@Test
	public void isHavingEnum() {
		assertEquals(true, ArTimeZoneEnum.isHavingEnum("IST"));
		assertEquals(true, ArTimeZoneEnum.isHavingEnum("GMT"));
		assertEquals(true, ArTimeZoneEnum.isHavingEnum(ArTimeZoneEnum.IST.name()));
		assertEquals(true, ArTimeZoneEnum.isHavingEnum(ArTimeZoneEnum.GMT.name()));
		assertEquals(false, ArTimeZoneEnum.isHavingEnum(null));
		assertEquals(false, ArTimeZoneEnum.isHavingEnum(""));
	}
	
	@Test
	public void isHavingEnumValue() {
		assertEquals(true, ArTimeZoneEnum.isHavingEnumValue(ArTimeZoneEnum.IST.getValue()));
		assertEquals(true, ArTimeZoneEnum.isHavingEnumValue(ArTimeZoneEnum.GMT.getValue()));
		assertEquals(true, ArTimeZoneEnum.isHavingEnumValue("IST"));
		assertEquals(false, ArTimeZoneEnum.isHavingEnumValue("GET_PROPERTY_VALUE"));
		assertEquals(false, ArTimeZoneEnum.isHavingEnumValue("GET_TABLE_NAME"));
		assertEquals(true, ArTimeZoneEnum.isHavingEnumValue("ist"));
		assertEquals(true, ArTimeZoneEnum.isHavingEnumValue("gmt"));
		assertEquals(true, ArTimeZoneEnum.isHavingEnumValue("GMT"));
		assertEquals(false, ArTimeZoneEnum.isHavingEnumValue(null));
	}
	
	@Test
	public void getAllArTimeZoneEnum() {
		List<ArTimeZoneEnum> all = new ArrayList<ArTimeZoneEnum>();
		all.add(ArTimeZoneEnum.IST);
		all.add(ArTimeZoneEnum.GMT);
		assertEquals(all, ArTimeZoneEnum.getAllArTimeZone());
	}
}
