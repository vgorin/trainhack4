package com.trainhack.geoinc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author vgorin
 *         file created on 11/26/17 4:09 AM
 */


@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/api-doc/**").addResourceLocations("classpath:/api-doc/");
	}
}
