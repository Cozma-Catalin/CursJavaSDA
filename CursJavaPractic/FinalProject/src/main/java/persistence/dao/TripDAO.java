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

    public List<Trip> findTripsByDepartureDate(java.sql.Date departureDate){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByDepartureDateQuery = session.createNamedQuery("findTripsByDepartureDate");
        findTripsByDepartureDateQuery.setParameter("departureDate",departureDate);
        List<Trip> tripList = findTripsByDepartureDateQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    public List<Trip> findTripsByReturnDate(java.sql.Date returnDate){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByReturnDateQuery = session.createNamedQuery("findTripsByReturnDate");
        findTripsByReturnDateQuery.setParameter("returnDate",returnDate);
        List<Trip> tripList = findTripsByReturnDateQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    public List<Trip> findTripsByDepartureTimeFrame(java.sql.Date departureDate, java.sql.Date returnDate){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByDepartureTimeFrameQuery = session.createNamedQuery("findTripsByDepartureTimeFrame");
        findTripsByDepartureTimeFrameQuery.setParameter("departureDate",departureDate);
        findTripsByDepartureTimeFrameQuery.setParameter("returnDate",returnDate);
        List<Trip> tripList = findTripsByDepartureTimeFrameQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }



    public List<Trip> findTripsByReturnTimeFrame(java.sql.Date departureDate, java.sql.Date returnDate){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByReturnTimeFrameQuery = session.createNamedQuery("findTripsByReturnTimeFrame");
        findTripsByReturnTimeFrameQuery.setParameter("departureDate",departureDate);
        findTripsByReturnTimeFrameQuery.setParameter("returnDate",returnDate);
        List<Trip> tripList = findTripsByReturnTimeFrameQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }


    public List<Trip> findTripsByMealType(String mealType){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByMealTypeQuery = session.createNamedQuery("findTripsByMealType");
        findTripsByMealTypeQuery.setParameter("mealType",mealType);
        List<Trip> tripList = findTripsByMealTypeQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }


    public List<Trip> findTripsByHotelStars(double numberOfStars){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByHotelStarsQuery = session.createNamedQuery("findTripsByHotelStars");
        findTripsByHotelStarsQuery.setParameter("numberOfStars",numberOfStars);
        List<Trip> tripList = findTripsByHotelStarsQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }


    public List<Trip> findTripsByNumberOfDays(int numberOfDays){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripsByNumberOfDaysQuery = session.createNamedQuery("findTripsByNumberOfDays");
        findTripsByNumberOfDaysQuery.setParameter("numberOfDays",numberOfDays);
        List<Trip> tripList = findTripsByNumberOfDaysQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }


    public List<Trip> findAllTrips(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findAllTripsQuery = session.createNamedQuery("findAllTrips");
        List<Trip> tripList = findAllTripsQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }
}
