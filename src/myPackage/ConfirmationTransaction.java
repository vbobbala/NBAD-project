package myPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ConfirmationTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List List;

	public ConfirmationTransaction() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		processrequest(request,response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		processrequest(request,response);
	}
	
	void processrequest(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{

		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();
		int aNumber = 0;
		int totalCost;
		String total;
		String accname = request.getParameter("Accountholdername");
		String accnum = request.getParameter("accountnumber");
		String routenum = request.getParameter("Routingnumber");
		
		int accountBalance = 0;
		totalCost = (Integer) request.getSession().getAttribute("totalCost");
		//totalCost=Integer.parseInt(total);
		BankDetailsCheck bdc = new BankDetailsCheck();
		int routen = Integer.parseInt(routenum);
		int accn = Integer.parseInt(accnum);
		
		try {
			aNumber = bdc.checkAccount(accname, routen);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		if (accn == aNumber) {
			try {
				accountBalance = bdc.findBalance(accname, accn, routen);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			if (accountBalance >= totalCost) {
				accountBalance = accountBalance - totalCost;
				bdc.updateBalance(accname, accn, routen, accountBalance);
				
				Booking bobj=new Booking();
				int Min=10000;
				int Max=100000;
				int bookingid;
				
				//int flightid =(Integer) request.getSession().getAttribute("flightId5");
				int id=(Integer) request.getSession().getAttribute("userid");
				ShoppingCart cart=(ShoppingCart) request.getSession().getAttribute("shoppingCart");
				ArrayList<FlightOrder> flob = new ArrayList<FlightOrder>(); 
			    flob= (ArrayList<FlightOrder>) cart.getFlightsOrdered();
			    for(int i=0;i<flob.size();i++){
			    	Flight f=new Flight();
			    	f=flob.get(i).getFlight();
			    	int flightid=f.getFlightid();
			    	System.out.println("shopping cart" + flightid);
			    				    	
			    	String date=f.getDate();
			    	int seats=(Integer) request.getSession().getAttribute("seatsSelected");
			    	int avail = f.getSeatsAvailable();
			    	int booked = f.getSeatsBooked();
					//int tot = f.getSeatsTotal();
					
					FlightSearch fs = new FlightSearch();
					int t = avail - seats;
					int b = booked + seats;
					
			    	
					try {
						fs.updateSeats(t, b, id);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	
			    	
			    	
			    	
			    	int cost=(Integer) request.getSession().getAttribute("totalCost");
			    	bookingid= Min + (int)(Math.random() * ((Max - Min) + 1));
			    	BookingDetails bdl=new BookingDetails();
			    	request.getSession().setAttribute("bookingID", "bookingid");
			    	try {
						bdl.insertRecordBooking(bookingid, id, flightid, date, seats, accn, cost);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	
							    	
			    }
												
				
				RequestDispatcher rd = request
						.getRequestDispatcher("confirmation.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("Balance.jsp");
				rd.forward(request, response);

			}
		} else {
			out.println("<center> Wrong account details </center>");
			RequestDispatcher rd = request
					.getRequestDispatcher("Transaction.jsp");
			rd.include(request, response);
		}
	}
}