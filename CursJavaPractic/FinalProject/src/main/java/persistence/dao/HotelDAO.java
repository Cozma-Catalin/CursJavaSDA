package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.HibernateUtil;
import persistence.entities.Hotel;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class HotelDAO {

    public void insertHotel(Hotel hotel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(hotel);
        session.getTransaction().commit();
        session.close();
    }


    public long countHotelName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countHotelNameQuery = session.createNamedQuery("countHotelName");
        countHotelNameQuery.setParameter("name", name);
        long result = (Long) countHotelNameQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }


    public List<String> countAddressInCity(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countAddressQuery = session.createNamedQuery("countAddressInCity");
        countAddressQuery.setParameter("name",name);
        List<String> result = countAddressQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List<Hotel> findHotel(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findHotelQuery = session.createNamedQuery("findHotel");
        findHotelQuery.setParameter("name", name);
        List<Hotel> result = findHotelQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Hotel findHotelByAddress(String address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findHotelByAddressQuery = session.createNamedQuery("findHotelByAddress");
        findHotelByAddressQuery.setParameter("address",address);
        Hotel result = null;
        try {
            result = (Hotel) findHotelByAddressQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int deleteHotelByName(String hotelName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteHotelByNameQuery = session.createNamedQuery("deleteHotelByName");
        deleteHotelByNameQuery.setParameter("name", hotelName);
        int result = deleteHotelByNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int deleteHotelByAddress(String address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteHotelByAddressQuery = session.createNamedQuery("deleteHotelByAddress");
        deleteHotelByAddressQuery.setParameter("address", address);
        int result = deleteHotelByAddressQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }


    public List<Hotel> findHotelsInCity(String cityName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findHotelsQuery = session.createNamedQuery("findHotelsInCity");
        findHotelsQuery.setParameter("name", cityName);
        List<Hotel> hotelList = findHotelsQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return hotelList;
    }

    public int changeHotelName(String newName, String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query changeHotelNameQuery = session.createNamedQuery("changeHotelName");
        changeHotelNameQuery.setParameter("newName", newName);
        changeHotelNameQuery.setParameter("name", name);
        int result = changeHotelNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
