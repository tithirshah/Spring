package com.springrest.controller;

import com.springrest.service.Weather;
import com.springrest.service.WeatherEntry;
import com.springrest.service.WeatherForecast;
import com.springrest.service.WeatherService;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.jsp.jstl.sql.Result;
import javax.swing.text.html.parser.Entity;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/weather")
public class WeatherApiController {

	private final WeatherService weatherService;

	public WeatherApiController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@RequestMapping("/now/{country}/{city}")
	public Weather getWeather(@PathVariable String country,
			@PathVariable String city) throws Exception {
		return this.weatherService.getWeather(country, city);
	}

//	@RequestMapping("/weekly/{country}/{city}")
//	public WeatherForecast getWeatherForecast(@PathVariable String country,
//			@PathVariable String city) {
//		WeatherForecast wf=new WeatherForecast();
//		wf= this.weatherService.getWeatherForecast(country, city);
//		double avgtemp=0;
//		double tempday=0;
//		double tempnight=0;
//		List<WeatherEntry> we=wf.getEntries();
//		for(WeatherEntry w:we)
//		{
//			LocalDate date = LocalDate.now();
//			LocalDateTime dateTime = LocalDateTime.parse(w.getTimestamp().toString());
//			if(dateTime.equals(date))
//			{
//				continue;
//			}
//			if(dateTime.equals(date.plusDays(1))||dateTime.equals(date.plusDays(2))||dateTime.equals(date.plusDays(3)))
//			{
//				if(dateTime.getHour()==6||dateTime.getHour()==9||dateTime.getHour()==12||dateTime.getHour()==15||dateTime.getHour()==18)
//				{
//					tempday+=w.getTemperature();
//				}
//				if(dateTime.getHour()==18||dateTime.getHour()==21||dateTime.getHour()==0||dateTime.getHour()==3||dateTime.getHour()==6)
//				{
//					tempnight+=w.getTemperature();
//				}
//				
//			}
//			//Period period = Period.between(date.plusDays(1),date.plusDays(3));
//			
//		//}
//		return wf;
//		
//	}
	
//	
	@GetMapping(path = "/weekly/{country}/{city}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getWeatherForecast(@PathVariable String country,
			@PathVariable String city) throws Exception {
		WeatherForecast wf=new WeatherForecast();
		try {
			wf= this.weatherService.getWeatherForecast(country, city);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			throw new Exception();
		}
		if(wf!=null)
		{
		double avgtempd,avgtempn=0;
		double tempday=0;
		double tempnight=0;
		double pressured = 0,pressuren=0;
		double avgpred = 0,avgpren=0;
		
		List<WeatherEntry> we=wf.getEntries();
		for(WeatherEntry w:we)
		{
			LocalDate date = LocalDate.now();
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
			LocalDateTime dateTime = LocalDateTime.parse(w.getTimestamp().toString(),inputFormatter);
			LocalDate dateT = LocalDate.parse(w.getTimestamp().toString(),inputFormatter);
			System.out.println("date"+date);
			System.out.println("datetime"+dateT);
			if(dateT.equals(date))
			{
				//System.out.println("in if");
				continue;
			}
			else if(dateT.equals(date.plusDays(1))||dateT.equals(date.plusDays(2))||dateT.equals(date.plusDays(3)))
			{
				System.out.println(dateTime.getHour());
				if(dateTime.getHour()==6||dateTime.getHour()==9||dateTime.getHour()==12||dateTime.getHour()==15||dateTime.getHour()==18)
				{
					tempday+=this.getCelsius(w.getTemperature());
					pressured+=w.getPressure();
					//System.out.println("tempday"+tempday);
				}
				if(dateTime.getHour()==18||dateTime.getHour()==21||dateTime.getHour()==0||dateTime.getHour()==3||dateTime.getHour()==6)
				{
					tempnight+=w.getTemperature();
					pressuren+=w.getPressure();
					//System.out.println("tempnight"+tempnight);
				}
				
			}
		}
		avgtempd=tempday/4;
		avgtempn=tempnight/4;
		avgpred=pressured/4;
		avgpren=pressuren/4;
		//System.out.println("avgtempd"+avgtempd);
		//System.out.println("avgtempn"+avgtempn);

			
			HashMap<String, String> map = new HashMap<>();
		    //map.put("tempd", avgtempd);
		    map.put("Average Temperature Day", Double.toString(avgtempd));
		    map.put("Average Temperature Night", Double.toString(avgtempn));
		    map.put("Average Pressure Day", Double.toString(avgpred));
		    map.put("Average Pressure Night", Double.toString(avgpred));
		    
	        return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
		else
		{
			
			
		
			throw new Exception();
		}
		
		
	}
	
	private double getCelsius(double k)
	{
		return k-273.15;
		
	}
//	@RequestMapping(method=RequestMethod.GET,value="/forcast/{country}/{city}")
//	public @ResponseBody Object getWeatherForcastbyCity(@PathVariable String country,
//			@PathVariable String city) 
//	{
//		RestTemplate resttemplate=new RestTemplate();
//		HttpHeaders headers=new HttpHeaders();
//		ResponseEntity<Object> response=resttemplate.getForEntity("http://api.openweathermap.org/data/2.5/forecast?q="+ city+"," +country+"&APPID=96c9189b4377490de31ea173a120bbc5", Object.class);
//		//response.getBody().get
//		Result responseResult = (Result) response.getBody();
//		
//		return response;
//		
//	}

}
;