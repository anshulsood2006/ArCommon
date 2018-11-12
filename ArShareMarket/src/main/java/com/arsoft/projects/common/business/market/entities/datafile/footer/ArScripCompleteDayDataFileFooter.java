package com.arsoft.projects.common.business.market.entities.datafile.footer;

import java.util.ArrayList;
import java.util.List;

import com.arsoft.projects.arcommon.ArDate;
import com.arsoft.projects.arcommon.ArDateTime;
import com.arsoft.projects.arcommon.ArTime;
import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.util.ArScripPriceDataUtil;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.string.ArStringUtil;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripCompleteDayDataFileFooter extends ArScripDataFileFooter{

	private List<ArPriceData> currentPriceList;
		
	public List<ArPriceData> getCurrentPriceList() {
		return currentPriceList;
	}

	public void setCurrentPriceList(List<ArPriceData> currentPriceList) {
		this.currentPriceList = currentPriceList;
	}

	public ArScripCompleteDayDataFileFooter(ArScrip arScrip) {
		super(arScrip, ArScripDataFileEnum.COMPLETE_DAY_DATE_FILE);
		if (this.currentPriceList == null){
			currentPriceList = new ArrayList<>();
		}
		ArPriceData e = new ArPriceData(arScrip.getPrice(), arScrip.getTimeOfRecord());
		this.currentPriceList.add(e);
	}
	
	public ArScripCompleteDayDataFileFooter(String footerString, ArScrip arScrip)  throws ArException {
		super(footerString, arScrip);
		super.setArScripDataFileEnum(ArScripDataFileEnum.CURRENT_DATA_FILE);
		
		if (footerString == null || footerString.length() == 0){
        	throw new ArException("ArScripCompleteDayDataFileFooter: Null Footer String");
        }
		
		String[] parts = ArStringUtil.splitString(footerString, ArStringConstant.DOUBLE_PIPE);
		if (parts == null || parts.length < 1){
        	throw new ArException("ArScripCompleteDayDataFileFooter: Invalid Footer String");
        }
		
		for (String part : parts) {
			if (this.currentPriceList == null){
				currentPriceList = new ArrayList<>();
			}
			ArPriceData currentPrice = ArScripPriceDataUtil.getArPriceData(part); 
			this.currentPriceList.add(currentPrice);
		}
	}

	public ArScripCompleteDayDataFileFooter() {
		
	}

	/**
	 * Returns footer string for Complete Day Data File in the format 
	 * price@date@time||price@date@time||price@date@time||price@date@time
	 * @return footer string for Complete Day Data File in the format
	 * @throws ArException
	 */
	public String getArScripDataFileFooterAsString() throws ArException {
		String footer = "";
		String scrip = this.getArScrip().getName();
		if(scrip == null || scrip.equals(ArStringConstant.EMPTY_STRING)) {
			throw new ArException("ArScripCompleteDayDataFileFooter: Scrip is not present");
		}
		ArScripDataFileEnum arScripDataFileEnum = this.getArScripDataFileEnum();
		if(arScripDataFileEnum == null || !ArScripDataFileEnum.isHavingEnum(arScripDataFileEnum.name())) {
			throw new ArException("ArScripCompleteDayDataFileFooter: Invalid value for arScripFileDataEnum");
		}
		List<ArPriceData> currentPriceList = this.getCurrentPriceList();
		if (currentPriceList != null) {
			int size = currentPriceList.size();
			for (int index = 0 ; index <  size ; index ++) {
				ArPriceData arPriceData = currentPriceList.get(index);
				double price = arPriceData.getPrice();
				ArDateTime arDateTime = arPriceData.getArDateTime();
				ArDate arDate = arDateTime.getArDate();
				ArTime arTime = arDateTime.getArTime();
				String string = price + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredDate(arDate) + ArStringConstant.AT_THE_RATE + ArDateTimeUtil.getUnderScoredTime(arTime);
				if (index < size - 1) {
					footer = footer + string + ArStringConstant.DOUBLE_PIPE ;
				}
				else {
					footer = footer + string;
				}
				
			}
		}
		return footer;
	}
	
	public String toString() {
		return "Scrip: "+this.getArScrip()+", Current Price List: "+this.getCurrentPriceList();
	}
	
	public static ArScripDataFileFooter getArScripDataFileFooter(ArScrip arScrip){
		return new ArScripCompleteDayDataFileFooter(arScrip);
	}

	public static ArScripDataFileFooter getArScripDataFileFooter(String footerString, ArScrip arScrip) throws ArException {
		return new ArScripCompleteDayDataFileFooter(footerString, arScrip);
	}
	
}
