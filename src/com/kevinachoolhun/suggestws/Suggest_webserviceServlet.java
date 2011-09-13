package com.kevinachoolhun.suggestws;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kevinachoolhun.suggestws.datalayer.GooglePlacesService;

@SuppressWarnings("serial")
public class Suggest_webserviceServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		double la = Double.parseDouble(req.getParameter("la"));
		double lo = Double.parseDouble(req.getParameter("lo"));
		
		String places = GooglePlacesService.CallGooglePlaces(la, lo);
		
		resp.getWriter().println(places);
	}
}
