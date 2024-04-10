/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package SurplusFoodItem;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class SurplusFoodItemTest {
    
    public SurplusFoodItemTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getSurplusItemId method, of class SurplusFoodItem.
     */
    @Test
    public void testGetSurplusItemId() {
        System.out.println("getSurplusItemId");
        SurplusFoodItem instance = new SurplusFoodItem();
        int expResult = 0;
        int result = instance.getSurplusItemId();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of setSurplusItemId method, of class SurplusFoodItem.
     */
    @Test
    public void testSetSurplusItemId() {
        System.out.println("setSurplusItemId");
        int surplusItemId = 0;
        SurplusFoodItem instance = new SurplusFoodItem();
        instance.setSurplusItemId(surplusItemId);
      
    }

    /**
     * Test of getFoodItemId method, of class SurplusFoodItem.
     */
    @Test
    public void testGetFoodItemId() {
        System.out.println("getFoodItemId");
        SurplusFoodItem instance = new SurplusFoodItem();
        int expResult = 0;
        int result = instance.getFoodItemId();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setFoodItemId method, of class SurplusFoodItem.
     */
    @Test
    public void testSetFoodItemId() {
        System.out.println("setFoodItemId");
        int foodItemId = 0;
        SurplusFoodItem instance = new SurplusFoodItem();
        instance.setFoodItemId(foodItemId);
      
    }

    /**
     * Test of getListingDate method, of class SurplusFoodItem.
     */
    @Test
    public void testGetListingDate() {
        System.out.println("getListingDate");
        SurplusFoodItem instance = new SurplusFoodItem();
        Timestamp expResult = null;
        Timestamp result = instance.getListingDate();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setListingDate method, of class SurplusFoodItem.
     */
    @Test
    public void testSetListingDate() {
        System.out.println("setListingDate");
        Timestamp listingDate = null;
        SurplusFoodItem instance = new SurplusFoodItem();
        instance.setListingDate(listingDate);
    
    }

    /**
     * Test of getSalePrice method, of class SurplusFoodItem.
     */
    @Test
    public void testGetSalePrice() {
        System.out.println("getSalePrice");
        SurplusFoodItem instance = new SurplusFoodItem();
        BigDecimal expResult = null;
        BigDecimal result = instance.getSalePrice();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setSalePrice method, of class SurplusFoodItem.
     */
    @Test
    public void testSetSalePrice() {
        System.out.println("setSalePrice");
        BigDecimal salePrice = null;
        SurplusFoodItem instance = new SurplusFoodItem();
        instance.setSalePrice(salePrice);
      
    }

    /**
     * Test of isDonation method, of class SurplusFoodItem.
     */
    @Test
    public void testIsDonation() {
        System.out.println("isDonation");
        SurplusFoodItem instance = new SurplusFoodItem();
        boolean expResult = false;
        boolean result = instance.isDonation();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setDonation method, of class SurplusFoodItem.
     */
    @Test
    public void testSetDonation() {
        System.out.println("setDonation");
        boolean donation = false;
        SurplusFoodItem instance = new SurplusFoodItem();
        instance.setDonation(donation);
       
    }
    
}