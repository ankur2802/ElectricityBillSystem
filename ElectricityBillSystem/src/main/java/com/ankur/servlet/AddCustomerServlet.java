package com.ankur.servlet;

import com.ankur.dao.CustomerDAO;
import com.ankur.model.Customer;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addCustomer")
public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        customer.setEmail(request.getParameter("email"));
        customer.setAddress(request.getParameter("address"));

        new CustomerDAO().addCustomer(customer);
        response.sendRedirect("listCustomer");
    }
}