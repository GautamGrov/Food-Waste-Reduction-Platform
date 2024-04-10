<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Charity Dashboard</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 20px;
            background: linear-gradient(to right, #6db9ef, #7ce08a); /* Adding a gradient background */
            color: #333; /* Ensuring text is readable on the new background */
        }
        h2 {
            text-align: center; /* Center aligning the header */
            color: #fff; /* White color for better visibility on gradient background */
        }
        p {
            text-align: center; /* Center aligning the paragraph */
            font-size: 18px; /* Slightly larger font size for readability */
            color: #fefefe; /* Light color for readability */
            max-width: 600px; /* Restricting max width for better readability */
            margin: 20px auto; /* Centering the paragraph */
        }
        form {
            display: flex;
            justify-content: center; /* Centering the form */
            margin-top: 30px;
        }
        button {
            background-color: #4CAF50; /* Green */
            color: white;
            padding: 15px 30px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: auto; /* Adjust width to fit content */
            font-size: 18px; /* Making the button text slightly larger */
            border-radius: 5px; /* Rounded corners for the button */
            box-shadow: 0 4px 14px 0 rgba(0,0,0,0.1); /* Adding a subtle shadow to the button */
            transition: all 1s ease; /* Smooth transition for hover effects */
        }
        button:hover {
            background-color: #45a049; /* Darker shade of green on hover */
            transform: translateY(-2px); /* Slight raise effect on hover */
            box-shadow: 0 6px 16px 0 rgba(0,0,0,0.2); /* Enhancing shadow on hover for a "lifted" effect */
        }
        button:active {
            transform: translateY(1px); /* Subtle press effect */
            box-shadow: 0 3px 12px 0 rgba(0,0,0,0.1); /* Softening shadow on press */
        }
    </style>
</head>
<body>
    <h2>Welcome to Your Charity Dashboard!</h2>
    <p>Here you can claim surplus food items, manage your profile, and view donation reports.</p>
    <!-- Form to Submit to Charity View Page -->
    <form action="CharityView" method="get">
        <button type="submit">View Donation Items</button>
    </form>
</body>
</html>
