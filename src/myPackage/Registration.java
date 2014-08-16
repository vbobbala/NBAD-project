package myPackage;

import java.io.IOException;
import java.sql.SQLException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processrequest(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processrequest(request,response);
		
		
	}

	void processrequest(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		int userid=Integer.parseInt(request.getParameter("username"));
		String password=request.getParameter("password1");
		String dob=request.getParameter("dob");
		String email=request.getParameter("email");
		//DBclass db=new DBclass();
		User1 user= new User1();
		try {
			user.insertRecordUsers(userid, password, dob, email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("login.jsp");
	}
	
}
