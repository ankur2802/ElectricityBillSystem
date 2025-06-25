package com.ankur.servlet;



import com.ankur.dao.BillDAO;
import com.ankur.model.Bill;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewBills")
public class BillListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        BillDAO billDAO = new BillDAO();
        List<Bill> billList = billDAO.getAllBills();
        
        // Critical: Set the attribute with EXACT name used in JSP
        request.setAttribute("billList", billList); // Must match JSP ${billList}
        
        request.getRequestDispatcher("billList.jsp").forward(request, response);
    }
}
