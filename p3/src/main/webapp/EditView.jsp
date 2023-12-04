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
<a href="UpdateCtl?id=<%=dto.getId()%>">edit</a>
</body>
</html>