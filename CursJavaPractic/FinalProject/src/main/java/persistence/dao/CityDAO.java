package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.HibernateUtil;
import persistence.entities.City;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class CityDAO {

    public void insertCity(City city) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
        session.close();
    }

    public long countCity(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countCityQuery = session.createNamedQuery("countCity");
        countCityQuery.setParameter("name", name);
        long result = (Long) countCityQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int deleteCity(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteCityQuery = session.createNamedQuery("deleteCity");
        deleteCityQuery.setParameter("name", name);
        int result = deleteCityQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public City findCity(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findCityQuery = session.createNamedQuery("findCity");
        findCityQuery.setParameter("name", name);
        City city = null;
        try {
            city = (City) findCityQuery.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        session.getTransaction().commit();
        session.close();
        return city;
    }

    public City findCity(String name,Session session) {

        Query findCityQuery = session.createNamedQuery("findCity");
        findCityQuery.setParameter("name", name);
        City city = null;
        try {
            city = (City) findCityQuery.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return city;
    }

    public List<City> findCitiesInCountry(String countryName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findCitiesQuery = session.createNamedQuery("findCitiesInCountry");
        findCitiesQuery.setParameter("name", countryName);
        List<City> cityList = findCitiesQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return cityList;
    }

    public int changeCityName(String newName, String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query changeCityNameQuery = session.createNamedQuery("changeCityName");
        changeCityNameQuery.setParameter("newName", newName);
        changeCityNameQuery.setParameter("name", name);
        int result = changeCityNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
