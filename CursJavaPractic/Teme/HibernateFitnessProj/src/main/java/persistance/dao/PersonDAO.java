package persistance.dao;


import org.hibernate.Session;
import persistance.entities.Person;

import javax.persistence.Query;

public class PersonDAO {

    public void insertPerson(Person person){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

   /* public int deletePersonByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deletePersonByNameQuery = session.createNamedQuery("DeletePersonByName");
        deletePersonByNameQuery.setParameter("name",name);
        int result = deletePersonByNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int deletePersonByEndOfSubscription(String endOfSubscription){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deletePersonByEndOfSubscriptionQuery = session.createNamedQuery("DeletePersonByEndOfSubscription");
        deletePersonByEndOfSubscriptionQuery.setParameter("endOfSubscription",endOfSubscription);
        int result = deletePersonByEndOfSubscriptionQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

*/









}
