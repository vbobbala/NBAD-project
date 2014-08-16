<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight search page</title>
</head>
<body bgcolor="grey">
	<center>
		<h2>Flight Search page</h2>
		<form action="BookingHistory" method="post">
			<input type="submit" value="Booking History">
		</form>
		<form action="Logout" method="post">
			<input type="submit" value="logout" />
		</form>
		<form action="FlightSearchQuery" method="POST">

			<table>
				<tr>
					<td>Source :</td>
					<td><input type="text" name="source"></td>
				</tr>
				<tr>
					<td>Destination :</td>
					<td><input type="text" name="destination"></td>
				</tr>
				<tr>
					<td>Date :</td>
					<td><input type="text" name="date"></td>
				</tr>
				<tr>
					<td>Number of Seats :</td>
					<td><input type="text" name="numberofseats"></td>
				</tr>
				<tr>
					<td>Class :</td>
					<td><select name="eclass">
							<option value="economy">economy</option>
							<option value="business">business</option>
							<option value="first class">first class</option>
					</select></td>
				</tr>
				<tr>
					<td colspan=2 align="center"><input type="submit"
						name="search" value="search"></td>
				</tr>
			</table>

		</form>

	</center>
</body>
</html>