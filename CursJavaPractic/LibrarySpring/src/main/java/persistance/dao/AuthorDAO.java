package persistance.dao;

import business.config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistance.entities.Author;

import javax.persistence.Query;
import java.util.List;
@Repository
public class AuthorDAO {

    public void insertAuthor(Author author){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
    }

    public List<Author> findAuthorByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findAuthorByNameQuery = session.createNamedQuery("findAuthorByName");
        findAuthorByNameQuery.setParameter("name",name);
        List<Author> authorList = findAuthorByNameQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return authorList;
    }
}
