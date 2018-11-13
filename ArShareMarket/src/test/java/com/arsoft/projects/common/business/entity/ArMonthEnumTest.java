package com.arsoft.projects.common.business.entity;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.arsoft.projects.arshared.ArMonthEnum;

public class ArMonthEnumTest {
	
	@Test
	public void isHavingEnum() {
		assertEquals(true, ArMonthEnum.isHavingEnum("JANUARY"));
		assertEquals(true, ArMonthEnum.isHavingEnum("FEBRUARY"));
		assertEquals(true, ArMonthEnum.isHavingEnum(ArMonthEnum.MARCH.name()));
		assertEquals(true, ArMonthEnum.isHavingEnum(ArMonthEnum.SEPTEMBER.name()));
		assertEquals(false, ArMonthEnum.isHavingEnum(null));
		assertEquals(false, ArMonthEnum.isHavingEnum(""));
	}
	
	@Test
	public void isHavingEnumValue() {
		assertEquals(true, ArMonthEnum.isHavingEnumValue(ArMonthEnum.DECEMBER.getValue()));
		assertEquals(true, ArMonthEnum.isHavingEnumValue(ArMonthEnum.SEPTEMBER.getValue()));
		assertEquals(true, ArMonthEnum.isHavingEnumValue("5"));
		assertEquals(false, ArMonthEnum.isHavingEnumValue("GET_PROPERTY_VALUE"));
		assertEquals(false, ArMonthEnum.isHavingEnumValue("GET_TABLE_NAME"));
		assertEquals(true, ArMonthEnum.isHavingEnumValue("6"));
		assertEquals(true, ArMonthEnum.isHavingEnumValue("10"));
		assertEquals(true, ArMonthEnum.isHavingEnumValue("11"));
		assertEquals(false, ArMonthEnum.isHavingEnumValue(null));
	}
	
	@Test
	public void getAllArMonthEnum() {
		List<ArMonthEnum> all = new ArrayList<ArMonthEnum>();
		all.add(ArMonthEnum.JANUARY);
		all.add(ArMonthEnum.FEBRUARY);
		all.add(ArMonthEnum.MARCH);
		all.add(ArMonthEnum.APRIL);
		all.add(ArMonthEnum.MAY);
		all.add(ArMonthEnum.JUNE);
		all.add(ArMonthEnum.JULY);
		all.add(ArMonthEnum.AUGUST);
		all.add(ArMonthEnum.SEPTEMBER);
		all.add(ArMonthEnum.OCTOBER);
		all.add(ArMonthEnum.NOVEMBER);
		all.add(ArMonthEnum.DECEMBER);
		assertEquals(all, ArMonthEnum.getAllArMonthEnum());
	}
}
