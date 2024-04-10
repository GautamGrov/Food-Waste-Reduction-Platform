package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodItemDao {
    private final Connection connection;

    public FoodItemDao(Connection connection) {
        this.connection = connection;
    }

    // Create a new food item
    public boolean createFoodItem(FoodItem foodItem) {
        String sql = "INSERT INTO FoodItems (RetailerID, Name, Quantity, ExpirationDate, Status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, foodItem.getRetailerId());
            statement.setString(2, foodItem.getName());
            statement.setInt(3, foodItem.getQuantity());
            statement.setDate(4, foodItem.getExpirationDate());
            statement.setString(5, foodItem.getStatus());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get a food item by ID
    public FoodItem getFoodItemById(int foodItemId) {
        String sql = "SELECT * FROM FoodItems WHERE FoodItemID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, foodItemId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                FoodItem foodItem = new FoodItem();
                foodItem.setFoodItemId(resultSet.getInt("FoodItemID"));
                foodItem.setRetailerId(resultSet.getInt("RetailerID"));
                foodItem.setName(resultSet.getString("Name"));
                foodItem.setQuantity(resultSet.getInt("Quantity"));
                foodItem.setExpirationDate(resultSet.getDate("ExpirationDate"));
                foodItem.setStatus(resultSet.getString("Status"));
                return foodItem;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update a food item
    public boolean updateFoodItem(FoodItem foodItem) {
        String sql = "UPDATE FoodItems SET Name = ?, Quantity = ?, ExpirationDate = ?, Status = ? WHERE FoodItemID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, foodItem.getName());
            statement.setInt(2, foodItem.getQuantity());
            statement.setDate(3, foodItem.getExpirationDate());
            statement.setString(4, foodItem.getStatus());
            statement.setInt(5, foodItem.getFoodItemId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a food item
    public boolean deleteFoodItem(int foodItemId) {
        String sql = "DELETE FROM FoodItems WHERE FoodItemID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, foodItemId);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Optionally, add a method to list all food items or food items by retailer
}

