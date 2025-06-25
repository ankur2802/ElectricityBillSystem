package com.ankur.servlet;

import com.ankur.dao.CustomerDAO;
import com.ankur.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listCustomer")
public class ListCustomerServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            // 1. Create DAO instance
            CustomerDAO customerDAO = new CustomerDAO();
            
            // 2. Get all customers using instance method
            List<Customer> customerList = customerDAO.getAllCustomers();
            
            // 3. Set attribute for JSP
            request.setAttribute("customerList", customerList);
            
            // 4. Forward to JSP
            request.getRequestDispatcher("customerList.jsp").forward(request, response);
            
        } catch (Exception e) {
            // 5. Basic error handling
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 
                "Error retrieving customer list: " + e.getMessage());
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}