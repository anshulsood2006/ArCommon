package com.arsoft.projects.common.business.market.factory;

import com.arsoft.projects.common.business.entity.ArAmPmEnum;
import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.entity.ArMonthEnum;
import com.arsoft.projects.common.business.entity.ArTime;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.equity.ArBourse;

public class ArScripTestUtil {
	public static ArScrip getTestScrip(){
		ArDate arDate = new ArDate(8, ArMonthEnum.JULY, 2018);
		ArTime arTime = new ArTime(12, 44, 42, ArAmPmEnum.PM);
		ArDateTime arDateTime = new ArDateTime(arDate, arTime);
		ArScrip arScrip = new ArScrip("SBIN", "", ArBourse.NSE, 21.64, arDateTime);
		return arScrip;
	}
	
	public static boolean assertStringStartsWith(String arScripFileDataHeaderAsString, String string) {
		return arScripFileDataHeaderAsString.startsWith(string);
	}
}
