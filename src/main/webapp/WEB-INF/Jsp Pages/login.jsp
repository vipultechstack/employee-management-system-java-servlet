<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<h2>Login Page</h2>

		<form action="Login" method="post">
			<label>Email:</label> 
			<input type="email" name="email" required placeholder="Enter Email"> 
				
			<label>Password:</label> 
			<input type="password" name="password" required placeholder="Enter Password"> 
			
			<input type="submit" value="Login">
		</form>

		<p>
			Don't have an account? <a href="register.jsp">Register here</a>
		</p>
		<c:if test="${not empty errorMessage}">
			<p style="color: red;">${errorMessage}</p>
		</c:if>
	</div>
</body>
</html>
