package com.arsoft.projects.common.business.market.factory;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.market.entities.ArScripFileDataEnum;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripFileDataHeaderFactoryTest {
	@Test
	public void verifyGetHeader() throws ParseException{
		String scrip = "SBIN";
		String string = "05/07/2018 12:08:56";
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
		Date date = format.parse(string);
		ArDateTime createdDateTime = ArDateTimeUtil.getArDateTime(date);
		string = "05/07/2018 14:22:33";
		format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
		date = format.parse(string);
		ArDateTime updatedDateTime = ArDateTimeUtil.getArDateTime(date);
		String header = ArScripFileDataHeaderFactory.getHeader(scrip, createdDateTime, updatedDateTime, ArScripFileDataEnum.FILE_CURRENT_DATA);
		assertEquals(header, "SBIN||SBIN_Current_Data_05_07_2018||Current Data||05_07_2018@12_08_56||05_07_2018@14_22_33");
		header = ArScripFileDataHeaderFactory.getHeader(scrip, createdDateTime, updatedDateTime, ArScripFileDataEnum.FILE_DAY_DATA);
		assertEquals(header, "SBIN||SBIN_Day_Data_05_07_2018||Day Data||05_07_2018@12_08_56||05_07_2018@14_22_33");
		header = ArScripFileDataHeaderFactory.getHeader(scrip, createdDateTime, updatedDateTime, ArScripFileDataEnum.FILE_DAY_DATA_COMPLETE);
		assertEquals(header, "SBIN||SBIN_Complete_Day_Data_05_07_2018||Complete Day Data||05_07_2018@12_08_56||05_07_2018@14_22_33");
		header = ArScripFileDataHeaderFactory.getHeader(scrip, createdDateTime, updatedDateTime, ArScripFileDataEnum.FILE_MONTH_DATA);
		assertEquals(header, "SBIN||SBIN_Month_Data_05_07_2018||Month Data||05_07_2018@12_08_56||05_07_2018@14_22_33");
		header = ArScripFileDataHeaderFactory.getHeader(scrip, createdDateTime, updatedDateTime, ArScripFileDataEnum.FILE_WEEK_DATA);
		assertEquals(header, "SBIN||SBIN_Week_Data_05_07_2018||Week Data||05_07_2018@12_08_56||05_07_2018@14_22_33");
		header = ArScripFileDataHeaderFactory.getHeader(scrip, createdDateTime, updatedDateTime, ArScripFileDataEnum.FILE_YEAR_DATA);
		assertEquals(header, "SBIN||SBIN_Year_Data_05_07_2018||Year Data||05_07_2018@12_08_56||05_07_2018@14_22_33");
	}
}
