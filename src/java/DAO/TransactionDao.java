package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {
    private Connection connection;

    public TransactionDao(Connection connection) {
        this.connection = connection;
    }

    // Create a new transaction
    public boolean createTransaction(Transaction transaction) {
        String sql = "INSERT INTO Transactions (SurplusItemID, UserID, TransactionDate, QuantityClaimed) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, transaction.getSurplusItemId());
            statement.setInt(2, transaction.getUserId());
            statement.setTimestamp(3, transaction.getTransactionDate());
            statement.setInt(4, transaction.getQuantityClaimed());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read a transaction by ID
    public Transaction getTransactionById(int transactionId) {
        String sql = "SELECT * FROM Transactions WHERE TransactionID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, transactionId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(resultSet.getInt("TransactionID"));
                transaction.setSurplusItemId(resultSet.getInt("SurplusItemID"));
                transaction.setUserId(resultSet.getInt("UserID"));
                transaction.setTransactionDate(resultSet.getTimestamp("TransactionDate"));
                transaction.setQuantityClaimed(resultSet.getInt("QuantityClaimed"));
                return transaction;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update a transaction
    public boolean updateTransaction(Transaction transaction) {
        String sql = "UPDATE Transactions SET SurplusItemID = ?, UserID = ?, TransactionDate = ?, QuantityClaimed = ? WHERE TransactionID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, transaction.getSurplusItemId());
            statement.setInt(2, transaction.getUserId());
            statement.setTimestamp(3, transaction.getTransactionDate());
            statement.setInt(4, transaction.getQuantityClaimed());
            statement.setInt(5, transaction.getTransactionId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a transaction
    public boolean deleteTransaction(int transactionId) {
        String sql = "DELETE FROM Transactions WHERE TransactionID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, transactionId);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Optionally, list all transactions or transactions by a specific user or item
}

