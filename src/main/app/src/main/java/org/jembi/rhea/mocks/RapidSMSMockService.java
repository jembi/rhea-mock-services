package org.jembi.rhea.mocks;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Path("/ws/rest/v1")
public class RapidSMSMockService {
	
	Log log = LogFactory.getLog(this.getClass());
	
	@Path("/alerts")
	@POST
	public Response postAlert(String body) {
		log.info("Called mock RapidSMS: post alert");
		
		log.info("Body recieved: " + body);
		
		return Response.created(null).build();
	}
	
}
