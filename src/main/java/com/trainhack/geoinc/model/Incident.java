package com.trainhack.geoinc.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vgorin
 *         file created on 11/26/17 4:40 AM
 */


@XmlRootElement
public class Incident {
	@XmlElement(name = "Affected_Stanox")
	public int stanox;
	@XmlElement(name = "Latitude")
	public float lat;
	@XmlElement(name = "Longitude")
	public float lon;
	@XmlElement(name = "Number_of_Effects")
	public int effects;
	@XmlElement(name = "Delay_Avg")
	public double delay;

	public Incident() {
	}

	public Incident(int stanox, float lat, float lon, int effects, double delay) {
		this.stanox = stanox;
		this.lat = lat;
		this.lon = lon;
		this.effects = effects;
		this.delay = delay;
	}
}
