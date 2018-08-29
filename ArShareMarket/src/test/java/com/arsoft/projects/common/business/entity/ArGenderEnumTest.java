package com.arsoft.projects.common.business.entity;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArGenderEnumTest {
	
	@Test
	public void isHavingEnum() {
		assertEquals(true, ArGenderEnum.isHavingEnum("MALE"));
		assertEquals(true, ArGenderEnum.isHavingEnum("FEMALE"));
		assertEquals(true, ArGenderEnum.isHavingEnum("OTHER"));
		assertEquals(true, ArGenderEnum.isHavingEnum(ArGenderEnum.MALE.name()));
		assertEquals(true, ArGenderEnum.isHavingEnum(ArGenderEnum.FEMALE.name()));
		assertEquals(true, ArGenderEnum.isHavingEnum(ArGenderEnum.OTHER.name()));
		assertEquals(false, ArGenderEnum.isHavingEnum(null));
		assertEquals(false, ArGenderEnum.isHavingEnum(""));
	}
	
	@Test
	public void isHavingEnumValue() {
		assertEquals(true, ArGenderEnum.isHavingEnumValue(ArGenderEnum.MALE.getValue()));
		assertEquals(true, ArGenderEnum.isHavingEnumValue(ArGenderEnum.FEMALE.getValue()));
		assertEquals(true, ArGenderEnum.isHavingEnumValue(ArGenderEnum.OTHER.getValue()));
		assertEquals(true, ArGenderEnum.isHavingEnumValue("male"));
		assertEquals(false, ArGenderEnum.isHavingEnumValue("GET_PROPERTY_VALUE"));
		assertEquals(false, ArGenderEnum.isHavingEnumValue("GET_TABLE_NAME"));
		assertEquals(true, ArGenderEnum.isHavingEnumValue("MALE"));
		assertEquals(true, ArGenderEnum.isHavingEnumValue("female"));
		assertEquals(true, ArGenderEnum.isHavingEnumValue("FEMALE"));
		assertEquals(true, ArGenderEnum.isHavingEnumValue("other"));
		assertEquals(true, ArGenderEnum.isHavingEnumValue("OTHER"));
		assertEquals(false, ArGenderEnum.isHavingEnumValue(null));
	}
	
	@Test
	public void getAllArGenderEnum() {
		List<ArGenderEnum> all = new ArrayList<ArGenderEnum>();
		all.add(ArGenderEnum.MALE);
		all.add(ArGenderEnum.FEMALE);
		all.add(ArGenderEnum.OTHER);
		assertEquals(all, ArGenderEnum.getAllArGender());
	}
}
