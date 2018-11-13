package com.arsoft.projects.common.business.market.entities.datafile.writer;

import com.arsoft.projects.arshared.ArTime;
import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDayDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.business.market.interfaces.ArScripDataFileWriter_IF;
import com.arsoft.projects.common.business.market.util.ArScripPriceDataUtil;

public class ArScripDayDataFileWriter implements ArScripDataFileWriter_IF {

	@Override
	public void writeData(ArScripDataFile arScripDataFile) throws ArException {
		ArScripPriceDataUtil.writeArScripDataFile(arScripDataFile);
	}

	@Override
	public void updateData(ArScripDataFile arScripDataFileCached, ArScripDataFile arScripDataFileNew) throws ArException{
		ArScripDataFileHeader headerCached = arScripDataFileCached.getArScripDataFileHeader();
		ArScripDayDataFileFooter footerCached = (ArScripDayDataFileFooter) arScripDataFileCached.getArScripDataFileFooter();
		ArScripDataFileHeader headerNew = arScripDataFileNew.getArScripDataFileHeader();
		ArScrip arScrip = headerNew.getArScrip();
		headerCached.setUpdatedDateTime(arScrip.getTimeOfRecord());
		ArPriceData arScripPrice = new ArPriceData(arScrip.getPrice(), arScrip.getTimeOfRecord());
		if (footerCached.getPreviousClosePrice() == null){
			footerCached.setPreviousClosePrice(arScripPrice);
		}
		ArTime arTime= arScrip.getTimeOfRecord().getArTime();
		int hours = arTime.getHour();
		int minutes = arTime.getMinute();
		int second = arTime.getSecond();
		
		if (hours > 15 && minutes > 15 && second > 0){
			footerCached.setClosePrice(arScripPrice);
		}
		if (hours > 9 && minutes < 15 && second < 0){
			footerCached.setOpenPrice(arScripPrice);
		}
		if (arScrip.getPrice() > (footerCached.getHighPrice().getPrice())){
			footerCached.setHighPrice(arScripPrice);
		}
		if (arScrip.getPrice() < (footerCached.getLowPrice().getPrice())){
			footerCached.setLowPrice(arScripPrice);
		}	
		ArScripPriceDataUtil.writeArScripDataFile(arScripDataFileCached);
	}

	public static ArScripDataFileWriter_IF getArScripDataWriter() {
		return new ArScripDayDataFileWriter();
	}

}
