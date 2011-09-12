package com.kevinachoolhun.suggestws.presentation;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.kevinachoolhun.suggestws.businesslogic.WeatherForecastService;
import com.kevinachoolhun.suggestws.entity.WeatherResult;

@SuppressWarnings("serial")
public class WeatherServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		// resp.setContentType("text/plain");

		if (req.getParameter("loc") == null) {
			resp.getWriter().write("Specify location(loc)");

		} else {
			String location = req.getParameter("loc");
			WeatherResult result = WeatherForecastService
					.getWeatherResult(location);

			StringWriter xml = new StringWriter();

			JAXBContext context;
			try {
				context = JAXBContext.newInstance(WeatherResult.class);
				Marshaller m = context.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

				m.marshal(result, xml);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			resp.getWriter().println(xml.toString());
		}

	}
}
