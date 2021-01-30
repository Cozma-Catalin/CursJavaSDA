package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.utils.HibernateUtil;
import persistence.entities.Customer;

import javax.persistence.NoResultException;


@Repository
public class CustomerDAO {


    public long countEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        org.hibernate.query.Query countEmailQuery = session.createNamedQuery("countEmail");
        countEmailQuery.setParameter("email", email);
        long result = (Long) countEmailQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Customer findCustomerAccount(String userName, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findCustomerAccountQuery = session.createNamedQuery("findCustomerAccount");
        findCustomerAccountQuery.setParameter("userName", userName);
        findCustomerAccountQuery.setParameter("password", password);
        Customer customer = null;
        try {
            customer = (Customer) findCustomerAccountQuery.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getCause());
        }
        session.getTransaction().commit();
        session.close();
        return customer;
    }


    public Customer findCustomerByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findCustomerByEmailQuery = session.createNamedQuery("findCustomerByEmail");
        findCustomerByEmailQuery.setParameter("email", email);
        Customer customer = null;
        try {
          customer = (Customer) findCustomerByEmailQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println(e.getCause());
        }
        session.getTransaction().commit();
        session.close();
        return customer;
    }

    public void insertCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(customer);
        session.getTransaction().commit();
        session.close();
    }


    public Customer findCustomerByUserName(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findCustomerByUserNameQuery = session.createNamedQuery("findCustomerByUserName");
        findCustomerByUserNameQuery.setParameter("userName", userName);
        Customer customer = null;
        try {
            customer = (Customer) findCustomerByUserNameQuery.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getCause());
        }
        session.getTransaction().commit();
        session.close();
        return customer;
    }


}
