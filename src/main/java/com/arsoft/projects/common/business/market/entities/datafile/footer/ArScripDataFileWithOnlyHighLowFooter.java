package com.arsoft.projects.common.business.market.entities.datafile.footer;

import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.entity.ArTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripDataFileWithOnlyHighLowFooter extends ArScripDataFileFooter{

	public ArScripDataFileWithOnlyHighLowFooter(String scrip, ArScripDataFileEnum arScripDataFileEnum) {
		super(scrip, arScripDataFileEnum);
	}

	private ArPriceData highPrice;
	private ArPriceData lowPrice;
	
	public ArPriceData getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(ArPriceData highPrice) {
		this.highPrice = highPrice;
	}

	public ArPriceData getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(ArPriceData lowPrice) {
		this.lowPrice = lowPrice;
	}

	@Override
	public String getArScripDataFileFooterAsString() throws ArException {
		String scrip = this.getScrip();
		if(scrip == null || scrip.equals(ArStringConstant.EMPTY_STRING)) {
			throw new ArException("ArScripCurrentDataFileFooter: Scrip is not present");
		}
		ArScripDataFileEnum arScripDataFileEnum = this.getArScripDataFileEnum();
		if(arScripDataFileEnum == null || !ArScripDataFileEnum.isHavingEnum(arScripDataFileEnum.name())) {
			throw new ArException("ArScripCurrentDataFileFooter: Invalid value for arScripFileDataEnum");
		}
		double price = highPrice.getPrice();
		ArDateTime arDateTime = highPrice.getArDateTime();
		ArDate arDate = arDateTime.getArDate();
		ArTime arTime = arDateTime.getArTime();
		String footer = price + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredDate(arDate) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(arTime)+ArStringConstant.DOUBLE_PIPE;
		price = lowPrice.getPrice();
		arDateTime = lowPrice.getArDateTime();
		arDate = arDateTime.getArDate();
		arTime = arDateTime.getArTime();
		footer = footer + price + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredDate(arDate) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(arTime);
		return footer;
	}
	
	public String toString() {
		return "Scrip: "+this.getScrip()+"High Price: "+this.getHighPrice()+", Low Price: "+this.getLowPrice();
	}
	
	

}
