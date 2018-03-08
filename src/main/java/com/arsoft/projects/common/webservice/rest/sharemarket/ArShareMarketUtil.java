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

import com.arsoft.projects.common.annotation.ArAnnotationUtil;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringUtil;
import com.arsoft.projects.common.webservice.ArScripPriceNew;




@Path("/shareMarket")
public class ArShareMarketUtil {
	
	private static final Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getDetailInHTml(@QueryParam("scrips") String scrips, @Context ServletContext context) throws ArException {
		logger.debug("Service "+  ArAnnotationUtil.getAttributeValue(ArAnnotationUtil.getClassAnnotations(getClass()).get(0),"value") +" called with parameters: scrips: "+scrips);
		if (ArStringUtil.isNullOrEmptyString(scrips)){
			return "Parameter 'scrips' is required in query string";
		}
		else{
			return ArScripPriceNew.getSharePrice(scrips);
		}
	}
	
}
