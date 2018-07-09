package com.arsoft.projects.common.business.market.entities.datafile.footer;

import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.entity.ArTime;
import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFileEnum;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripCurrentDataFileFooter extends ArScripDataFileFooter{

	private ArPriceData currentPrice;
	
	public ArPriceData getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(ArPriceData currentPrice) {
		this.currentPrice = currentPrice;
	}

	public ArScripCurrentDataFileFooter(String scrip, ArPriceData currentPrice) {
		super(scrip, ArScripDataFileEnum.CURRENT_DATA_FILE);
		this.currentPrice = currentPrice;
	}

	/**
	 * Returns footer string for Current Data File in the format 
	 * price@date@time
	 * @return footer string for Current Data File in the format 
	 * @throws ArException
	 */
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
		double price = currentPrice.getPrice();
		ArDateTime arDateTime = currentPrice.getArDateTime();
		ArDate arDate = arDateTime.getArDate();
		ArTime arTime = arDateTime.getArTime();
		return price + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredDate(arDate) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(arTime);
	}
	
	public String toString() {
		return "Scrip: "+this.getScrip()+", Current Price: "+this.getCurrentPrice();
	}
	
}
