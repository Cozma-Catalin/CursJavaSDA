package persistence.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.HibernateUtil;
import persistence.entities.Flight;

@Repository
public class FlightDAO {

    public void insertFlight(Flight flight){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(flight);
        session.getTransaction().commit();
        session.close();
    }
}
