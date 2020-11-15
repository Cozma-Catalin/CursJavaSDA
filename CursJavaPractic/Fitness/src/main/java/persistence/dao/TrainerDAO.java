package persistence.dao;

import org.hibernate.query.Query;
import persistence.hibernateConfig.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Trainer;

@Repository
public class TrainerDAO {

    public void addTrainer(Trainer trainer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(trainer);
        session.getTransaction().commit();
        session.close();
    }

    public long countTrainer(String name, String surname) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countTrainerQuery = session.createNamedQuery("countTrainer");
        countTrainerQuery.setParameter("name", name);
        countTrainerQuery.setParameter("surname",session);
        long result = (Long) countTrainerQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int deleteTrainerByNameAndSurname(String name,String surname){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteTrainerQuery = session.createNamedQuery("deleteTrainer");
        deleteTrainerQuery.setParameter("name",name);
        deleteTrainerQuery.setParameter("surname",surname);
        int result = deleteTrainerQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
