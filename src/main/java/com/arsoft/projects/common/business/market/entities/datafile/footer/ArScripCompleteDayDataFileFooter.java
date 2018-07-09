package com.arsoft.projects.common.business.market.entities.datafile.footer;

import java.util.List;

import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.entity.ArTime;
import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFileEnum;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArScripCompleteDayDataFileFooter extends ArScripDataFileFooter{

	private List<ArPriceData> currentPriceList;
		
	public List<ArPriceData> getCurrentPriceList() {
		return currentPriceList;
	}

	public void setCurrentPriceList(List<ArPriceData> currentPriceList) {
		this.currentPriceList = currentPriceList;
	}

	public ArScripCompleteDayDataFileFooter(String scrip, List<ArPriceData> currentPriceList) {
		super(scrip, ArScripDataFileEnum.COMPLETE_DAY_DATE_FILE);
		this.currentPriceList = currentPriceList;
	}
	
	/**
	 * Returns footer string for Complete Day Data File in the format 
	 * price@date@time||price@date@time||price@date@time||price@date@time
	 * @return footer string for Complete Day Data File in the format
	 * @throws ArException
	 */
	public String getArScripDataFileFooterAsString() throws ArException {
		String footer = "";
		String scrip = this.getScrip();
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

}
