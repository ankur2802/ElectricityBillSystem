package com.ankur.servlet;

import com.ankur.dao.BillDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteBill")
public class DeleteBillServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Get the ID parameter from request
        String idParam = request.getParameter("id");
        
        try {
            // 2. Convert to integer
            int id = Integer.parseInt(idParam);
            
            // 3. Delete the bill
            BillDAO billDAO = new BillDAO();
            boolean deleted = billDAO.deleteBill(id);
            
            // 4. Redirect with status
            if (deleted) {
                response.sendRedirect("viewBills?deleted=true");
            } else {
                response.sendRedirect("viewBills?error=notfound");
            }
            
        } catch (NumberFormatException e) {
            // 5. Handle invalid ID format
            response.sendRedirect("viewBills?error=invalidid");
        }
    }
}