package model;

import DAO.FoodItem;
import java.util.ArrayList;
import java.util.List;

public class Retailer {
    private int id; // Retailer ID
    private String name;
    private List<FoodItem> inventory;
    private List<FoodItem> surplusItems;

    public Retailer(int id, String name) {
        this.id = id;
        this.name = name;
        this.inventory = new ArrayList<>();
        this.surplusItems = new ArrayList<>();
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FoodItem> getInventory() {
        return inventory;
    }

    public void setInventory(List<FoodItem> inventory) {
        this.inventory = inventory;
    }

    public List<FoodItem> getSurplusItems() {
        return surplusItems;
    }

    public void setSurplusItems(List<FoodItem> surplusItems) {
        this.surplusItems = surplusItems;
    }
    
    
}
