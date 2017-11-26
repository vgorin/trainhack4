package com.trainhack.geoinc.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vgorin
 *         file created on 11/26/17 4:40 AM
 */


@XmlRootElement
public class Incident {
	@XmlElement(name = "Incident Number")
	public int incidentNumber;
	@XmlElement(name = "TSC - Affected")
	public int tsc;
	@XmlElement(name = "English Day Type")
	public String dayType;
	@XmlElement(name = "Incident Start Datetime")
	public String incidentStart;
	@XmlElement(name = "Incident End Datetime")
	public String incidentEnd;
	@XmlElement(name = "Event Datetime")
	public String eventDate;
	@XmlElement(name = "Incident Category")
	public String category;
	@XmlElement(name = "Incident Category Super Group Code")
	public String catSuperGroup;
	@XmlElement(name = "Incident Category Description")
	public String catDescription;
	@XmlElement(name = "Section Code")
	public String sectionCode;
	@XmlElement(name = "Start Stanox")
	public int startStanox;
	@XmlElement(name = "Start Latitude")
	public String statLat;
	@XmlElement(name = "Start Longitude")
	public String statLong;
	@XmlElement(name = "End Stanox")
	public int endStanox;
	@XmlElement(name = "End Latitude")
	public String endLat;
	@XmlElement(name = "End Longitude")
	public String endLong;
	@XmlElement(name = "PfPI Minutes")
	public int delay;

	public Incident() {
	}

	public Incident(int incidentNumber, int tsc, String dayType, String incidentStart, String incidentEnd, String eventDate, String category, String catSuperGroup, String catDescription, String sectionCode, int startStanox, String statLat, String statLong, int endStanox, String endLat, String endLong, int delay) {
		this.incidentNumber = incidentNumber;
		this.tsc = tsc;
		this.dayType = dayType;
		this.incidentStart = incidentStart;
		this.incidentEnd = incidentEnd;
		this.eventDate = eventDate;
		this.category = category;
		this.catSuperGroup = catSuperGroup;
		this.catDescription = catDescription;
		this.sectionCode = sectionCode;
		this.startStanox = startStanox;
		this.statLat = statLat;
		this.statLong = statLong;
		this.endStanox = endStanox;
		this.endLat = endLat;
		this.endLong = endLong;
		this.delay = delay;
	}
}
