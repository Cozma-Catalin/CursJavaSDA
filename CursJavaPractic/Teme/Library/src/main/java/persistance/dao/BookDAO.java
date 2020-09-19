package persistance.dao;

import org.hibernate.Session;
import persistance.entities.Book;

public class BookDAO {


    public void insertBook(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }
}
