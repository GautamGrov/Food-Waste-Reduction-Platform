<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.FoodItem" %>
<html>
<head>
    <title>View Inventory</title>
    <link rel="stylesheet" href="InventoryStyles.css"/>
</head>
<body>
<h2>Inventory List</h2>

<table>
    <tr>
        <th>Item Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Expiration Date</th>
        <th>Status</th>
    </tr>
    <% 
    List<FoodItem> inventoryList = (List<FoodItem>) request.getAttribute("inventoryList");
    for (FoodItem item : inventoryList) {
    %>
    <tr>
        <td><%= item.getName() %></td>
        <td><%= item.getQuantity() %></td>
        <td><%= item.getPrice().toString() %></td>
        <td><%= item.getExpirationDate().toString() %></td>
        <td><%= item.getStatus() %></td>
    </tr>
    <% } %>
</table>
<a href="login.html">Logout</a> 
</body>
</html>
