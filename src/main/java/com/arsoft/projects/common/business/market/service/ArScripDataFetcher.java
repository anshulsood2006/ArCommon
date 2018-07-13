package com.arsoft.projects.common.business.market.service;

import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;
import com.arsoft.projects.common.business.market.factory.ArScripDataFileFactory;
import com.arsoft.projects.common.business.market.interfaces.ArScripDataFetcher_IF;
import com.arsoft.projects.common.equity.ArBourse;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.webservice.rest.sharemarket.ArScripUtil;

public class ArScripDataFetcher implements ArScripDataFetcher_IF{

	@Override
	public ArScrip getScripCurrentData(String scripName, ArBourse arBourse) throws ArException {
		ArScrip arScrip = ArScripUtil.getArScrip(scripName, arBourse);
		return arScrip;
	}
	
	public static void main(String[] args) throws ArException {
		ArScripDataFetcher a = new ArScripDataFetcher();
		ArScrip arScrip = a.getScripCurrentData("SBIN", ArBourse.NSE);
		ArScripDataFile arScripDataFile = ArScripDataFileFactory.getArScripDataFile(arScrip, ArScripDataFileEnum.COMPLETE_DAY_DATE_FILE);
		System.out.println(arScripDataFile.getArScripDataFileHeader().getArScripFileDataHeaderAsString());
		System.out.println(arScripDataFile.getArScripDataFileFooter().getArScripDataFileFooterAsString());
	}

}
