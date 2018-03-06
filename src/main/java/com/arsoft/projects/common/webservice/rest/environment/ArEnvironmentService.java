package com.arsoft.projects.common.webservice.rest.environment;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/getEnvironmentDetail")
public class ArEnvironmentService {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getDetail(@QueryParam("action") String action, @QueryParam("entityName") String entityName) {
		System.out.println("Anshul Sood");
		return "<html><body>Anshul</body></html>";
	}
}
