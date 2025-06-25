package com.ankur.servlet;

import com.ankur.dao.BillDAO;
import com.ankur.model.Bill;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/addBill")
public class AddBillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            int customerId = Integer.parseInt(request.getParameter("customerId"));
            int units = Integer.parseInt(request.getParameter("units"));
            
            Bill bill = new Bill();
            bill.setCustomerId(customerId);
            bill.setUnitsConsumed(units);
            bill.setTotalAmount(BillDAO.calculateBillAmount(units));
            bill.setBillDate(LocalDate.now());
            
            BillDAO billDAO = new BillDAO();
            boolean success = billDAO.addBill(bill);
            
            // Critical fix: Redirect after POST to prevent duplicate submissions
            response.sendRedirect("viewBills"); 
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("addBill.html?error=true");
        }
    }
}