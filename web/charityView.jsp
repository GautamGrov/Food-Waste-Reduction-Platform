<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.FoodItem" %>
<html>
<head>
    <title>Items Available for Donation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4; /* Light grey background for contrast */
        }
        h2 {
            margin-top: 15%;
            text-align: center;
            color: #333;
        }
        table {
            width: 80%;
            margin-left: auto;
            margin-right: auto; /* Center the table */
            border-collapse: collapse;
            background-color: #fff; /* White background for the table */
        }
        th, td {
            text-align: left;
            padding: 8px;
            border: 1px solid #ddd; /* Light grey border */
        }
        th {
            background-color: #4CAF50; /* Green background for headers */
            color: white;
        }
        tr:nth-child(even) {background-color: #f2f2f2;} /* Zebra striping for rows */
        input[type="submit"] {
            background-color: #4CAF50; /* Green background to match the table header */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049; /* Darker green on hover */
        }
        form {
            text-align: center; /* Centering the form submit button */
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h2>Items Available for Donation</h2>
    <form action="ClaimItemServlet" method="post">
        <table>
            <thead>
                <tr>
                    <th>Item Name</th>
                    <th>Quantity Available</th>
                    <th>Expiration Date</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% List<FoodItem> donationItems = (List<FoodItem>) request.getAttribute("donationItems");
                if (donationItems != null) {
                    for (FoodItem item : donationItems) { %>
                        <tr>
                            <td><%= item.getName() %></td>
                            <td><%= item.getQuantity() %></td>
                            <td><%= item.getExpirationDate().toString() %></td>
                            <td>
                                <input type="hidden" name="foodItemId" value="<%= item.getFoodItemId() %>" />
                                <input type="submit" value="Claim" />
                            </td>
                        </tr>
                <% 
                    }
                } %>
            </tbody>
        </table>
    </form>
</body>
</html>
