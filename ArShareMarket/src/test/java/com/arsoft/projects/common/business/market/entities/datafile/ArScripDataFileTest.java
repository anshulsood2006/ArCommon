package com.arsoft.projects.common.business.market.entities.datafile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.business.market.factory.ArScripDataFileFactory;
import com.arsoft.projects.common.business.market.factory.ArScripTestUtil;
import com.arsoft.projects.common.exception.ArException;

public class ArScripDataFileTest {
	@Test
	public void verifyHeaderAndFooterString() throws ArException{
		ArScrip arScrip = ArScripTestUtil.getTestScrip();
		ArScripDataFile arScripDataFile = ArScripDataFileFactory.getArScripDataFile(arScrip, ArScripDataFileEnum.COMPLETE_DAY_DATE_FILE);
		assertNotNull(arScripDataFile);
		ArScripDataFileHeader header = arScripDataFile.getArScripDataFileHeader();
		ArScripDataFileFooter footer = arScripDataFile.getArScripDataFileFooter();
		assertNotNull(header);
		assertNotNull(footer);
		assertTrue(ArScripTestUtil.assertStringStartsWith(header.getArScripFileDataHeaderAsString(),"SBIN||SBIN_Complete_Day_Data_08_07_2018||Complete Day Data||08_07_2018@12_44_42||"));
		assertEquals(footer.getArScripDataFileFooterAsString(),"21.64@08_07_2018@12_44_42");
		arScripDataFile = ArScripDataFileFactory.getArScripDataFile(arScrip, ArScripDataFileEnum.CURRENT_DATA_FILE);
		assertNotNull(arScripDataFile);
		header = arScripDataFile.getArScripDataFileHeader();
		footer = arScripDataFile.getArScripDataFileFooter();
		assertNotNull(header);
		assertNotNull(footer);
		assertEquals(footer.getArScripDataFileFooterAsString(),"21.64@08_07_2018@12_44_42");
		assertTrue(ArScripTestUtil.assertStringStartsWith(header.getArScripFileDataHeaderAsString(),"SBIN||SBIN_Current_Data_08_07_2018||Current Data||08_07_2018@12_44_42||"));
		arScripDataFile = ArScripDataFileFactory.getArScripDataFile(arScrip, ArScripDataFileEnum.DAY_DATA_FILE);
		assertNotNull(arScripDataFile);
		header = arScripDataFile.getArScripDataFileHeader();
		footer = arScripDataFile.getArScripDataFileFooter();
		assertNotNull(header);
		assertNotNull(footer);
		arScripDataFile = ArScripDataFileFactory.getArScripDataFile(arScrip, ArScripDataFileEnum.MONTH_DATA_FILE);
		assertNotNull(arScripDataFile);
		header = arScripDataFile.getArScripDataFileHeader();
		footer = arScripDataFile.getArScripDataFileFooter();
		assertNotNull(header);
		assertNotNull(footer);
		arScripDataFile = ArScripDataFileFactory.getArScripDataFile(arScrip, ArScripDataFileEnum.WEEK_DATA_FILE);
		assertNotNull(arScripDataFile);
		header = arScripDataFile.getArScripDataFileHeader();
		footer = arScripDataFile.getArScripDataFileFooter();
		assertNotNull(header);
		assertNotNull(footer);
		arScripDataFile = ArScripDataFileFactory.getArScripDataFile(arScrip, ArScripDataFileEnum.YEAR_DATA_FILE);
		assertNotNull(arScripDataFile);
		header = arScripDataFile.getArScripDataFileHeader();
		footer = arScripDataFile.getArScripDataFileFooter();
		assertNotNull(header);
		assertNotNull(footer);
	}
	
}
