package persistance.dao;

import org.hibernate.Session;
import persistance.entities.Section;

public class SectionDAO {


    public void insertSection(Section section) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(section);
        session.getTransaction().commit();
        session.close();
    }
}
