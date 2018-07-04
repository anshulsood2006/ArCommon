package com.arsoft.projects.common.webservice.rest.sharemarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.business.market.entities.ArScripConstant;
import com.arsoft.projects.common.equity.ArBourse;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringUtil;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;
import com.arsoft.projects.common.webservice.rest.ArList;
import com.arsoft.projects.common.webservice.rest.error.ArError;
import com.arsoft.projects.common.webservice.rest.error.ArErrorList;




@Path("/shareMarket")
public class ArScripService{
	
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
			return ArScripUtil.getSharePriceHtml(scrips);
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
			jsonArray.put(ArException.createArError("1","Parameter 'scrips' is required in query string"));
			return jsonArray;
		}
		else{
			return ArScripUtil.getSharePriceJson(scrips);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/xml")
	public ArList<?> getResponseAsXml(@Context ServletContext context, @QueryParam("scrips") String scrips){
		ArScripList arScripList = null;
		List<ArScrip> arScrips = null;
		ArErrorList arErrorList = null;
		List<ArError> arErrors = null;
		if (ArStringUtil.isNullOrEmptyString(scrips)){
			arErrorList = new ArErrorList();
			arErrors = new ArrayList<>();
			arErrors.add(ArException.createArError("1","Parameter 'scrips' is required in query string"));
			arErrorList.setErrorList(arErrors);
			return arErrorList;
		}
		else{
			Map<String, String> map = ArScripUtil.getSharePriceMap(scrips);
			arScrips = new ArrayList<>();
			arScripList = new ArScripList();
			for (Map.Entry<String, String> entryMap: map.entrySet()){
				double value = 0f;
				ArScrip arScrip = null;
				try{
					value = Double.parseDouble(entryMap.getValue());
					arScrip= new ArScrip(entryMap.getKey(), entryMap.getKey(), ArBourse.NSE, value, ArDateTimeUtil.getCurrentArDateTime());
				}catch(NumberFormatException e){
					arScrip= new ArScrip(entryMap.getKey(), ArScripConstant.SCRIP_NOT_FOUND , ArBourse.NSE, value, ArDateTimeUtil.getCurrentArDateTime());
				}
				arScrips.add(arScrip);
			}
			arScripList.setArScripList(arScrips);
			return arScripList;
		}
	}
}
