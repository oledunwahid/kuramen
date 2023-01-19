/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Khaled Makkawirelang
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
   @BeforeClass
    public static void setUpClass() {
        System.out.println("***** Starting Test *****");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("***** Ending Test *****");
    }
    
    @Before
    public void setUp() {
        System.out.println("\n");
    }
    
    @After
    public void tearDown() {
        System.out.println("\n");
    }
    
    // untuk mengetes login user 
    @Test
  public void testLogin_user() {
    System.out.println("***** Test Login User *****");
   
    Login instance = new Login();
    instance.setEmail("khaled@gmail.com");
    instance.setPassword("123"); 
    
    String expResult = "List";
    String result = instance.login_user();
    System.out.println(expResult);
    System.out.println(result);
    assertEquals(expResult, result);
  }
}

   
