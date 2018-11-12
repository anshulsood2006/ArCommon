package com.arsoft.projects.common.business.market.entities.datafile.footer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.arsoft.projects.arcommon.ArAmPmEnum;
import com.arsoft.projects.arcommon.ArDate;
import com.arsoft.projects.arcommon.ArDateTime;
import com.arsoft.projects.arcommon.ArMonthEnum;
import com.arsoft.projects.arcommon.ArTime;
import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.factory.ArScripTestUtil;
import com.arsoft.projects.common.equity.ArBourse;
import com.arsoft.projects.common.exception.ArException;

public class ArScripCompleteDataFileFooterTest {
	
	@Test
	public void verifyGetArScripCompleteFileDataFooterAsString() throws ArException {
		List<ArPriceData> currentPriceList = new ArrayList<ArPriceData>();
		ArDate arDate = new ArDate(8, ArMonthEnum.JULY, 2018);
		ArTime arTime = new ArTime(12, 44, 42, ArAmPmEnum.PM);
		ArDateTime arDateTime = new ArDateTime(arDate, arTime);
		ArPriceData arPriceData = new ArPriceData(21.64, arDateTime);
		currentPriceList.add(arPriceData);
		arDate = new ArDate(8, ArMonthEnum.JULY, 2018);
		arTime = new ArTime(13, 44, 42, ArAmPmEnum.PM);
		arDateTime = new ArDateTime(arDate, arTime);
		arPriceData = new ArPriceData(22, arDateTime);
		currentPriceList.add(arPriceData);
		arDate = new ArDate(8, ArMonthEnum.JULY, 2018);
		arTime = new ArTime(12, 04, 42, ArAmPmEnum.PM);
		arDateTime = new ArDateTime(arDate, arTime);
		arPriceData = new ArPriceData(18, arDateTime);
		currentPriceList.add(arPriceData);
		ArScripCompleteDayDataFileFooter arScripCompleteDataFileFooter = new ArScripCompleteDayDataFileFooter(new ArScrip("SBIN", "", ArBourse.NSE, 12.56, new ArDateTime()));
		arScripCompleteDataFileFooter.setCurrentPriceList(currentPriceList);
		String string = arScripCompleteDataFileFooter.getArScripDataFileFooterAsString();
		assertEquals("21.64@08_07_2018@12_44_42||22.0@08_07_2018@13_44_42||18.0@08_07_2018@12_04_42",string);
	}
	
