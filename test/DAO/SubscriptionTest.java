/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

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
public class SubscriptionTest {
    
    public SubscriptionTest() {
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
     * Test of getSubscriptionId method, of class Subscription.
     */
    @Test
    public void testGetSubscriptionId() {
        System.out.println("getSubscriptionId");
        Subscription instance = new Subscription();
        int expResult = 0;
        int result = instance.getSubscriptionId();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setSubscriptionId method, of class Subscription.
     */
    @Test
    public void testSetSubscriptionId() {
        System.out.println("setSubscriptionId");
        int subscriptionId = 0;
        Subscription instance = new Subscription();
        instance.setSubscriptionId(subscriptionId);
       
    }

    /**
     * Test of getUserId method, of class Subscription.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        Subscription instance = new Subscription();
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setUserId method, of class Subscription.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        int userId = 0;
        Subscription instance = new Subscription();
        instance.setUserId(userId);
       
    }
    
}