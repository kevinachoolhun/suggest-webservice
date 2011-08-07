package com.kevinachoolhun.suggestws.controller;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.kevinachoolhun.suggestws.Model.LocationResult;
import com.kevinachoolhun.suggestws.business.LocationPlacesFinder;

@SuppressWarnings("serial")
public class LocationServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		resp.setContentType("text/plain");

		double la = Double.parseDouble(req.getParameter("la"));
		double lo = Double.parseDouble(req.getParameter("lo"));

		LocationResult result = LocationPlacesFinder.GetPossibleLocations(la, lo);


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
