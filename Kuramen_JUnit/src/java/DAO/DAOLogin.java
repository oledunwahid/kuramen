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
import POJO.Login;
import POJO.KuramenUtil;

/**
 *
 * @author Khaled Makkawirelang
 */
public class DAOLogin {
    public List<Login> getBy(String uEmail, String uPass) {
        Transaction trans = null;
        Login us = new Login();
        List<Login> user = new ArrayList();
        Session session = KuramenUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Login where email=:uEmail AND password=:uPass");
            query.setString("uEmail", uEmail);
            query.setString("uPass", uPass);
            us = (Login) query.uniqueResult();
            user = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

}
