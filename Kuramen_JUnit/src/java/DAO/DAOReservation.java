/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import POJO.Reservation;
import POJO.KuramenUtil;
/**
 *
 * @author revin
 */
public class DAOReservation {
        public List<Reservation> retrieveTblReservation() {
        List listReservation = new ArrayList();
        Transaction transaction = null;
        Session session = KuramenUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Reservation");
            listReservation = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listReservation;
    }
        
        
    public List<Reservation> getbyID(String idReservation) {
        Reservation reservation = new Reservation();
        List<Reservation> listReservation = new ArrayList();
        Transaction transaction = null;
        Session session = KuramenUtil.getSessionFactory().openSession();
        
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Reservation where id = :id");
            query.setString("id", idReservation);
            reservation = (Reservation) query.uniqueResult();
            listReservation = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listReservation;
    }    
    
    public void addReservation(Reservation reservation){
        Transaction transaction = null;
        Session session = KuramenUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(reservation);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void deleteUser(Integer idReservation) {
        Transaction transaction = null;
        Session session = KuramenUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Reservation usr = (Reservation) session.load(Reservation.class, new Integer(idReservation));
            session.delete(usr);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // untuk edit
    public void editUser(Reservation reservation) {
        Transaction transaction = null;
        Session session = KuramenUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(reservation);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
    
