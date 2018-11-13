package com.arsoft.projects.common.business.market.interfaces;

import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;

public interface ArScripDataFileReader_IF{
	public ArScripDataFile readData(String fileName, ArScrip arScrip) throws ArException;
}
