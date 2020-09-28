package persistance.dao.structures;

import bussiness.config.HibernateUtil;
import bussiness.dto.products.chemicals.CementDTO;
import bussiness.dto.structures.WarehouseDTO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistance.entities.products.Chemicals.Cement;
import persistance.entities.structures.Warehouse;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class WarehouseDAO {


    public List<Warehouse> findWarehouseList(String name, String city) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findWarehouseQuery = session.createNamedQuery("findWarehouse");
        findWarehouseQuery.setParameter("name", name);
        findWarehouseQuery.setParameter("city", city);
        List<Warehouse> warehouseFoundList = findWarehouseQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return warehouseFoundList;
    }

    public void extractWarehouseDTOFromCement(CementDTO cementDTO, Cement cement) {
        Set<WarehouseDTO> warehouseDTOSet = new HashSet<>();
        for (Warehouse warehouse : cement.getWarehouseSet()) {
            WarehouseDTO warehouseDTO = new WarehouseDTO();
            warehouseDTO.setCity(warehouse.getCity());
            warehouseDTO.setAddress(warehouse.getAddress());
            warehouseDTOSet.add(warehouseDTO);
        }
        cementDTO.setWarehouseDTOSet(warehouseDTOSet);
    }

}