<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="myPackage.Flight"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
</head>
<body bgcolor="grey">
	<center>
		<h2>Transaction Page</h2>
		<form action="Logout" method="post">
			<input type="button" onclick="location.href='Flightsearchpage.jsp';"
				value="cancel" /> <input type="button"
				onclick="location.href='Flightsearchpage.jsp';"
				value="Add More Flights" /> <input type="submit" value="logout" />
		</form>
		<form action="ConfirmationTransaction" method="post">

			<table>
				<tr>
					<td>Seats</td>
					<td><%=request.getSession().getAttribute("seatsSelected")%></td>
				</tr>
				<tr>
					<td>Total Cost</td>
					<td><%=request.getSession().getAttribute("totalCost")%></td>
				</tr>
				<tr>
					<td>Account Holdername</td>
					<td><input type="text" name="Accountholdername"></td>
				</tr>
				<tr>
					<td>Routing Number</td>
					<td><input type="text" name="Routingnumber"></td>
				</tr>
				<tr>
					<td>Account Number</td>
					<td><input type="text" name="accountnumber"></td>
				</tr>
				<tr>
					<td colspan=2 align="center"><input type="submit"
						value="confirm" /></td>
				</tr>
			</table>
		</form>

	</center>
</body>
</html>