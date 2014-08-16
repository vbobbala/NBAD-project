package myPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class viewbook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public viewbook() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int seatsbo = Integer.parseInt(request.getParameter("seats"));
		int travelpackageno=Integer.parseInt(request.getParameter("TravelPackage"));
		//System.out.println("travelpackageno" + travelpackageno);
		// System.out.println(seatsbo);
		int flightid = (Integer) request.getSession().getAttribute("flightId5");
		
		
		// System.out.println(flightid);
		int total = 0;
		HttpSession session = request.getSession();
		ShoppingCart cart;
		synchronized (session) {
			cart = (ShoppingCart) session.getAttribute("shoppingCart");
			if (cart == null) {
				cart = new ShoppingCart();
				session.setAttribute("shoppingCart", cart);
			}
			// int flightid = Integer.parseInt(id1);
			if (flightid != 0) {

				if (seatsbo == 0) {
					try {
						cart.addFlight(flightid);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					

					try {
						cart.setNumOrdered(flightid, seatsbo);
						if(travelpackageno!=0){
							cart.setTravelOrdered(travelpackageno, 1);
							//cart
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}

				}

			
			total = cart.totalCost();

		}

		Flight flobj = (Flight) request.getSession().getAttribute(
				"flightDetails");
		if (flobj.getSeatsAvailable() >= seatsbo) {

			int seats = flobj.getSeatsAvailable();
			
			
			// int cost=flobj.getCost();
			// int total=seatsbo*cost;
			// System.out.println(total);
			request.getSession().setAttribute("totalCost", total);
			request.getSession().setAttribute("seatsSelected", seatsbo);

			RequestDispatcher rd = request
					.getRequestDispatcher("Transaction.jsp");

			rd.forward(request, response);
		} else {
			System.out.println("selected no of seats are not available");
			RequestDispatcher rd = request
					.getRequestDispatcher("Flightsearchresult.jsp");
			rd.forward(request, response);
		}

	}

}
