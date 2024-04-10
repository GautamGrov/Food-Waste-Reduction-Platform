<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
    <link rel="stylesheet" type="text/css" href="style.css"> 
    <style>
        body {
    font-family: Arial, sans-serif;
}

.confirmation-container {
    margin: 20px;
    padding: 20px;
    border: 1px solid #ddd;
    border-radius: 5px;
    background-color: #f9f9f9;
}

a {
    display: inline-block;
    margin-top: 20px;
    padding: 10px;
    background-color: #007bff;
    color: #ffffff;
    text-decoration: none;
    border-radius: 5px;
}

    </style>
</head>
<body>

<%
    // Retrieve status and food item ID from query parameters
    String status = request.getParameter("status");
    String foodItemId = request.getParameter("foodItemId");
%>

<div class="confirmation-container">
    <h2>Confirmation</h2>
    <% if("success".equals(status)) { %>
        <!-- Display success message -->
        <p>Your claim for the food item with ID <%= foodItemId %> has been successfully processed.</p>
        <p>Thank you for using our service!</p>
    <% } else if("failed".equals(status)) { %>
        
        <p>Sorry, we could not process your claim for the food item with ID <%= foodItemId %>.</p>
        <p>Please try again later or contact support for more help.</p>
    <% } else { %>
        <!-- Fallback message for unexpected status -->
        <p>We could not determine the outcome of your request.</p>
        <p>Please check your request or contact support for assistance.</p>
    <% } %>

    <!-- Link to go back to the items page or home page -->
    <a href="Consumer.jsp">Back to Items</a> <!-- Adjust the link as necessary -->
    <a href="consumerDashboard.jsp">Home</a>
</div>

</body>
</html>
