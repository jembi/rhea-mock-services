package org.jembi.rhea.mocks;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Path("/validate.php")
public class TerminologyServiceMockService {
	
	Log log = LogFactory.getLog(this.getClass());
	
	@GET
	public String registerPatient(@QueryParam("conceptCode") String conceptCode, @QueryParam("namespaceCode") String namespaceCode) {
		log.info("Called mock terminology service: validate term");
		
		log.info("Concept to validate: " + namespaceCode + " - " + conceptCode);
		
		return "<tsvalidate><result>1</result></tsvalidate>";
	}
	
}
