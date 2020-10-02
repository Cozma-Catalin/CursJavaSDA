package persistance.dao.structures;

import bussiness.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistance.entities.structures.Warehouse;

import java.util.List;


@Repository
public class WarehouseDAO {


    public List<Warehouse> findWarehouse(String city, String address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findWarehouseQuery = session.createNamedQuery("findWarehouse");
        findWarehouseQuery.setParameter("city", city);
        findWarehouseQuery.setParameter("address",address);
        List<Warehouse> warehouseFoundList = findWarehouseQuery.getResultList();
        /*if(!warehouseFound.getAddress().equalsIgnoreCase(address)){
            warehouseFound.setName(" ");
            warehouseFound.setCity(" ");
            warehouseFound.setAddress(" ");
        }*/
        session.getTransaction().commit();
        session.close();
        return warehouseFoundList;
    }


}