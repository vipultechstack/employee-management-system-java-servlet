package com.employee.servlet;

import com.employee.dao.EmployeeDao;
import com.employee.model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {

    private EmployeeDao employeeDao;

    @Override
    public void init() throws ServletException {
        employeeDao = new EmployeeDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        String phoneno = request.getParameter("phone");
        String gender = request.getParameter("gender");

        User user = new User(id, name, email, phoneno, city, gender);

        boolean success = employeeDao.updateEmployee(user);

        if (success) {
            response.sendRedirect("getuserdata");
        } else {
            response.getWriter().println("Update failed. Please try again.");
        }
    }
}
