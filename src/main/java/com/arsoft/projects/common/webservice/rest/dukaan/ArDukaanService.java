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

import com.arsoft.projects.common.webservice.rest.ArList;

@Path("/dukaan/product")
public class ArDukaanService implements ArDukaanServiceIF{
	
	private static final Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	@Override
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean addProduct(ArDukaanProductList arDukaanProductList) {
		for (ArDukaanProduct arDukaanProduct: arDukaanProductList.getArDukaanProductList()) {
			logger.info("Going to add product "+arDukaanProduct);
		}
		return false;
	}

	@Override
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public ArList<?> getProducts() {
		ArDukaanProductList arDukaanProductList = null;
		List<ArDukaanProduct> productList = null;
		for (int i = 0 ; i < 4; i++){
			if (arDukaanProductList== null){
				productList = new ArrayList<ArDukaanProduct>();
			}
			if (arDukaanProductList == null){
				arDukaanProductList = new ArDukaanProductList();
			}
			ArDukaanProduct arDukaanProduct = new ArDukaanProduct();
			arDukaanProduct.setId(i+"");
			arDukaanProduct.setName("Biscuit");
			arDukaanProduct.setPrice(200);
			arDukaanProduct.setMrp(210);
			arDukaanProduct.setQuantity(10);
			productList.add(arDukaanProduct);
		}
		arDukaanProductList.setArDukaanProductList(productList);
		return arDukaanProductList;
	}
	
}
