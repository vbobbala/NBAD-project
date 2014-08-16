package myPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();
		out.println("<center> printing from servlet </center>");
		out.println("<center> printing from servlet </center>");
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();
		out.println("<center> printing from servlet2 </center>");
		out.println("<center> printing from servlet2 </center>");
		
		//String accname = request.getParameter("Accountholdername");
		String accname="pinky";
		System.out.println("in servlet bank");
		//System.out.println("acc holder name" + accname);
		String accn=request.getParameter("accountnumber");
		//int accn=Integer.parseInt(request.getParameter("accountnumber"));
		System.out.println("in servlet bank3" + accn);
		int routen=Integer.parseInt(request.getParameter("Routingnumber"));
		System.out.println("in servlet bank2");
		//System.out.println("valuess " + accname + accn + routen );
	}

}
