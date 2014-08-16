<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@page import="java.util.ArrayList"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="myPackage.Flight"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="Style.css">
<title>Search Results!</title>
</head>

<body BGcolor="grey"> 
             
<center>
<h2> Search Result </h2>     
	<form id="results" name="results" method="post" action="FlightSearchRes">
		<table border="3" cellpadding="2">
			<%
			if((ArrayList<Flight>)request.getSession().getAttribute("flightsSearchResult")!=null){

				ArrayList<Flight> al = (ArrayList<Flight>) request.getSession()
						.getAttribute("flightsSearchResult");

					if (!al.isEmpty()) {
						out.print("<thead>");
						out.print("<tr>");
						out.print("<th></th>");
						out.print("<th>Flight No</th>");
						out.print("<th>Flight Date</th>");
						out.print("<th>Departure Time</th>");
						out.print("<th>Arrival Time</th>");
						out.print("<th>Stops</th>");
						out.print("<th>Cost</th>");
						out.print("</tr>");
						out.print("</thead>");
						out.print("<tbody>");
						out.print("<tr>");

						for (Flight f : al) {

							out.print("<tr>");
							out.print("<td> <input type=radio name=flightSelected  id="
									+ f.getFlightid()
									+ " value ="
									+ f.getFlightid()
									+ ">"+ "</td>");
							out.print("<td>" + f.getFlightid() + "</td>");
							out.print("<td>" + f.getDate() + "</td>");
							out.print("<td>" + f.getDeparturetime() + "</td>");
							out.print("<td>" + f.getArrivaltime()+ "</td>");
							out.print("<td>" + 0 + "</td>");
							out.print("<td>" + f.getCost() + "</td>");
							out.print("</td></tr>");

						}
						out.print("</tr>");
						out.print("</tbody>");
					} else {
						out.print("No Flights !");
					}
				} else {
					out.print("No Flights !");

				}
			%>
			<tr>
				<td colspan="6" align="center"><input type="submit"
					name="submitBtn" value="View and Book"></td>
			</tr>
		</table>
	</form>
	<form action="Logout" method="post">
			<input type="submit" value="logout" />
		</form>
	</center>
</body>
</html>