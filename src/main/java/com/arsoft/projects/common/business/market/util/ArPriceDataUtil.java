package com.arsoft.projects.common.business.market.util;

import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.entity.ArTime;
import com.arsoft.projects.common.business.market.entities.ArPriceData;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.string.ArStringUtil;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;

public class ArPriceDataUtil {
	
	public static ArPriceData getArPriceData(String priceDataString) throws ArException {
		String[] priceStringArray = ArStringUtil.splitString(priceDataString, ArStringConstant.AT_THE_RATE);
		if (priceStringArray == null || priceStringArray.length != 3){
        	throw new ArException("ArPriceDataUtil: Invalid priceDataString");
        }
		double price = Double.parseDouble(priceStringArray[0]);
		String priceDateString = priceStringArray[1];
		ArDate arDate = ArDateTimeUtil.getArDate(priceDateString);
		String highestPriceTimeString = priceStringArray[2];
		ArTime arTime = ArDateTimeUtil.getArTime(highestPriceTimeString);
		ArDateTime arDateTime = new ArDateTime(arDate, arTime);
		ArPriceData arPriceData = new ArPriceData(price, arDateTime);
		return arPriceData;
	}
}
