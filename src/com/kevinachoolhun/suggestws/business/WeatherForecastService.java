package com.kevinachoolhun.suggestws.business;

import com.kevinachoolhun.suggestws.Model.WeatherResult;

public class WeatherForecastService {

	public static WeatherResult getWeatherResult(String postcode) {
		WeatherResult result = JSONXMLParser
				.ParseGoogleWeatherXML(GoogleWeatherService
						.CallGoogleWeather(postcode));

		return result;
	}

}
