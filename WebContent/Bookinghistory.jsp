<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="myPackage.Booking"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking History</title>
</head>
<body bgcolor="grey">
	<center>
		<h2>Booking History</h2>
		<table border="3" cellpadding="2">
			<%
				if (request.getSession().getAttribute("historyList") != null) {
					ArrayList<Booking> bookinglist = (ArrayList<Booking>) request
							.getSession().getAttribute("historyList");
					if (!bookinglist.isEmpty()) {
						out.print("<thead>");
						out.print("<tr>");
						out.print("<th>BookingID</th>");
						out.print("<th>FlightID</th>");
						out.print("<th>Account Number</th>");
						out.print("<th>Date</th>");
						out.print("<th>Number of Seats</th>");
						out.print("<th>Total Cost</th>");
						out.print("</tr>");
						out.print("</thead>");
						out.print("<tbody>");
						out.print("<tr>");

						for (Booking b : bookinglist) {
							out.print("<tr>");
							out.print("<td>" + b.getBookingId() + "</td>");
							out.print("<td>" + b.getFlightid() + "</td>");
							out.print("<td>" + b.getAccountid() + "</td>");
							out.print("<td>" + b.getDate() + "</td>");
							out.print("<td>" + b.getNumberOfSeats() + "</td>");
							out.print("<td>" + b.getTotalCost() + "</td>");
							out.print("</tr>");
						}
						out.print("</tr>");
						out.print("</tbody>");
					} else {
						out.print("No Booking History");
					}

				} else {
					out.print("No Booking History");
				}
			%>
		</table>

		<form>
			<input type="button" onclick="location.href='Flightsearchpage.jsp';"
				value="Home" />
		</form>
		<form action="Logout" method="post">
			<input type="submit" value="logout" />
		</form>
		
	</center>
</body>
</html>