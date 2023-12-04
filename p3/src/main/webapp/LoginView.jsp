<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LoginCtl" method="post">

<%

%>

	<tr>
		<br>
		<div>
			<label>LoginId</label> <input type="text" name="LoginId"
				placeholder="enter your loginId">
		</div>
	</tr>

	<tr>
		<br>
		<div>
			<label>Password</label> <input type="text" name="Password"
				placeholder="enter your password">
		</div>
	</tr>
	<tr>
		<br>
		<input type=submit name="operation" value=Login>
	</tr>
	</form>
</body>
</html>