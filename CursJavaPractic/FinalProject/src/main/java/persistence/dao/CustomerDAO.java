package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.HibernateUtil;
import persistence.entities.Customer;


@Repository
public class CustomerDAO {


    public long countEmail(String email){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        org.hibernate.query.Query countEmailQuery = session.createNamedQuery("countEmail");
        countEmailQuery.setParameter("email",email);
        long result = (Long) countEmailQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Customer findCustomerAccount(String userName, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findCustomerAccountQuery = session.createNamedQuery("findCustomerAccount");
        findCustomerAccountQuery.setParameter("userName",userName);
        findCustomerAccountQuery.setParameter("password",password);
        Customer customer = (Customer) findCustomerAccountQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return customer;

    }


    public Customer findCustomerByEmail(String email){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findCustomerByEmailQuery = session.createNamedQuery("findCustomerByEmail");
        findCustomerByEmailQuery.setParameter("email",email);
        Customer customer = (Customer) findCustomerByEmailQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return customer;
    }

    public void insertCustomer(Customer customer){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }




}
