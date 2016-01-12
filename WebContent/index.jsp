<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wellsneargo</title>
</head>
<body>

	<h1>Welcome to Wellsneargo! Please Signup!</h1>
	<form action="SignupServlet" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="custName" id="custName" /></td>
			</tr>

			<tr>
				<td>Username:</td>
				<td><input type="text" name="custUsername" id="custUsername" />
				</td>
			</tr>


			<tr>
				<td>Password:</td>
				<td><input type="password" name="custPassword"
					id="custPassword" /></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="email" name="custEmail" id="custEmail" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="signup" id="signupBtn" /></td>

				<td><input type="reset" name="reset" id="resetBtn" /></td>
			</tr>
		</table>
	</form>

	

</body>
</html>