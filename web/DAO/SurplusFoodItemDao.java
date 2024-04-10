package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SurplusFoodItemDao {
    private Connection connection;

    public SurplusFoodItemDao(Connection connection) {
        this.connection = connection;
    }

    // Method to insert a new surplus food item
    public boolean createSurplusFoodItem(SurplusFoodItem surplusFoodItem) {
        String sql = "INSERT INTO SurplusFoodItems (FoodItemID, ListingDate, SalePrice, IsDonation) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, surplusFoodItem.getFoodItemId());
            statement.setTimestamp(2, surplusFoodItem.getListingDate());
            if (surplusFoodItem.getSalePrice() != null) {
                statement.setBigDecimal(3, surplusFoodItem.getSalePrice());
            } else {
                statement.setNull(3, java.sql.Types.DECIMAL);
            }
            statement.setBoolean(4, surplusFoodItem.isDonation());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to get a surplus food item by ID
    public SurplusFoodItem getSurplusFoodItemById(int surplusItemId) {
        String sql = "SELECT * FROM SurplusFoodItems WHERE SurplusItemID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, surplusItemId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                SurplusFoodItem item = new SurplusFoodItem();
                item.setSurplusItemId(resultSet.getInt("SurplusItemID"));
                item.setFoodItemId(resultSet.getInt("FoodItemID"));
                item.setListingDate(resultSet.getTimestamp("ListingDate"));
                item.setSalePrice(resultSet.getBigDecimal("SalePrice"));
                item.setDonation(resultSet.getBoolean("IsDonation"));
                return item;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateSurplusFoodItem(SurplusFoodItem surplusFoodItem) {
        String sql = "UPDATE SurplusFoodItems SET FoodItemID = ?, ListingDate = ?, SalePrice = ?, IsDonation = ? WHERE SurplusItemID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, surplusFoodItem.getFoodItemId());
            statement.setTimestamp(2, surplusFoodItem.getListingDate());
            statement.setBigDecimal(3, surplusFoodItem.getSalePrice());
            statement.setBoolean(4, surplusFoodItem.isDonation());
            statement.setInt(5, surplusFoodItem.getSurplusItemId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a surplus food item
    public boolean deleteSurplusFoodItem(int surplusItemId) {
        String sql = "DELETE FROM SurplusFoodItems WHERE SurplusItemID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, surplusItemId);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // List all surplus food items (optional)
    public List<SurplusFoodItem> getAllSurplusFoodItems() {
        List<SurplusFoodItem> surplusFoodItems = new ArrayList<>();
        String sql = "SELECT * FROM SurplusFoodItems";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                SurplusFoodItem item = new SurplusFoodItem();
                item.setSurplusItemId(resultSet.getInt("SurplusItemID"));
                item.setFoodItemId(resultSet.getInt("FoodItemID"));
                item.setListingDate(resultSet.getTimestamp("ListingDate"));
                item.setSalePrice(resultSet.getBigDecimal("SalePrice"));
                item.setDonation(resultSet.getBoolean("IsDonation"));
                surplusFoodItems.add(item);
            }
            return surplusFoodItems;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return surplusFoodItems;
    }
}

