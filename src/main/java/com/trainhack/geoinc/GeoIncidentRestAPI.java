package com.trainhack.geoinc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author vgorin
 *         file created on 11/26/17 2:38 AM
 */


@Api
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class GeoIncidentRestAPI {
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
