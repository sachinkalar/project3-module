<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UserRegistrationCtl" method="post">

<br><br><br><br><br>



	<div align="center">
		<h1>User Registration</h1>
		<table>

			<tr>
			<br>
				<div>
					<label>FirstName</label> 
					<input type=text name="FirstName"
						placeholder="enter your firstname">
				</div>
			</tr>

			<tr>
				<br>
				<div>
					<label>LastName</label>
					<input type=text name="LastName"
						placeholder="enter your lastname">
				</div>
			</tr>

			<tr>
				<br>
				<div>
					<label>LoginId</label>
					<input type=text name="LoginId"
						placeholder="enter your login">
				</div>
			</tr>

			<tr>
				<br>
				<div>
					<label>Password</label>
					<input type=text name="Password"
						placeholder="enter your password">
				</div>
			</tr>

			<tr>
				<br>
				<div>
					<label>Address</label>
					<input type=text name="Address"
						placeholder="enter your address">
				</div>
			</tr>

<tr><br>
<input type="submit" name="operation" value=SignUP>
</tr></br>

		</table>
	</div>
	</form>
</body>
</html>