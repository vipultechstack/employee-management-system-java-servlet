package com.employee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	 	private static final String URL = "jdbc:mysql://localhost:3306/servlet_jdbc";
	    private static final String USERNAME = "YOUR_DB_USER";
	    private static final String PASSWORD = "YOUR_DB_PASSWORD";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}
