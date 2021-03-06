package persistance.entities.products;


import persistance.entities.structures.Department;
import persistance.entities.structures.Warehouse;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "findCementByBrand", query = "select cement from Cement cement where brand= :brand"),
        @NamedQuery(name = "deleteCementByBrand", query = "delete from Cement where brand= :brand"),
        @NamedQuery(name = "updateCementPrice", query = "update from Cement cement set price= :price where brand= :brand"),
        @NamedQuery(name = "updateCementQuantity", query = "update from Cement cement set quantity= :quantity where brand= :brand"),
        @NamedQuery(name = "countCementByBrand", query = "select count(*) from Cement cement where brand= :brand")
})

@Entity
@Table(name = "cements")
public class Cement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "size")
    private String size;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private double quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departments_id")
    private Department department;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "cements_warehouses",
            joinColumns = {@JoinColumn(name = "cements_id")},
            inverseJoinColumns = {@JoinColumn(name = "warehouses_id")}
    )
    private Set<Warehouse> warehouseSet;


    public Cement(String brand, String size, double price, double quantity, Department department) {
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
        this.department = department;
    }

    public Cement(String brand, String size, double price, double quantity, Department department, Set<Warehouse> warehouses) {
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
        this.department = department;
        this.warehouseSet = warehouses;
    }

    public Cement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Warehouse> getWarehouseSet() {
        return warehouseSet;
    }

    public void setWarehouseSet(Set<Warehouse> warehouseSet) {
        this.warehouseSet = warehouseSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cement cement = (Cement) o;
        return Double.compare(cement.price, price) == 0 &&
                Double.compare(cement.quantity, quantity) == 0 &&
                Objects.equals(brand, cement.brand) &&
                Objects.equals(size, cement.size) &&
                Objects.equals(department, cement.department) &&
                Objects.equals(warehouseSet, cement.warehouseSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, size, price, quantity, department, warehouseSet);
    }

    @Override
    public String toString() {
        return "Cement: " + "brand: " + brand + ", size: " + size + ", price: " + price + ", quantity: " + quantity + ", department: " + department + ",warehouses: " + warehouseSet;
    }
}
