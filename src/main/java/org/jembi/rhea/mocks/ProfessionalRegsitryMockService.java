package org.jembi.rhea.mocks;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jembi.rhea.MocksUtil;

@Path("/webservices")
public class ProfessionalRegsitryMockService {
	
	Log log = LogFactory.getLog(this.getClass());
	
	@Path("/lookupbyid/epid")
	@GET
	public String getProfessionalEcid(@QueryParam("id_number") String id_number, @QueryParam("id_type") String id_type) {
		log.info("Called mock professionals registry: get professional EPID");
		
		log.info("Returning epid for professional with " + id_type + ": " + id_number + " ...");
		if (id_number.equals("3525410")) {
			return "e8597a14-436f-1031-8b61-8d373bf4f88f";
		} else if (id_number.equals("8103869")) {
			return "2572edfe-5f59-1031-9435-7f3016bad837";
		} else {
			return UUID.randomUUID().toString();
		}
	}
	
	@Path("/lookupbyid/nid")
	@GET
	public String getProfessionalNid(@QueryParam("id_number") String id_number, @QueryParam("id_type") String id_type) {
		log.info("Called mock professionals registry: get professional NID");
		
		log.info("Returning NID for professional with " + id_type + ": " + id_number + " ...");
		if (id_number.equals("e8597a14-436f-1031-8b61-8d373bf4f88f")) {
			return "3525410";
		} else if (id_number.equals("2572edfe-5f59-1031-9435-7f3016bad837")) {
			return "8103869";
		} else {
			return "0000000000000000";
		}
	}
	
	// === un-used services ===
	
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
	
}
