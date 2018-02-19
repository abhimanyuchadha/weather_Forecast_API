package com.weather.repository;

import java.util.List;

import com.weather.model.HistoricalResponse;
import com.weather.model.Weather;

/**
 * @author Abhimanyu
 *
 */
public interface WeatherRepository {

	public List<Weather> weatherRepository();

	public List<HistoricalResponse> fetchAllHistoricalDates();

	public Weather fetchHistoricalWeather(String date);

	public HistoricalResponse addHistoricalWeatherData(Weather weather);

	public boolean deleteHistoricalWeatherData(String date);

	List<Weather> fetchAllRecordsWithSimilarDate(String date);
	

}
