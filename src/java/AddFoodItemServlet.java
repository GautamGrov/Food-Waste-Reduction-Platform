import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;

@WebServlet("/AddFoodItemServlet")
public class AddFoodItemServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    String expirationDate = request.getParameter("expirationDate");
    String priceStr = request.getParameter("price");
    String status = request.getParameter("status");
    BigDecimal price = new BigDecimal(priceStr); // Convert string to BigDecimal for price
    Integer userIDObj = (Integer) request.getSession().getAttribute("userID"); // Using generic userID for session attribute
    
    if (userIDObj == null) {
        // Assuming userID is an int variable representing the user's ID
        HttpSession session = request.getSession();
        session.setAttribute("userID", userIDObj);

        // Handle case where userID is not set in session
        request.setAttribute("errorMessage", "User ID is not set in session.");
        request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        return;
    }
    
    int userID = userIDObj.intValue();
    
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FoodWasteReduction", "root", "grov0086@algonquinlive.com");
         PreparedStatement pst = con.prepareStatement("INSERT INTO FoodItems (RetailerID, Name, Quantity, ExpirationDate, Status, Price) VALUES (?, ?, ?, ?, ?, ?)")) {
        
        pst.setInt(1, userID);
        pst.setString(2, name);
        pst.setInt(3, quantity);
        pst.setDate(4, java.sql.Date.valueOf(expirationDate));
        pst.setString(5, status); // Since status is hardcoded as 'available', directly set it here
        pst.setBigDecimal(6, price); // Now setting the price correctly at index 6
        
        int rowsInserted = pst.executeUpdate();
        if (rowsInserted > 0) {
            // Item added successfully
            response.sendRedirect("ViewInventory");
        } else {
            // No rows were inserted, indicating an error
            request.setAttribute("errorMessage", "Failed to insert food item into the database.");
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Set error message
        request.setAttribute("errorMessage", "An SQL exception occurred: " + e.getMessage());
        // Forward to error page
        request.getRequestDispatcher("errorPage.jsp").forward(request, response);
    }
}
}