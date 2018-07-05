package com.arsoft.projects.common.business.market.entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArScripFileDataEnumTest {
	
	@Test
	public void isHavingEnum() {
		assertEquals(true, ArScripFileDataEnum.isHavingEnum("FILE_DAY_DATA"));
		assertEquals(true, ArScripFileDataEnum.isHavingEnum("FILE_WEEK_DATA"));
		assertEquals(true, ArScripFileDataEnum.isHavingEnum("FILE_MONTH_DATA"));
		assertEquals(true, ArScripFileDataEnum.isHavingEnum("FILE_YEAR_DATA"));
		assertEquals(true, ArScripFileDataEnum.isHavingEnum("FILE_CURRENT_DATA"));
		assertEquals(true, ArScripFileDataEnum.isHavingEnum("FILE_DAY_DATA_COMPLETE"));
		assertEquals(true, ArScripFileDataEnum.isHavingEnum(ArScripFileDataEnum.FILE_DAY_DATA.name()));
		assertEquals(true, ArScripFileDataEnum.isHavingEnum(ArScripFileDataEnum.FILE_WEEK_DATA.name()));
		assertEquals(true, ArScripFileDataEnum.isHavingEnum(ArScripFileDataEnum.FILE_MONTH_DATA.name()));
		assertEquals(true, ArScripFileDataEnum.isHavingEnum(ArScripFileDataEnum.FILE_YEAR_DATA.name()));
		assertEquals(true, ArScripFileDataEnum.isHavingEnum(ArScripFileDataEnum.FILE_CURRENT_DATA.name()));
		assertEquals(true, ArScripFileDataEnum.isHavingEnum(ArScripFileDataEnum.FILE_DAY_DATA_COMPLETE.name()));
		assertEquals(false, ArScripFileDataEnum.isHavingEnum(null));
		assertEquals(false, ArScripFileDataEnum.isHavingEnum(""));
	}
	
	@Test
	public void isHavingFileType() {
		assertEquals(true, ArScripFileDataEnum.isHavingFileType(ArScripFileDataEnum.FILE_DAY_DATA.getFileType()));
		assertEquals(true, ArScripFileDataEnum.isHavingFileType(ArScripFileDataEnum.FILE_WEEK_DATA.getFileType()));
		assertEquals(true, ArScripFileDataEnum.isHavingFileType(ArScripFileDataEnum.FILE_DAY_DATA_COMPLETE.getFileType()));
		assertEquals(true, ArScripFileDataEnum.isHavingFileType(ArScripFileDataEnum.FILE_MONTH_DATA.getFileType()));
		assertEquals(true, ArScripFileDataEnum.isHavingFileType(ArScripFileDataEnum.FILE_YEAR_DATA.getFileType()));
		assertEquals(true, ArScripFileDataEnum.isHavingFileType(ArScripFileDataEnum.FILE_CURRENT_DATA.getFileType()));
		assertEquals(true, ArScripFileDataEnum.isHavingFileType("Day Data"));
		assertEquals(true, ArScripFileDataEnum.isHavingFileType("Week Data"));
		assertEquals(true, ArScripFileDataEnum.isHavingFileType("Month Data"));
		assertEquals(true, ArScripFileDataEnum.isHavingFileType("Year Data"));
		assertEquals(true, ArScripFileDataEnum.isHavingFileType("Current Data"));
		assertEquals(true, ArScripFileDataEnum.isHavingFileType("Complete Day Data"));
		assertEquals(false, ArScripFileDataEnum.isHavingFileType("FILE_DAY_DATA_COMPLETE"));
		assertEquals(false, ArScripFileDataEnum.isHavingFileType(null));
	}
	
	@Test
	public void isHavingFileName() {
		assertEquals(true, ArScripFileDataEnum.isHavingFileName(ArScripFileDataEnum.FILE_DAY_DATA.getFileName()));
		assertEquals(true, ArScripFileDataEnum.isHavingFileName(ArScripFileDataEnum.FILE_WEEK_DATA.getFileName()));
		assertEquals(true, ArScripFileDataEnum.isHavingFileName(ArScripFileDataEnum.FILE_DAY_DATA_COMPLETE.getFileName()));
		assertEquals(true, ArScripFileDataEnum.isHavingFileName(ArScripFileDataEnum.FILE_MONTH_DATA.getFileName()));
		assertEquals(true, ArScripFileDataEnum.isHavingFileName(ArScripFileDataEnum.FILE_YEAR_DATA.getFileName()));
		assertEquals(true, ArScripFileDataEnum.isHavingFileName(ArScripFileDataEnum.FILE_CURRENT_DATA.getFileName()));
		assertEquals(true, ArScripFileDataEnum.isHavingFileName("Day_Data"));
		assertEquals(true, ArScripFileDataEnum.isHavingFileName("Week_Data"));
		assertEquals(true, ArScripFileDataEnum.isHavingFileName("Month_Data"));
		assertEquals(true, ArScripFileDataEnum.isHavingFileName("Year_Data"));
		assertEquals(true, ArScripFileDataEnum.isHavingFileName("Current_Data"));
		assertEquals(true, ArScripFileDataEnum.isHavingFileName("Complete_Day_Data"));
		assertEquals(false, ArScripFileDataEnum.isHavingFileName("FILE_DAY_DATA_COMPLETE"));
		assertEquals(false, ArScripFileDataEnum.isHavingFileName(null));
	}
	
	@Test
	public void isHavingAllArScripFileDataEnum() {
		List<ArScripFileDataEnum> all = new ArrayList<ArScripFileDataEnum>();
		all.add(ArScripFileDataEnum.FILE_DAY_DATA);
		all.add(ArScripFileDataEnum.FILE_WEEK_DATA);
		all.add(ArScripFileDataEnum.FILE_MONTH_DATA);
		all.add(ArScripFileDataEnum.FILE_YEAR_DATA);
		all.add(ArScripFileDataEnum.FILE_CURRENT_DATA);
		all.add(ArScripFileDataEnum.FILE_DAY_DATA_COMPLETE);
		assertEquals(all, ArScripFileDataEnum.getAllArScripFileDataEnum());
	}
}
