package org.jembi.rhea.mocks;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jembi.rhea.MocksUtil;

@Path("/api")
public class FacilityRegistryMockService {
	
	Log log = LogFactory.getLog(this.getClass());
	
	@Path("collections/26.rss")
	@GET 
	@Produces("text/xml")
	public String queryFacility(@QueryParam("updated_since") String updatedSince,
								@QueryParam("fosaid") String fosaid,
								@QueryParam("name") String name,
								@QueryParam("type") String type,
								@QueryParam("status") String status,
								@QueryParam("category") String category,
								@QueryParam("director_name") String director_name,
								@QueryParam("director_nid") String director_nid,
								@QueryParam("province") String province,
								@QueryParam("district") String district,
								@QueryParam("sector") String sector,
								@QueryParam("village") String village,
								@QueryParam("cell") String cell,
								@QueryParam("tel_number") String tel_number,
								@QueryParam("internet_connection") String internet_connection,
								@QueryParam("electricity_src") String electricity_src,
								@QueryParam("water_src") String water_src
			) throws IOException {
		log.info("Called mock facility registry: query facilities");
		
		// log all param values
		log.info("	Updated since param = " + updatedSince);
		log.info("	FID param = " + fosaid);
		log.info("	Name param = " + name);
		log.info("	Type param = " + type);
		log.info("	Status param = " + status);
		log.info("	Category param = " + category);
		log.info("	Direcotr Name param = " + director_name);
		log.info("	Director NID param = " + director_nid);
		log.info("	Province param = " + province);
		log.info("	District param = " + district);
		log.info("	Sector param = " + sector);
		log.info("	Village param = " + village);
		log.info("	Cell param = " + cell);
		log.info("	Tel Number param = " + tel_number);
		log.info("	Internet Connection param = " + internet_connection);
		log.info("	Electricity Source param = " + electricity_src);
		log.info("	Water Source param = " + water_src);
		
		log.info("Returning list of facilities...");
		if (fosaid != null && !fosaid.isEmpty()) {
			return MocksUtil.getFileAsString("/xml/GetFacility.xml");
		}
		
		return MocksUtil.getFileAsString("/xml/QueryFacilities.xml");
	}
	
}
