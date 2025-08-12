<%@page import="com.employee.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/update.css">
</head>
<body>
    <h2>Edit User</h2>
    <%
        User user = (User) request.getAttribute("user");
    %>
    <form action="UpdateData" method="post">
        <input type="hidden" name="id" value="<%= user.getEmp_id() %>">
        
        <label>Name:</label> 
        <input type="text" name="name" value="<%= user.getEmp_name() %>" required><br>
        
        <label>Email:</label> 
        <input type="email" name="email" value="<%= user.getEmail() %>" required><br>
        
        <label>Phone:</label> 
        <input type="text" name="phone" value="<%= user.getPhoneno() %>" required><br>
        
        <label>City:</label> 
        <input type="text" name="city" value="<%= user.getCity() %>" required><br>
        
        <label>Gender:</label>
        <select name="gender" required>
            <option value="Male" <%= "Male".equals(user.getGender()) ? "selected" : "" %>>Male</option>
            <option value="Female" <%= "Female".equals(user.getGender()) ? "selected" : "" %>>Female</option>
        </select><br>
        
        <input type="submit" value="Update">
    </form>
    <a href="getuserdata">Back to Users</a>
</body>
</html>
