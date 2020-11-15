package persistence.dao;

import org.springframework.stereotype.Repository;


import persistence.hibernateConfig.HibernateUtil;
import org.hibernate.Session;
import persistence.entities.Subscription;
@Repository
public class SubscriptionDAO {

    public void insertSubscription(Subscription subscription){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(subscription);
        session.getTransaction().commit();
        session.close();
    }
}
