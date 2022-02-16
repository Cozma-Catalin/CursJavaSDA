package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.utils.HibernateUtil;
import persistence.entities.User;

import javax.persistence.NoResultException;


@Repository
public class UserDAO {


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

    public int updateUserLogIn(boolean loggedIn,String email){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateUserLogInQuery = session.createNamedQuery("updateUserLogIn");
        updateUserLogInQuery.setParameter("loggedIn",loggedIn);
        updateUserLogInQuery.setParameter("email",email);
        int result = updateUserLogInQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }



    public String checkRegistration(String email,String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String retrievedPassword = null;
        Query checkRegistrationQuery = session.createNamedQuery("checkRegistration");
        checkRegistrationQuery.setParameter("email",email);
        checkRegistrationQuery.setParameter("password",password);
        try{
           retrievedPassword = (String) checkRegistrationQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println(e.getCause());
        }
        session.getTransaction().commit();
        session.close();
        return retrievedPassword;
    }


    public User findUserByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findUserByEmailQuery = session.createNamedQuery("findUserByEmail");
        findUserByEmailQuery.setParameter("email", email);
        User user = null;
        try {
          user = (User) findUserByEmailQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println(e.getCause());
        }
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public void insertUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
    }


    public User findUserAccount(String email, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findUserAccountQuery = session.createNamedQuery("findUserAccount");
        findUserAccountQuery.setParameter("email",email);
        findUserAccountQuery.setParameter("password",password);
        User user = null;
        try {
            user = (User) findUserAccountQuery.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getCause());
        }
        session.getTransaction().commit();
        session.close();
        return user;
    }


}
