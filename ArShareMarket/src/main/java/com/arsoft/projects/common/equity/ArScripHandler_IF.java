package com.arsoft.projects.common.equity;

public interface ArScripHandler_IF {

	//Should return the scrip name
	public void getScripName();
	
	//
	public void getCurrentScripPrice();
	
	public void getMaximumScripData();
	
	public void getMinimumScripData();
}
