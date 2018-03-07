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

import com.arsoft.projects.common.annotation.ArAnnotationUtil;
import com.arsoft.projects.common.environment.ArEnvironmentActionEnum;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.properties.ArPropertyHandler;
import com.arsoft.projects.common.string.ArStringUtil;

@Path("/getEnvironmentDetail")
public class ArEnvironmentService {

	private static final Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getDetail(@QueryParam("action") String action, @QueryParam("entityName") String entityName,  @Context ServletContext context) throws ArException {
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
			for (String str : map.keySet()){
				bf.append("Property: "+str+" Value:"+map.get(str));
			}
			return bf.toString();
		}
		else {
			return "Invalid Value for parameter Action.\n\nValid Values are: "+ArEnvironmentActionEnum.getAllArEnvironmentActionEnum();
		}
		
	}
}
