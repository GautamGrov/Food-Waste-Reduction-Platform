import DAO.FoodItem;
import DAO.FoodItemDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ClaimItemServlet")
public class ClaimItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Database connection details
        String dbURL = "jdbc:mysql://localhost:3306/FoodWasteReduction"; 
        String dbUser = "root";
        String dbPassword = "grov0086@algonquinlive.com";
        
        // Retrieve parameters from the request
        int foodItemId = Integer.parseInt(request.getParameter("foodItemId"));
        int claimedQuantity = Integer.parseInt(request.getParameter("claimedQuantity"));
        
        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
            conn.setAutoCommit(false); // Start transaction
            
            // Initialize FoodItemDao
            FoodItemDao foodItemDao = new FoodItemDao(conn);
            
            // Get the food item to claim
            FoodItem foodItem = foodItemDao.getFoodItemById(foodItemId);
            
            // Ensure the claimed quantity does not exceed available quantity
            if (foodItem != null && foodItem.getQuantity() >= claimedQuantity) {
                // Update the quantity of the food item
                foodItem.setQuantity(foodItem.getQuantity() - claimedQuantity);
                boolean updateSuccess = foodItemDao.updateFoodItem(foodItem);
                
                // If update is successful, add entry to Claims table
                if (updateSuccess) {
                    // Insert a new record into the Claims table
                    try (PreparedStatement pstmt = conn.prepareStatement(
                            "INSERT INTO Claims (FoodItemID, QuantityClaimed) VALUES (?, ?)")) {
                        pstmt.setInt(1, foodItemId);
                        pstmt.setInt(2, claimedQuantity);
                        pstmt.executeUpdate();
                    }
                    
                    // Commit transaction
                    conn.commit();
                    response.sendRedirect("charityDashboard.jsp"); // Redirect to success page
                    return;
                }
            }
            
            // If any error occurs, rollback transaction and redirect to error page
            conn.rollback();
            response.sendRedirect("errorPage.jsp"); 
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("errorPage.jsp"); // Redirect to error page
        }
    }
}
