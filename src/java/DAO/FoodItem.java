package DAO;

import java.math.BigDecimal;
import java.sql.Date;

public class FoodItem {
    private int foodItemId;
    private int retailerId;
    private String name;
    private int quantity;
    private Date expirationDate;
    private String status;
    private BigDecimal price;

    // Getters and setters
    public int getFoodItemId() { return foodItemId; }
    public void setFoodItemId(int foodItemId) { this.foodItemId = foodItemId; }

    public int getRetailerId() { return retailerId; }
    public void setRetailerId(int retailerId) { this.retailerId = retailerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Date getExpirationDate() { return expirationDate; }
    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
