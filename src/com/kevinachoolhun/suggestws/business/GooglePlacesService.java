package com.kevinachoolhun.suggestws.business;

import com.kevinachoolhun.suggestws.business.Utilities.Utilities;

public class GooglePlacesService {
	public static String CallGooglePlaces(double latitude, double longitude) {
		
		String address = "https://maps.googleapis.com/maps/api/place/search/json?location="
			+ latitude
			+ ","
			+ longitude
			+ "&radius=100000&types=restaurant|food|establishment&sensor=false&key=AIzaSyA6K2MKCrqnT0ImUCP4Pq3oWGb7Id7UuUA";
		
		String retVal = Utilities.getStringResponse(address);
		
		return retVal;
	}
}
