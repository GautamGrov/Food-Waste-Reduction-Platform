import DAO.FoodItem;
import DAO.FoodItemDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewInventory")
public class ViewInventoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Database connection details
        String dbURL = "jdbc:mysql://localhost:3306/FoodWasteReduction"; 
        String dbUser = "root";
        String dbPassword = "grov0086@algonquinlive.com"; // Update your password here
        Integer retailerID = (Integer) request.getSession().getAttribute("userID"); // Assuming you store the retailer's ID as "userID" in the session

        if (retailerID == null) {
            // Handle case where there's no retailer ID in session, e.g., redirect to login
            response.sendRedirect("login.html"); // Adjust this as needed
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
                FoodItemDao foodItemDao = new FoodItemDao(conn);
                // Assuming getItemsByRetailer method has been implemented to fetch items based on retailerID
                List<FoodItem> inventoryList = foodItemDao.getItemsByRetailer(retailerID);
                
                request.setAttribute("inventoryList", inventoryList);
                request.getRequestDispatcher("/viewInventory.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("errorPage.jsp"); // Make sure you have an error.html page or adjust this as needed
        }
    }
}
