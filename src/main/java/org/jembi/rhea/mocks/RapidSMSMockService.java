package org.jembi.rhea.mocks;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;

@Path("/ws/rest/v1")
public class RapidSMSMockService {
	
	Log log = LogFactory.getLog(this.getClass());
	
	@Path("/alerts")
	@POST
	public Response postAlert(String body) {
		log.info("Called mock RapidSMS: post alert");
		
		log.info("Body recieved: " + body);
		
		log.info("Attempting to parser the body as a HL7v2 ORU_R01 message...");
		
		Parser p = new GenericParser();
		
		Message hl7 = null;
		try {
			hl7 = p.parse(body);
			
			ORU_R01 oruMsg = (ORU_R01) hl7;
			
			if (oruMsg != null) {
				log.info("Successfully parsed HL7v2 ORU_R01 message!");
				
				log.info("== Message overview ==\n" + oruMsg.toString());
				
				log.info("NID: " + oruMsg.getPATIENT_RESULT().getPATIENT().getPID().getPatientIdentifierList(0).getIDNumber().getValue());
				log.info("Alert: " + oruMsg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX().getObservationIdentifier().getText().getValue());
				
				return Response.created(null).build();
			}
		} catch (Exception e) {
			log.error("Parsing failed: ", e);
			return Response.status(400).entity("Failed to parse HL7 message: " + e).build();
		}
		
		return Response.status(500).build();
	}
	
}
