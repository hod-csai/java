package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        User user = new User(1, "Alice");
        session.save(user);
        session.getTransaction().commit();
        
        session.close();
        factory.close();
    }
}
