package com.trainhack.geoinc;

import com.trainhack.geoinc.model.Incident;
import com.trainhack.geoinc.model.IncidentProbability;
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
	@Path("/deriving-incidents")
	@ApiOperation(
			value = "Get Deriving Incidents",
			notes = "Given a section code, find out all the incidents which were caused by the incidents originating from the section specified",
			response = List.class
	)
	public List<Incident> getDerivingIncidents(@QueryParam("section-code") String sectionCode) {
		try(
				Connection c = dataSource.getConnection();
				PreparedStatement s = c.prepareStatement(p.getProperty("get-deriving-incidents"))
		) {
			List<Incident> incidents = new LinkedList<>();
			s.setString(1, String.format("%s%%", sectionCode));
			s.setString(2, String.format("%%%s", sectionCode));
			try(ResultSet r = s.executeQuery()) {
				while(r.next()) {
					incidents.add(new Incident(
							r.getInt("Incident Number"),
							r.getInt("TSC - Affected"),
							r.getString("English Day Type"),
							r.getString("Incident Start Datetime"),
							r.getString("Incident End Datetime"),
							r.getString("Event Datetime"),
							r.getString("Incident Category"),
							r.getString("Incident Category Super Group Code"),
							r.getString("Incident Category Description"),
							r.getString("Section Code"),
							r.getInt("Start Stanox"),
							r.getString("Start Latitude"),
							r.getString("Start Longitude"),
							r.getInt("End Stanox"),
							r.getString("End Latitude"),
							r.getString("End Longitude"),
							r.getInt("PfPI Minutes")
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
	@Path("/deriving-incidents-probability")
	@ApiOperation(
			value = "Get Deriving Incidents Probability",
			notes = "Given a section code, find out the probabilities of an accident on adjacent sections",
			response = List.class
	)
	public List<IncidentProbability> getDerivingIncidentsProbability(@QueryParam("section-code") int sectionCode) {
		try(
				Connection c = dataSource.getConnection();
				PreparedStatement s = c.prepareStatement(p.getProperty("get-deriving-incidents-probability"))
		) {
			List<IncidentProbability> probabilities = new LinkedList<>();
			s.setString(1, String.format("%s%%", sectionCode));
			s.setString(2, String.format("%%%s", sectionCode));
			try(ResultSet r = s.executeQuery()) {
				while(r.next()) {
					probabilities.add(new IncidentProbability(
							r.getInt("Start Stanox"),
							r.getString("FULL NAME"),
							r.getFloat("Latitude"),
							r.getFloat("Longitude"),
							r.getInt("Stanox Count"),
							r.getDouble("Average Delay")
					));
				}
			}
			return probabilities;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@GET
	@Path("/version")
	@ApiOperation(
			value = "API Version",
			notes = "Returns API Version, ex.: 0.0.1-SNAPSHOT",
			response = String.class
	)
	public String getVersion() {
		return "0.0.2-SNAPSHOT";
	}
}
