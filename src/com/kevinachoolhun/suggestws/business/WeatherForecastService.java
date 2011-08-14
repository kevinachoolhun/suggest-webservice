package com.kevinachoolhun.suggestws.business;

import com.kevinachoolhun.suggestws.Model.WeatherResult;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class WeatherForecastService {

	public static WeatherResult getWeatherResult(String postcode) {
		WeatherResult result = JSONXMLParser
				.ParseGoogleWeatherXML(GoogleWeatherService
						.CallGoogleWeather(postcode));

		return result;
	}

}
