package com.arsoft.projects.common.business.market.entities.datafile.footer;

import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.entity.ArTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.string.ArStringUtil;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripDataFileWithOnlyHighLowFooter extends ArScripDataFileFooter{

	public ArScripDataFileWithOnlyHighLowFooter(ArScrip arScrip, ArScripDataFileEnum arScripDataFileEnum) {
		super(arScrip, arScripDataFileEnum);
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
	
	public ArScripDataFileWithOnlyHighLowFooter() {
		
	}
	
	public ArScripDataFileWithOnlyHighLowFooter(String footerString, ArScrip arScrip)  throws ArException {
		super(footerString, arScrip);
		if (footerString == null || footerString.length() == 0){
        	throw new ArException("ArScripDataFileWithOnlyHighLowFooter: Null Footer String");
        }
		String[] parts = ArStringUtil.splitString(footerString, ArStringConstant.DOUBLE_PIPE);
		if (parts == null || parts.length != 2){
        	throw new ArException("ArScripDataFileWithOnlyHighLowFooter: Invalid Footer String");
        }
		
		String highestPriceString = parts[0];
		String[] highestPriceStringArray = ArStringUtil.splitString(highestPriceString, ArStringConstant.AT_THE_RATE);
		if (highestPriceStringArray == null || highestPriceStringArray.length != 3){
        	throw new ArException("ArScripDataFileWithOnlyHighLowFooter: Invalid Highest Price in Footer String");
        }
		double highestPrice = Double.parseDouble(highestPriceStringArray[0]);
		String highestPriceDateString = highestPriceStringArray[1];
		ArDate arDate = ArDateTimeUtil.getArDate(highestPriceDateString);
		String highestPriceTimeString = highestPriceStringArray[2];
		ArTime arTime = ArDateTimeUtil.getArTime(highestPriceTimeString);
		ArDateTime arDateTime = new ArDateTime(arDate, arTime);
		ArPriceData highPrice = new ArPriceData(highestPrice, arDateTime);
		this.setHighPrice(highPrice);
		
		String lowestPriceString = parts[1];
		String[] lowestPriceStringArray = ArStringUtil.splitString(lowestPriceString, ArStringConstant.AT_THE_RATE);
		if (lowestPriceStringArray == null || lowestPriceStringArray.length != 3){
        	throw new ArException("ArScripDataFileWithOnlyHighLowFooter: Invalid Lowest Price in Footer String");
        }
		double lowestPrice = Double.parseDouble(lowestPriceStringArray[0]);
		String lowettPriceDateString = lowestPriceStringArray[1];
		arDate = ArDateTimeUtil.getArDate(lowettPriceDateString);
		String lowestPriceTimeString = lowestPriceStringArray[2];
		arTime = ArDateTimeUtil.getArTime(lowestPriceTimeString);
		arDateTime = new ArDateTime(arDate, arTime);
		ArPriceData lowPrice = new ArPriceData(lowestPrice, arDateTime);
		this.setLowPrice(lowPrice);
	}

	@Override
	public String getArScripDataFileFooterAsString() throws ArException {
		String scrip = this.getArScrip().getName();
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
		return "Scrip: "+this.getArScrip()+", High Price: "+this.getHighPrice()+", Low Price: "+this.getLowPrice();
	}
	
}
