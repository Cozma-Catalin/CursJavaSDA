package persistence.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.PurchasedTrip;
import persistence.utils.HibernateUtil;

@Repository
public class PurchasedTripDAO {

    public void insertPurchasedTrip(PurchasedTrip purchasedTrip){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(purchasedTrip);
        session.getTransaction().commit();
        session.close();
    }
}
