package persistance.dao;

import org.hibernate.Session;
import persistance.entities.Subscription;

public class SubscriptionDAO {

    public void insertSubscription(Subscription subscription){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(subscription);
        session.getTransaction().commit();
        session.close();
    }





}
