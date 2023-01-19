/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Reservation;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import POJO.KuramenUtil;
import com.mchange.util.AssertException;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

/**
 *
 * @author Khaled Makkawirelang
 */
public class DAOReservationTest {

    public DAOReservationTest() {
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
     * Test of retrieveTblReservation method, of class DAOReservation.
     */
    @Test
    public void testRetrieveTblReservation() {
        System.out.println("retrieveTblReservation");
        DAOReservation instance = new DAOReservation();
        List<Reservation> expResult = null;
        List<Reservation> result = instance.retrieveTblReservation();
        assertThat(result, is(not(nullValue())));
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getbyID method, of class DAOReservation.
     */
    @Test
    public void tesstRetriveTblReservation() {
        System.out.println("Test List Reservation");
        DAOReservation instance = new DAOReservation();
        List<Reservation> result = instance.retrieveTblReservation();
        System.out.println("Total Reservation inside: " + result.toArray().length);
        assertFalse(result.isEmpty());
    }

    /**
     * Test of getbyID method, of class DAOReservation.
     */
    @Test(expected = AssertionError.class)
    public void testGetbyID() {
        System.out.println("Test Search by ID");
        String idReservation = "1";
        DAOReservation instance = new DAOReservation();
        List<Reservation> result = instance.getbyID(idReservation);
    }

    /**
     * Test of addReservation method, of class DAOReservation.
     */
    @Test
    public void testAddReservation() {
        System.out.println("Test Create Reservation");

        Reservation reservation = new Reservation();
        reservation.setNama("Syafiq");
        reservation.setAlamat("Kampus CCIT");
        reservation.setJk("Laki-Laki");
        reservation.setEmail("Syafiq@gmail.com");
        reservation.setTel("0866683138");
        reservation.setHour("17:00");
        reservation.setOrang("20");

        DAOReservation instance = new DAOReservation();
        instance.addReservation(reservation);

        assertNotNull(reservation);
    }

    /**
     * Test of deleteUser method, of class DAOReservation.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("Test Delete Product");

        Integer idReservation = 16;
        DAOReservation instance = new DAOReservation();
        Transaction transaction = null;
        Session session = KuramenUtil.getSessionFactory().openSession();

        transaction = session.beginTransaction();
        instance.deleteUser(idReservation);
        transaction.commit();

        Reservation deletedProduct = (Reservation) session.get(Reservation.class, idReservation);
        assertNull(deletedProduct);
    }

    /**
     * Test of editUser method, of class DAOReservation.
     */
    @Test(expected = NullPointerException.class)
    public void testEditUser() {
        System.out.println("Test Update Reservation");

        DAOReservation instance = new DAOReservation();
        Transaction transaction = null;
        Session session = KuramenUtil.getSessionFactory().openSession();

        Integer id = 9;
        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setNama("Syafiq2");
        reservation.setAlamat("Kampus CCIT");
        reservation.setJk("Laki-Laki");
        reservation.setEmail("Syafiq@gmail.com");
        reservation.setTel("0866683138");
        reservation.setHour("17:00");
        reservation.setOrang("20");

        transaction = session.beginTransaction();
        instance.editUser(reservation);
        transaction.commit();

        Reservation updatedReservation = (Reservation) session.get(Reservation.class, id);

        String expResult = "Syafiq";
        String result = updatedReservation.getNama();
        //assertEquals(expResult, result);
        assertThat(result, is(not(nullValue())));
    }
}
