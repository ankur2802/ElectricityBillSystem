<%@ page import="java.util.List, com.ankur.model.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
    <h2>Customer List</h2>
    <table border="1">
        <tr>
            <th>ID</th><th>Name</th><th>Email</th><th>Address</th><th>Action</th>
        </tr>
        <% for (Customer customer : (List<Customer>)request.getAttribute("customerList")) { %>
        <tr>
            <td><%= customer.getId() %></td>
            <td><%= customer.getName() %></td>
            <td><%= customer.getEmail() %></td>
            <td><%= customer.getAddress() %></td>
            <td><a href="deleteCustomer?id=<%= customer.getId() %>">Delete</a></td>
        </tr>
        <% } %>
    </table>
    <br>
    <a href="addCustomer.html">Add New Customer</a>
    <br>
    <a href="index.html">Home</a>
</body>
</html>