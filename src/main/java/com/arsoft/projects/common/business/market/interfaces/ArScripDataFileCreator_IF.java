package com.arsoft.projects.common.business.market.interfaces;

import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;

public interface ArScripDataFileCreator_IF {
	
	public abstract ArScripDataFile createArScripCompleteDayDataFile(ArScrip arScrip);
	
	public abstract ArScripDataFile createArScripCurrentDataFile(ArScrip arScrip);
	
	public abstract ArScripDataFile createArScripDayDataFile(ArScrip arScrip);
	
	public abstract ArScripDataFile createArScripMonthDataFile(ArScrip arScrip);
	
	public abstract ArScripDataFile createArScripWeekDataFile(ArScrip arScrip);
	
	public abstract ArScripDataFile createArScripYearDataFile(ArScrip arScrip);
	
}
