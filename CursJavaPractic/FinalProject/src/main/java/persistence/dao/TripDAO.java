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

    public List<Trip> findTripsByDepartureContinent(String continentName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByContinentQuery = session.createNamedQuery("findTripsByDepartureContinent");
        findTripsByContinentQuery.setParameter("name",continentName);
        List<Trip> tripList = findTripsByContinentQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    public List<Trip> findTripsByArrivingContinent(String continentName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByArrivingContinentQuery = session.createNamedQuery("findTripsByArrivingContinent");
        findTripsByArrivingContinentQuery.setParameter("name",continentName);
        List<Trip> tripList = findTripsByArrivingContinentQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    public List<Trip> findTripsByDepartureCountry(String countryName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByDepartureCountryQuery = session.createNamedQuery("findTripsByDepartureCountry");
        findTripsByDepartureCountryQuery.setParameter("name",countryName);
        List<Trip> tripList = findTripsByDepartureCountryQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }


    public List<Trip> findTripsByArrivingCountry(String countryName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByArrivingCountryQuery = session.createNamedQuery("findTripsByArrivingCountry");
        findTripsByArrivingCountryQuery.setParameter("name",countryName);
        List<Trip> tripList = findTripsByArrivingCountryQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    public List<Trip> findTripsByDepartureCity(String cityName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByDepartureCityQuery = session.createNamedQuery("findTripsByDepartureCity");
        findTripsByDepartureCityQuery.setParameter("name",cityName);
        List<Trip> tripList = findTripsByDepartureCityQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }


    public List<Trip> findTripsByArrivingCity(String cityName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByArrivingCityQuery = session.createNamedQuery("findTripsByArrivingCity");
        findTripsByArrivingCityQuery.setParameter("name",cityName);
        List<Trip> tripList = findTripsByArrivingCityQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    public List<Trip> findTripsByHotel(String hotelName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByHotelQuery = session.createNamedQuery("findTripsByHotel");
        findTripsByHotelQuery.setParameter("name",hotelName);
        List<Trip> tripList = findTripsByHotelQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }


    public List<Trip> findTripsByDepartureAirport(String airportName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByDepartureAirportQuery = session.createNamedQuery("findTripsByDepartureAirport");
        findTripsByDepartureAirportQuery.setParameter("name",airportName);
        List<Trip> tripList = findTripsByDepartureAirportQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }
}
