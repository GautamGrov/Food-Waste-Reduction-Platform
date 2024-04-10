package RegistrationForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/UserForm"})
public class UserForm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Create or Login to Your Account</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Create or Login to Your Account</h1>");
            out.println("<form action='AccountAction' method='POST'>");
            out.println("Name: <input type='text' name='name' required><br>");
            out.println("Email: <input type='email' name='email' required><br>");
            out.println("Password: <input type='password' name='password' required><br>");
            out.println("User Type: <select name='userType' required>");
            out.println("<option value='retailer'>Retailer</option>");
            out.println("<option value='consumer'>Consumer</option>");
            out.println("<option value='charity'>Charitable Organization</option>");
            out.println("</select><br>");
            out.println("<input type='submit' name='action' value='Create Account'>");
            out.println("<input type='submit' name='action' value='Login'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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

    @Override
    public String getServletInfo() {
        return "User Registration and Login Form Servlet";
    }
}
