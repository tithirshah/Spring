package com.springrest.service;

import java.net.URI;

import com.example.demo.WeatherAppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Service
public class WeatherService {

	private static final String WEATHER_URL =
			"http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}";

	private static final String FORECAST_URL =
			"http://api.openweathermap.org/data/2.5/forecast?q={city},{country}&APPID={key}&mode=json";

	private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

	private final RestTemplate restTemplate;

	private final String apiKey;

	public WeatherService(RestTemplateBuilder restTemplateBuilder,
			WeatherAppProperties properties) {
		this.restTemplate = restTemplateBuilder.build();
		this.apiKey = properties.getApi().getKey();
	}

	@Cacheable("weather")
	public Weather getWeather(String country, String city) throws Exception {
		logger.info("Requesting current weather for {}/{}", country, city);
		URI url = new UriTemplate(WEATHER_URL).expand(city, country, this.apiKey);
		return invoke(url, Weather.class);
	}

	@Cacheable("forecast")
	public WeatherForecast getWeatherForecast(String country, String city) throws Exception{
		logger.info("Requesting weather forecast for {}/{}", country, city);
		URI url = new UriTemplate(FORECAST_URL).expand(city, country, this.apiKey);
		return invoke(url, WeatherForecast.class);
		
	}
	

	
	
//	@Cacheable("forecast")
//	public WeatherForecast getWeatherForecast(String city) {
//		logger.info("Requesting weather forecast for {}/{}", city);
//		URI url = new UriTemplate(FORECAST_URL).expand(city,this.apiKey);
//		return invoke(url, WeatherForecast.class);
//	}

	private <T> T invoke(URI url, Class<T> responseType) throws Exception {
		RequestEntity<?> request = RequestEntity.get(url)
				.accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<T> exchange = this.restTemplate
				.exchange(request, responseType);
		WeatherForecast wf=(WeatherForecast) exchange.getBody();
		//for(wf.getEntries())
		return exchange.getBody();
	}

}
