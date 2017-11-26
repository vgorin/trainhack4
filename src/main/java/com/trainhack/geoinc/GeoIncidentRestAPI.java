package com.trainhack.geoinc;

import com.trainhack.geoinc.model.Incident;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * @author vgorin
 *         file created on 11/26/17 2:38 AM
 */


@Api
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class GeoIncidentRestAPI {
	@Autowired
	private DataSource dataSource;

	private Properties p;

	@PostConstruct
	private void initProperties() {
		p = new Properties();
		try {
			p.loadFromXML(getClass().getResourceAsStream("/dbscripts.xml"));
		}
		catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	@GET
	@Path("incident")
	@ApiOperation(
			value = "",
			notes = "",
			response = List.class
	)
	public List<Incident> getIncident(@QueryParam("section-code") int sectionCode) {
		try(
				Connection c = dataSource.getConnection();
				PreparedStatement s = c.prepareStatement(p.getProperty("get-incident"))
		) {
			List<Incident> incidents = new LinkedList<>();
			s.setString(1, String.format("%s%%", sectionCode));
			s.setString(2, String.format("%%%s", sectionCode));
			try(ResultSet r = s.executeQuery()) {
				while(r.next()) {
					incidents.add(new Incident(
							r.getInt("Affected_Stanox"),
							r.getFloat("Latitude"),
							r.getFloat("Longitude"),
							r.getInt("Number_of_Effects"),
							r.getDouble("Delay_Avg")
					));
				}
			}
			return incidents;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}


	@GET
	@Path("version")
	@ApiOperation(
			value = "API Version",
			notes = "Returns API Version, ex.: 0.0.1-SNAPSHOT",
			response = String.class
	)
	public String getVersion() {
		return "0.0.1-SNAPSHOT";
	}
}
