package com.compit.hibernate;


import com.compit.hibernate.entity.Countries;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class App {

    private final static Logger logger = Logger.getLogger(App.class);
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        App app = new App();

        System.out.println("countries: ");
        app.listDevelopers();
        sessionFactory.close();

    }



    public void listDevelopers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List developers = session.createQuery("FROM COUNTRIES").list();
        for (Object developer : developers) {
            System.out.println(developer);
            System.out.println("\n================\n");
        }
        session.close();
    }
}
