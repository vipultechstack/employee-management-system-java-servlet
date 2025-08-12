package com.employee.servlet;

import com.employee.dao.EmployeeDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {

    private EmployeeDao employeeDao;

    @Override
    public void init() throws ServletException {
        employeeDao = new EmployeeDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("emp_id"));

        boolean deleted = employeeDao.deleteEmployee(id);

        if (deleted) {
            response.sendRedirect("getuserdata");
        } else {
            response.getWriter().println("Error deleting user with ID: " + id);
        }
    }
}
