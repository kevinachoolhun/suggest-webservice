package com.kevinachoolhun.suggestws.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kevinachoolhun.suggestws.business.GoogleWeatherService;

@SuppressWarnings("serial")
public class WeatherServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		resp.setContentType("text/plain");
		String location = req.getParameter("location");
		String retValue = GoogleWeatherService.CallGoogleWeather(location);
		resp.getWriter().println(retValue);
	}

}
