package com.kevinachoolhun.suggestws.business;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;

import com.kevinachoolhun.suggestws.business.Utilities.Utilities;

public class GoogleWeatherService {
	
	public static String CallGoogWeather(String location) {
		return  Utilities.getStringResponse("http://www.google.com/ig/api?weather="+location);
	}
	
	public static InputStream CallGoogleWeather(String location) {
		String str;
		InputStream streamFromWS = null;
		try {
			
			String webserviceUrl = "http://www.google.com/ig/api?weather=";

			String urlWithPostalCode = webserviceUrl.concat(location);
			
			URL url = new URL(urlWithPostalCode);
			URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(),
					url.getQuery(), null);

			URL myURL = uri.toURL();
			URLConnection conn = myURL.openConnection();

			streamFromWS = conn.getInputStream();
		

		} catch (Exception ex) {
			ex.printStackTrace();
			str = ex.getMessage();

		}

		return streamFromWS;

	}
}
