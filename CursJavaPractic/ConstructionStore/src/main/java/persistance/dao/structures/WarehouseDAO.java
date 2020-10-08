package persistance.dao.structures;

import business.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistance.entities.structures.Warehouse;

import java.util.List;


@Repository
public class WarehouseDAO {


    public Warehouse findWarehouse(String city, String address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findWarehouseQuery = session.createNamedQuery("findWarehouse");
        findWarehouseQuery.setParameter("city", city);
        findWarehouseQuery.setParameter("address", address);
        Warehouse warehouseFound = (Warehouse) findWarehouseQuery.uniqueResult();
        session.getTransaction().commit();
        session.close();
        Warehouse warehouse = new Warehouse();
        if (warehouseFound == null) {
            warehouse.setName(" ");
            warehouse.setCity(" ");
            warehouse.setAddress(" ");
            return warehouse;
        } else {
            return warehouseFound;
        }
    }


}