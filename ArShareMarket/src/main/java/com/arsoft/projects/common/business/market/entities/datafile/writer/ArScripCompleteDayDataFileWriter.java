package com.arsoft.projects.common.business.market.entities.datafile.writer;

import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripCompleteDayDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.business.market.interfaces.ArScripDataFileWriter_IF;
import com.arsoft.projects.common.business.market.util.ArScripPriceDataUtil;

public class ArScripCompleteDayDataFileWriter implements ArScripDataFileWriter_IF {

	@Override
	public void writeData(ArScripDataFile arScripDataFile) throws ArException {
		ArScripPriceDataUtil.writeArScripDataFile(arScripDataFile);
	}

	@Override
	public void updateData(ArScripDataFile arScripDataFileCached, ArScripDataFile arScripDataFileNew) throws ArException{
		ArScripDataFileHeader headerCached = arScripDataFileCached.getArScripDataFileHeader();
		ArScripCompleteDayDataFileFooter footerCached = (ArScripCompleteDayDataFileFooter) arScripDataFileCached.getArScripDataFileFooter();
		ArScripDataFileHeader headerNew = arScripDataFileNew.getArScripDataFileHeader();
		ArScripCompleteDayDataFileFooter footerNew = (ArScripCompleteDayDataFileFooter) arScripDataFileNew.getArScripDataFileFooter();
		headerCached.setUpdatedDateTime(headerNew.getUpdatedDateTime());
		footerCached.setCurrentPriceList(footerNew.getCurrentPriceList());
		ArScripPriceDataUtil.writeArScripDataFile(arScripDataFileCached);
	}

	public static ArScripDataFileWriter_IF getArScripDataWriter() {
		return new ArScripCompleteDayDataFileWriter();
	}
}
