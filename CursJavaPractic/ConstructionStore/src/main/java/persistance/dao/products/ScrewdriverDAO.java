package persistance.dao.products;

import bussiness.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistance.entities.products.Tools.Screwdriver;

import java.util.List;
@Repository
public class ScrewdriverDAO {


    public String insertScrewdriver(Screwdriver screwdriver){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(screwdriver);
        session.getTransaction().commit();
        session.close();
        return "Screwdriver added.";
    }

    public List<Screwdriver> findScrewdriverByBrand(String brand){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findScrewdriverByBrandQuery = session.createNamedQuery("findScrewdriverByBrand");
        findScrewdriverByBrandQuery.setParameter("brand",brand);
        List<Screwdriver> screwdriverList = findScrewdriverByBrandQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return screwdriverList;
    }

    public String deleteScrewdriverByBrand(String brand){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteScrewdriverByBrandQuery = session.createNativeQuery("deleteScrewdriverByBrand");
        deleteScrewdriverByBrandQuery.setParameter("brand",brand);
        int result = deleteScrewdriverByBrandQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result + " items were deleted.";
    }

    public String modifyScrewdriverPrice(String brand,double price){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query modifyScrewdriverPriceQuery = session.createNamedQuery("modifyScrewdriverPrice");
        modifyScrewdriverPriceQuery.setParameter("price",price);
        modifyScrewdriverPriceQuery.setParameter("brand",brand);
        int result = modifyScrewdriverPriceQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result + " items were modified.";
    }


}
