package persistance.entities.products;

import persistance.entities.structures.Department;
import persistance.entities.structures.Warehouse;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "findScrewdriverByBrand", query = "select screwdriver from Screwdriver screwdriver where brand= :brand"),
        @NamedQuery(name = "deleteScrewdriverByBrand", query = "delete from Screwdriver where brand= :brand"),
        @NamedQuery(name = "updateScrewdriverPrice", query = "update from Screwdriver screwdriver set price= :price where brand= :brand"),
        @NamedQuery(name = "updateScrewdriverQuantity",query = "update from Screwdriver screwdriver set quantity= :quantity where brand= :brand"),
        @NamedQuery(name = "countScrewdriverByBrand",query = "select count(*) from Screwdriver screwdriver where brand= :brand")
})

@Entity
@Table(name = "screwdrivers")
public class Screwdriver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "head_type")
    private String headType;
    @Column(name = "size")
    private String size;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private double quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departments_id")
    private Department department;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    @JoinTable(name = "screwdrivers_warehouses",
            joinColumns = {@JoinColumn(name = "screwdrivers_id")},
            inverseJoinColumns = {@JoinColumn(name = "warehouses_id")}
    )
    private Set<Warehouse> warehouseSet;

    public Screwdriver(String brand, String headType, String size, double price, double quantity) {

        this.brand = brand;
        this.headType = headType;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public Screwdriver() {
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

    public String getHeadType() {
        return headType;
    }

    public void setHeadType(String headType) {
        this.headType = headType;
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
    public String toString() {
        return "Screwdriver: " + "brand: " + brand + ", headType: " + headType + ", size: " + size + ", price: " + price + ", quantity: " + quantity + ", department: " + department + ",warehouses: " + warehouseSet;
    }
}
