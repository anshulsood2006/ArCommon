package com.arsoft.projects.common.equity;

public enum ArBourse {
	
	NSE("NSE"),
	BSE("BSE");

	private String bourse;
	
	private ArBourse(String bourse){
		this.bourse = bourse;
	}
	
	public String getEquityAction(){
		return this.bourse;
	}
}
