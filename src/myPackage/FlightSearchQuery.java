package myPackage;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FlightSearchQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FlightSearchQuery() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String date = request.getParameter("date");
		String Number_of_seats = request.getParameter("numberofseats");
		String eclass = request.getParameter("eclass");

		FlightSearch fobj = new FlightSearch();
		ArrayList<Flight> list = fobj.getFlightInfo(source, destination,
				Number_of_seats,eclass,date);
		request.setAttribute("flightlist", list);
		request.getSession().setAttribute("flightsSearchResult", list);
		RequestDispatcher rd = request
				.getRequestDispatcher("Flightsearchresult.jsp");
		rd.forward(request, response);

	}

}
