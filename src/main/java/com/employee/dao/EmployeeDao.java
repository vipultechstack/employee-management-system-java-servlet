package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.employee.model.User;
import com.employee.util.DBConnect;

public class EmployeeDao {

    private Connection getConnection() throws SQLException {
        return DBConnect.getConnection();
    }

    // Add new employee including password
    public boolean addEmployee(User user) {
        String query = "INSERT INTO employees (emp_name, email, city, gender, phoneno, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, user.getEmp_name());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCity());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getPhoneno());
            ps.setString(6, user.getPassword());  // Store password here

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all employees without exposing password
    public List<User> getAllEmployees() {
        List<User> users = new ArrayList<>();
        String query = "SELECT emp_id, emp_name, email, phoneno, city, gender FROM employees";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getString("email"),
                        rs.getString("phoneno"),
                        rs.getString("city"),
                        rs.getString("gender")
                );
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Get one employee by ID without password
    public User getEmployeeById(int id) {
        User user = null;
        String query = "SELECT emp_id, emp_name, email, phoneno, city, gender FROM employees WHERE emp_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User(
                            rs.getInt("emp_id"),
                            rs.getString("emp_name"),
                            rs.getString("email"),
                            rs.getString("phoneno"),
                            rs.getString("city"),
                            rs.getString("gender")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Update employee (no password update here)
    public boolean updateEmployee(User user) {
        String query = "UPDATE employees SET emp_name = ?, email = ?, city = ?, phoneno = ?, gender = ? WHERE emp_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, user.getEmp_name());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCity());
            ps.setString(4, user.getPhoneno());
            ps.setString(5, user.getGender());
            ps.setInt(6, user.getEmp_id());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete employee by ID
    public boolean deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE emp_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get user by email (for login validation)
    public User getUserByEmail(String email) {
        User user = null;
        String query = "SELECT * FROM employees WHERE email = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User(
                        rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getString("email"),
                        rs.getString("phoneno"),
                        rs.getString("city"),
                        rs.getString("gender"),
                        rs.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Validate user login by email and password
    public User validateUser(String email, String password) {
        User user = null;
        String query = "SELECT * FROM employees WHERE email = ? AND password = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User(
                        rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getString("email"),
                        rs.getString("phoneno"),
                        rs.getString("city"),
                        rs.getString("gender"),
                        rs.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
