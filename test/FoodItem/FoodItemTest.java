/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FoodItem;

import java.sql.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Tamana Kaushal
 */
public class FoodItemTest {
    
    public FoodItemTest() {
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
     * Test of getFoodItemId method, of class FoodItem.
     */
    @Test
    public void testGetFoodItemId() {
        System.out.println("getFoodItemId");
        FoodItem instance = new FoodItem();
        int expResult = 0;
        int result = instance.getFoodItemId();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of getRetailerId method, of class FoodItem.
     */
    @Test
    public void testGetRetailerId() {
        System.out.println("getRetailerId");
        FoodItem instance = new FoodItem();
        int expResult = 0;
        int result = instance.getRetailerId();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getName method, of class FoodItem.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        FoodItem instance = new FoodItem();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getQuantity method, of class FoodItem.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        FoodItem instance = new FoodItem();
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getExpirationDate method, of class FoodItem.
     */
    @Test
    public void testGetExpirationDate() {
        System.out.println("getExpirationDate");
        FoodItem instance = new FoodItem();
        Date expResult = null;
        Date result = instance.getExpirationDate();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getStatus method, of class FoodItem.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        FoodItem instance = new FoodItem();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFoodItemId method, of class FoodItem.
     */
    @Test
    public void testSetFoodItemId() {
        System.out.println("setFoodItemId");
        int foodItemId = 0;
        FoodItem instance = new FoodItem();
        instance.setFoodItemId(foodItemId);
      
    }

    /**
     * Test of setRetailerId method, of class FoodItem.
     */
    @Test
    public void testSetRetailerId() {
        System.out.println("setRetailerId");
        int retailerId = 0;
        FoodItem instance = new FoodItem();
        instance.setRetailerId(retailerId);
       
    }

    /**
     * Test of setName method, of class FoodItem.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        FoodItem instance = new FoodItem();
        instance.setName(name);
     
    }

    /**
     * Test of setQuantity method, of class FoodItem.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        FoodItem instance = new FoodItem();
        instance.setQuantity(quantity);
     
    }

    /**
     * Test of setExpirationDate method, of class FoodItem.
     */
    @Test
    public void testSetExpirationDate() {
        System.out.println("setExpirationDate");
        Date expirationDate = null;
        FoodItem instance = new FoodItem();
        instance.setExpirationDate(expirationDate);
       
    }

    /**
     * Test of setStatus method, of class FoodItem.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        FoodItem instance = new FoodItem();
        instance.setStatus(status);
       
    }
    
}