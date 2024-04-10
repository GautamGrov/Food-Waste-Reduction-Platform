package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.tomcat.jdbc.pool.DataSource;

public class FoodItemDao {
    private final Connection connection;
    

    public FoodItemDao(Connection connection) {
        this.connection = connection;
    }
    

    // Create a new food item
 public boolean createFoodItem(FoodItem foodItem) {
        String sql = "INSERT INTO FoodItems (RetailerID, Name, Quantity, ExpirationDate, Status, Price) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, foodItem.getRetailerId());
            statement.setString(2, foodItem.getName());
            statement.setInt(3, foodItem.getQuantity());
            statement.setDate(4, foodItem.getExpirationDate());
            statement.setString(5, foodItem.getStatus());
            statement.setBigDecimal(6, foodItem.getPrice());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean claimFoodItem(int foodItemId) {
        String sql = "UPDATE FoodItems SET status = 'claimed' WHERE food_item_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, foodItemId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
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
    
    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> foodItemList = new ArrayList<>();
        String sql = "SELECT * FROM FoodItems"; // Adjust this query as needed, e.g., to filter by RetailerID

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                FoodItem foodItem = new FoodItem();
                foodItem.setFoodItemId(resultSet.getInt("FoodItemID"));
                foodItem.setRetailerId(resultSet.getInt("RetailerID"));
                foodItem.setName(resultSet.getString("Name"));
                foodItem.setQuantity(resultSet.getInt("Quantity"));
                foodItem.setExpirationDate(resultSet.getDate("ExpirationDate"));
                foodItem.setStatus(resultSet.getString("Status"));
                foodItem.setPrice(resultSet.getBigDecimal("Price")); // Assuming FoodItem class has a price field and setter
                
                foodItemList.add(foodItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodItemList;
    }
    
    public List<FoodItem> getItemsByRetailer(int retailerID) {
    List<FoodItem> items = new ArrayList<>();
    String sql = "SELECT * FROM FoodItems WHERE RetailerID = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, retailerID);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            FoodItem item = new FoodItem();
            // Assuming you have setters in FoodItem class to set properties from ResultSet
            item.setFoodItemId(resultSet.getInt("FoodItemID"));
            item.setRetailerId(resultSet.getInt("RetailerID"));
            item.setName(resultSet.getString("Name"));
            item.setQuantity(resultSet.getInt("Quantity"));
            item.setExpirationDate(resultSet.getDate("ExpirationDate"));
            item.setStatus(resultSet.getString("Status"));
            item.setPrice(resultSet.getBigDecimal("Price")); // Make sure you have this setter if you're using price
            items.add(item);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return items;
}

    public boolean updateItemStatus(int itemId, String status) {
    String sql = "UPDATE FoodItems SET Status = ? WHERE FoodItemID = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, status);
        statement.setInt(2, itemId);
        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
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
    
  public List<FoodItem> getDonationItems() throws Exception {
        List<FoodItem> items = new ArrayList<>();
        String sql = "SELECT * FROM FoodItems WHERE Status = 'donated'";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                FoodItem item = new FoodItem();
                item.setFoodItemId(resultSet.getInt("FoodItemID"));
                item.setRetailerId(resultSet.getInt("RetailerID"));
                item.setName(resultSet.getString("Name"));
                item.setQuantity(resultSet.getInt("Quantity"));
                item.setExpirationDate(resultSet.getDate("ExpirationDate"));
                item.setStatus(resultSet.getString("Status"));
                item.setPrice(resultSet.getBigDecimal("Price"));
                items.add(item);
            }
        }
        return items;
    }
    
   public List<FoodItem> getItemsByStatus(String status) throws SQLException {
        List<FoodItem> items = new ArrayList<>();
        String sql = "SELECT * FROM FoodItems WHERE Status = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, status);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FoodItem item = new FoodItem();
                item.setFoodItemId(resultSet.getInt("FoodItemID"));
                item.setRetailerId(resultSet.getInt("RetailerID"));
                item.setName(resultSet.getString("Name"));
                item.setQuantity(resultSet.getInt("Quantity"));
                item.setExpirationDate(resultSet.getDate("ExpirationDate"));
                item.setStatus(resultSet.getString("Status"));
                item.setPrice(resultSet.getBigDecimal("Price"));
                items.add(item);
            }
        }
        return items;
    }

}

