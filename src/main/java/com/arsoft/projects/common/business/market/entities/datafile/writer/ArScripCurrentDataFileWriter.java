package com.arsoft.projects.common.business.market.entities.datafile.writer;

import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripCurrentDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.business.market.interfaces.ArScripDataFileWriter_IF;
import com.arsoft.projects.common.business.market.util.ArScripPriceDataUtil;
import com.arsoft.projects.common.exception.ArException;

public class ArScripCurrentDataFileWriter implements ArScripDataFileWriter_IF {

	@Override
	public void writeData(ArScripDataFile arScripDataFile) throws ArException {
		ArScripPriceDataUtil.writeArScripDataFile(arScripDataFile);
	}

	@Override
	public void updateData(ArScripDataFile arScripDataFileCached, ArScripDataFile arScripDataFileNew) throws ArException{
		ArScripDataFileHeader headerCached = arScripDataFileCached.getArScripDataFileHeader();
		ArScripCurrentDataFileFooter footerCached = (ArScripCurrentDataFileFooter) arScripDataFileCached.getArScripDataFileFooter();
		ArScripDataFileHeader headerNew = arScripDataFileNew.getArScripDataFileHeader();
		ArScripCurrentDataFileFooter footerNew = (ArScripCurrentDataFileFooter) arScripDataFileNew.getArScripDataFileFooter();
		headerCached.setUpdatedDateTime(headerNew.getUpdatedDateTime());
		footerCached.setCurrentPrice(footerNew.getCurrentPrice());
		ArScripPriceDataUtil.writeArScripDataFile(arScripDataFileCached);
	}

}
