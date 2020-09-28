package persistance.entities.products.Chemicals;

import persistance.entities.structures.Department;
import persistance.entities.structures.Warehouse;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "findPaintByBrand", query = "select paint from Paint paint where brand= :brand"),
        @NamedQuery(name = "deletePaintByBrand", query = "delete from Paint where brand= :brand"),
        @NamedQuery(name = "modifyPaintPrice", query = "update from Paint paint set price= :price where brand= :brand")
})
@Entity
@Table(name = "paints")
public class Paint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "size")
    private String size;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "color")
    private String color;
    @Column(name = "used_for")
    private String usage;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departments_id")
    private Department department;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
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
