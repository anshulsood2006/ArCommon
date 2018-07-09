package com.arsoft.projects.common.business.market.entities.filedata.footer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.arsoft.projects.common.business.entity.ArAmPmEnum;
import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.entity.ArMonthEnum;
import com.arsoft.projects.common.business.entity.ArTime;
import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripCompleteDayDataFileFooter;
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
		ArScripCompleteDayDataFileFooter arScripCompleteDataFileFooter = new ArScripCompleteDayDataFileFooter("SBI", currentPriceList);
		String string = arScripCompleteDataFileFooter.getArScripDataFileFooterAsString();
		assertEquals("21.64@08_07_2018@12_44_42||22.0@08_07_2018@13_44_42||18.0@08_07_2018@12_04_42",string);
	}
}
