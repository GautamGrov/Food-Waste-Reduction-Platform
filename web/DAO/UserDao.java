package DAO;

import java.sql.*;

public class UserDao {
    private final Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    // Create a new user
    public int createUser(User user) {
        int userId = -1; // Default to -1 to indicate failure
        String sql = "INSERT INTO Users (Name, Email, Password, UserType) VALUES (?, ?, ?, ?)";

        try (Connection connection = this.connection; // Assuming 'this.connection' is already established
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword()); // Ensure this is hashed
            statement.setString(4, user.getUserType());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                // Retrieve the generated key (UserID)
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        userId = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userId; // Return the generated UserID or -1 if insertion failed
    }


    // Fetch a user by ID
    public User getUserById(int userId) {
        String sql = "SELECT * FROM Users WHERE UserID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("UserID"));
                user.setName(resultSet.getString("Name"));
                user.setEmail(resultSet.getString("Email"));
                user.setPassword(resultSet.getString("Password"));
                user.setUserType(resultSet.getString("UserType"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update a user's information
    public boolean updateUser(int userId, String name, String email, String password, String userType) {
        String sql = "UPDATE Users SET Name = ?, Email = ?, Password = ?, UserType = ? WHERE UserID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, userType);
            statement.setInt(5, userId);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a user
    public boolean deleteUser(int userId) {
        String sql = "DELETE FROM Users WHERE UserID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}

