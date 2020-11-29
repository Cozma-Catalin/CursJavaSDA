package persistence.dao;

import business.dto.CountryDTO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.HibernateUtil;
import persistence.entities.Continent;
import persistence.entities.Country;

import javax.persistence.NoResultException;
import java.util.List;


@Repository

public class ContinentDAO {

    public void insertContinent(Continent continent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(continent);
        session.getTransaction().commit();
        session.close();
    }

    public int deleteContinent(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteContinentQuery = session.createNamedQuery("deleteContinent");
        deleteContinentQuery.setParameter("name", name);
        int result = deleteContinentQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Continent findContinent(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findContinentQuery = session.createNamedQuery("findContinent");
        findContinentQuery.setParameter("name", name);
        Continent continent = null;
        try {
            continent = (Continent) findContinentQuery.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        session.getTransaction().commit();
        session.close();
        return continent;
    }

    public Continent findContinent(String name,Session session) {

        Query findContinentQuery = session.createNamedQuery("findContinent");
        findContinentQuery.setParameter("name", name);
        Continent continent = null;
        try {
            continent = (Continent) findContinentQuery.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return continent;
    }


    public long countContinent(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countContinentQuery = session.createNamedQuery("countContinent");
        countContinentQuery.setParameter("name", name);
        long result = (Long) countContinentQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
