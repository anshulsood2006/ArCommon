package com.arsoft.projects.common.business.market.entities.datafile.footer;

import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripMonthDataFileFooter extends ArScripDataFileWithOnlyHighLowFooter{

	public ArScripMonthDataFileFooter(ArScrip arScrip) {
		super(arScrip, ArScripDataFileEnum.MONTH_DATA_FILE);
		this.setLowPrice(new ArPriceData(0, ArDateTimeUtil.getCurrentArDateTime()));
		this.setHighPrice(new ArPriceData(0, ArDateTimeUtil.getCurrentArDateTime()));
	}

	@Override
	public String getArScripDataFileFooterAsString() throws ArException {
		return super.getArScripDataFileFooterAsString();
	}

	public String toString() {
		return "Scrip: "+this.getArScrip()+", High Price: "+this.getHighPrice()+", Low Price: "+this.getLowPrice();
	}
	
	public static ArScripDataFileFooter getArScripDataFileFooter(ArScrip arScrip){
		return new ArScripMonthDataFileFooter(arScrip);
	}
}
