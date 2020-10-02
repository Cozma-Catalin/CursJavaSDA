package persistance.dao.products;

import bussiness.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistance.entities.finance.ShoppingCart;
import persistance.entities.products.Cement;
import java.util.HashSet;
import java.util.Set;



@Repository
public class CementDAO {

    public void insertCement(Cement cement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(cement);
        session.getTransaction().commit();
        session.close();
    }

    public Cement findCementByBrand(String brand) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findCementByBrandQuery = session.createNamedQuery("findCementByBrand");
        findCementByBrandQuery.setParameter("brand", brand);
        Cement cement = (Cement) findCementByBrandQuery.getSingleResult();
        if(cement == null){
            cement.setBrand(" ");
        }
        session.getTransaction().commit();
        session.close();
        return cement;
    }


    public int deleteCementByBrand(String brand) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteCementByBrandQuery = session.createNamedQuery("deleteCementByBrand");
        deleteCementByBrandQuery.setParameter("brand", brand);
        int result = deleteCementByBrandQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }


    public Long countCementByBrand(String brand) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countCementQuery = session.createNamedQuery("countCementByBrand");
        countCementQuery.setParameter("brand", brand);
        Long result = (Long) (countCementQuery.getSingleResult());
        session.getTransaction().commit();
        session.close();
        return result;
    }


    public int updateCementPrice(String brand, double price) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateCementPriceQuery = session.createNamedQuery("updateCementPrice");
        updateCementPriceQuery.setParameter("price", price);
        updateCementPriceQuery.setParameter("brand", brand);
        int result = updateCementPriceQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int updateCementQuantity(String brand, double quantity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateCementQuantityQuery = session.createNamedQuery("updateCementQuantity");
        updateCementQuantityQuery.setParameter("quantity", quantity);
        updateCementQuantityQuery.setParameter("brand", brand);
        int result = updateCementQuantityQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }


    public void addCementToCart(String brand, double quantity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ShoppingCart shoppingCart = new ShoppingCart();
        Set<Cement> cementSet = new HashSet<>();
        Cement cement = findCementByBrand(brand);
        cement.setQuantity(quantity);
        cementSet.add(cement);
        shoppingCart.setCementSet(cementSet);
        session.save(shoppingCart);
        session.getTransaction().commit();
        session.close();
    }
}
