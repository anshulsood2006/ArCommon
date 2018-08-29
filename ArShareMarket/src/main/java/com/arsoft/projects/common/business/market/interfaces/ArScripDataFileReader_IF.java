package com.arsoft.projects.common.business.market.interfaces;

import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;
import com.arsoft.projects.common.exception.ArException;

public interface ArScripDataFileReader_IF{
	public ArScripDataFile readData(String fileName, ArScrip arScrip) throws ArException;
}
