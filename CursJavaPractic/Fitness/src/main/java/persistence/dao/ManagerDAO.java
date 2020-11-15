package persistence.dao;

import org.hibernate.query.Query;
import persistence.hibernateConfig.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Manager;

@Repository
public class ManagerDAO {

    public void insertManager(Manager manager){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(manager);
        session.getTransaction().commit();
        session.close();
    }

    public int deleteManager(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteManagerQuery = session.createNamedQuery("deleteManager");
        deleteManagerQuery.setParameter("name",name);
        int result = deleteManagerQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public long countManager(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countManagerQuery = session.createNamedQuery("countManager");
        countManagerQuery.setParameter("name",name);
        long result =(Long) countManagerQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Manager findManager(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findGymQuery = session.createNamedQuery("findManager");
        findGymQuery.setParameter("name",name);
        Manager manager = (Manager) findGymQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        if(manager==null){
            manager.setName(" ");
        }
        return manager;
    }

}
