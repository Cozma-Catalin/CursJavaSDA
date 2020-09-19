package persistance.dao;

import org.hibernate.Session;
import persistance.entities.Workout;

public class WorkoutDAO {


    public void insertWorkout(Workout workout){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(workout);
        session.getTransaction().commit();
        session.close();
    }









}
