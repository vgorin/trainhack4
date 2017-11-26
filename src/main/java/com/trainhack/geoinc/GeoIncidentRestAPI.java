package com.trainhack.geoinc;

import io.swagger.annotations.Api;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author vgorin
 *         file created on 11/26/17 2:38 AM
 */


@Api
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class GeoIncidentRestAPI {
	@Path("/version")
	public String getVersion() {
		return "0.0.1-SNAPSHOT";
	}
}
