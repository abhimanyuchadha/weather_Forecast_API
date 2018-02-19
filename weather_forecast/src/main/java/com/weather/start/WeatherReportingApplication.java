package com.weather.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Abhimanyu
 *
 */
@SpringBootApplication
@ComponentScan("com.weather")
public class WeatherReportingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherReportingApplication.class, args);
	}
	
}
