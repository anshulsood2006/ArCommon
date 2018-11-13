package com.arsoft.projects.common.business.market.entities.datafile.footer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.arsoft.projects.arshared.ArAmPmEnum;
import com.arsoft.projects.arshared.ArDate;
import com.arsoft.projects.arshared.ArDateTime;
import com.arsoft.projects.arshared.ArMonthEnum;
import com.arsoft.projects.arshared.ArTime;
import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.equity.ArBourse;

public class ArScripDayDataFileFooterTest {
	@Test
	public void verifyGetArScripDataFileFooterAsString() throws ArException {
		ArDate arDate = new ArDate(8, ArMonthEnum.JULY, 2018);
		ArTime arTime = new ArTime(15, 30, 00, ArAmPmEnum.PM);
		ArDateTime arDateTime = new ArDateTime(arDate, arTime);
		ArPriceData previousPrice = new ArPriceData(21, arDateTime);
		arDate = new ArDate(9, ArMonthEnum.JULY, 2018);
		arTime = new ArTime(9, 15, 00, ArAmPmEnum.PM);
		arDateTime = new ArDateTime(arDate, arTime);
		ArPriceData openPrice = new ArPriceData(21.64, arDateTime);
		arDate = new ArDate(9, ArMonthEnum.JULY, 2018);
		arTime = new ArTime(12, 44, 42, ArAmPmEnum.PM);
		arDateTime = new ArDateTime(arDate, arTime);
		ArPriceData highPrice = new ArPriceData(29, arDateTime);
		arDate = new ArDate(9, ArMonthEnum.JULY, 2018);
		arTime = new ArTime(13, 2, 33, ArAmPmEnum.PM);
		arDateTime = new ArDateTime(arDate, arTime);
		ArPriceData lowPrice = new ArPriceData(19, arDateTime);
		arDate = new ArDate(9, ArMonthEnum.JULY, 2018);
		arTime = new ArTime(15, 30, 00, ArAmPmEnum.PM);
		arDateTime = new ArDateTime(arDate, arTime);
		ArPriceData closePrice = new ArPriceData(21.64, arDateTime);
		ArScripDayDataFileFooter footer = new ArScripDayDataFileFooter(new ArScrip("SBIN", "", ArBourse.NSE, 21.64, arDateTime), previousPrice, openPrice, highPrice, lowPrice, closePrice);
		assertEquals("21.0@08_07_2018@15_30_00||21.64@09_07_2018@09_15_00||29.0@09_07_2018@12_44_42||19.0@09_07_2018@13_02_33||21.64@09_07_2018@15_30_00",footer.getArScripDataFileFooterAsString());
	}
}	
