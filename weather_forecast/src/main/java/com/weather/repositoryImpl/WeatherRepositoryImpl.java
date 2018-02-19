package com.weather.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import org.jongo.Find;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.weather.mapper.WeatherMapper;
import com.weather.model.HistoricalResponse;
import com.weather.model.Weather;
import com.weather.repository.WeatherRepository;

/**
 * @author Abhimanyu
 *
 */
@Repository
public class WeatherRepositoryImpl implements WeatherRepository {

	private static final String WEATHER_DATA_PATH = "/daily.csv";

	private static final String HISTORIC_DATA_COLLECTION = "historical";

	@Autowired
	private Jongo dataSource;


	@Override
	public List<Weather> weatherRepository() {
		// TODO Auto-generated method stub

		MongoCollection collection = dataSource.getCollection(HISTORIC_DATA_COLLECTION);
		// MongoCursor<Weather> cursor = collection.find().as(Weather.class);
		Find cursor = collection.find();
		MongoCursor<Weather> result = cursor.map(new WeatherMapper());

		List<Weather> listOfWeatherData = convertMongoCursorToList(result);
		
		return listOfWeatherData;
		
	}

	public <T> List<T> convertMongoCursorToList(MongoCursor<T> cursor) {
		List<T> list = new ArrayList<>();
		for (T t : cursor) {
			list.add(t);
		}
		return list;
	}

	@Override
	public List<HistoricalResponse> fetchAllHistoricalDates() {
		// TODO Auto-generated method stub
		MongoCollection collection = dataSource.getCollection(HISTORIC_DATA_COLLECTION);
		MongoCursor<HistoricalResponse> cursor = collection.find().as(HistoricalResponse.class);
		return convertMongoCursorToList(cursor);
	}

	@Override
	public Weather fetchHistoricalWeather(String date) {
		// TODO Auto-generated method stub
		MongoCollection collection = dataSource.getCollection(HISTORIC_DATA_COLLECTION);
		Find cursor = collection.find("{DATE:#}", date);
		MongoCursor<Weather> result = cursor.map(new WeatherMapper());
		List<Weather> listOfWeatherData = convertMongoCursorToList(result);
		return listOfWeatherData.get(0);
	}

	@Override
	public HistoricalResponse addHistoricalWeatherData(Weather weather) {
		// TODO Auto-generated method stub
		MongoCollection collection = dataSource.getCollection(HISTORIC_DATA_COLLECTION);
		return collection.save(weather).getN() > 0 ? new HistoricalResponse(weather.getDate()) : null;

	}

	@Override
	public boolean deleteHistoricalWeatherData(String date) {
		// TODO Auto-generated method stub
		MongoCollection collection = dataSource.getCollection(HISTORIC_DATA_COLLECTION);
		return collection.remove("{DATE:#}", date).getN() > 0 ? true : false;

	}
	
	@Override
	public List<Weather> fetchAllRecordsWithSimilarDate(String date) {
		// TODO Auto-generated method stub
		MongoCollection collection = dataSource.getCollection(HISTORIC_DATA_COLLECTION);
		return null;

	}
	
	

}
