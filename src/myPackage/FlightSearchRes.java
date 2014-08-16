package myPackage;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FlightSearchRes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FlightSearchRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		Flight f = new Flight();
		int id = Integer.parseInt(request.getParameter("flightSelected"));
		request.setAttribute("flightId1", id);

		// System.out.println(request.getAttribute("flightId1"));
		FlightSearch obj = new FlightSearch();
		try {
			f = obj.getFindFlight(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("flightDetails", f);
		request.getSession().setAttribute("flightId5", id);

		// RequestDispatcher rd1 = request.getRequestDispatcher("viewbook.jsp");
		// rd1.forward(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("Viewandbook.jsp");
		rd.forward(request, response);

	}

}
