package com.arsoft.projects.common.business.market.entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.arsoft.projects.common.business.market.entities.filedata.ArScripDataFileEnum;

public class ArScripDataFileEnumTest {
	
	@Test
	public void isHavingEnum() {
		assertEquals(true, ArScripDataFileEnum.isHavingEnum("DAY_DATA_FILE"));
		assertEquals(true, ArScripDataFileEnum.isHavingEnum("WEEK_DATA_FILE"));
		assertEquals(true, ArScripDataFileEnum.isHavingEnum("MONTH_DATA_FILE"));
		assertEquals(true, ArScripDataFileEnum.isHavingEnum("YEAR_DATA_FILE"));
		assertEquals(true, ArScripDataFileEnum.isHavingEnum("CURRENT_DATA_FILE"));
		assertEquals(true, ArScripDataFileEnum.isHavingEnum("COMPLETE_DAY_DATE_FILE"));
		assertEquals(true, ArScripDataFileEnum.isHavingEnum(ArScripDataFileEnum.DAY_DATA_FILE.name()));
		assertEquals(true, ArScripDataFileEnum.isHavingEnum(ArScripDataFileEnum.WEEK_DATA_FILE.name()));
		assertEquals(true, ArScripDataFileEnum.isHavingEnum(ArScripDataFileEnum.MONTH_DATA_FILE.name()));
		assertEquals(true, ArScripDataFileEnum.isHavingEnum(ArScripDataFileEnum.YEAR_DATA_FILE.name()));
		assertEquals(true, ArScripDataFileEnum.isHavingEnum(ArScripDataFileEnum.CURRENT_DATA_FILE.name()));
		assertEquals(true, ArScripDataFileEnum.isHavingEnum(ArScripDataFileEnum.COMPLETE_DAY_DATE_FILE.name()));
		assertEquals(false, ArScripDataFileEnum.isHavingEnum(null));
		assertEquals(false, ArScripDataFileEnum.isHavingEnum(""));
	}
	
	@Test
	public void isHavingFileType() {
		assertEquals(true, ArScripDataFileEnum.isHavingFileType(ArScripDataFileEnum.DAY_DATA_FILE.getFileType()));
		assertEquals(true, ArScripDataFileEnum.isHavingFileType(ArScripDataFileEnum.WEEK_DATA_FILE.getFileType()));
		assertEquals(true, ArScripDataFileEnum.isHavingFileType(ArScripDataFileEnum.COMPLETE_DAY_DATE_FILE.getFileType()));
		assertEquals(true, ArScripDataFileEnum.isHavingFileType(ArScripDataFileEnum.MONTH_DATA_FILE.getFileType()));
		assertEquals(true, ArScripDataFileEnum.isHavingFileType(ArScripDataFileEnum.YEAR_DATA_FILE.getFileType()));
		assertEquals(true, ArScripDataFileEnum.isHavingFileType(ArScripDataFileEnum.CURRENT_DATA_FILE.getFileType()));
		assertEquals(true, ArScripDataFileEnum.isHavingFileType("Day Data"));
		assertEquals(true, ArScripDataFileEnum.isHavingFileType("Week Data"));
		assertEquals(true, ArScripDataFileEnum.isHavingFileType("Month Data"));
		assertEquals(true, ArScripDataFileEnum.isHavingFileType("Year Data"));
		assertEquals(true, ArScripDataFileEnum.isHavingFileType("Current Data"));
		assertEquals(true, ArScripDataFileEnum.isHavingFileType("Complete Day Data"));
		assertEquals(false, ArScripDataFileEnum.isHavingFileType("COMPLETE_DAY_DATA_FILE"));
		assertEquals(false, ArScripDataFileEnum.isHavingFileType(null));
	}
	
	@Test
	public void isHavingFileName() {
		assertEquals(true, ArScripDataFileEnum.isHavingFileName(ArScripDataFileEnum.DAY_DATA_FILE.getFileName()));
		assertEquals(true, ArScripDataFileEnum.isHavingFileName(ArScripDataFileEnum.WEEK_DATA_FILE.getFileName()));
		assertEquals(true, ArScripDataFileEnum.isHavingFileName(ArScripDataFileEnum.COMPLETE_DAY_DATE_FILE.getFileName()));
		assertEquals(true, ArScripDataFileEnum.isHavingFileName(ArScripDataFileEnum.MONTH_DATA_FILE.getFileName()));
		assertEquals(true, ArScripDataFileEnum.isHavingFileName(ArScripDataFileEnum.YEAR_DATA_FILE.getFileName()));
		assertEquals(true, ArScripDataFileEnum.isHavingFileName(ArScripDataFileEnum.CURRENT_DATA_FILE.getFileName()));
		assertEquals(true, ArScripDataFileEnum.isHavingFileName("Day_Data"));
		assertEquals(true, ArScripDataFileEnum.isHavingFileName("Week_Data"));
		assertEquals(true, ArScripDataFileEnum.isHavingFileName("Month_Data"));
		assertEquals(true, ArScripDataFileEnum.isHavingFileName("Year_Data"));
		assertEquals(true, ArScripDataFileEnum.isHavingFileName("Current_Data"));
		assertEquals(true, ArScripDataFileEnum.isHavingFileName("Complete_Day_Data"));
		assertEquals(false, ArScripDataFileEnum.isHavingFileName("COMPLETE_DAY_DATA_FILE"));
		assertEquals(false, ArScripDataFileEnum.isHavingFileName(null));
	}
	
	@Test
	public void isHavingAllArScripDataFileEnum() {
		List<ArScripDataFileEnum> all = new ArrayList<ArScripDataFileEnum>();
		all.add(ArScripDataFileEnum.DAY_DATA_FILE);
		all.add(ArScripDataFileEnum.WEEK_DATA_FILE);
		all.add(ArScripDataFileEnum.MONTH_DATA_FILE);
		all.add(ArScripDataFileEnum.YEAR_DATA_FILE);
		all.add(ArScripDataFileEnum.CURRENT_DATA_FILE);
		all.add(ArScripDataFileEnum.COMPLETE_DAY_DATE_FILE);
		assertEquals(all, ArScripDataFileEnum.getAllArScripDataFileEnum());
	}
}
