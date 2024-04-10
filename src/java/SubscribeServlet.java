import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SubscribeServlet")
public class SubscribeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Example of processing form data
        String location = request.getParameter("location");
        String email = request.getParameter("email");
        response.sendRedirect("thankyou.jsp"); 
    }
}
