package bussiness.service.products;

import bussiness.dto.finance.ShoppingCartDTO;
import bussiness.dto.products.CementDTO;
import bussiness.dto.structures.DepartmentDTO;
import bussiness.dto.structures.WarehouseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistance.dao.products.CementDAO;
import persistance.dao.structures.DepartmentDAO;
import persistance.dao.structures.WarehouseDAO;
import persistance.entities.products.Cement;
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

    public void addCementDTOtoCart(String brand,double quantity){
        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        Set<CementDTO> cementDTOSet = new HashSet<>();
        CementDTO cementDTO = findCementDTOByBrand(brand);
        cementDTO.setQuantity(quantity);
        cementDTOSet.add(cementDTO);
        shoppingCartDTO.setCementDTOSet(cementDTOSet);
    }

    public void insertCementDTO(CementDTO cementDTO) {
        Cement cement = new Cement();
        cement.setBrand(cementDTO.getBrand());
        cement.setSize(cementDTO.getSize());
        cement.setPrice(cementDTO.getPrice());
        cement.setQuantity(cementDTO.getQuantity());

        setCementDepartment(cementDTO, cement);
        setCementWarehouse(cementDTO, cement);


        cementDAO.insertCement(cement);
    }

    public void setCementDepartment(CementDTO cementDTO, Cement cement) {
        Department departmentFound = departmentDAO.findDepartmentByName(cementDTO.getDepartmentDTO().getName());
        Department department = new Department();
        if (departmentFound.getName().equalsIgnoreCase(cementDTO.getDepartmentDTO().getName())) {
           department.setId(departmentFound.getId());
           department.setName(departmentFound.getName());
        }else {
            department.setName(cementDTO.getDepartmentDTO().getName());
        }
        cement.setDepartment(department);

    }

    public void setCementWarehouse(CementDTO cementDTO, Cement cement) {
        Set<Warehouse> warehouseSet = new HashSet<>();
        Warehouse warehouse = new Warehouse();
        for (WarehouseDTO warehouseDTO : cementDTO.getWarehouseDTOSet()) {
           List<Warehouse> warehouseFoundList = warehouseDAO.findWarehouse( warehouseDTO.getCity(),warehouseDTO.getAddress());
            if (!warehouseFoundList.isEmpty()) {
                warehouse.setName(warehouseDTO.getName());
                warehouse.setCity(warehouseDTO.getCity());
                warehouse.setAddress(warehouseDTO.getAddress());
                warehouseSet.add(warehouse);
            } else {
                warehouseSet.addAll(warehouseFoundList);
            }
        }
        cement.setWarehouseSet(warehouseSet);
    }



    public Long countCementDTOByBrand(String brand) {
        Long result = cementDAO.countCementByBrand(brand);
        return result;
    }


    public CementDTO findCementDTOByBrand(String brand) {
        CementDTO cementDTO = new CementDTO();
        Cement cement = cementDAO.findCementByBrand(brand);
        if(!cement.getBrand().equalsIgnoreCase(brand)){
            cementDTO.setBrand(" ");
        }
        cementDTO.setBrand(cement.getBrand());
        cementDTO.setSize(cement.getSize());
        cementDTO.setPrice(cement.getPrice());
        cementDTO.setQuantity(cement.getQuantity());

        extractDepartmentDTOFromCement(cementDTO, cement);
        extractWarehouseDTOFromCement(cementDTO, cement);

        return cementDTO;
    }

    public void extractDepartmentDTOFromCement(CementDTO cementDTO, Cement cement) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(cement.getDepartment().getName());
        cementDTO.setDepartmentDTO(departmentDTO);
    }

    public void extractWarehouseDTOFromCement(CementDTO cementDTO, Cement cement) {
        Set<WarehouseDTO> warehouseDTOSet = new HashSet<>();
        for (Warehouse warehouse : cement.getWarehouseSet()) {
            WarehouseDTO warehouseDTO = new WarehouseDTO();
            warehouseDTO.setName(warehouse.getName());
            warehouseDTO.setCity(warehouse.getCity());
            warehouseDTO.setAddress(warehouse.getAddress());
            warehouseDTOSet.add(warehouseDTO);
        }
        cementDTO.setWarehouseDTOSet(warehouseDTOSet);
    }


    public int deleteCementDTOByBrand(String brand) {
        int result = cementDAO.deleteCementByBrand(brand);
        return result;
    }

    public int updateCementDTOPrice(String brand, double price) {
        int result = cementDAO.updateCementPrice(brand, price);
        return result;
    }

    public int updateCementDTOQuantity(String brand, double quantity) {
        int result = cementDAO.updateCementQuantity(brand, quantity);
        return result;
    }


}
