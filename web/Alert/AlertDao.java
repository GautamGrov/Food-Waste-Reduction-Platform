package Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlertDao {
    private Connection connection;

    public AlertDao(Connection connection) {
        this.connection = connection;
    }

    // Create a new alert
    public boolean createAlert(Alert alert) {
        String sql = "INSERT INTO Alerts (SubscriptionID, SurplusItemID, AlertDate, Status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, alert.getSubscriptionId());
            statement.setInt(2, alert.getSurplusItemId());
            statement.setTimestamp(3, alert.getAlertDate());
            statement.setString(4, alert.getStatus());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read an alert by ID
    public Alert getAlertById(int alertId) {
        String sql = "SELECT * FROM Alerts WHERE AlertID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, alertId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Alert alert = new Alert();
                alert.setAlertId(resultSet.getInt("AlertID"));
                alert.setSubscriptionId(resultSet.getInt("SubscriptionID"));
                alert.setSurplusItemId(resultSet.getInt("SurplusItemID"));
                alert.setAlertDate(resultSet.getTimestamp("AlertDate"));
                alert.setStatus(resultSet.getString("Status"));
                return alert;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update an alert
    public boolean updateAlert(Alert alert) {
        String sql = "UPDATE Alerts SET SubscriptionID = ?, SurplusItemID = ?, AlertDate = ?, Status = ? WHERE AlertID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, alert.getSubscriptionId());
            statement.setInt(2, alert.getSurplusItemId());
            statement.setTimestamp(3, alert.getAlertDate());
            statement.setString(4, alert.getStatus());
            statement.setInt(5, alert.getAlertId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete an alert
    public boolean deleteAlert(int alertId) {
        String sql = "DELETE FROM Alerts WHERE AlertID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, alertId);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Optionally, add methods to list alerts by subscription, status, etc.
}

