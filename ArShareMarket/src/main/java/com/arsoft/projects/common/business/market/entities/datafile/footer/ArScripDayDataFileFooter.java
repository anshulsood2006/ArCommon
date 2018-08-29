package com.arsoft.projects.common.business.market.entities.datafile.footer;

import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.entity.ArTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.util.ArScripPriceDataUtil;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.string.ArStringUtil;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripDayDataFileFooter extends ArScripDataFileFooter{

	private ArPriceData previousClosePrice;
	private ArPriceData openPrice;
	private ArPriceData highPrice;
	private ArPriceData lowPrice;
	private ArPriceData closePrice;
	
	public ArPriceData getPreviousClosePrice() {
		return previousClosePrice;
	}

	public void setPreviousClosePrice(ArPriceData previousClosePrice) {
		this.previousClosePrice = previousClosePrice;
	}

	public ArPriceData getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(ArPriceData openPrice) {
		this.openPrice = openPrice;
	}

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

	public ArPriceData getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(ArPriceData closePrice) {
		this.closePrice = closePrice;
	}

	public ArScripDayDataFileFooter(ArScrip arScrip) {
		super(arScrip, ArScripDataFileEnum.DAY_DATA_FILE);
		this.previousClosePrice = new ArPriceData(0, ArDateTimeUtil.getCurrentArDateTime());
		this.openPrice = new ArPriceData(0, ArDateTimeUtil.getCurrentArDateTime());
		this.highPrice = new ArPriceData(0, ArDateTimeUtil.getCurrentArDateTime());
		this.lowPrice = new ArPriceData(0, ArDateTimeUtil.getCurrentArDateTime());
		this.closePrice = new ArPriceData(0, ArDateTimeUtil.getCurrentArDateTime());
	}
	
	public ArScripDayDataFileFooter(ArScrip arScrip, ArPriceData previousClosePrice, ArPriceData openPrice, ArPriceData highPrice, ArPriceData lowPrice, ArPriceData closePrice) {
		super(arScrip, ArScripDataFileEnum.DAY_DATA_FILE);
		this.previousClosePrice = previousClosePrice;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
	}
	
	public ArScripDayDataFileFooter(String footerString, ArScrip arScrip) throws ArException {
		super(footerString, arScrip);
		super.setArScripDataFileEnum(ArScripDataFileEnum.DAY_DATA_FILE);
		
		if (footerString == null || footerString.length() == 0){
        	throw new ArException("ArScripDayDataFileFooter: Null Footer String");
        }
		String[] parts = ArStringUtil.splitString(footerString, ArStringConstant.DOUBLE_PIPE);
		if (parts == null || parts.length != 5){
        	throw new ArException("ArScripDayDataFileFooter: Invalid Footer String");
        }
	
		String previousClosePriceString = parts[0];
		ArPriceData previousClosePrice = ArScripPriceDataUtil.getArPriceData(previousClosePriceString);
		this.setPreviousClosePrice(previousClosePrice);
		
		String openPriceString = parts[1];
		ArPriceData openPrice = ArScripPriceDataUtil.getArPriceData(openPriceString);
		this.setOpenPrice(openPrice);
		
		String highPriceString = parts[2];
		ArPriceData highPrice = ArScripPriceDataUtil.getArPriceData(highPriceString);
		this.setHighPrice(highPrice);
		
		String lowPriceString = parts[3];
		ArPriceData lowPrice = ArScripPriceDataUtil.getArPriceData(lowPriceString);
		this.setLowPrice(lowPrice);
		
		String closePriceString = parts[4];
		ArPriceData closePrice = ArScripPriceDataUtil.getArPriceData(closePriceString);
		this.setClosePrice(closePrice);
		
		
	}

	/**
	 * Returns footer string for Day Data File in the format 
	 * price@date@time
	 * @return footer string for Day Data File in the format 
	 * @throws ArException
	 */
	@Override
	public String getArScripDataFileFooterAsString() throws ArException {
		String footer = ArStringConstant.EMPTY_STRING;
		String scrip = this.getArScrip().getName();
		if(scrip == null || scrip.equals(ArStringConstant.EMPTY_STRING)) {
			throw new ArException("ArScripCurrentDataFileFooter: Scrip is not present");
		}
		ArScripDataFileEnum arScripDataFileEnum = this.getArScripDataFileEnum();
		if(arScripDataFileEnum == null || !ArScripDataFileEnum.isHavingEnum(arScripDataFileEnum.name())) {
			throw new ArException("ArScripCurrentDataFileFooter: Invalid value for arScripFileDataEnum");
		}
		double price = previousClosePrice.getPrice();
		ArDateTime arDateTime = previousClosePrice.getArDateTime();
		ArDate arDate = arDateTime.getArDate();
		ArTime arTime = arDateTime.getArTime();
		footer = footer+ price + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredDate(arDate) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(arTime) + ArStringConstant.DOUBLE_PIPE;
		price = openPrice.getPrice();
		arDateTime = openPrice.getArDateTime();
		arDate = arDateTime.getArDate();
		arTime = arDateTime.getArTime();
		footer = footer+ price + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredDate(arDate) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(arTime) + ArStringConstant.DOUBLE_PIPE;
		price = highPrice.getPrice();
		arDateTime = highPrice.getArDateTime();
		arDate = arDateTime.getArDate();
		arTime = arDateTime.getArTime();
		footer = footer+ price + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredDate(arDate) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(arTime) + ArStringConstant.DOUBLE_PIPE;
		price = lowPrice.getPrice();
		arDateTime = lowPrice.getArDateTime();
		arDate = arDateTime.getArDate();
		arTime = arDateTime.getArTime();
		footer = footer+ price + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredDate(arDate) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(arTime) + ArStringConstant.DOUBLE_PIPE;
		price = closePrice.getPrice();
		arDateTime = closePrice.getArDateTime();
		arDate = arDateTime.getArDate();
		arTime = arDateTime.getArTime();
		footer = footer+ price + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredDate(arDate) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(arTime);
		return footer;
	}
	
	public String toString() {
		return "Scrip: "+this.getArScrip()+", Previous Close Price: "+this.getPreviousClosePrice()+", Open Price: "+this.getOpenPrice()+", High Price: "+this.getHighPrice()+", Low Price: "+this.getLowPrice()+", Close Price: "+this.getClosePrice();
	}

	public static ArScripDataFileFooter getArScripDataFileFooter(ArScrip arScrip){
		return new ArScripDayDataFileFooter(arScrip);
	}

	public static ArScripDataFileFooter getArScripDataFileFooter(String footerString, ArScrip arScrip) throws ArException {
		return new ArScripDayDataFileFooter(footerString, arScrip);
	}
}
