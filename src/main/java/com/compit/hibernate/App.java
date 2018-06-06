package com.compit.hibernate;


import com.compit.hibernate.entity.Countries;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class App {

    private final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {


//
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
//

            listDevelopers(sessionFactory);
        }

    }


    public static void listDevelopers(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        List<Countries> countries = session.createQuery("FROM Countries").list();
        System.out.println("countries: ");
        for (Object developer : countries) {
            System.out.println(developer);
        }
        session.close();
    }
}
