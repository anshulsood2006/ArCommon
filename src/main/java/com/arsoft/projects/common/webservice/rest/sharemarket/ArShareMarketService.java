package com.arsoft.projects.common.webservice.rest.sharemarket;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;

import com.arsoft.projects.common.annotation.ArAnnotationUtil;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringUtil;
import com.arsoft.projects.common.webservice.ArScripPriceNew;




@Path("/shareMarket")
public class ArShareMarketService{
	
	private static final Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/html")
	public String getResponseAsHtml(@Context ServletContext context, @QueryParam("scrips") String scrips) throws ArException {
		logger.debug("Service "+  ArAnnotationUtil.getAttributeValue(ArAnnotationUtil.getClassAnnotations(getClass()).get(0),"value") +" called with parameters: scrips: "+scrips);
		if (ArStringUtil.isNullOrEmptyString(scrips)){
			return "Parameter 'scrips' is required in query string";
		}
		else{
			return ArScripPriceNew.getSharePriceHtml(scrips);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/json")
	public JSONArray getResponseAsJsonArray(@Context ServletContext context, @QueryParam("scrips") String scrips) throws ArException {
		logger.debug("Service "+  ArAnnotationUtil.getAttributeValue(ArAnnotationUtil.getClassAnnotations(getClass()).get(0),"value") +" called with parameters: scrips: "+scrips);
		JSONArray jsonArray = null;
		logger.debug("Service "+  ArAnnotationUtil.getAttributeValue(ArAnnotationUtil.getClassAnnotations(getClass()).get(0),"value") +" called with parameters: scrips: "+scrips);
		if (ArStringUtil.isNullOrEmptyString(scrips)){
			jsonArray = new JSONArray();
			jsonArray.put(ArException.createArErrorJson("1","Parameter 'scrips' is required in query string"));
			return jsonArray;
		}
		else{
			return ArScripPriceNew.getSharePriceJson(scrips);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/xml")
	public String getResponseAsXml(@Context ServletContext context, @QueryParam("scrips") String scrips){
		return "";
	}

}
