package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import persistence.utils.HibernateUtil;



@Repository
public class AccountDAO  {



    public int updateUserLogIn(boolean loggedIn,String userName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateUserLogInQuery = session.createNamedQuery("updateUserLogIn");
        updateUserLogInQuery.setParameter("loggedIn",loggedIn);
        updateUserLogInQuery.setParameter("userName",userName);
        int result = updateUserLogInQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int changeUserName(String newUserName,String userName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query changeUserNameQuery = session.createNamedQuery("changeUserName");
        changeUserNameQuery.setParameter("newUserName",newUserName);
        changeUserNameQuery.setParameter("userName",userName);
        int result = changeUserNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int deleteAccount(String userName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteAccountQuery = session.createNamedQuery("deleteAccount");
        deleteAccountQuery.setParameter("userName",userName);
        int result = deleteAccountQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public String checkRegistration(String userName,String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query checkRegistrationQuery = session.createNamedQuery("checkRegistration");
        checkRegistrationQuery.setParameter("userName",userName);
        checkRegistrationQuery.setParameter("password",password);
        String retrievedPassword = (String) checkRegistrationQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return retrievedPassword;
    }

  

    public long countUserName(String userName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countUserNameQuery = session.createNamedQuery("countAccountUserName");
        countUserNameQuery.setParameter("userName",userName);
        long result = (Long) countUserNameQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }


}
