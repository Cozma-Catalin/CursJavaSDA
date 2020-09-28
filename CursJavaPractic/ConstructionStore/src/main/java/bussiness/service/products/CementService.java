package bussiness.service.products;

import bussiness.dto.products.chemicals.CementDTO;
import bussiness.dto.structures.DepartmentDTO;
import bussiness.dto.structures.WarehouseDTO;
import bussiness.service.structures.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistance.dao.products.CementDAO;
import persistance.dao.structures.DepartmentDAO;
import persistance.dao.structures.WarehouseDAO;
import persistance.entities.products.Chemicals.Cement;
import persistance.entities.structures.Department;
import persistance.entities.structures.Warehouse;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CementService {

    @Autowired
    CementDAO cementDAO;
    @Autowired
    DepartmentDAO departmentDAO;
    @Autowired
    WarehouseDAO warehouseDAO;
   
    public void insertCementDTO(CementDTO cementDTO) {
        Cement cement = new Cement();
        checkIfCementDepartmentExists(cementDTO, cement);
        checkIfCementWarehouseExists(cementDTO, cement);

        cement.setBrand(cementDTO.getBrand());
        cement.setSize(cementDTO.getSize());
        cement.setPrice(cementDTO.getPrice());
        cement.setQuantity(cementDTO.getQuantity());

        cementDAO.insertCement(cement);
    }

    public void checkIfCementDepartmentExists(CementDTO cementDTO, Cement cement) {
        Department departmentFound = departmentDAO.findDepartmentByName(cementDTO.getDepartmentDTO().getName());
        Department department = new Department();
        if (departmentFound.getName().equalsIgnoreCase(cementDTO.getDepartmentDTO().getName())) {
            department.setId(departmentFound.getId());
            department.setName(departmentFound.getName());
        } else {
            department.setName(cementDTO.getDepartmentDTO().getName());
        }
        cement.setDepartment(department);
    }


    public void checkIfCementWarehouseExists(CementDTO cementDTO, Cement cement) {
        Set<Warehouse> warehouseSet = new HashSet<>();
        Warehouse warehouse = new Warehouse();
        for (WarehouseDTO warehouseDTO : cementDTO.getWarehouseDTOSet()) {
            List<Warehouse> warehouseList = warehouseDAO.findWarehouseList(warehouseDTO.getName(), warehouseDTO.getCity());
            if (warehouseList.isEmpty()) {
                warehouse.setName(warehouseDTO.getName());
                warehouse.setCity(warehouseDTO.getCity());
                warehouse.setAddress(warehouseDTO.getAddress());
                warehouseSet.add(warehouse);
            } else {
                warehouseSet.addAll(warehouseList);
            }
        }
        cement.setWarehouseSet(warehouseSet);
    }


    public Long countCementDTO(String brand) {
        Long result = cementDAO.countCement(brand);
        return result;
    }


    public CementDTO findCementDTOByBrand(String brand) {
        CementDTO cementDTO = new CementDTO();
        Cement cement = cementDAO.findCementByBrand(brand);
        cementDTO.setBrand(cement.getBrand());
        cementDTO.setSize(cement.getSize());
        cementDTO.setPrice(cement.getPrice());
        cementDTO.setQuantity(cement.getQuantity());

        departmentDAO.extractDepartmentDTOFromCement(cementDTO, cement);
        warehouseDAO.extractWarehouseDTOFromCement(cementDTO, cement);
        return cementDTO;
    }



    public int deleteCementDTOByBrand(String brand){
        int result = cementDAO.deleteCementByBrand(brand);
        return result ;
    }

    public int updateCementPrice(String brand,double price){
        int result = cementDAO.updateCementPrice(brand,price);
        return result;
    }

    public int updateCementQuantity(String brand,double quantity){
        int result = cementDAO.updateCementQuantity(brand,quantity);
        return result;
    }
}
