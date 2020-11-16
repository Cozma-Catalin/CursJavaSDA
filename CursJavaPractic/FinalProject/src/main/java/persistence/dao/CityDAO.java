package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.HibernateUtil;
import persistence.entities.City;
@Repository
public class CityDAO {

    public void insertCity(City city){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
        session.close();
    }

    public int deleteCity(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteCityQuery = session.createNamedQuery("deleteCity");
        deleteCityQuery.setParameter("name",name);
        int result = deleteCityQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public City findCity(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findCityQuery = session.createNamedQuery("findCity");
        findCityQuery.setParameter("name",name);
        City city = (City) findCityQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return city;
    }

    public int changeCityName(String newName,String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query changeCityNameQuery = session.createNamedQuery("changeCityName");
        changeCityNameQuery.setParameter("newName",newName);
        changeCityNameQuery.setParameter("name",name);
        int result = changeCityNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
