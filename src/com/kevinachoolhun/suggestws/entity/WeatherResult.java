package com.kevinachoolhun.suggestws.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WeatherResult {

	private String city;
	private Date forecastDate;
	private String condition;
	private int temperatureInCelcius;
	private int humidity;
	private String windCondition;
	
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return city;
	}
	public Date getForecastDate() {
		return forecastDate;
	}
	public void setForecastDate(Date forecastDate) {
		this.forecastDate = forecastDate;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getTemperatureInCelcius() {
		return temperatureInCelcius;
	}
	public void setTemperatureInCelcius(int temperatureInCelcius) {
		this.temperatureInCelcius = temperatureInCelcius;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public String getWindCondition() {
		return windCondition;
	}
	public void setWindCondition(String windCondition) {
		this.windCondition = windCondition;
	}
	
	
	
}
