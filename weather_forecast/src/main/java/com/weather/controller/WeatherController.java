package com.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weather.model.HistoricalResponse;
import com.weather.model.Weather;
import com.weather.service.WeatherService;

/**
 * @author Abhimanyu
 *
 */
@RestController
public class WeatherController {
	
	@Autowired
	WeatherService weatherService;
	
	/**
	 * @return
	 */
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public List<Weather> fetchAllHistoricalData() {
	
		return weatherService.fetchAllHistoricalData();
	}
	
	@RequestMapping(value="/historical", method=RequestMethod.GET)
	public List<HistoricalResponse> fetchAllHistoricalDates() {
	
		return weatherService.fetchAllHistoricalDates();
	}
	
	@RequestMapping(value="/historical/{date}", method=RequestMethod.GET)
	public Weather fetchHistoricalWeather(@PathVariable("date") String date) {
	
		return weatherService.fetchHistoricalWeather(date);
	}
	
	
	@RequestMapping(value="/historical", method=RequestMethod.POST)
	public HistoricalResponse addHistoricalWeatherData(@RequestBody Weather weather) {
	
		return weatherService.addHistoricalWeatherData(weather);
	}
	
	@RequestMapping(value="/historical/{date}", method=RequestMethod.DELETE)
	public boolean deleteHistoricalWeatherData(@PathVariable("date") String date) {
	
		return weatherService.deleteHistoricalWeatherData(date);
	}
	
	@RequestMapping("/check")
	public List<Weather> checkData() {
	
		return weatherService.checkData();
		
	}
	
	

}
