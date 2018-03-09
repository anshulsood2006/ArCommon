package com.arsoft.projects.common.webservice.rest;

import javax.servlet.ServletContext;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.json.JSONArray;

import com.arsoft.projects.common.exception.ArException;

public interface ArService {
	
	public String getResponseAsHtml(@QueryParam("param") String param, @Context ServletContext context) throws ArException;
	public JSONArray getResponseAsJsonArray(@QueryParam("param") String param, @Context ServletContext context) throws ArException;
	public String getResponseAsXml(@QueryParam("param") String param, @Context ServletContext context) throws ArException;
	
}
