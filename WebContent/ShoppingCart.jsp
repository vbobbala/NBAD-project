<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="myPackage.ShoppingCart"%>
<%@page import="myPackage.FlightOrder" %>
<%@page import="myPackage.TravelPackageOrder" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shopping cart</title>
</head>
<body>
	<%
		if ((ShoppingCart) request.getSession()
				.getAttribute("shoppingCart") != null) {
			ShoppingCart sc = (ShoppingCart) request.getSession()
					.getAttribute("shoppingCart");
			ArrayList fl = sc.getFlightsOrdered();
			// Arraylist tl=sc.getTravelPackageOrdered();
			  
		}			
	%>


</body>
</html>