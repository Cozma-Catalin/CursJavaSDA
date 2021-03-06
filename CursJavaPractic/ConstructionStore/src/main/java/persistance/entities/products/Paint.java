package persistance.entities.products;

import persistance.entities.structures.Department;
import persistance.entities.structures.Warehouse;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "findPaintByBrand", query = "select paint from Paint paint where brand= :brand"),
        @NamedQuery(name = "deletePaintByBrand", query = "delete from Paint where brand= :brand"),
        @NamedQuery(name = "updatePaintPrice", query = "update from Paint paint set price= :price where brand= :brand"),
        @NamedQuery(name = "updatePaintQuantity",query = "update from Paint paint set quantity= :quantity where brand= :brand"),
        @NamedQuery(name = "countPaintByBrand",query = "select count(*) from Paint paint where brand= :brand")
})
@Entity
@Table(name = "paints")
public class Paint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "color")
    private String color;
    @Column(name = "size")
    private String size;
    @Column(name = "used_for")
    private String usage;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private double quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departments_id")
    private Department department;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "paints_warehouses",
            joinColumns = {@JoinColumn(name = "paints_id")},
            inverseJoinColumns = {@JoinColumn(name = "warehouses_id")}
    )
    private Set<Warehouse> warehouseSet;

    public Paint(String brand, String size, Double price, double quantity, String color, String usage) {

        this.brand = brand;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.usage = usage;
    }

    public Paint(String brand, String color, String size, String usage, double price, double quantity, Department department) {
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.usage = usage;
        this.price = price;
        this.quantity = quantity;
        this.department = department;
    }

    public Paint(String brand, String color, String size, String usage, double price, double quantity, Department department, Set<Warehouse> warehouseSet) {
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.usage = usage;
        this.price = price;
        this.quantity = quantity;
        this.department = department;
        this.warehouseSet = warehouseSet;
    }

    public Paint() {
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
    public String toString() {
        return "Paint: " + ", brand: " + brand + ", color: " + color + ", size: " + size + ", usage: " + usage + ", price=" + price + ", quantity=" + quantity + ", department: " + department + ",warehouses: " + warehouseSet;
    }
}
