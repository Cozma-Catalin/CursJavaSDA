package persistance.dao.products;

import bussiness.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistance.entities.products.Paint;

@Repository
public class PaintDAO {


    public void insertPaint(Paint paint) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(paint);
        session.getTransaction().commit();
        session.close();

    }

    public int deletePaintByBrand(String brand) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deletePaintByBrandQuery = session.createNamedQuery("deletePaintByBrand");
        deletePaintByBrandQuery.setParameter("brand", brand);
        int result = deletePaintByBrandQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Paint findPaintByBrand(String brand) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findPaintByBrandQuery = session.createNamedQuery("findPaintByBrand");
        findPaintByBrandQuery.setParameter("brand", brand);
        Paint paint = (Paint) findPaintByBrandQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return paint;
    }

    public int updatePaintPrice( double price,String brand) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query modifyPaintPriceQuery = session.createNamedQuery("updatePaintPrice");
        modifyPaintPriceQuery.setParameter("price", price);
        modifyPaintPriceQuery.setParameter("brand", brand);
        int result = modifyPaintPriceQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int updatePaintQuantity(double quantity,String brand){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query modifyPaintQuantityQuery = session.createNamedQuery("updatePaintQuantity");
        modifyPaintQuantityQuery.setParameter("quantity", quantity);
        modifyPaintQuantityQuery.setParameter("brand", brand);
        int result = modifyPaintQuantityQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Long countPaintByBrand(String brand) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countPaintByBrandQuery = session.createNamedQuery("countPaintByBrand");
        countPaintByBrandQuery.setParameter("brand", brand);
        Long result = (Long) countPaintByBrandQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
