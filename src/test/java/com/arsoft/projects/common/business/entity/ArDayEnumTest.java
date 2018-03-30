package com.arsoft.projects.common.business.entity;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArDayEnumTest {
	
	@Test
	public void isHavingEnum() {
		assertEquals(true, ArDayEnum.isHavingEnum("MONDAY"));
		assertEquals(true, ArDayEnum.isHavingEnum("TUESDAY"));
		assertEquals(true, ArDayEnum.isHavingEnum("WEDNESDAY"));
		assertEquals(true, ArDayEnum.isHavingEnum("THURSDAY"));
		assertEquals(true, ArDayEnum.isHavingEnum("FRIDAY"));
		assertEquals(true, ArDayEnum.isHavingEnum("SATURDAY"));
		assertEquals(true, ArDayEnum.isHavingEnum("SUNDAY"));
		assertEquals(true, ArDayEnum.isHavingEnum(ArDayEnum.MONDAY.name()));
		assertEquals(true, ArDayEnum.isHavingEnum(ArDayEnum.TUESDAY.name()));
		assertEquals(true, ArDayEnum.isHavingEnum(ArDayEnum.WEDNESDAY.name()));
		assertEquals(true, ArDayEnum.isHavingEnum(ArDayEnum.THURSDAY.name()));
		assertEquals(true, ArDayEnum.isHavingEnum(ArDayEnum.FRIDAY.name()));
		assertEquals(true, ArDayEnum.isHavingEnum(ArDayEnum.SATURDAY.name()));
		assertEquals(true, ArDayEnum.isHavingEnum(ArDayEnum.SUNDAY.name()));
		assertEquals(false, ArDayEnum.isHavingEnum(null));
		assertEquals(false, ArDayEnum.isHavingEnum(""));
	}
	
	@Test
	public void isHavingEnumValue() {
		assertEquals(true, ArDayEnum.isHavingEnumValue(ArDayEnum.MONDAY.getValue()));
		assertEquals(true, ArDayEnum.isHavingEnumValue(ArDayEnum.TUESDAY.getValue()));
		assertEquals(true, ArDayEnum.isHavingEnumValue(ArDayEnum.WEDNESDAY.getValue()));
		assertEquals(true, ArDayEnum.isHavingEnumValue(ArDayEnum.THURSDAY.getValue()));
		assertEquals(true, ArDayEnum.isHavingEnumValue(ArDayEnum.FRIDAY.getValue()));
		assertEquals(true, ArDayEnum.isHavingEnumValue(ArDayEnum.SATURDAY.getValue()));
		assertEquals(true, ArDayEnum.isHavingEnumValue(ArDayEnum.SUNDAY.getValue()));
		assertEquals(true, ArDayEnum.isHavingEnumValue("monday"));
		assertEquals(false, ArDayEnum.isHavingEnumValue("GET_PROPERTY_VALUE"));
		assertEquals(false, ArDayEnum.isHavingEnumValue("GET_TABLE_NAME"));
		assertEquals(true, ArDayEnum.isHavingEnumValue("tuesday"));
		assertEquals(true, ArDayEnum.isHavingEnumValue("wednesday"));
		assertEquals(false, ArDayEnum.isHavingEnumValue(null));
	}
	
	@Test
	public void getAllArDayEnum() {
		List<ArDayEnum> all = new ArrayList<ArDayEnum>();
		all.add(ArDayEnum.SUNDAY);
		all.add(ArDayEnum.MONDAY);
		all.add(ArDayEnum.TUESDAY);
		all.add(ArDayEnum.WEDNESDAY);
		all.add(ArDayEnum.THURSDAY);
		all.add(ArDayEnum.FRIDAY);
		all.add(ArDayEnum.SATURDAY);
		assertEquals(all, ArDayEnum.getAllArDayEnum());
	}
}
