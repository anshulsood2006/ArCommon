package com.arsoft.projects.common.business.market.entities.datafile.footer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.arsoft.projects.arshared.ArAmPmEnum;
import com.arsoft.projects.arshared.ArMonthEnum;
import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.factory.ArScripTestUtil;

public class ArScripMonthDataFileFooterTest {
	
	@Test
	public void verify() throws ArException {
		String footerString = "50@31_07_2018@15_15_00||10@01_07_2018@9_15_00";
		ArScrip arScrip = ArScripTestUtil.getTestScrip();
		ArScripMonthDataFileFooter footer = (ArScripMonthDataFileFooter) ArScripMonthDataFileFooter.getArScripDataFileFooter(footerString, arScrip);
		assertNotNull(footer);
		assertEquals(footer.getArScrip(), arScrip);
		assertEquals(footer.getHighPrice().getArDateTime().getArDate().getMonth(), ArMonthEnum.JULY);
		assertEquals(footer.getHighPrice().getArDateTime().getArDate().getYear(), 2018);
		assertEquals(footer.getHighPrice().getArDateTime().getArDate().getDay(), 31);
		assertEquals(footer.getLowPrice().getArDateTime().getArDate().getMonth(), ArMonthEnum.JULY);
		assertEquals(footer.getLowPrice().getArDateTime().getArDate().getYear(), 2018);
		assertEquals(footer.getLowPrice().getArDateTime().getArDate().getDay(), 1);
		assertEquals(footer.getHighPrice().getArDateTime().getArTime().getAmPm(), ArAmPmEnum.PM);
		assertEquals(footer.getHighPrice().getArDateTime().getArTime().getHour(), 15);
		assertEquals(footer.getHighPrice().getArDateTime().getArTime().getMinute(), 15);
		assertEquals(footer.getHighPrice().getArDateTime().getArTime().getSecond(), 0);
		assertEquals(footer.getLowPrice().getArDateTime().getArTime().getAmPm(), ArAmPmEnum.AM);
		assertEquals(footer.getLowPrice().getArDateTime().getArTime().getHour(), 9);
		assertEquals(footer.getLowPrice().getArDateTime().getArTime().getMinute(), 15);
		assertEquals(footer.getLowPrice().getArDateTime().getArTime().getSecond(), 0);
	}
	
}	
