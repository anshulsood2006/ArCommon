package com.arsoft.projects.common.business.market.entities;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.business.market.util.ArScripPriceDataUtil;
import com.arsoft.projects.common.equity.ArBourse;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripDataFileTest {
	
	@Test
	public void verifyGetScripDataFileName() throws ParseException{
		String createdDateString = "July 5, 2018 12:08:56";
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy HH:mm:ss", Locale.ENGLISH);
		Date date = format.parse(createdDateString);
		ArDateTime createdDateTime = ArDateTimeUtil.getArDateTime(date);
		ArScrip arScrip = new ArScrip("HCL", "HCL", ArBourse.NSE, 0, createdDateTime);
		String fileName = ArScripPriceDataUtil.getScripDataFileName(arScrip, ArScripDataFileEnum.CURRENT_DATA_FILE);
		assertEquals(fileName, "HCL_Current_Data_05_07_2018");
		fileName = ArScripPriceDataUtil.getScripDataFileName(arScrip, ArScripDataFileEnum.DAY_DATA_FILE);
		assertEquals(fileName, "HCL_Day_Data_05_07_2018");
		fileName = ArScripPriceDataUtil.getScripDataFileName(arScrip, ArScripDataFileEnum.COMPLETE_DAY_DATE_FILE);
		assertEquals(fileName, "HCL_Complete_Day_Data_05_07_2018");
		fileName = ArScripPriceDataUtil.getScripDataFileName(arScrip, ArScripDataFileEnum.MONTH_DATA_FILE);
		assertEquals(fileName, "HCL_Month_Data_07_2018");
		fileName = ArScripPriceDataUtil.getScripDataFileName(arScrip, ArScripDataFileEnum.WEEK_DATA_FILE);
		assertEquals(fileName, "HCL_Week_Data_27_2018");
		fileName = ArScripPriceDataUtil.getScripDataFileName(arScrip, ArScripDataFileEnum.YEAR_DATA_FILE);
		assertEquals(fileName, "HCL_Year_Data_2018");
	}
	
}
