<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<script type="text/javascript">
	function validate() {
		var username = document.frm.username.value;
		var password = document.frm.password.value;
		if (username == "" && password == "") {
			alert("Enter username and password");
			return false;
			document.frm.password1.focus();
		}
		return true;

	}
</script>
</head>
<body bgcolor="grey">
	<center>
		<h2>login page</h2>
		<form name="frm" action="Login" method="post"
			onsubmit="return(validate());">

			<table>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
				<td>DOB:</td>
				<td><input type="text" name="dob"></td>
				</tr>
				<tr>
				    <td>Email:</td> 
				    <td><input type="text" name="email" ></td>
				    </tr>
				
				<tr>
					<td colspan=2><input type="submit" value="login"> New
						User ? <a href="Registration.jsp"> Registration </a></td>
				</tr>
				
				
			</table>
		</form>
	</center>
</body>
</html>