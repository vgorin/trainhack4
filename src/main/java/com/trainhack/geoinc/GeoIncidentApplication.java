package com.trainhack.geoinc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.trainhack.geoinc")
public class GeoIncidentApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoIncidentApplication.class, args);
	}
}
