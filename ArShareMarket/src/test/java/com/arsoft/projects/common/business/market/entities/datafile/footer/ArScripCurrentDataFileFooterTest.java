package com.arsoft.projects.common.business.market.entities.datafile.footer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.arsoft.projects.common.business.entity.ArAmPmEnum;
import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.entity.ArMonthEnum;
import com.arsoft.projects.common.business.entity.ArTime;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.equity.ArBourse;
import com.arsoft.projects.common.exception.ArException;

public class ArScripCurrentDataFileFooterTest {
	
	@Test
	public void verifyGetArScripDataFileFooterAsString() throws ArException {
		ArDate arDate = new ArDate(8, ArMonthEnum.JULY, 2018);
		ArTime arTime = new ArTime(12, 44, 42, ArAmPmEnum.PM);
		ArDateTime arDateTime = new ArDateTime(arDate, arTime);
		ArScripCurrentDataFileFooter footer = new ArScripCurrentDataFileFooter(new ArScrip("SBIN", "", ArBourse.NSE, 21.64, arDateTime));
		assertEquals("21.64@08_07_2018@12_44_42",footer.getArScripDataFileFooterAsString());
		
	}
	
}
