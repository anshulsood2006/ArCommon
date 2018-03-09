package com.arsoft.projects.common.webservice.rest.environment;


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
import com.arsoft.projects.common.environment.ArEnvironmentActionEnum;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.properties.ArPropertyHandler;
import com.arsoft.projects.common.string.ArStringUtil;

@Path("/getEnvironmentDetail")
public class ArEnvironmentService{

	private static final Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/html")
	public String getResponseAsHtml(@QueryParam("action") String action, @QueryParam("entityName") String entityName,  @Context ServletContext context) throws ArException {
		logger.debug("Service "+  ArAnnotationUtil.getAttributeValue(ArAnnotationUtil.getClassAnnotations(getClass()).get(0),"value") +" called with parameters: action: "+action+" and entityName: "+entityName);
		if (ArStringUtil.isNullOrEmptyString(action)){
			return "Parameter 'action' is required in query string";
		}
		if (ArStringUtil.isNullOrEmptyString(entityName)){
			return "Parameter 'entityName' is required in query string";
		}
		if (ArEnvironmentActionEnum.isHavingEnumValue(action)){
			Map<String, String> map = ArPropertyHandler.getPropertyAsMap(entityName);
			StringBuffer bf = new StringBuffer();
			bf.append("<table border=\"1\">");
			bf.append("<tr><th>Property Name</th><th>Property Value</th></tr>");
			for (String str : map.keySet()){
				bf.append("<tr><td>"+str+"</td><td>"+map.get(str)+"</td></tr>");
			}
			bf.append("</table>");
			return bf.toString();
		}
		else {
			return "Invalid Value for parameter 'action'.\n\nValid Values are: "+ArEnvironmentActionEnum.getAllArEnvironmentActionEnum();
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/json")
	public JSONArray getResponseAsJsonArray(@QueryParam("action") String action, @QueryParam("entityName") String entityName,  @Context ServletContext context) throws ArException {
		logger.debug("Service "+  ArAnnotationUtil.getAttributeValue(ArAnnotationUtil.getClassAnnotations(getClass()).get(0),"value") +" called with parameters: action: "+action+" and entityName: "+entityName);
		JSONArray jsonArray = null;
		if (ArStringUtil.isNullOrEmptyString(action)){
			jsonArray = new JSONArray();
			jsonArray.put(ArException.createArErrorJson("1","Parameter 'action' is required in query string"));
		}
		if (ArStringUtil.isNullOrEmptyString(entityName)){
			jsonArray = new JSONArray();
			jsonArray.put(ArException.createArErrorJson("1","Parameter 'entityName' is required in query string"));
		}
		if (ArEnvironmentActionEnum.isHavingEnumValue(action)){
			Map<String, String> map = ArPropertyHandler.getPropertyAsMap(entityName);
			jsonArray = new JSONArray();
			for (String key : map.keySet()){
				ArJsonEnvironmentProperty jsObject = new ArJsonEnvironmentProperty();
				jsObject.setName(key);
				jsObject.setValue(map.get(key));
				jsonArray.put(jsObject);
			}
		}
		else {
			jsonArray = new JSONArray();
			jsonArray.put(ArException.createArErrorJson("1","Invalid Value for parameter 'action'. Valid Values are: "+ArEnvironmentActionEnum.getAllArEnvironmentActionEnum()));
		}	
		return jsonArray;
	}

}
