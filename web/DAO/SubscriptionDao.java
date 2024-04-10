package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriptionDao {
    private Connection connection;

    public SubscriptionDao(Connection connection) {
        this.connection = connection;
    }

    // Create a new subscription
    public boolean createSubscription(Subscription subscription) {
        String sql = "INSERT INTO Subscriptions (UserID) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, subscription.getUserId());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read a subscription by ID
    public Subscription getSubscriptionById(int subscriptionId) {
        String sql = "SELECT * FROM Subscriptions WHERE SubscriptionID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, subscriptionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Subscription subscription = new Subscription();
                subscription.setSubscriptionId(resultSet.getInt("SubscriptionID"));
                subscription.setUserId(resultSet.getInt("UserID"));
                return subscription;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    // Delete a subscription
    public boolean deleteSubscription(int subscriptionId) {
        String sql = "DELETE FROM Subscriptions WHERE SubscriptionID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, subscriptionId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Optionally, list all subscriptions or subscriptions by a specific user
}