	@Test
	public void verifyGetArScripCompleteFileDataFooter() throws ArException {
		String footerString = "50@31_07_2018@09_15_00||51@31_07_2018@10_15_00||52@31_07_2018@11_15_00||53@31_07_2018@12_15_00||54@31_07_2018@13_15_00";
		ArScrip arScrip = ArScripTestUtil.getTestScrip();
		ArScripCompleteDayDataFileFooter footer = (ArScripCompleteDayDataFileFooter) ArScripCompleteDayDataFileFooter.getArScripDataFileFooter(footerString, arScrip);
		assertNotNull(footer);
		assertEquals(footer.getArScrip(), arScrip);
		assertEquals(footer.getCurrentPriceList().size(), 5);
		assertEquals(footer.getCurrentPriceList().get(0).getPrice(), 51, 1);
		assertEquals(footer.getCurrentPriceList().get(0).getArDateTime().getArDate().getDay(), 31);
		assertEquals(footer.getCurrentPriceList().get(0).getArDateTime().getArDate().getMonth(), ArMonthEnum.JULY);
		assertEquals(footer.getCurrentPriceList().get(0).getArDateTime().getArDate().getYear(), 2018);
		assertEquals(footer.getCurrentPriceList().get(0).getArDateTime().getArTime().getAmPm(), ArAmPmEnum.AM);
		assertEquals(footer.getCurrentPriceList().get(0).getArDateTime().getArTime().getHour(), 9);
		assertEquals(footer.getCurrentPriceList().get(0).getArDateTime().getArTime().getMinute(), 15);
		assertEquals(footer.getCurrentPriceList().get(0).getArDateTime().getArTime().getSecond(), 00);
		assertEquals(footer.getCurrentPriceList().get(1).getPrice(), 52, 1);
		assertEquals(footer.getCurrentPriceList().get(1).getArDateTime().getArDate().getDay(), 31);
		assertEquals(footer.getCurrentPriceList().get(1).getArDateTime().getArDate().getMonth(), ArMonthEnum.JULY);
		assertEquals(footer.getCurrentPriceList().get(1).getArDateTime().getArDate().getYear(), 2018);
		assertEquals(footer.getCurrentPriceList().get(1).getArDateTime().getArTime().getAmPm(), ArAmPmEnum.AM);
		assertEquals(footer.getCurrentPriceList().get(1).getArDateTime().getArTime().getHour(), 10);
		assertEquals(footer.getCurrentPriceList().get(1).getArDateTime().getArTime().getMinute(), 15);
		assertEquals(footer.getCurrentPriceList().get(1).getArDateTime().getArTime().getSecond(), 00);
		assertEquals(footer.getCurrentPriceList().get(2).getPrice(), 53, 1);
		assertEquals(footer.getCurrentPriceList().get(2).getArDateTime().getArDate().getDay(), 31);
		assertEquals(footer.getCurrentPriceList().get(2).getArDateTime().getArDate().getMonth(), ArMonthEnum.JULY);
		assertEquals(footer.getCurrentPriceList().get(2).getArDateTime().getArDate().getYear(), 2018);
		assertEquals(footer.getCurrentPriceList().get(2).getArDateTime().getArTime().getAmPm(), ArAmPmEnum.AM);
		assertEquals(footer.getCurrentPriceList().get(2).getArDateTime().getArTime().getHour(), 11);
		assertEquals(footer.getCurrentPriceList().get(2).getArDateTime().getArTime().getMinute(), 15);
		assertEquals(footer.getCurrentPriceList().get(2).getArDateTime().getArTime().getSecond(), 00);
		assertEquals(footer.getCurrentPriceList().get(3).getPrice(), 54, 1);
		assertEquals(footer.getCurrentPriceList().get(3).getArDateTime().getArDate().getDay(), 31);
		assertEquals(footer.getCurrentPriceList().get(3).getArDateTime().getArDate().getMonth(), ArMonthEnum.JULY);
		assertEquals(footer.getCurrentPriceList().get(3).getArDateTime().getArDate().getYear(), 2018);
		assertEquals(footer.getCurrentPriceList().get(3).getArDateTime().getArTime().getAmPm(), ArAmPmEnum.PM);
		assertEquals(footer.getCurrentPriceList().get(3).getArDateTime().getArTime().getHour(), 12);
		assertEquals(footer.getCurrentPriceList().get(3).getArDateTime().getArTime().getMinute(), 15);
		assertEquals(footer.getCurrentPriceList().get(3).getArDateTime().getArTime().getSecond(), 00);
		assertEquals(footer.getCurrentPriceList().get(4).getPrice(), 55, 1);
		assertEquals(footer.getCurrentPriceList().get(4).getArDateTime().getArDate().getDay(), 31);
		assertEquals(footer.getCurrentPriceList().get(4).getArDateTime().getArDate().getMonth(), ArMonthEnum.JULY);
		assertEquals(footer.getCurrentPriceList().get(4).getArDateTime().getArDate().getYear(), 2018);
		assertEquals(footer.getCurrentPriceList().get(4).getArDateTime().getArTime().getAmPm(), ArAmPmEnum.PM);
		assertEquals(footer.getCurrentPriceList().get(4).getArDateTime().getArTime().getHour(), 13);
		assertEquals(footer.getCurrentPriceList().get(4).getArDateTime().getArTime().getMinute(), 15);
		assertEquals(footer.getCurrentPriceList().get(4).getArDateTime().getArTime().getSecond(), 00);
	}
	
	
	
}
