package org.jembi.rhea.mocks;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jembi.rhea.MocksUtil;

@Path("/ws/rest/v1")
public class SharedHealthRecordMockService {
	
	Log log = LogFactory.getLog(this.getClass());
	
	@Path("/patient/{pid}/encounters")
	@POST
	public Response saveEncounter(String body, @PathParam("pid") String pid) {
		log.info("Called mock Shared Health Record: save encounter");
		
		log.info("Body recieved: " + body);
		
		return Response.created(null).build();
	}
	
	@Path("/patient/{pid}/encounters")
	@GET
	@Produces("text/xml")
	public String queryForEncounters(@PathParam("pid") String pid) throws IOException {
		log.info("Called mock Shared Health Record: query for encounters");
		
		log.info("Returning list of encounters...");
		return MocksUtil.getFileAsString("/xml/undefined.xml");
	}
	
	@Path("/patient/{pid}/encounter/{eid}")
	@GET
	@Produces("text/xml")
	public String getEncounter(@PathParam("pid") String pid, @PathParam("eid") String eid) throws IOException {
		log.info("Called mock Shared Health Record: get encounter");
		
		log.info("Returning encounter...");
		return MocksUtil.getFileAsString("/xml/undefined.xml");
	}
	
}
