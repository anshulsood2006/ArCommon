package com.arsoft.projects.common.webservice.rest.dukaan;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;

@Path("/dukaan")
public class ArDukaanService implements ArDukaanServiceIF{
	
	private static final Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	@Override
	@POST
	@Path("/json/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean addProduct(ArDukaanProductList arDukaanProductList) {
		for (ArDukaanProduct arDukaanProduct: arDukaanProductList.getArDukaanProductList()) {
			logger.info("Going to add product "+arDukaanProduct);
		}
		return false;
	}

	@Override
	@GET
	@Path("/json/get")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray getProducts() {
		JSONArray jsonArray = new JSONArray();
		ArDukaanProduct arDukaanProduct = new ArDukaanProduct();
		arDukaanProduct.setName("Biscuit");
		arDukaanProduct.setPrice(200);
		arDukaanProduct.setMrp(210);
		arDukaanProduct.setQuantity(10);
		jsonArray.put(arDukaanProduct);
		return jsonArray;
	}
	
}
