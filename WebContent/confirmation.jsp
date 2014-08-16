<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
</head>

<body bgcolor="grey" >
<center>

<p> Enter Passenger details </p>


		<table>
		
	<% int seats=(Integer)request.getSession().getAttribute("seatsSelected");
		
	for(int i=1;i<=seats;i++){
		out.print("<tr> <td> Passenger"+ i +": </td> </tr>" );
		out.print("<tr> <td> Name </td> <td> <input type=text > </tr> ");
		out.print("<tr> <td> Age </td> <td> <input type=text > </tr> ");
		out.print("<tr> <td> Sex </td> <td> <input type=text > </tr> ");
	}
		%>
		</table>
		
<form action="Logout" method="post">
			<input type="submit" value="logout" />
			<input type="button" value ="print" onclick ="window.print()"/>
			<input type="button" onclick="location.href='Flightsearchpage.jsp';" value="Home" />
		</form>
</center>
</body>
</html>