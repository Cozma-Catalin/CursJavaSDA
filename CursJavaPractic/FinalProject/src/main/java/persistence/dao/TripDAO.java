package persistence.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Trip;



@Repository
public class TripDAO {

    public void insertTrip(Trip trip,Session session){
        session.saveOrUpdate(trip);
    }



}
