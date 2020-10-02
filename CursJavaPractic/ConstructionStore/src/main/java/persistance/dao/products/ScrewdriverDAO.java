package persistance.dao.products;

import bussiness.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistance.entities.products.Screwdriver;


@Repository
public class ScrewdriverDAO {


    public void insertScrewdriver(Screwdriver screwdriver){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(screwdriver);
        session.getTransaction().commit();
        session.close();
    }

    public Screwdriver findScrewdriverByBrand(String brand){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findScrewdriverByBrandQuery = session.createNamedQuery("findScrewdriverByBrand");
        findScrewdriverByBrandQuery.setParameter("brand",brand);
        Screwdriver screwdriver = (Screwdriver) findScrewdriverByBrandQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return screwdriver;
    }

    public int deleteScrewdriverByBrand(String brand){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteScrewdriverByBrandQuery = session.createNativeQuery("deleteScrewdriverByBrand");
        deleteScrewdriverByBrandQuery.setParameter("brand",brand);
        int result = deleteScrewdriverByBrandQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result ;
    }

    public int updateScrewdriverPrice(double price,String brand){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateScrewdriverPriceQuery = session.createNamedQuery("updateScrewdriverPrice");
        updateScrewdriverPriceQuery.setParameter("price",price);
        updateScrewdriverPriceQuery.setParameter("brand",brand);
        int result = updateScrewdriverPriceQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int updateScrewdriverQuantity(double quantity,String brand){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateScrewdriverQuantityQuery = session.createNamedQuery("updateScrewdriverQuantity");
        updateScrewdriverQuantityQuery.setParameter("quantity",quantity);
        updateScrewdriverQuantityQuery.setParameter("brand",brand);
        int result = updateScrewdriverQuantityQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Long countScrewdriverByBrand(String brand){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countScrewdriverByBrand = session.createNamedQuery("countScrewdriverByBrand");
        countScrewdriverByBrand.setParameter("brand",brand);
        Long result = (Long) countScrewdriverByBrand.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
