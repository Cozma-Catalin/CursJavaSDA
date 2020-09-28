package persistance.dao.products;

import bussiness.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistance.entities.products.Chemicals.Paint;

import java.util.List;
@Repository
public class PaintDAO {


    public String insertPaint(Paint paint){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(paint);
        session.getTransaction().commit();
        session.close();
        return "Paint added successfully.";
    }

    public String deletePaintByBrand(String brand){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deletePaintByBrandQuery = session.createNamedQuery("deletePaintByBrand");
        deletePaintByBrandQuery.setParameter("brand",brand);
        int result = deletePaintByBrandQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        if(result == 0){
            return "Operation not successful.";
        }
        return result+ " items deleted.";
    }

    public List<Paint> findPaintByBrand(String brand){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findPaintByBrandQuery = session.createNamedQuery("findPaintByBrand");
        findPaintByBrandQuery.setParameter("brand",brand);
        List<Paint> paintList = findPaintByBrandQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return paintList;
    }

    public String modifyPaintPrice(String brand,Double price){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query modifyPaintPriceQuery = session.createNamedQuery("modifyPaintPrice");
        modifyPaintPriceQuery.setParameter("price",price);
        modifyPaintPriceQuery.setParameter("brand",brand);
        int result = modifyPaintPriceQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result + " items were modified.";
    }

}
