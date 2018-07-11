package com.arsoft.projects.common.business.market.entities.datafile.footer;

import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.exception.ArException;

public class ArScripYearDataFileFooter extends ArScripDataFileWithOnlyHighLowFooter{

	public ArScripYearDataFileFooter(ArScrip arScrip) {
		super(arScrip, ArScripDataFileEnum.YEAR_DATA_FILE);
	}

	@Override
	public String getArScripDataFileFooterAsString() throws ArException {
		return super.getArScripDataFileFooterAsString();
	}

	public String toString() {
		return "Scrip: "+this.getArScrip()+", High Price: "+this.getHighPrice()+", Low Price: "+this.getLowPrice();
	}
	
}