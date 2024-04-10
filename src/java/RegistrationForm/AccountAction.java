package RegistrationForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "AccountAction", urlPatterns = {"/AccountAction"})
public class AccountAction extends HttpServlet {

    private String dbURL = "jdbc:mysql://localhost:3306/FoodWasteReduction"; 
    private String dbUser = "root";
    private String dbPassword = "grov0086@algonquinlive.com";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            // Ensuring the JDBC driver is loaded
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("registrationError.html");
            return; 
        }

        if ("Register".equals(action)) {
            createAccount(request, response);
        } else if ("Login".equals(action)) {
            // Handle login
            login(request, response);
        }
    }

    private void createAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password"); 
        String userType = request.getParameter("userType");

        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
            String sql = "INSERT INTO Users (Name, Email, Password, UserType) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, password);
                stmt.setString(4, userType);
                stmt.executeUpdate();
            }
            redirectUserByType(userType, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("registrationError.html");
        }
    }

 private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
        String sql = "SELECT UserID, UserType FROM Users WHERE Email = ? AND Password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int userID = rs.getInt("UserID");
                String userType = rs.getString("UserType");

                // Store UserID in session as userID
                request.getSession().setAttribute("userID", userID); // Changed from retailerID to userID

                redirectUserByType(userType, response);
            } else {
                response.sendRedirect("loginError.html");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        response.sendRedirect("registrationError.html");
    }
}



    private void redirectUserByType(String userType, HttpServletResponse response) throws IOException {
        switch (userType) {
            case "retailer":
                response.sendRedirect("retailerDashboard.html");
                break;
            case "consumer":
                response.sendRedirect("consumerDashboard.jsp");
                break;
            case "charity":
                response.sendRedirect("charityDashboard.jsp");
                break;
            default:
                response.sendRedirect("loginError.html");
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
