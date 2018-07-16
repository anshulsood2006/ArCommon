package com.arsoft.projects.common.business.market.entities.datafile.writer;

import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripYearDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.business.market.interfaces.ArScripDataFileWriter_IF;
import com.arsoft.projects.common.business.market.util.ArScripPriceDataUtil;
import com.arsoft.projects.common.exception.ArException;

public class ArScripYearDataFileWriter implements ArScripDataFileWriter_IF {

	@Override
	public void writeData(ArScripDataFile arScripDataFile) throws ArException {
		ArScripPriceDataUtil.writeArScripDataFile(arScripDataFile);
	}

	@Override
	public void updateData(ArScripDataFile arScripDataFileCached, ArScripDataFile arScripDataFileNew) throws ArException{
		ArScripDataFileHeader headerCached = arScripDataFileCached.getArScripDataFileHeader();
		ArScripYearDataFileFooter footerCached = (ArScripYearDataFileFooter) arScripDataFileCached.getArScripDataFileFooter();
		ArScripDataFileHeader headerNew = arScripDataFileNew.getArScripDataFileHeader();
		ArScrip arScrip = headerNew.getArScrip();
		headerCached.setUpdatedDateTime(arScrip.getTimeOfRecord());
		ArPriceData arScripPrice = new ArPriceData(arScrip.getPrice(), arScrip.getTimeOfRecord());
		if (arScrip.getPrice() > footerCached.getHighPrice().getPrice()){
			footerCached.setHighPrice(arScripPrice);
		}
		if (arScrip.getPrice() < footerCached.getLowPrice().getPrice()){
			footerCached.setLowPrice(arScripPrice);
		}
		ArScripPriceDataUtil.writeArScripDataFile(arScripDataFileCached);
	}

}
