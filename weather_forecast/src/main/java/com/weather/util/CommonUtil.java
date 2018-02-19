package com.weather.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author Abhimanyu
 *
 */
public class CommonUtil {
	
	private CommonUtil() throws IllegalAccessException{
		throw new IllegalAccessException();
	}
	
	/**
	 * @param date
	 * @return
	 */
	public static String stringDateFormat(Date date){		
		if(date != null){
			SimpleDateFormat datetimeFormatter = new SimpleDateFormat("MMddyyyy");
			String finalDate = datetimeFormatter.format(date);
			return finalDate;
		}
		else
			return null;		
	}
	
	//read data
//	try {
//		br = new BufferedReader(new FileReader(new ClassPathResource(WEATHER_DATA_PATH).getFile()));
//		br.readLine();
//		String s = null;
//		while ((s = br.readLine()) != null) {
//			String[] split = s.split(",");
//			Weather weather = new Weather(split[0], Double.parseDouble(split[1]), Double.parseDouble(split[2]));
//			collection.save(weather);
//		}
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return null;

}
