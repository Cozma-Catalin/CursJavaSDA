package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.entities.PurchasedTrip;
import persistence.utils.HibernateUtil;

import javax.persistence.NoResultException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Repository
public class PurchasedTripDAO {

    public void insertPurchasedTrip(PurchasedTrip purchasedTrip){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(purchasedTrip);
        session.getTransaction().commit();
        session.close();
    }

    public List<PurchasedTrip> showPurchasedTrips(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query showPurchasedTripsQuery = session.createNamedQuery("showPurchasedTripsByUser");
        showPurchasedTripsQuery.setParameter("name",name);
        List<PurchasedTrip> purchasedTrips = null;
        try{
            purchasedTrips = showPurchasedTripsQuery.getResultList();
        }catch (NoResultException e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
        session.close();
        return purchasedTrips;
    }

    public List<PurchasedTrip> showPurchasedTripsByDate(Date date){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query showRecentlyPurchasedTripsQuery = session.createNamedQuery("showPurchasedTripsByDate");
        showRecentlyPurchasedTripsQuery.setParameter("dateOfPurchase",date);
        Calendar calendar = Calendar.getInstance();
        java.util.Date dateUtil = calendar.getTime();
        java.sql.Date currentDate = new Date(dateUtil.getTime());
        showRecentlyPurchasedTripsQuery.setParameter("currentDate",currentDate);
        List<PurchasedTrip> purchasedTrips = null;
        try{
            purchasedTrips = showRecentlyPurchasedTripsQuery.getResultList();
        }catch (NoResultException e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
        session.close();
        return purchasedTrips;
    }
}
