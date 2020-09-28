package bussiness.dto.products.chemicals;

import bussiness.dto.structures.DepartmentDTO;
import bussiness.dto.structures.WarehouseDTO;

import java.util.Set;

public class PaintDTO {
    private String brand;
    private String size;
    private String color;
    private String usage;
    private double price;
    private double quantity;
    private DepartmentDTO departmentDTO;
    private Set<WarehouseDTO> warehouseDTOSet;

    public PaintDTO() {
    }

    public PaintDTO(String brand, String size, String color, String usage, double price, double quantity, DepartmentDTO departmentDTO, Set<WarehouseDTO> warehouseDTOSet) {
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.usage = usage;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
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
        return "PaintDTO: " + brand + ", size: " + size + ", color: " + color + ", usage: " + usage + ", price: " + price + ", quantity: " + quantity + ",department: " + departmentDTO + ",warehouses: " + warehouseDTOSet;
    }
}
