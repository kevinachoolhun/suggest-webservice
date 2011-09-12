package com.kevinachoolhun.suggestws.businesslogic;

import com.kevinachoolhun.suggestws.entity.LocationResult;

public class LocationPlacesFinder {

	public static LocationResult GetPossibleLocations(double latitude,
			double longitude) {

	
		LocationResult locResult = null;
		try {

			String jsonString = GooglePlacesService.CallGooglePlaces(
					latitude, longitude);
			locResult = JSONXMLParser.ParseGooglePlacesJSON(jsonString);
		

		} catch (Exception ex) {
			ex.printStackTrace();
			//Toast.makeText(this, "IOException: " + ex.getMessage(), 50).show();
		}

		return locResult;

	}

}
