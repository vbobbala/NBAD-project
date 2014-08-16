package myPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processrequest(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processrequest(request,response);
	}
	
	void processrequest(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();
		int aNumber = 0;
		int totalCost;
		int accountBalance = 0;
		String accname = request.getParameter("Accountholdername");
		int accn=Integer.parseInt(request.getParameter("accountnumber"));
		int routen=Integer.parseInt(request.getParameter("Routingnumber"));
		totalCost = (Integer) request.getSession().getAttribute("totalCost");
		request.getSession().setAttribute("accnum", accn);
		BankDetailsCheck bdc = new BankDetailsCheck();
		
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
				
				
				
				//int flightid =(Integer) request.getSession().getAttribute("flightId5");
				int id=(Integer) request.getSession().getAttribute("userid");
				ShoppingCart cart=(ShoppingCart) request.getSession().getAttribute("shoppingCart");
				ArrayList<FlightOrder> flob = new ArrayList<FlightOrder>(); 
			    flob= (ArrayList<FlightOrder>) cart.getFlightsOrdered();
			    for(int i=0;i<flob.size();i++){
			    	Flight f=new Flight();
			    	f=flob.get(i).getFlight();
			    	int flightid=f.getFlightid();
			    	//System.out.println("shopping cart" + flightid);
			    				    	
			    	String date=f.getDate();
			    	int seats=(Integer) request.getSession().getAttribute("seatsSelected");
			    	int avail = f.getSeatsAvailable();
			    	int booked = f.getSeatsBooked();
					FlightSearch fs = new FlightSearch();
					int t = avail - seats;
					int b = booked + seats;
					
			    	
					try {
						fs.updateSeats(t, b, flightid);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	
			    							    	
			    }
			    								
			    response.getWriter().write("1");
				
			} else {
				
				response.getWriter().write("2");
				
				//out.println("balance insufficient");
				//RequestDispatcher rd = request.getRequestDispatcher("Balance.jsp");
				//rd.forward(request, response);

			}
		} else {
			
			response.getWriter().write("3");
			//out.println("Wrong account details");
			//RequestDispatcher rd = request.getRequestDispatcher("Transaction.jsp");
			//rd.forward(request, response);
		}
	}
	

}

