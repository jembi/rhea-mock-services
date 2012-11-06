package org.jembi.rhea.mocks;

import java.io.IOException;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jembi.rhea.MocksUtil;

@Path("/openempi-admin/openempi-ws-rest")
public class ClientRegistryMockService {
	
	Log log = LogFactory.getLog(this.getClass());
	
	@Path("/person-manager-resource/addPerson")
	@PUT
	public Response registerPatient(String body) {
		log.info("Called mock client registry: register patient");
		
		log.info("Body recieved: " + body);
		
		return Response.status(201).build();
	}
	
	@Path("/person-query-resource/findPersonsByAttributes")
	@POST
	@Produces("text/xml")
	public String queryPatients(String body) throws IOException {
		log.info("Called mock client registry: query patients");
		
		log.info("Returning list of patients...");
		return MocksUtil.getFileAsString("/xml/openempi-people.xml");
	}
	
	@Path("/person-query-resource/findPersonById")
	@POST
	@Produces("text/xml")
	public String getPatient(String body) throws IOException {
		log.info("Called mock client registry: get patient");
		
		log.info("Returning patient...");
		return MocksUtil.getFileAsString("/xml/openempi-person.xml");
	}
	
	@Path("/person-manager-resource/updatePerson")
	@PUT
	public Response updatePatient(String body, @PathParam("pid") String pid) {
		log.info("Called mock client registry: update patient");
		
		log.info("Body recieved: " + body);
		
		log.info("Attempting to parser the body as a HL7v2 message...");
		
		return Response.status(204).build();
		
	}
	
}
