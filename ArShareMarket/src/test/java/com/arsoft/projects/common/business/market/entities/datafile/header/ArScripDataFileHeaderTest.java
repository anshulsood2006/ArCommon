package com.arsoft.projects.common.business.market.entities.datafile.header;

import org.junit.Test;

import com.arsoft.projects.common.exception.ArException;

public class ArScripDataFileHeaderTest {
	@Test
	public void verifyGetArScripFileDataHeader() throws ArException{
		String headerString = "SBIN||SBIN_Current_Data_05_07_2018||Current Data||05_07_2018@12_08_56||05_07_2018@14_22_33";
		ArScripDataFileHeader.getArScripDataFileHeader(headerString);
	}
}
