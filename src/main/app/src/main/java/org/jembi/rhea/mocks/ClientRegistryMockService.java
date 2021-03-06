package org.jembi.rhea.mocks;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jembi.rhea.MocksUtil;

@Path("/ws/rest/v1")
public class ClientRegistryMockService {
	
	Log log = LogFactory.getLog(this.getClass());
	
	@Path("/patients")
	@POST
	public Response registerPatient(String body) {
		log.info("Called mock client registry: register patient");
		
		log.info("Body recieved: " + body);
		
		return Response.created(null).build();
	}
	
	@Path("/patients")
	@GET
	@Produces("text/xml")
	public String queryPatients() throws IOException {
		log.info("Called mock client registry: query patients");
		
		log.info("Returning list of patients...");
		return MocksUtil.getFileAsString("/xml/undefined.xml");
	}
	
	@Path("/patient/{pid}")
	@GET
	@Produces("text/xml")
	public String getPatient(@PathParam("pid") String pid) throws IOException {
		log.info("Called mock client registry: get patient");
		
		log.info("Returning patient...");
		return MocksUtil.getFileAsString("/xml/undefined.xml");
	}
	
	@Path("/patient/{pid}")
	@PUT
	public Response updatePatient(String body, @PathParam("pid") String pid) {
		log.info("Called mock client registry: update patient");
		
		log.info("Body recieved: " + body);
		
		return Response.ok().build();
	}
	
}
