package com.arsoft.projects.common.equity;

public enum ArEquityAction {
		
	BUY("BUY"),
	SELL("SELL");

	
	private String equityAction;
	
	private ArEquityAction(String equityAction){
		this.equityAction = equityAction;
	}
	
	public String getEquityAction(){
		return this.equityAction;
	}

}
