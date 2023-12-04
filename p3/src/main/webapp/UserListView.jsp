<%@page import="com.rays.dto.UserDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="UserListCtl" method="post">
		<h1 align="center">USER LIST</h1>

		<jsp:useBean id="dto" class="com.rays.dto.UserDTO" scope="request"></jsp:useBean>


		<%
			List list = (List) request.getAttribute("list");
			int pageNo = (Integer) request.getAttribute("pageNo");
			int pageSize = (Integer) request.getAttribute("pageSize");
			int index = (pageNo - 1) * pageSize + 1;

			Iterator<UserDTO> it = list.iterator();
		%>


      <div align="center">
      
   <input type="text" name="FirstName" placeholder="enter your firstname" value="<%=request.getParameter("FirstName")%>"  >
   <input type="submit" name="operation"  value="Search">
   
   
			<table class="table table-bordered">
				<thead>
					<tr style="background-color: yellow;">
						<th width="5%" class="text">S.NO</th>
						<th width="15%" class="text">FirstName</th>
						<th width="15%" class="text">LastName</th>
						<th width="20%" class="text">Login</th>
						<th width="10%" class="text">Password</th>
						<th width="10%" class="text">Address</th>
						<th width="5%" class="text">Delete</th>
						<th width="5%" class="text">Edit</th>
					</tr>
				</thead>

				<%
					while (it.hasNext()) {
						dto = it.next();
					
				%>

				<tbody>
					<tr>
						<td class="text"><%=index++%></td>
						<td class="text"><%=dto.getFirstName()%></td>
						<td class="text"><%=dto.getLastName()%></td>
						<td class="text"><%=dto.getLoginId()%></td>
						<td class="text"><%=dto.getPassword()%></td>
						<td class="text"><%=dto.getAddress()%></td>
						<td class="text"><a href="UserCtl?id=<%=dto.getId()%>">Delete</a>
						<td class="text"><a href="UpdateCtl?id=<%=dto.getId()%>">edit</a>
						


					</tr>

				</tbody>
				<%
				}
				%>


				<tbody>
					<tr>
						<td class>
					</tr>
				</tbody>
			</table>


		</div>

	</form>
</body>
</html>