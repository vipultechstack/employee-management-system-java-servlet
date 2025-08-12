package com.employee.servlet;

import com.employee.dao.EmployeeDao;
import com.employee.model.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getData")
public class GetData extends HttpServlet {

    private EmployeeDao employeeDao;

    @Override
    public void init() throws ServletException {
        employeeDao = new EmployeeDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> users = employeeDao.getAllEmployees();

        request.setAttribute("user", users);

        RequestDispatcher dispatcher = request.getRequestDispatcher("getuser.jsp");
        dispatcher.forward(request, response);
    }
}
