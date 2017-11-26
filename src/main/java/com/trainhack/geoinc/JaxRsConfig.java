package com.trainhack.geoinc;

import org.glassfish.jersey.server.ResourceConfig;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;


/**
 * @author vgorin
 *         file created on 11/26/17 2:32 AM
 */

@Configuration
@ApplicationPath("/api")
public class JaxRsConfig extends ResourceConfig {
	public JaxRsConfig() {
		register(GeoIncidentRestAPI.class);
		register(ApiListingResource.class);
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("0.3");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/api");
		beanConfig.setDescription("GeoIncident RESTful API");
		beanConfig.setResourcePackage("com.trainhack.geoinc");
		beanConfig.setPrettyPrint(true);
		beanConfig.setScan(true);
	}
}
