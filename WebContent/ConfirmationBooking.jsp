<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation Booking</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
	
</script>
<script>
	function getdata() {
		var aName = $("#Accountholdername").val();
		var rNum = $("#Routingnumber").val();
		var aNum = $("#accountnumber").val();

		var request = $.ajax({
			url : "BankServlet",
			type : "POST",
			data : $('#form').serialize() + "&" + "Accountholdername=" + aName
					+ "&Routingnumber=" + rNum + "&accountnumber=" + aNum

		});

		request
				.done(function(msg) {
					$('#myDiv').show();

					if (msg == "1") {
						$('#myDiv')
								.html(
										" Transaction Successful <br> Click here to add passenger details ");
					}

					if (msg == "2") {
						$('#myDiv')
								.html(
										" Balance Insufficient <br> Click here to change the account details");
						$("#myDiv").click(function() {
							$("#myDiv").load("ConfirmationBooking.jsp");
						});
					}

					if (msg == "3") {
						$('#myDiv')
								.html(
										" Wrong account details <br> Click here to change the account details");
						$("#myDiv").click(function() {
							$("#myDiv").load("ConfirmationBooking.jsp");
						});

					}

				});

		request.fail(function(jqXHR, textStatus) {
			alert("Request failed: " + textStatus);
		});

	}
</script>
</head>
<body bgcolor="grey">
	<fieldset>
		<div id="myFirstDiv"></div>
		<center>
			<h2>Transaction Page</h2>
			<form action="Logout" method="post">
				<input type="button" onclick="location.href='Flightsearchpage.jsp';"
					value="cancel" /> <input type="button"
					onclick="location.href='Flightsearchpage.jsp';"
					value="Add More Flights" /> <input type="submit" value="logout" />
			</form>
		</center>

	</fieldset>
	<fieldset>
		<center>
			<div id="myDiv">
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
						<td>Account HolderName</td>
						<td><input type="text" name="Accountholdername"
							id="Accountholdername"></td>
					</tr>
					<tr>
						<td>Routing Number</td>
						<td><input type="text" name="Routingnumber"
							id="Routingnumber"></td>
					</tr>
					<tr>
						<td>Account Number</td>
						<td><input type="text" name="accountnumber"
							id="accountnumber"></td>
					</tr>



					<tr>
						<td colspan=2 align="center">

							<button type="button" onclick="getdata()">ConfirmTransaction</button>
						</td>
					</tr>

				</table>
			</div>
			<div id="myDiv2"></div>
		</center>

	</fieldset>
</body>
</html>