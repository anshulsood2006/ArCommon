package com.arsoft.projects.common.webservice.rest.dukaan;

import com.arsoft.projects.arcommon.ArList;
import com.arsoft.projects.arcommon.ArProductList;

public interface ArDukaanServiceIF {
	
	public boolean addProduct(ArProductList arDukaanProductList);
	
	public ArList<?> getProducts();
}
	
	