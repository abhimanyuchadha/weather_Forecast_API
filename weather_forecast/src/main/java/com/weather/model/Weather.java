package com.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Abhimanyu
 *
 */
public class Weather {
	
	@JsonProperty("DATE")
	String date;
	
	@JsonProperty("TMAX")	
	Double tMax;
	
	@JsonProperty("TMIN")	
	Double tMin;
	
	
	public Weather() {}
	public Weather(String date, double tMax, double tMin) {
		// TODO Auto-generated constructor stub
		this.date=date;
		this.tMax=tMax;
		this.tMin=tMin;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public Double gettMax() {
		return tMax;
	}
	
	
	public void settMax(Double tMax) {
		this.tMax = tMax;
	}
	
	
	public Double gettMin() {
		return tMin;
	}
	
	
	public void settMin(Double tMin) {
		this.tMin = tMin;
	}
	
	
}
