package persistance.dao;

import org.hibernate.Session;
import persistance.entities.Author;

public class AuthorDAO {

    public void insertAuthor(Author author){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
    }





}
