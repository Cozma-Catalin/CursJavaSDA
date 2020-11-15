package persistence.dao;

import persistence.hibernateConfig.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Janitor;

@Repository
public class JanitorDAO {

    public void insertJanitor(Janitor janitor){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(janitor);
        session.getTransaction().commit();
        session.close();
    }
}
