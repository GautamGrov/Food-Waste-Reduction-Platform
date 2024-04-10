import DAO.FoodItem;
import DAO.FoodItemDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/FilterFoodItemsServlet"})
public class FilterFoodItemsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FoodWasteReduction", "root", "grov0086@algonquinlive.com");
            FoodItemDao foodItemDao = new FoodItemDao(connection);
            List<FoodItem> filteredItems = foodItemDao.getItemsByStatus(status);
            request.setAttribute("filteredItems", filteredItems);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Consumer.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilterFoodItemsServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
