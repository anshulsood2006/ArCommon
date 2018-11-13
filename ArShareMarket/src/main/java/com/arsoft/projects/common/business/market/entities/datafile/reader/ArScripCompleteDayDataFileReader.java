package com.arsoft.projects.common.business.market.entities.datafile.reader;

import java.util.Map;

import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.common.business.market.constant.ArScripConstant;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripCompleteDayDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripCompleteDayDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.footer.ArScripDataFileFooter;
import com.arsoft.projects.common.business.market.entities.datafile.header.ArScripDataFileHeader;
import com.arsoft.projects.common.business.market.interfaces.ArScripDataFileReader_IF;
import com.arsoft.projects.common.business.market.util.ArScripPriceDataUtil;

public class ArScripCompleteDayDataFileReader implements ArScripDataFileReader_IF {

	@Override
	public ArScripDataFile readData(String fileName, ArScrip arScrip) throws ArException {
		Map<String, String> headerFooterStringMap = ArScripPriceDataUtil.readFile(fileName);
		String headerString = headerFooterStringMap.get(ArScripConstant.DATA_FILE_HEADER);
		String footerString = headerFooterStringMap.get(ArScripConstant.DATA_FILE_FOOTER);;
		ArScripDataFileHeader header = ArScripDataFileHeader.getArScripDataFileHeader(headerString);
		ArScripDataFileFooter footer = ArScripCompleteDayDataFileFooter.getArScripDataFileFooter(footerString, arScrip);
		ArScripDataFile arScripDataFile = new ArScripCompleteDayDataFile(header, footer);
		return arScripDataFile;
	}

	public static ArScripDataFileReader_IF getArScripDataReader() {
		return new ArScripCompleteDayDataFileReader();
	}

	
}
