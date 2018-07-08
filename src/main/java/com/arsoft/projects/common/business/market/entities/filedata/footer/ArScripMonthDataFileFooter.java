package com.arsoft.projects.common.business.market.entities.filedata.footer;

import com.arsoft.projects.common.business.market.entities.filedata.ArScripDataFileEnum;
import com.arsoft.projects.common.exception.ArException;

public class ArScripMonthDataFileFooter extends ArScripDataFileWithOnlyHighLowFooter{

	public ArScripMonthDataFileFooter(String scrip) {
		super(scrip, ArScripDataFileEnum.MONTH_DATA_FILE);
	}

	@Override
	public String getArScripDataFileFooterAsString() throws ArException {
		return super.getArScripDataFileFooterAsString();
	}

	public String toString() {
		return "Scrip: "+this.getScrip()+"High Price: "+this.getHighPrice()+", Low Price: "+this.getLowPrice();
	}
}
