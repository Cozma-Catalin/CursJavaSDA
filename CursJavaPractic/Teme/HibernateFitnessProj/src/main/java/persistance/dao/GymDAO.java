package persistance.dao;

import org.hibernate.Session;
import persistance.entities.Gym;

public class GymDAO {

    public void insertGym(Gym gym){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(gym);
        session.getTransaction().commit();
        session.close();
    }
}
