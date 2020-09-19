package persistance.dao;

import org.hibernate.Session;
import persistance.entities.Person;

public class PersonDAO {

    public void insertPerson(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }
}
