package com.kevinachoolhun.suggestws.presentation;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.kevinachoolhun.suggestws.businesslogic.LocationPlacesFinder;
import com.kevinachoolhun.suggestws.entity.LocationResult;

@SuppressWarnings("serial")
public class LocationServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		// resp.setContentType("text/plain");

		if (req.getParameter("lat") == null || req.getParameter("lng") == null) {
			resp.getWriter().write("Specify lattitude(lat) and longitude (lng)");

		} else {
			double la = Double.parseDouble(req.getParameter("lat"));
			double lo = Double.parseDouble(req.getParameter("lng"));

			LocationResult result = LocationPlacesFinder.GetPossibleLocations(
					la, lo);

			StringWriter xml = new StringWriter();

			JAXBContext context;
			try {
				context = JAXBContext.newInstance(LocationResult.class);
				Marshaller m = context.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

				m.marshal(result, xml);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			resp.getWriter().write(xml.toString());
		}

	}

}
