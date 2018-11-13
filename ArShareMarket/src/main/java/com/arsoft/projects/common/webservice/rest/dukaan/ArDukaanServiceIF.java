package com.arsoft.projects.common.webservice.rest.dukaan;

import com.arsoft.projects.arshared.ArList;
import com.arsoft.projects.arshared.ArProductList;

public interface ArDukaanServiceIF {
	
	public boolean addProduct(ArProductList arDukaanProductList);
	
	public ArList<?> getProducts();
}
	
	