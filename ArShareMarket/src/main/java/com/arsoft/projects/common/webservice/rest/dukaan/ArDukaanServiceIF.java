package com.arsoft.projects.common.webservice.rest.dukaan;

import com.arsoft.projects.common.business.entity.ArProductList;
import com.arsoft.projects.common.webservice.rest.ArList;

public interface ArDukaanServiceIF {
	
	public boolean addProduct(ArProductList arDukaanProductList);
	
	public ArList<?> getProducts();
}
	
	