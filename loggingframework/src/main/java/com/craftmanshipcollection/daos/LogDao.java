package com.craftmanshipcollection.daos;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.craftmanshipcollection.models.Log;
import com.craftmanshipcollection.utils.HibernateUtil;


public class LogDao {

    
    public void persist(String message) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        LocalDateTime now = LocalDateTime.now();

        Log log = new Log();

        log.setMessage(message);
        log.setTimeStamp(now);

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            
            transaction = session.beginTransaction();

            session.persist(log);
            transaction.commit();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}

    
