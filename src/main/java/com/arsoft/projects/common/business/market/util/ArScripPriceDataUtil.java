package com.arsoft.projects.common.business.market.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.entity.ArTime;
import com.arsoft.projects.common.business.market.constant.ArScripConstant;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;
import com.arsoft.projects.common.business.market.factory.ArScripDataFileReaderFactory;
import com.arsoft.projects.common.business.market.interfaces.ArScripDataFileReader_IF;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.string.ArStringUtil;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripPriceDataUtil {
	
	public static ArPriceData getArPriceData(String priceDataString) throws ArException {
		String[] priceStringArray = ArStringUtil.splitString(priceDataString, ArStringConstant.AT_THE_RATE);
		if (priceStringArray == null || priceStringArray.length != 3){
        	throw new ArException("ArPriceDataUtil: Invalid priceDataString");
        }
		double price = Double.parseDouble(priceStringArray[0]);
		String priceDateString = priceStringArray[1];
		ArDate arDate = ArDateTimeUtil.getArDate(priceDateString);
		String highestPriceTimeString = priceStringArray[2];
		ArTime arTime = ArDateTimeUtil.getArTime(highestPriceTimeString);
		ArDateTime arDateTime = new ArDateTime(arDate, arTime);
		ArPriceData arPriceData = new ArPriceData(price, arDateTime);
		return arPriceData;
	}

	public static void writeToFile(String fileName, String contentToWrite) {
		System.out.println("Going to write to file: "+fileName + "Content: "+contentToWrite);		
	}

	public static void writeArScripDataFile(ArScripDataFile arScripDataFileCached) throws ArException {
		String fileName = arScripDataFileCached.getArScripDataFileHeader().getFileName();
		String footer = arScripDataFileCached.getArScripDataFileFooter().getArScripDataFileFooterAsString();
		String header = arScripDataFileCached.getArScripDataFileHeader().getArScripFileDataHeaderAsString();
		String contentToWrite =  footer+"\n"+header;
	}
	
	public static ArScripDataFile readArScripDataFile(String fileName, ArScripDataFileEnum arScripDataFileEnum, ArScrip arScrip) throws ArException{
		ArScripDataFileReader_IF reader = ArScripDataFileReaderFactory.getArScripDataFileReader(arScripDataFileEnum);
		ArScripDataFile arScripDataFile = reader.readData(fileName, arScrip);
		return arScripDataFile;
	}
	
	public static Map<String, String> readFile(String filePath) {
		Map<String, String> headerFooterStringMap = null;
		try {
			File file = new File(filePath);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String[] arr = new String[2];
			String line;
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				arr[i] = line;
				i++;
			}
			fileReader.close();
			headerFooterStringMap = new HashMap<>();
			headerFooterStringMap.put(ArScripConstant.DATA_FILE_HEADER, arr[0]);
			headerFooterStringMap.put(ArScripConstant.DATA_FILE_FOOTER, arr[1]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return headerFooterStringMap;
	}
}
