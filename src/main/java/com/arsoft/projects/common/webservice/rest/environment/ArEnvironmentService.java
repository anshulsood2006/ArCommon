package com.arsoft.projects.common.webservice.rest.environment;


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
import com.arsoft.projects.common.environment.ArEnvironmentActionEnum;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.properties.ArPropertyHandler;
import com.arsoft.projects.common.string.ArStringUtil;
import com.arsoft.projects.common.webservice.rest.ArList;
import com.arsoft.projects.common.webservice.rest.error.ArError;
import com.arsoft.projects.common.webservice.rest.error.ArErrorList;

@Path("/environment")
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
			jsonArray.put(ArException.createArError("1","Parameter 'action' is required in query string"));
			return jsonArray;
		}
		if (ArStringUtil.isNullOrEmptyString(entityName)){
			jsonArray = new JSONArray();
			jsonArray.put(ArException.createArError("1","Parameter 'entityName' is required in query string"));
			return jsonArray;
		}
		if (ArEnvironmentActionEnum.isHavingEnumValue(action)){
			Map<String, String> map = ArPropertyHandler.getPropertyAsMap(entityName);
			jsonArray = new JSONArray();
			for (String key : map.keySet()){
				ArEnvironmentProperty jsObject = new ArEnvironmentProperty();
				jsObject.setName(key);
				jsObject.setValue(map.get(key));
				jsonArray.put(jsObject);
			}
		}
		else {
			jsonArray = new JSONArray();
			jsonArray.put(ArException.createArError("1","Invalid Value for parameter 'action'. Valid Values are: "+ArEnvironmentActionEnum.getAllArEnvironmentActionEnum()));
		}	
		return jsonArray;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/xml")
	public ArList getResponseAsXml(@QueryParam("action") String action, @QueryParam("entityName") String entityName,  @Context ServletContext context) throws ArException {
		logger.debug("Service "+  ArAnnotationUtil.getAttributeValue(ArAnnotationUtil.getClassAnnotations(getClass()).get(0),"value") +" called with parameters: action: "+action+" and entityName: "+entityName);
		ArEnvironmentPropertyList arEnvironmentPropertyList = null;
		ArEnvironmentProperty arEnvironmentProperty = null;
		List<ArEnvironmentProperty> arEnvironmentProperties = null;
		ArErrorList arErrorList = null;
		List<ArError> arErrors = null;
		if (ArStringUtil.isNullOrEmptyString(action)){
			arErrorList = new ArErrorList();
			arErrors = new ArrayList<>();
			arErrors.add(ArException.createArError("1","Parameter 'action' is required in query string"));
			arErrorList.setErrorList(arErrors);
			return arErrorList;
		}
		if (ArStringUtil.isNullOrEmptyString(entityName)){
			arErrorList = new ArErrorList();
			arErrors = new ArrayList<>();
			arErrors.add(ArException.createArError("1","Parameter 'entityName' is required in query string"));
			arErrorList.setErrorList(arErrors);
			return arErrorList;
		}
		if (ArEnvironmentActionEnum.isHavingEnumValue(action)){
			Map<String, String> map = ArPropertyHandler.getPropertyAsMap(entityName);
			arEnvironmentPropertyList = new ArEnvironmentPropertyList();
			arEnvironmentProperties = new ArrayList<>();
			for (String key : map.keySet()){
				arEnvironmentProperty = new ArEnvironmentProperty();
				arEnvironmentProperty.setName(key);
				arEnvironmentProperty.setValue(map.get(key));
				arEnvironmentProperties.add(arEnvironmentProperty);
			}
			arEnvironmentPropertyList.setArEnvironmentPropertyList(arEnvironmentProperties);
			return arEnvironmentPropertyList;
		}
		else {
			arErrorList = new ArErrorList();
			arErrors = new ArrayList<>();
			arErrors.add(ArException.createArError("1","Invalid Value for parameter 'action'. Valid Values are: "+ArEnvironmentActionEnum.getAllArEnvironmentActionEnum()));
			arErrorList.setErrorList(arErrors);
			return arErrorList;
		}
	}

}
