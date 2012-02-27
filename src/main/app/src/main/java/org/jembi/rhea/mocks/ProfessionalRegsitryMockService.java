package org.jembi.rhea.mocks;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
		return MocksUtil.getFileAsString("/xml/undefined.xml");
	}
	
	@Path("/professional")
	@GET
	@Produces("text/xml")
	public String getProfessional() throws IOException {
		log.info("Called mock professionals registry: get prefessional");
		
		log.info("Returning prefessional...");
		return MocksUtil.getFileAsString("/xml/undefined.xml");
	}
	
}
