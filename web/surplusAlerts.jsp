<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Subscribe to Surplus Food Alerts</title>
    <link rel="stylesheet" href="stylesRegistration.css"/>
</head>
<body>
    <h1>Subscribe to Surplus Food Alerts</h1>
    <form action="SubscribeServlet" method="post">
        <label for="location">Your Location:</label><br>
        <input type="text" id="location" name="location" required><br><br>

        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="phone">Phone (optional):</label><br>
        <input type="text" id="phone" name="phone"><br><br>

        <label for="preferences">Food Preferences:</label><br>
        <input type="text" id="preferences" name="preferences" placeholder="e.g., Vegetables, Fruits" required><br><br>

        <input type="submit" value="Subscribe">
    </form>
</body>
</html>
