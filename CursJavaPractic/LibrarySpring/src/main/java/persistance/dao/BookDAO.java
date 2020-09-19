package persistance.dao;

import business.config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistance.entities.Book;

import javax.persistence.Query;
import java.util.List;
@Repository
public class BookDAO {


    public void insertBook(Book book){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    public List<Book> findBook(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findBookQuery = session.createNamedQuery("findBook");
        List<Book> bookList= findBookQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return bookList;
    }

    public int deleteBookByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteBookByNameQuery = session.createNamedQuery("deleteBookByName");
        deleteBookByNameQuery.setParameter("name",name);
        int result = deleteBookByNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;

    }
}
