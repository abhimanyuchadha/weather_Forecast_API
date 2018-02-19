package com.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Abhimanyu
 *
 */
public class HistoricalResponse {

	@JsonProperty("DATE")
	String date;
		
	public HistoricalResponse() {
		// TODO Auto-generated constructor stub
	}

	public HistoricalResponse(String date) {
		// TODO Auto-generated constructor stub
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
