package bussiness.service.products;

import bussiness.dto.products.ScrewdriverDTO;
import bussiness.dto.structures.DepartmentDTO;
import bussiness.dto.structures.WarehouseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistance.dao.products.ScrewdriverDAO;
import persistance.dao.structures.DepartmentDAO;
import persistance.dao.structures.WarehouseDAO;
import persistance.entities.products.Screwdriver;
import persistance.entities.structures.Department;
import persistance.entities.structures.Warehouse;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ScrewdriverService {

    @Autowired
    ScrewdriverDAO screwdriverDAO;
    @Autowired
    WarehouseDAO warehouseDAO;
    @Autowired
    DepartmentDAO departmentDAO;

    public void insertScrewdriverDTO(ScrewdriverDTO screwdriverDTO) {
        Screwdriver screwdriver = new Screwdriver();
        screwdriver.setBrand(screwdriverDTO.getBrand());
        screwdriver.setHeadType(screwdriverDTO.getHeadType());
        screwdriver.setSize(screwdriverDTO.getSize());
        screwdriver.setPrice(screwdriverDTO.getPrice());
        screwdriver.setQuantity(screwdriverDTO.getQuantity());
        setScrewdriverDepartment(screwdriverDTO, screwdriver);
        setScrewdriverWarehouseSet(screwdriverDTO, screwdriver);

        screwdriverDAO.insertScrewdriver(screwdriver);
    }

    private void setScrewdriverWarehouseSet(ScrewdriverDTO screwdriverDTO, Screwdriver screwdriver) {
        Set<Warehouse> warehouseSet = new HashSet<>();
        Warehouse warehouse = new Warehouse();
        for (WarehouseDTO warehouseDTO : screwdriverDTO.getWarehouseDTOSet()) {
            List<Warehouse> warehouseList = warehouseDAO.findWarehouse(warehouseDTO.getCity(), warehouseDTO.getAddress());
            if (warehouseList.isEmpty()) {
                warehouse.setName(warehouseDTO.getName());
                warehouse.setCity(warehouseDTO.getCity());
                warehouse.setAddress(warehouseDTO.getAddress());
                warehouseSet.add(warehouse);
            } else {
                warehouseSet.addAll(warehouseList);
            }
            screwdriver.setWarehouseSet(warehouseSet);
        }
    }
        private void setScrewdriverDepartment (ScrewdriverDTO screwdriverDTO, Screwdriver screwdriver){
            Department departmentFound = departmentDAO.findDepartmentByName(screwdriverDTO.getDepartmentDTO().getName());
            Department department = new Department();
            if(departmentFound.getName().equalsIgnoreCase(screwdriverDTO.getDepartmentDTO().getName())) {
                department.setId(departmentFound.getId());
                department.setName(departmentFound.getName());
            }else {
                department.setName(screwdriverDTO.getDepartmentDTO().getName());
            }
                screwdriver.setDepartment(department);
        }

        public Long countScrewdriverDTOByBrand (String brand){
            Long result = screwdriverDAO.countScrewdriverByBrand(brand);
            return result;
        }

        public ScrewdriverDTO findScrewdriverDTOByBrand (String brand){
            Screwdriver screwdriver = screwdriverDAO.findScrewdriverByBrand(brand);
            ScrewdriverDTO screwdriverDTO = new ScrewdriverDTO();
            screwdriverDTO.setBrand(screwdriver.getBrand());
            screwdriverDTO.setSize(screwdriver.getSize());
            screwdriverDTO.setHeadType(screwdriver.getHeadType());
            screwdriverDTO.setPrice(screwdriver.getPrice());
            screwdriverDTO.setQuantity(screwdriver.getQuantity());

            extractDepartmentDTOFromScrewdriver(screwdriverDTO, screwdriver);
            extractWarehouseDTOFromScrewdriver(screwdriverDTO, screwdriver);

            return screwdriverDTO;
        }

        private void extractWarehouseDTOFromScrewdriver (ScrewdriverDTO screwdriverDTO, Screwdriver screwdriver){
            Set<WarehouseDTO> warehouseDTOSet = new HashSet<>();
            for (Warehouse warehouse : screwdriver.getWarehouseSet()) {
                WarehouseDTO warehouseDTO = new WarehouseDTO();
                warehouseDTO.setName(warehouse.getName());
                warehouseDTO.setCity(warehouse.getCity());
                warehouseDTO.setAddress(warehouse.getAddress());
                warehouseDTOSet.add(warehouseDTO);
            }
            screwdriverDTO.setWarehouseDTOSet(warehouseDTOSet);
        }

        private void extractDepartmentDTOFromScrewdriver (ScrewdriverDTO screwdriverDTO, Screwdriver screwdriver){
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setName(screwdriver.getDepartment().getName());
            screwdriverDTO.setDepartmentDTO(departmentDTO);
        }

        public int deleteScrewdriverDTOByBrand (String brand){
            int result = screwdriverDAO.deleteScrewdriverByBrand(brand);
            return result;
        }

        public int updateScrewdriverDTOPrice ( double price, String brand){
            int result = screwdriverDAO.updateScrewdriverPrice(price, brand);
            return result;
        }

        public int updateScrewdriverDTOQuantity ( double quantity, String brand){
            int result = screwdriverDAO.updateScrewdriverQuantity(quantity, brand);
            return result;
        }
    }
