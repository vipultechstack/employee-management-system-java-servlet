<%@page import="com.employee.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Registered Users</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/users.css">

</head>
<body>
	<h2>Users Details</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>City</th>
			<th>Gender</th>
			<th>Actions</th>
		</tr>
		<%
		List<User> users = (List<User>) request.getAttribute("user");

		if (users != null) {

			for (User user : users) {
		%>
		<tr>
			<td><%=user.getEmp_id()%></td>
			<td><%=user.getEmp_name()%></td>
			<td><%=user.getEmail()%></td>
			<td><%=user.getPhoneno()%></td>
			<td><%=user.getCity()%></td>
			<td><%=user.getGender()%></td>

			<td>
 			 <a class="action-btn edit-btn" href="edituser?emp_id=<%= user.getEmp_id() %>">Edit</a>
 			 <a class="action-btn delete-btn" href="deleteuserdata?emp_id=<%= user.getEmp_id() %>" onclick="return confirm('Are you sure to delete this user?');">Delete</a>
			</td>


		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="7">No users found.</td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<a href="register.jsp">Go Back</a>
	<a href="logout">Logout</a>
</body>
</html>