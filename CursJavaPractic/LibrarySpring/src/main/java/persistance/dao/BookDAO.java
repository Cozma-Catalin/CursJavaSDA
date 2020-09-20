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

    public List<Book> findBookByTitle(String title){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findBookByTitleQuery = session.createNamedQuery("findBookByTitle");
        findBookByTitleQuery.setParameter("title",title);
        List<Book> bookList= findBookByTitleQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return bookList;
    }

    public List<Book> findAllBooks(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findAllBooksQuery = session.createNamedQuery("findAllBooks");
        List<Book> bookList= findAllBooksQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return bookList;
    }


    public Long deleteBookByTitle(String title){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteBookByTitleQuery = session.createNamedQuery("deleteBookByTitle");
        deleteBookByTitleQuery.setParameter("title",title);
        Long result =(Long) (deleteBookByTitleQuery.getSingleResult());
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Long countBooksByTitle(String title){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countBooksByTitleQuery = session.createNamedQuery("countBooksByTitle");
        countBooksByTitleQuery.setParameter("title",title);
        Long result =(Long) (countBooksByTitleQuery.getSingleResult());
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
