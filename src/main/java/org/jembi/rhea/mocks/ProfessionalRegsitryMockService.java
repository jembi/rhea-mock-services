package org.jembi.rhea.mocks;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jembi.rhea.MocksUtil;

@Path("/ws/rest/v1")
public class ProfessionalRegsitryMockService {
	
	Log log = LogFactory.getLog(this.getClass());
	
	@Path("/professionals")
	@GET
	@Produces("text/xml")
	public String queryProfessionals() throws IOException {
		log.info("Called mock professionals registry: query professionals");
		
		log.info("Returning list of professionals...");
		return MocksUtil.getFileAsString("/hl7/PMU_B01-list.rss");
	}
	
	@Path("/professional/{id}")
	@GET
	@Produces("text/xml")
	public String getProfessional(@PathParam("id") String id) throws IOException {
		log.info("Called mock professionals registry: get professional");
		
		log.info("Returning professional with id " + id + " ...");
		return MocksUtil.getFileAsString("/hl7/PMU_B01.xml");
	}
	
	@Path("/professional/{id}/epid")
	@GET
	public String getProfessionalEcid(@PathParam("id") String id) {
		log.info("Called mock professionals registry: get professional EPID");
		
		log.info("Returning epid for professional with id " + id + " ...");
		return UUID.randomUUID().toString();
	}
	
}
