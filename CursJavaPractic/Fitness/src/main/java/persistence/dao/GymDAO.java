package persistence.dao;

import org.hibernate.query.Query;
import persistence.hibernateConfig.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Gym;

@Repository
public class GymDAO {

    public void insertGym(Gym gym) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(gym);
        session.getTransaction().commit();
        session.close();
    }

    public long countGym(String address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countGymQuery = session.createNamedQuery("countGym");
        countGymQuery.setParameter("address", address);
        long result = (Long) countGymQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Gym findGym(String address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findGymQuery = session.createNamedQuery("findGym");
        findGymQuery.setParameter("address", address);
        Gym gymFound = (Gym) findGymQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return gymFound;
    }

    public int deleteGym(String address){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteGymQuery = session.createNamedQuery("deleteGym");
        deleteGymQuery.setParameter("address",address);
        int result = deleteGymQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int changeGymName(String name,String address){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query changeGymNameQuery = session.createNamedQuery("changeGymName");
        changeGymNameQuery.setParameter("name",name);
        changeGymNameQuery.setParameter("address",address);
        int result = changeGymNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
