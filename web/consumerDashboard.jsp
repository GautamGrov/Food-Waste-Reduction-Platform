<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Consumer Dashboard</title>
    <link rel="stylesheet" href="ConsumerStyles.css"/>
</head>
<body>
    <h2>Welcome to Your Consumer Dashboard!</h2>
    <p>Browse available surplus food items, subscribe to alerts, and more.</p>
    <a href="FilterFoodItemsServlet?status=discounted"><button>View Discounted Food Items</button></a>
    <a href="FilterFoodItemsServlet?status=available"><button>View Available Food Items</button></a>
    <a href="surplusAlerts.jsp">SURPLUS ALERTS</a>
    <a href="login.html">Logout</a> 

    <!-- Displayed Food Items -->
    <div class="food-items">
        <ul>
            
            <c:forEach var="item" items="${filteredItems}">
                <li>
                    <strong>${item.name}</strong> - ${item.quantity} - ${item.expirationDate}
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
