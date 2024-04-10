import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/UpdateFoodItemServlet")
public class UpdateFoodItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int foodItemID = Integer.parseInt(request.getParameter("foodItemID"));
        int newQuantity = Integer.parseInt(request.getParameter("quantity"));
        String newExpirationDate = request.getParameter("expirationDate");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FoodWasteReduction", "username", "password"); // Update with your database credentials

            String query = "UPDATE FoodItems SET Quantity = ?, ExpirationDate = ? WHERE FoodItemID = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, newQuantity);
            pst.setDate(2, java.sql.Date.valueOf(newExpirationDate));
            pst.setInt(3, foodItemID);
            
            pst.executeUpdate();
            response.sendRedirect("updateFoodItemSuccess.html"); // Redirect to a success page
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("updateFoodItemError.html"); // Redirect to an error page
        }
    }
}
