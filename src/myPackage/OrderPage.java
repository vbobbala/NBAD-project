package myPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		ShoppingCart cart;
		synchronized (session) {
			cart = (ShoppingCart) session.getAttribute("shoppingCart");
			if (cart == null) {
				cart = new ShoppingCart();
				session.setAttribute("shoppingCart", cart);
			}
			int flightid = Integer.parseInt(request.getParameter("flightid"));
			if(flightid!=0){
				int numSeatsString =Integer.parseInt(request.getParameter("seats"));
				if(numSeatsString==0){
					try {
						cart.addFlight(flightid);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					
					try {
						cart.setNumOrdered(flightid, numSeatsString);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		

	}
}