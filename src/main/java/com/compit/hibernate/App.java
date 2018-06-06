package com.compit.hibernate;


import com.compit.hibernate.entity.Countries;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class App {

    private static SessionFactory sessionFactory;

//    private final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        App app = new App();
        System.out.println("Add: ");
        app.addCountry( "INSERT INTO Countries(countryID, countryName, regionID)"  +
                "SELECT countryID, countryName, regionID from Countries");
        app.listCountries();
        app.addCountry( "INSERT INTO Countries(countryID, countryName, regionID)"  +
                "SELECT countryID, countryName, regionID from Countries");
        System.out.println("Select: ");
        app.listCountries();
        sessionFactory.close();
    }


    public void listCountries() {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        List<Countries> countries = session.createQuery("FROM Countries").list();
        System.out.println("COUNTRIES: ");
        for (Object developer : countries) {
            System.out.println(developer);
        }
        session.close();
    }

    public void addCountry(String hql) {
        Session session = sessionFactory.openSession();

        session.createQuery(hql);

        session.close();
    }
}
