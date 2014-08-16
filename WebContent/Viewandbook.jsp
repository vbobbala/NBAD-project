<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="myPackage.Flight"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View and Book</title>
</head>
<body bgcolor="grey">

	<center>

		<h2>View and Book</h2>
		<form action="Logout" method="post">
			<input type="submit" value="logout" />
			 <input type="button"
				onclick="location.href='Flightsearchresult.jsp';" value="Back" /> <input
				type="button" onclick="location.href='Flightsearchpage.jsp';"
				value="Home" />
		</form>

		<form action="viewbook" method="post">

			<table border="3" cellpadding="2">
				<%
					Flight flobj = (Flight) request.getSession().getAttribute(
							"flightDetails");

					out.print("<tr> <td>");
					out.print("id </td>");
					out.print("<td>" + flobj.getFlightid() + "</td> </tr>");
					out.print("<tr> <td>");
					out.print("Source </td>");
					out.print("<td> " + flobj.getSource() + "</td> </tr>");
					out.print("<tr> <td>");
					out.print("Destination </td>");
					out.print("<td>" + flobj.getDestination() + "</td> </tr>");
					out.print("<tr> <td>");
					out.print("Date </td>");
					out.print("<td>" + flobj.getDate() + "</td> </tr>");
					out.print("<tr> <td>");
					out.print("Cost </td>");
					out.print("<td>" + flobj.getCost() + "</td> </tr>");
					out.print("<tr> <td>");
					out.print("No of seats available </td>");
					out.print("<td>" + flobj.getSeatsAvailable() + "</td> </tr>");
					out.print("<tr> <td>");
					out.print("class </td>");
					out.print("<td>" + flobj.getEclass() + "</td> </tr>");
					out.print("<tr> <td>");
					out.print("Arrival Time </td>");
					out.print("<td>" + flobj.getArrivaltime() + "</td> </tr>");
					out.print("<tr> <td>");
					out.print("Departure Time </td>");
					out.print("<td>" + flobj.getDeparturetime() + "</td> </tr>");
				%>
				<tr>
					<td>select seats</td>
					<td><input type="text" name="seats"></td>
				</tr>
				<tr>
					<td>Travel Packages</td>
					<td><input type="radio" name="TravelPackage" value="0"> I don't need a travel package<br>
						<input type="radio" name="TravelPackage" value="1"> Travel Package1<br>
					    <input type="radio" name="TravelPackage" value="2"> Travel Package2<br> 
					    <input type="radio" name="TravelPackage" value="3"> Travel Package3<br>
					    </td>
					    
				</tr>
			</table>
			<input type="submit" value="select seats">
		</form>

	</center>
</body>
</html>