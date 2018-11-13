package com.arsoft.projects.common.business.market.factory;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

import com.arsoft.projects.arshared.ArDateTime;
import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.equity.ArBourse;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripFileDataHeaderFactoryTest {
	@Test
	public void verifyGetHeader() throws ParseException, ArException{
		String string = "05/07/2018 12:08:56";
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
		Date date = format.parse(string);
		ArDateTime createdDateTime = ArDateTimeUtil.getArDateTime(date);
		string = "05/07/2018 14:22:33";
		format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
		date = format.parse(string);
		ArDateTime updatedDateTime = ArDateTimeUtil.getArDateTime(date);
		ArScrip arScrip = new ArScrip("SBIN", "SBIN", ArBourse.NSE, 0, createdDateTime);
		ArScripDataFileHeader arScripDataFileHeader = ArScripDataFileHeaderFactory.getArScripDataFileHeader(arScrip, updatedDateTime, ArScripDataFileEnum.CURRENT_DATA_FILE); 
		String headerString = arScripDataFileHeader.getArScripFileDataHeaderAsString();
		assertEquals(headerString, "SBIN||SBIN_Current_Data_05_07_2018||Current Data||05_07_2018@12_08_56||05_07_2018@14_22_33");
		arScripDataFileHeader = ArScripDataFileHeaderFactory.getArScripDataFileHeader(arScrip, updatedDateTime, ArScripDataFileEnum.DAY_DATA_FILE);
		headerString = arScripDataFileHeader.getArScripFileDataHeaderAsString();
		assertEquals(headerString, "SBIN||SBIN_Day_Data_05_07_2018||Day Data||05_07_2018@12_08_56||05_07_2018@14_22_33");
		arScripDataFileHeader = ArScripDataFileHeaderFactory.getArScripDataFileHeader(arScrip, updatedDateTime, ArScripDataFileEnum.COMPLETE_DAY_DATE_FILE);
		headerString = arScripDataFileHeader.getArScripFileDataHeaderAsString();
		assertEquals(headerString, "SBIN||SBIN_Complete_Day_Data_05_07_2018||Complete Day Data||05_07_2018@12_08_56||05_07_2018@14_22_33");
		arScripDataFileHeader = ArScripDataFileHeaderFactory.getArScripDataFileHeader(arScrip, updatedDateTime, ArScripDataFileEnum.MONTH_DATA_FILE);
		headerString = arScripDataFileHeader.getArScripFileDataHeaderAsString();
		assertEquals(headerString, "SBIN||SBIN_Month_Data_07_2018||Month Data||05_07_2018@12_08_56||05_07_2018@14_22_33");
		arScripDataFileHeader = ArScripDataFileHeaderFactory.getArScripDataFileHeader(arScrip, updatedDateTime, ArScripDataFileEnum.WEEK_DATA_FILE);
		headerString = arScripDataFileHeader.getArScripFileDataHeaderAsString();
		assertEquals(headerString, "SBIN||SBIN_Week_Data_27_2018||Week Data||05_07_2018@12_08_56||05_07_2018@14_22_33");
		arScripDataFileHeader = ArScripDataFileHeaderFactory.getArScripDataFileHeader(arScrip, updatedDateTime, ArScripDataFileEnum.YEAR_DATA_FILE);
		headerString = arScripDataFileHeader.getArScripFileDataHeaderAsString();
		assertEquals(headerString, "SBIN||SBIN_Year_Data_2018||Year Data||05_07_2018@12_08_56||05_07_2018@14_22_33");
	}
}
