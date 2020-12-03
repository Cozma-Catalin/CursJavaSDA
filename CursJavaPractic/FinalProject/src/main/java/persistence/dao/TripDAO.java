package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.HibernateUtil;
import persistence.entities.Trip;

import java.util.Date;
import java.util.List;


@Repository
public class TripDAO {

    public void insertTrip(Trip trip,Session session){
        session.saveOrUpdate(trip);
    }

    public long countTrips(String name, Date date){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countTripsQuery = session.createNamedQuery("countTrips");
        countTripsQuery.setParameter("name",name);
        countTripsQuery.setParameter("departureDate",date);
        long result = (Long) countTripsQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int deleteTripsByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteTripsByNameQuery = session.createNamedQuery("deleteTripsByName");
        deleteTripsByNameQuery.setParameter("name",name);
        int result = deleteTripsByNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List<Trip> findPromotedTrips(boolean promoted){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findPromotedTripsQuery = session.createNamedQuery("findPromotedTrips");
        findPromotedTripsQuery.setParameter("promoted",promoted);
        List<Trip> trips = findPromotedTripsQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return trips;
    }
}
