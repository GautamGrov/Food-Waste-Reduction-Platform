

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

@WebServlet("/CharityView")
public class CharityViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dbURL = "jdbc:mysql://localhost:3306/FoodWasteReduction"; 
        String dbUser = "root";
        String dbPassword = "grov0086@algonquinlive.com";

        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
            FoodItemDao dao = new FoodItemDao(conn);
            List<FoodItem> donationItems = dao.getDonationItems();
            request.setAttribute("donationItems", donationItems);
            request.getRequestDispatcher("/charityView.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("errorPage.jsp");
        }
    }
}
