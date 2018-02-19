package com.weather.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weather.model.HistoricalResponse;
import com.weather.model.Weather;

/**
 * @author Abhimanyu
 *
 */
@Service
public interface WeatherService {
	
	public List<Weather> fetchAllHistoricalData();

	public List<Weather> checkData();

	public List<HistoricalResponse> fetchAllHistoricalDates();

	public Weather fetchHistoricalWeather(String date);

	public HistoricalResponse addHistoricalWeatherData(Weather weather);

	public boolean deleteHistoricalWeatherData(String date);
	

}
