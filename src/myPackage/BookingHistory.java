package myPackage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookingHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookingHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html/text");
		int id;
		id = (Integer) request.getSession().getAttribute("userid");
		BookingDetails bd = new BookingDetails();
		try {
			ArrayList<Booking> bookinglist = bd.findHistory(id);
			request.getSession().setAttribute("historyList", bookinglist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		RequestDispatcher rd = request
				.getRequestDispatcher("Bookinghistory.jsp");
		rd.forward(request, response);

	}

}
