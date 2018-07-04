package com.arsoft.projects.common.business.market.interfaces;

import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.equity.ArBourse;
import com.arsoft.projects.common.webservice.rest.sharemarket.ArScripUtil;

public class ArScripDataFetcher implements ArScripDataFetcher_IF{

	@Override
	public ArScrip getScripCurrentData(String scripName, ArBourse arBourse) {
		ArScrip arScrip = ArScripUtil.getArScrip(scripName, arBourse);
		return arScrip;
	}
	
	public static void main(String[] args) {
		ArScripDataFetcher a = new ArScripDataFetcher();
		ArScrip s = a.getScripCurrentData("SBIN", ArBourse.NSE);
		System.out.println(s);
	}

}
