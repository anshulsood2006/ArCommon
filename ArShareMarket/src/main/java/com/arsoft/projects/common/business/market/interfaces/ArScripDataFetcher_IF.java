package com.arsoft.projects.common.business.market.interfaces;

import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.equity.ArBourse;

public interface ArScripDataFetcher_IF {
	/*
	 * This method will bring the scrips current live data.
	 * 
	 * @param scripName name of the scrip
	 * @ return ArScrip object
	 */
	public ArScrip getScripCurrentData(String scripName, ArBourse arBourse) throws ArException;
}
