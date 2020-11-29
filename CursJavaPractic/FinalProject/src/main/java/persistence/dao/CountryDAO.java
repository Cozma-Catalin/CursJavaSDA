package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.HibernateUtil;
import persistence.entities.Country;

import javax.persistence.NoResultException;
import java.util.List;


@Repository
public class CountryDAO {

    public void insertCountry(Country country) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(country);
        session.getTransaction().commit();
        session.close();
    }

    public long countCountry(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countCountryQuery = session.createNamedQuery("countCountry");
        countCountryQuery.setParameter("name", name);
        long result = (Long) countCountryQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int deleteCountry(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteCountryQuery = session.createNamedQuery("deleteCountry");
        deleteCountryQuery.setParameter("name", name);
        int result = deleteCountryQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Country findCountry(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findCountryQuery = session.createNamedQuery("findCountry");
        findCountryQuery.setParameter("name", name);
        Country country = null;
        try {
            country = (Country) findCountryQuery.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        session.getTransaction().commit();
        session.close();
        return country;
    }

    public Country findCountry(String name,Session session) {

        Query findCountryQuery = session.createNamedQuery("findCountry");
        findCountryQuery.setParameter("name", name);
        Country country = null;
        try {
            country = (Country) findCountryQuery.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return country;
    }


    public List<Country> findCountriesInContinent(String continentName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findCountriesQuery = session.createNamedQuery("findCountriesInContinent");
        findCountriesQuery.setParameter("name", continentName);
        List<Country> countryList = findCountriesQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return countryList;
    }


    public int changeCountryName(String newName, String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query changeCountryNameQuery = session.createNamedQuery("changeCountryName");
        changeCountryNameQuery.setParameter("newName", newName);
        changeCountryNameQuery.setParameter("name", name);
        int result = changeCountryNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
