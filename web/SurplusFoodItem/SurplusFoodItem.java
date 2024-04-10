package SurplusFoodItem;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SurplusFoodItem {
    private int surplusItemId;
    private int foodItemId;
    private Timestamp listingDate;
    private BigDecimal salePrice;
    private boolean isDonation;

    // Constructors, getters, and setters

    public SurplusFoodItem() {
    }

    // Getters and setters for all properties
    public int getSurplusItemId() {
        return surplusItemId;
    }

    public void setSurplusItemId(int surplusItemId) {
        this.surplusItemId = surplusItemId;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public Timestamp getListingDate() {
        return listingDate;
    }

    public void setListingDate(Timestamp listingDate) {
        this.listingDate = listingDate;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isDonation() {
        return isDonation;
    }

    public void setDonation(boolean donation) {
        isDonation = donation;
    }
}

