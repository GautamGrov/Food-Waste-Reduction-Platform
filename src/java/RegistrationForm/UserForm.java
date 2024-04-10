package RegistrationForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserForm")
public class UserForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Create Your Account</title>");
            // Reference the external CSS file here
            out.println("<link rel='stylesheet' type='text/css' href='stylesRegistration.css'>");
            out.println("</head><body>");
            out.println("<h1>Register for a New Account</h1>");
            out.println("<form action='AccountAction' method='POST'>");
            out.println("Name: <input type='text' name='name' required><br>");
            out.println("Email: <input type='email' name='email' required><br>");
            out.println("Password: <input type='password' name='password' required><br>");
            out.println("User Type: <select name='userType' required>");
            out.println("<option value='retailer'>Retailer</option>");
            out.println("<option value='consumer'>Consumer</option>");
            out.println("<option value='charity'>Charitable Organization</option>");
            out.println("</select><br>");
            out.println("<input type='submit' name='action' value='Register'>");
            out.println("</form>");
            out.println("<p>Already have an account? <a href='login.html'>Login here</a>.</p>");
            out.println("</body></html>");
        }
    }

    // Post method will simply redirect to Get method to display the form
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
