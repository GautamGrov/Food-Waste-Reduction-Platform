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
public class TransactionTest {
    
    public TransactionTest() {
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
     * Test of getTransactionId method, of class Transaction.
     */
    @Test
    public void testGetTransactionId() {
        System.out.println("getTransactionId");
        Transaction instance = new Transaction();
        int expResult = 0;
        int result = instance.getTransactionId();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setTransactionId method, of class Transaction.
     */
    @Test
    public void testSetTransactionId() {
        System.out.println("setTransactionId");
        int transactionId = 0;
        Transaction instance = new Transaction();
        instance.setTransactionId(transactionId);
      
    }

    /**
     * Test of getSurplusItemId method, of class Transaction.
     */
    @Test
    public void testGetSurplusItemId() {
        System.out.println("getSurplusItemId");
        Transaction instance = new Transaction();
        int expResult = 0;
        int result = instance.getSurplusItemId();
        assertEquals(expResult, result);
     ;
    }

    /**
     * Test of setSurplusItemId method, of class Transaction.
     */
    @Test
    public void testSetSurplusItemId() {
        System.out.println("setSurplusItemId");
        int surplusItemId = 0;
        Transaction instance = new Transaction();
        instance.setSurplusItemId(surplusItemId);

    }

    /**
     * Test of getUserId method, of class Transaction.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        Transaction instance = new Transaction();
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of setUserId method, of class Transaction.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        int userId = 0;
        Transaction instance = new Transaction();
        instance.setUserId(userId);
      
    }

    /**
     * Test of getTransactionDate method, of class Transaction.
     */
    @Test
    public void testGetTransactionDate() {
        System.out.println("getTransactionDate");
        Transaction instance = new Transaction();
        Timestamp expResult = null;
        Timestamp result = instance.getTransactionDate();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setTransactionDate method, of class Transaction.
     */
    @Test
    public void testSetTransactionDate() {
        System.out.println("setTransactionDate");
        Timestamp transactionDate = null;
        Transaction instance = new Transaction();
        instance.setTransactionDate(transactionDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantityClaimed method, of class Transaction.
     */
    @Test
    public void testGetQuantityClaimed() {
        System.out.println("getQuantityClaimed");
        Transaction instance = new Transaction();
        int expResult = 0;
        int result = instance.getQuantityClaimed();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setQuantityClaimed method, of class Transaction.
     */
    @Test
    public void testSetQuantityClaimed() {
        System.out.println("setQuantityClaimed");
        int quantityClaimed = 0;
        Transaction instance = new Transaction();
        instance.setQuantityClaimed(quantityClaimed);
      ;
    }
    
}