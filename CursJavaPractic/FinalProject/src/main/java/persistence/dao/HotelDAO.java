package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.HibernateUtil;
import persistence.entities.Hotel;

@Repository
public class HotelDAO {

    public void insertHotel(Hotel hotel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(hotel);
        session.getTransaction().commit();
        session.close();
    }

    public long countHotel(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countHotelQuery = session.createNamedQuery("countHotel");
        countHotelQuery.setParameter("name",name);
        long result = (Long) countHotelQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
