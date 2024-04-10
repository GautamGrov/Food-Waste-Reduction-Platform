/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

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
public class AlertTest {
    
    public AlertTest() {
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
     * Test of getAlertId method, of class Alert.
     */
    @Test
    public void testGetAlertId() {
        System.out.println("getAlertId");
        Alert instance = new Alert();
        int expResult = 0;
        int result = instance.getAlertId();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of setAlertId method, of class Alert.
     */
    @Test
    public void testSetAlertId() {
        System.out.println("setAlertId");
        int alertId = 0;
        Alert instance = new Alert();
        instance.setAlertId(alertId);
       
    }

    /**
     * Test of getSubscriptionId method, of class Alert.
     */
    @Test
    public void testGetSubscriptionId() {
        System.out.println("getSubscriptionId");
        Alert instance = new Alert();
        int expResult = 0;
        int result = instance.getSubscriptionId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setSubscriptionId method, of class Alert.
     */
    @Test
    public void testSetSubscriptionId() {
        System.out.println("setSubscriptionId");
        int subscriptionId = 0;
        Alert instance = new Alert();
        instance.setSubscriptionId(subscriptionId);
    
    }

    /**
     * Test of getSurplusItemId method, of class Alert.
     */
    @Test
    public void testGetSurplusItemId() {
        System.out.println("getSurplusItemId");
        Alert instance = new Alert();
        int expResult = 0;
        int result = instance.getSurplusItemId();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setSurplusItemId method, of class Alert.
     */
    @Test
    public void testSetSurplusItemId() {
        System.out.println("setSurplusItemId");
        int surplusItemId = 0;
        Alert instance = new Alert();
        instance.setSurplusItemId(surplusItemId);
       
  
    }

    /**
     * Test of getAlertDate method, of class Alert.
     */
    @Test
    public void testGetAlertDate() {
        System.out.println("getAlertDate");
        Alert instance = new Alert();
        Timestamp expResult = null;
        Timestamp result = instance.getAlertDate();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setAlertDate method, of class Alert.
     */
    @Test
    public void testSetAlertDate() {
        System.out.println("setAlertDate");
        Timestamp alertDate = null;
        Alert instance = new Alert();
        instance.setAlertDate(alertDate);
       
    }

    /**
     * Test of getStatus method, of class Alert.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Alert instance = new Alert();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setStatus method, of class Alert.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        Alert instance = new Alert();
        instance.setStatus(status);
     
    }
    
}