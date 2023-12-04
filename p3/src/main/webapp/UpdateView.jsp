<%@page import="com.rays.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<jsp:useBean id="dto" class="com.rays.dto.UserDTO" scope="request"></jsp:useBean>
<% 

dto = (UserDTO) request.getAttribute("dto");
int id = Integer.parseInt(request.getParameter("id"));


%>

<h1 align="center">UPDATE USER</h1>

<div align="center">
<div>
<br>
<label>FIRSTNAME</label>
<input type="text" name="FirstName" value="<%=dto.getFirstName()%>">
</div>

<div>
<br>
<label>LASTNAME</label>
<input type="text" name="LastName" value="<%=dto.getLastName()%>">
</div>

<div>
<br>
<label>LOGINID</label>
<input type="text" name="LoginId" value="<%=dto.getLoginId()%>">
</div>

<div>
<br>
<label>PASSWORD</label>
<input type="text" name="Password" value="<%=dto.getPassword()%>">
</div>

<div>
<br>
<label>ADDRESS</label>
<input type="text" name="Address" value="<%=dto.getAddress()%>">
</div>

<div>
<br>
<input type="submit" name="operation" value="UPDATE">
</div>


</div>
</body>
</html>