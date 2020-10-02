package bussiness.service.products;

import bussiness.dto.products.PaintDTO;
import bussiness.dto.structures.DepartmentDTO;
import bussiness.dto.structures.WarehouseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistance.dao.products.PaintDAO;
import persistance.dao.structures.DepartmentDAO;
import persistance.dao.structures.WarehouseDAO;
import persistance.entities.products.Paint;
import persistance.entities.structures.Department;
import persistance.entities.structures.Warehouse;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PaintService {

    @Autowired
    PaintDAO paintDAO;
    @Autowired
    WarehouseDAO warehouseDAO;
    @Autowired
    DepartmentDAO departmentDAO;

    public Long countPaintDTOByBrand(String brand) {
        Long result = paintDAO.countPaintByBrand(brand);
        return result;
    }

    public void insertPaintDTO(PaintDTO paintDTO) {
        Paint paint = new Paint();
        paint.setBrand(paintDTO.getBrand());
        paint.setColor(paintDTO.getColor());
        paint.setSize(paintDTO.getSize());
        paint.setUsage(paintDTO.getUsage());
        paint.setPrice(paintDTO.getPrice());
        paint.setQuantity(paintDTO.getQuantity());

        setPaintDepartment(paintDTO, paint);
        setPaintWarehouse(paintDTO, paint);

        paintDAO.insertPaint(paint);
    }

    private void setPaintDepartment(PaintDTO paintDTO, Paint paint) {
        Department departmentFound = departmentDAO.findDepartmentByName(paintDTO.getDepartmentDTO().getName());
        Department department = new Department();
        if (departmentFound.getName().equalsIgnoreCase(paintDTO.getDepartmentDTO().getName())) {
            department.setId(departmentFound.getId());
            department.setName(departmentFound.getName());
        }else{
            department.setName(paintDTO.getDepartmentDTO().getName());
        }
        paint.setDepartment(department);
    }

    private void setPaintWarehouse(PaintDTO paintDTO, Paint paint) {
        Set<Warehouse> warehouseSet = new HashSet<>();
        Warehouse warehouse = new Warehouse();
        for (WarehouseDTO warehouseDTO : paintDTO.getWarehouseDTOSet()) {
            List<Warehouse> warehouseFoundList = warehouseDAO.findWarehouse(warehouseDTO.getCity(),warehouseDTO.getAddress());
            if (warehouseFoundList.isEmpty()) {
                warehouse.setName(warehouseDTO.getName());
                warehouse.setCity(warehouseDTO.getCity());
                warehouse.setAddress(warehouseDTO.getAddress());
                warehouseSet.add(warehouse);
            } else {
                warehouseSet.addAll(warehouseFoundList);
            }
        }
        paint.setWarehouseSet(warehouseSet);

    }

    public int deletePaintByBrand(String brand){
        int result = paintDAO.deletePaintByBrand(brand);
        return result;
    }

    public PaintDTO findPaintDTOByBrand(String brand){
        Paint paint = paintDAO.findPaintByBrand(brand);
        PaintDTO paintDTO = new PaintDTO();
        paintDTO.setBrand(paint.getBrand());
        paintDTO.setColor(paint.getColor());
        paintDTO.setUsage(paint.getUsage());
        paintDTO.setSize(paint.getSize());
        paintDTO.setPrice(paint.getPrice());
        paintDTO.setQuantity(paint.getQuantity());

        extractDepartmentDTOFromPaint(paintDTO, paint);
        extractWarehouseDTOSetFromPaint(paintDTO, paint);

        return paintDTO;
    }

    private void extractWarehouseDTOSetFromPaint(PaintDTO paintDTO, Paint paint) {
        Set<WarehouseDTO> warehouseDTOSet = new HashSet<>();
        for(Warehouse warehouse : paint.getWarehouseSet()){
            WarehouseDTO warehouseDTO = new WarehouseDTO();
            warehouseDTO.setName(warehouse.getName());
            warehouseDTO.setCity(warehouse.getCity());
            warehouseDTO.setAddress(warehouse.getAddress());
            warehouseDTOSet.add(warehouseDTO);
        }
        paintDTO.setWarehouseDTOSet(warehouseDTOSet);
    }

    private void extractDepartmentDTOFromPaint(PaintDTO paintDTO, Paint paint) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(paint.getDepartment().getName());
        paintDTO.setDepartmentDTO(departmentDTO);
    }

    public int updatePaintPrice(double price,String brand){
        int result = paintDAO.updatePaintPrice(price,brand);
        return result;
    }

    public int updatePaintQuantity(double quantity,String brand){
        int result = paintDAO.updatePaintQuantity(quantity,brand);
        return result;
    }
}