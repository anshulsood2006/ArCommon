package com.arsoft.projects.common.business.entity;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArAmPmEnumTest {
	
	@Test
	public void isHavingEnum() {
		assertEquals(true, ArAmPmEnum.isHavingEnum("AM"));
		assertEquals(true, ArAmPmEnum.isHavingEnum("PM"));
		assertEquals(true, ArAmPmEnum.isHavingEnum(ArAmPmEnum.AM.name()));
		assertEquals(true, ArAmPmEnum.isHavingEnum(ArAmPmEnum.PM.name()));
		assertEquals(false, ArAmPmEnum.isHavingEnum(null));
		assertEquals(false, ArAmPmEnum.isHavingEnum(""));
	}
	
	@Test
	public void isHavingEnumValue() {
		assertEquals(true, ArAmPmEnum.isHavingEnumValue(ArAmPmEnum.AM.getValue()));
		assertEquals(true, ArAmPmEnum.isHavingEnumValue(ArAmPmEnum.PM.getValue()));
		assertEquals(true, ArAmPmEnum.isHavingEnumValue("am"));
		assertEquals(false, ArAmPmEnum.isHavingEnumValue("GET_PROPERTY_VALUE"));
		assertEquals(false, ArAmPmEnum.isHavingEnumValue("GET_TABLE_NAME"));
		assertEquals(true, ArAmPmEnum.isHavingEnumValue("AM"));
		assertEquals(true, ArAmPmEnum.isHavingEnumValue("pm"));
		assertEquals(true, ArAmPmEnum.isHavingEnumValue("PM"));
		assertEquals(false, ArAmPmEnum.isHavingEnumValue(null));
	}
	
	@Test
	public void getAllArAmPmEnum() {
		List<ArAmPmEnum> all = new ArrayList<ArAmPmEnum>();
		all.add(ArAmPmEnum.AM);
		all.add(ArAmPmEnum.PM);
		assertEquals(all, ArAmPmEnum.getAllArAmPm());
	}
}
