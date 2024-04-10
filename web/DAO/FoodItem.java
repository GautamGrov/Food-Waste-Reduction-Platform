package DAO;

public class FoodItem {
    private int foodItemId;
    private int retailerId;
    private String name;
    private int quantity;
    private java.sql.Date expirationDate;
    private String status;

    // Default constructor
    public FoodItem() {
    }

    // Constructor with all fields
    public FoodItem(int foodItemId, int retailerId, String name, int quantity, java.sql.Date expirationDate, String status) {
        this.foodItemId = foodItemId;
        this.retailerId = retailerId;
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.status = status;
    }

    // Getters
    public int getFoodItemId() {
        return foodItemId;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public java.sql.Date getExpirationDate() {
        return expirationDate;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setExpirationDate(java.sql.Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

