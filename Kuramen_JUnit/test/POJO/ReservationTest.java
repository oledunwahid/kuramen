/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.List;
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
public class ReservationTest {
    
    public ReservationTest() {
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

    /**
     * Test of getAllRecords method, of class Reservation.
     */
    @Test
  public void testGetAllRecords() {
    System.out.println("Test Get All Record");
    Reservation instance = new Reservation();
    int expResult = 39;
    List<Reservation> result = instance.getAllRecords();
    assertEquals(expResult, result.toArray().length);
  }
  
  @Test
  public void testGetById() {
    System.out.println("Test Get by ID");
      
    Reservation instance = new Reservation();
    instance.setId(1);
    
    String expResult = "List";
    String result = instance.getById();

    assertEquals(expResult, result);
  }
  
  @Test
  public void testSaveReservation() {
    System.out.println("Test Save Reservation");
    
    Reservation reservation = new Reservation();
    reservation.setNama("Syafiq");
    reservation.setAlamat("Kampus CCIT");
    reservation.setJk("Laki-Laki");
    reservation.setEmail("Syafiq@gmail.com");
    reservation.setTel ("0866683138");
    reservation.setHour ("17:00");
    reservation.setOrang ("20");
    
    String expResult = "reservation";
    String result = reservation.saveReservation();

    assertEquals(expResult, result);
  }

   @Test
  public void testSaveReservation2() {
    System.out.println("Test Save Reservation");
    
    Reservation reservation = new Reservation();
    reservation.setNama("Syafiq2");
    reservation.setAlamat("Kampus CCIT");
    reservation.setJk("Laki-Laki");
    reservation.setEmail("Syafiq@gmail.com");
    reservation.setTel ("0866683138");
    reservation.setHour ("17:00");
    reservation.setOrang ("20");
    
    String expResult = "List";
    String result = reservation.saveReservation2();

    assertEquals(expResult, result);
  }

  
  @Test
  public void testEditReservation() {
    System.out.println("editReservation");
    
    Reservation reservation = new Reservation();
    reservation.setNama("Syafiq");
    reservation.setAlamat("Kampus CCIT");
    reservation.setJk("Laki-Laki");
    reservation.setEmail("Syafiq@gmail.com");
    reservation.setTel ("0866683138");
    reservation.setHour ("17:00");
    reservation.setOrang ("20");
    
    String expResult = "List";
    String result = reservation.editReservation();
    

    assertEquals(expResult, result);
  }
  
   @Test
  public void testDeleteProduct() {
    System.out.println("deleteReservation");
    
    Reservation instance = new Reservation();
    instance.setId(9);
    
    String expResult = "List";
    String result = instance.deleteReservation();
    assertEquals(expResult, result);
  }
}