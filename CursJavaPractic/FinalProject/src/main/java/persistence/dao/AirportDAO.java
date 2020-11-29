package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.HibernateUtil;
import persistence.entities.Airport;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class AirportDAO {

    public void insertAirport(Airport airport){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(airport);
        session.getTransaction().commit();
        session.close();
    }

    public List<String> getAirportNameByCityName(String cityName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query getAirportNameByCityNameQuery = session.createNamedQuery("getAirportNameByCityName");
        getAirportNameByCityNameQuery.setParameter("name",cityName);
        List<String> result = getAirportNameByCityNameQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int deleteAirportByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteAirportByNameQuery =session.createNamedQuery("deleteAirportByName");
        deleteAirportByNameQuery.setParameter("name",name);
        int result = deleteAirportByNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public long countAirportName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countAirportNameQuery = session.createNamedQuery("countAirportName");
        countAirportNameQuery.setParameter("name",name);
        long result = (Long) countAirportNameQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int changeAirportName(String newName,String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query changeAirportNameQuery = session.createNamedQuery("changeAirportName");
        changeAirportNameQuery.setParameter("newName",newName);
        changeAirportNameQuery.setParameter("name",name);
        int result = changeAirportNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Airport findAirportByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findAirportByNameQuery = session.createNamedQuery("findAirportByName");
        findAirportByNameQuery.setParameter("name",name);
        Airport airport = null;
        try {
            airport = (Airport) findAirportByNameQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }
        session.getTransaction().commit();
        session.close();
        return airport;
    }

    public List<Airport> findAirportsInCity(String cityName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findAirportsInCityQuery = session.createNamedQuery("findAirportsInCity");
        findAirportsInCityQuery.setParameter("cityName",cityName);
        List<Airport> airportList = findAirportsInCityQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return airportList;
    }


    public List<Airport> findAirportsInCity(String cityName,Session session){

        Query findAirportsInCityQuery = session.createNamedQuery("findAirportsInCity");
        findAirportsInCityQuery.setParameter("cityName",cityName);
        List<Airport> airportList = findAirportsInCityQuery.getResultList();

        return airportList;
    }
}
