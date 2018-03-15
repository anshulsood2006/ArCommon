package com.arsoft.projects.common.webservice.rest.dukaan;

import org.json.JSONArray;

public interface ArDukaanServiceIF {
	
	public boolean addProduct(ArDukaanProductList arDukaanProductList);
	
	public JSONArray getProducts();
}
	
	