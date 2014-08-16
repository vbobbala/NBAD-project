package myPackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		int userid = Integer.parseInt(request.getParameter("username"));
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("userid", userid);
		session.setAttribute("password", password);

		User1 user = new User1();

		String pswd = user.getUserPassword(userid);
		if (pswd != null) {
			if (password.equalsIgnoreCase(pswd)) {
				RequestDispatcher rd = request
						.getRequestDispatcher("Flightsearchpage.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("loginerror.jsp");
				rd.forward(request, response);

			}
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("Registration.jsp");
			rd.forward(request, response);
		}

	}

}
