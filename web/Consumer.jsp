<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.FoodItem" %>
<html>
<head>
    <title>Filtered Food Items</title>
    <link rel="stylesheet" type="text/css" href="Claim.css">
</head>
<body>
<h2>Filtered Food Items</h2>
<table>
    <tr>
        <th>Item Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Expiration Date</th>
        <th>Status</th>
        <th>Action</th> <!-- Added column for the claim action -->
    </tr>
    <% 
    List<FoodItem> filteredItems = (List<FoodItem>) request.getAttribute("filteredItems");
    for (FoodItem item : filteredItems) {
    %>
    <tr>
        <td><%= item.getName() %></td>
        <td><%= item.getQuantity() %></td>
        <td><%= item.getPrice().toString() %></td>
        <td><%= item.getExpirationDate().toString() %></td>
        <td><%= item.getStatus() %></td>
        <td>
            
            <form action="ClaimItemServlet" method="post">
           
            <input type="hidden" name="foodItemId" value="1"> 
            <input type="submit" value="Claim">
             </form>

        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
