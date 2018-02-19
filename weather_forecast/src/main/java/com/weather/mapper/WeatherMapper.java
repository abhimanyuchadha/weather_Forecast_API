package com.weather.mapper;

import org.jongo.ResultHandler;

import com.mongodb.DBObject;
import com.weather.model.Weather;

/**
 * @author Abhimanyu
 *
 */
public class WeatherMapper implements ResultHandler<Weather>{
	
	@Override
	public Weather map(DBObject result) {
		// TODO Auto-generated method stub
		Weather weather=new Weather();
		weather.setDate(result.get("DATE").toString());
		weather.settMax(Double.parseDouble(result.get("TMAX").toString()));
		weather.settMin(Double.parseDouble(result.get("TMIN").toString()));
		
		return weather;
	}

}
