package com.arsoft.projects.common.business.market.entities.datafile.reader;

import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;
import com.arsoft.projects.common.business.market.interfaces.ArScripDataFileReader_IF;

public class ArScripWeekDataFileReader implements ArScripDataFileReader_IF {

	@Override
	public ArScripDataFile readData(String fileName, ArScrip arScrip) throws ArException {
		return null;
	}

	public static ArScripDataFileReader_IF getArScripDataReader() {
		return new ArScripWeekDataFileReader();
	}
}
