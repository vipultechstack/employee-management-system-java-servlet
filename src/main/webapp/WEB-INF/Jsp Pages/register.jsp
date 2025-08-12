<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Registration Page</h2>
        
        <form action="SaveData" method="post">
            <label>Name:</label> 
            <input type="text" name="name" required placeholder="Enter Name">

            <label>Email:</label> 
            <input type="email" name="email" required placeholder="Enter Email">

            <label>Phone:</label> 
            <input type="text" name="phoneno" required placeholder="Enter Phone">

            <label>City:</label> 
            <input type="text" name="city" required placeholder="Enter City">

            <label>Gender:</label> 
            <select name="gender" required>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
            
            <label>Password:</label>
			<input type="password" name="password" required placeholder="Enter Password">
            
            
            <input type="submit" value="Register">
        </form>

        <a href="getuserdata" class="view-users-link">View All Users</a>
    </div>
</body>
</html>
