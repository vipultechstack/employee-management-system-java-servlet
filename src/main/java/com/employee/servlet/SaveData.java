package com.employee.servlet;

import com.employee.dao.EmployeeDao;
import com.employee.model.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/SaveData")
public class SaveData extends HttpServlet {

    private EmployeeDao employeeDao;

    @Override
    public void init() throws ServletException {
        employeeDao = new EmployeeDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        String phoneno = request.getParameter("phoneno");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User(0, name, email, phoneno, city, gender, hashedPassword);

        boolean success = employeeDao.addEmployee(user);

        if (success) {
            response.sendRedirect("login.jsp");
        } else {
        	
            response.getWriter().println("Error: Unable to save user.");
        }
    }
}
