package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.HibernateUtil;
import persistence.entities.Flight;

import javax.persistence.NoResultException;

@Repository
public class FlightDAO {

    public void insertFlight(Flight flight){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(flight);
        session.getTransaction().commit();
        session.close();
    }

    public long countFlightNumber(String flightNumber){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countFlightNumberQuery = session.createNamedQuery("countFlightNumber");
        countFlightNumberQuery.setParameter("flightNumber",flightNumber);
        long result = (Long) countFlightNumberQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Flight findFlightByFlightNumber(String flightNumber){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findFlightByFlightNumberQuery = session.createNamedQuery("findFlightByFlightNumber");
        findFlightByFlightNumberQuery.setParameter("flightNumber",flightNumber);
        Flight flight = null;
        try{
            flight = (Flight) findFlightByFlightNumberQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }
        session.getTransaction().commit();
        session.close();
        return flight;
    }

    public Flight findFlightByFlightNumber(String flightNumber,Session session){

        Query findFlightByFlightNumberQuery = session.createNamedQuery("findFlightByFlightNumber");
        findFlightByFlightNumberQuery.setParameter("flightNumber",flightNumber);
        Flight flight = null;
        try{
            flight = (Flight) findFlightByFlightNumberQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }

        return flight;
    }
}
