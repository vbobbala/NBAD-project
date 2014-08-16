<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>

<script type="text/javascript">
	function validate() {
		var pass1 = document.frm.password1.value;
		var pass2 = document.frm.confirmpassword.value;
		if (pass1 != pass2) {
			alert("Passwords Do not match");
			return false;
			documeny.frm.password1.focus();
		}
		return true;

	}
</script>

</head>
<body bgcolor="grey">
	<center>
		<h2>Registration Page</h2>
		<form name="frm" action="Registration" method="post"
			onsubmit="return(validate());">
			<table>
			<tr> 
			<td> Username : </td> 
			<td> <input type="text" name="username"> </td>
			 </tr>
			<tr> <td> Password : </td>
			<td> <input type="password" name="password1"> </td>
			</tr>
			<tr>
			<td> Confirm Password : </td>
			<td> <input type="password" name="confirmpassword"> </td>
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
			<td colspan=2 align="center"> <input type="submit" name="submit" value="submit"> </td>
			</tr>

            </table>
		</form>
	</center>
</body>
</html>