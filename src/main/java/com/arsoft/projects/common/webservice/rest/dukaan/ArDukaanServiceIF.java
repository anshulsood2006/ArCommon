package com.arsoft.projects.common.webservice.rest.dukaan;

import com.arsoft.projects.common.webservice.rest.ArList;

public interface ArDukaanServiceIF {
	
	public boolean addProduct(ArDukaanProductList arDukaanProductList);
	
	public ArList<?> getProducts();
}
	
	