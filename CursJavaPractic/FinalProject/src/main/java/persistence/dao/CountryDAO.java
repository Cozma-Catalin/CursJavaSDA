package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.HibernateUtil;
import persistence.entities.Country;
@Repository
public class CountryDAO {

    public void insertCountry(Country country){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(country);
        session.getTransaction().commit();
        session.close();
    }

    public int deleteCountry(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteCountryQuery = session.createNamedQuery("deleteCountry");
        deleteCountryQuery.setParameter("name",name);
        int result = deleteCountryQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Country findCountry(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findCountryQuery = session.createNamedQuery("findCountry");
        findCountryQuery.setParameter("name",name);
        Country country = (Country) findCountryQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return country;
    }

    public int changeCountryName(String newName,String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query changeCountryNameQuery = session.createNamedQuery("changeCountryName");
        changeCountryNameQuery.setParameter("newName",newName);
        changeCountryNameQuery.setParameter("name",name);
        int result = changeCountryNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
