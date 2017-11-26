package com.trainhack.geoinc.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vgorin
 *         file created on 11/26/17 7:32 AM
 */


@XmlRootElement
public class IncidentProbability {
	@XmlElement(name = "Stanox")
	public int stanox;
	@XmlElement(name = "Latitude")
	public float lat;
	@XmlElement(name = "Longitude")
	public float lon;
	@XmlElement(name = "Stanox Count")
	public int stanoxCount;
	@XmlElement(name = "Average Delay")
	public double avgDelay;

	public IncidentProbability() {
	}

	public IncidentProbability(int stanox, float lat, float lon, int stanoxCount, double avgDelay) {
		this.stanox = stanox;
		this.lat = lat;
		this.lon = lon;
		this.stanoxCount = stanoxCount;
		this.avgDelay = avgDelay;
	}
}
