package business.dto.products;

import business.dto.structures.DepartmentDTO;
import business.dto.structures.WarehouseDTO;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class ScrewdriverDTO {
    @NotNull
    private String brand;
    @NotNull
    private String size;
    @NotNull
    private String headType;
    @NotNull
    private double price;
    @NotNull
    private double quantity;
    private DepartmentDTO departmentDTO;
    private Set<WarehouseDTO> warehouseDTOSet;

    public ScrewdriverDTO(){}

    public ScrewdriverDTO(String brand, String size, String headType, double price, double quantity, DepartmentDTO departmentDTO, Set<WarehouseDTO> warehouseDTOSet) {
        this.brand = brand;
        this.size = size;
        this.headType = headType;
        this.price = price;
        this.quantity = quantity;
        this.departmentDTO = departmentDTO;
        this.warehouseDTOSet = warehouseDTOSet;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getHeadType() {
        return headType;
    }

    public void setHeadType(String headType) {
        this.headType = headType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }

    public void setDepartmentDTO(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }

    public Set<WarehouseDTO> getWarehouseDTOSet() {
        return warehouseDTOSet;
    }

    public void setWarehouseDTOSet(Set<WarehouseDTO> warehouseDTOSet) {
        this.warehouseDTOSet = warehouseDTOSet;
    }

    @Override
    public String toString() {
        return "ScrewdriverDTO: " + brand + ", size: " + size + ", headType: " + headType + ", price: " + price + ", quantity: " + quantity + ",department: " + departmentDTO + ",warehouses: " + warehouseDTOSet ;
    }
}
