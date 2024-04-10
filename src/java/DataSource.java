import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
    private static Connection connection = null;
    private static final String SERVER_URL = "jdbc:mysql://localhost:3306/FoodWasteReduction";
    private static final String USER = "root";
    private static final String PASSWORD = "grov0086@algonquinlive.com";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    // Private constructor to prevent instantiation
    private DataSource() {}

    public static Connection getConnection() throws IOException {
        if (connection != null) {
            return connection;
        }
        
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(SERVER_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new IOException("Failed to obtain database connection", e);
        }
        
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection = null;
            }
        }
    }
}