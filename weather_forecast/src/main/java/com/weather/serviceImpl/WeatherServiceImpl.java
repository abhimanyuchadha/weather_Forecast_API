package com.weather.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.model.HistoricalResponse;
import com.weather.model.Weather;
import com.weather.repository.WeatherRepository;
import com.weather.service.WeatherService;

/**
 * @author Abhimanyu
 *
 */
@Service
public class WeatherServiceImpl implements WeatherService{

	@Autowired
	WeatherRepository weatherRepository;
	

	@Override
	public List<Weather> fetchAllHistoricalData() {
		// TODO Auto-generated method stub
		return weatherRepository.weatherRepository(); 		
	}

	@Override
	public List<Weather> checkData() {
		// TODO Auto-generated method stub
		return weatherRepository.weatherRepository(); 
		
	}

	@Override
	public List<HistoricalResponse> fetchAllHistoricalDates() {
		// TODO Auto-generated method stub
		
		return weatherRepository.fetchAllHistoricalDates();
		
	}

	@Override
	public Weather fetchHistoricalWeather(String date) {
		// TODO Auto-generated method stub
		
		return weatherRepository.fetchHistoricalWeather(date.trim());
		
	}

	@Override
	public HistoricalResponse addHistoricalWeatherData(Weather weather) {
		// TODO Auto-generated method stub
		
		if(weather.getDate()==null || weather.gettMax()==null || weather.gettMin()==null) {
			throw new RuntimeException();
		} else {
			weather.setDate(weather.getDate().trim());
			return weatherRepository.addHistoricalWeatherData(weather);
		}
		
	}

	@Override
	public boolean deleteHistoricalWeatherData(String date) {
		// TODO Auto-generated method stub
		if(date!=null && !date.isEmpty())
			return weatherRepository.deleteHistoricalWeatherData(date);
		return false;
	}
	
	
	
	

}
