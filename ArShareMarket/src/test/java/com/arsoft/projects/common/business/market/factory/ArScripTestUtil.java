package com.arsoft.projects.common.business.market.factory;

import com.arsoft.projects.arcommon.ArAmPmEnum;
import com.arsoft.projects.arcommon.ArDate;
import com.arsoft.projects.arcommon.ArDateTime;
import com.arsoft.projects.arcommon.ArMonthEnum;
import com.arsoft.projects.arcommon.ArTime;
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
