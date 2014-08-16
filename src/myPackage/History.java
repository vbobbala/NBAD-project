package myPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class History extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public History() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processrequest(request,response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processrequest(request,response);
	
	}
		
		void processrequest(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
		{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int Min = 10000;
		int Max = 100000;
		int bookingid;
		Booking bobj=new Booking();
		int id = (Integer) request.getSession().getAttribute("userid");
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute(
				"shoppingCart");
		ArrayList<FlightOrder> flob = new ArrayList<FlightOrder>();
		flob = (ArrayList<FlightOrder>) cart.getFlightsOrdered();
		for (int i = 0; i < flob.size(); i++) {
			Flight f = new Flight();
			f = flob.get(i).getFlight();
			int flightid = f.getFlightid();
			//System.out.println("shopping cart" + flightid);

			String date = f.getDate();
			int seats = (Integer) request.getSession().getAttribute(
					"seatsSelected");
			int accn = (Integer) request.getSession().getAttribute("accnum");

			int cost = (Integer) request.getSession().getAttribute("totalCost");
			bookingid = Min + (int) (Math.random() * ((Max - Min) + 1));
			BookingDetails bdl = new BookingDetails();
			request.getSession().setAttribute("bookingID", "bookingid");
			try {
				bdl.insertRecordBooking(bookingid, id, flightid, date, seats,
						accn, cost);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		out.println("Details added to booking history");

	}
}