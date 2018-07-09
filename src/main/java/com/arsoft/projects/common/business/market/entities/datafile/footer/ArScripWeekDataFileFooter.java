package com.arsoft.projects.common.business.market.entities.datafile.footer;

import com.arsoft.projects.common.business.market.constant.ArScripDataFileEnum;
import com.arsoft.projects.common.exception.ArException;

public class ArScripWeekDataFileFooter extends ArScripDataFileWithOnlyHighLowFooter{

	public ArScripWeekDataFileFooter(String scrip) {
		super(scrip, ArScripDataFileEnum.WEEK_DATA_FILE);
	}

	@Override
	public String getArScripDataFileFooterAsString() throws ArException {
		return super.getArScripDataFileFooterAsString();
	}
	
	public String toString() {
		return "Scrip: "+this.getScrip()+"High Price: "+this.getHighPrice()+", Low Price: "+this.getLowPrice();
	}

}
