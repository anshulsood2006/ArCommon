package com.arsoft.projects.common.webservice.rest.dukaan;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arsoft.projects.arcommon.ArList;
import com.arsoft.projects.arcommon.ArProduct;
import com.arsoft.projects.arcommon.ArProductList;

@Path("/dukaan/product")
public class ArDukaanService implements ArDukaanServiceIF{
	
	private static final Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	@Override
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean addProduct(ArProductList arDukaanProductList) {
		for (ArProduct arDukaanProduct: arDukaanProductList.getArDukaanProductList()) {
			logger.info("Going to add product "+arDukaanProduct);
		}
		return false;
	}

	@Override
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public ArList<?> getProducts() {
		ArProductList arDukaanProductList = null;
		List<ArProduct> productList = null;
		for (int i = 0 ; i < 4; i++){
			if (arDukaanProductList== null){
				productList = new ArrayList<ArProduct>();
			}
			if (arDukaanProductList == null){
				arDukaanProductList = new ArProductList();
			}
			ArProduct arDukaanProduct = new ArProduct();
			arDukaanProduct.setName("Biscuit");
			arDukaanProduct.setPrice(200);
			productList.add(arDukaanProduct);
		}
		arDukaanProductList.setArDukaanProductList(productList);
		return arDukaanProductList;
	}
	
}
