<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.ankur.model.Bill, java.text.SimpleDateFormat" %>
<% 
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    List<Bill> billList = (List<Bill>) request.getAttribute("billList");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Bill List</title>
</head>
<body>
    <h2>All Bills</h2>
    
    <%-- Success/Error Messages --%>
    <% if (request.getParameter("success") != null) { %>
        <p style="color:green">Bill generated successfully!</p>
    <% } %>
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red">Error: <%= request.getParameter("error") %></p>
    <% } %>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Customer ID</th>
            <th>Units</th>
            <th>Amount (₹)</th>
            <th>Bill Date</th>
            <th>Action</th>
        </tr>
        
        <% if (billList != null && !billList.isEmpty()) { 
            for (Bill bill : billList) { %>
            <tr>
                <td><%= bill.getId() %></td>
                <td><%= bill.getCustomerId() %></td>
                <td><%= bill.getUnitsConsumed() %></td>
                <td><%= String.format("%.2f", bill.getTotalAmount()) %></td>
                <td><%= dateFormat.format(java.sql.Date.valueOf(bill.getBillDate())) %></td>
                <td><a href="deleteBill?id=<%= bill.getId() %>">Delete</a></td>
            </tr>
        <% } 
           } else { %>
            <tr>
                <td colspan="6" style="text-align:center">No bills found</td>
            </tr>
        <% } %>
    </table>
    
    <br>
    <a href="addBill.html">Generate New Bill</a>
    <br><br>
    <a href="index.html">Back to Home</a>
</body>
</html>