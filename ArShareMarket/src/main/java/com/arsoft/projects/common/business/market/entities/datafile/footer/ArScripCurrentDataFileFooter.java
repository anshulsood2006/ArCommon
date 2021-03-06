package com.arsoft.projects.common.business.market.entities.datafile.footer;

import com.arsoft.projects.arshared.ArDate;
import com.arsoft.projects.arshared.ArDateTime;
import com.arsoft.projects.arshared.ArTime;
import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.util.ArScripPriceDataUtil;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.string.ArStringUtil;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripCurrentDataFileFooter extends ArScripDataFileFooter{

	private ArPriceData currentPrice;
	
	public ArPriceData getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(ArPriceData currentPrice) {
		this.currentPrice = currentPrice;
	}

	public ArScripCurrentDataFileFooter(ArScrip arScrip) {
		super(arScrip, ArScripDataFileEnum.CURRENT_DATA_FILE);
		this.currentPrice = new ArPriceData(arScrip.getPrice(), arScrip.getTimeOfRecord());
	}
	
	public ArScripCurrentDataFileFooter(String footerString, ArScrip arScrip) throws ArException {
		super(footerString, arScrip);
		super.setArScripDataFileEnum(ArScripDataFileEnum.CURRENT_DATA_FILE);
		
		if (footerString == null || footerString.length() == 0){
        	throw new ArException("ArScripCurrentDataFileFooter: Null Footer String");
        }
		
		String[] parts = ArStringUtil.splitString(footerString, ArStringConstant.DOUBLE_PIPE);
		if (parts == null || parts.length != 1){
        	throw new ArException("ArScripCurrentDataFileFooter: Invalid Footer String");
        }
		
		String currentPriceString = parts[0];
		ArPriceData currentPrice = ArScripPriceDataUtil.getArPriceData(currentPriceString);
		this.setCurrentPrice(currentPrice);
	}

	/**
	 * Returns footer string for Current Data File in the format 
	 * price@date@time
	 * @return footer string for Current Data File in the format 
	 * @throws ArException
	 */
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
		double price = currentPrice.getPrice();
		ArDateTime arDateTime = currentPrice.getArDateTime();
		ArDate arDate = arDateTime.getArDate();
		ArTime arTime = arDateTime.getArTime();
		return price + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredDate(arDate) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(arTime);
	}
	
	public String toString() {
		return "Scrip: "+this.getArScrip()+", Current Price: "+this.getCurrentPrice();
	}
	
	public static ArScripDataFileFooter getArScripDataFileFooter(ArScrip arScrip){
		return new ArScripCurrentDataFileFooter(arScrip);
	}

	public static ArScripDataFileFooter getArScripDataFileFooter(String footerString, ArScrip arScrip) throws ArException {
		return new ArScripCurrentDataFileFooter(footerString, arScrip);
	}
	
}
