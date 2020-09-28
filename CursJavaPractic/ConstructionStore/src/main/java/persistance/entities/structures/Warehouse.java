package persistance.entities.structures;

import persistance.entities.products.Chemicals.Cement;
import persistance.entities.products.Chemicals.Paint;
import persistance.entities.products.Tools.Screwdriver;

import javax.persistence.*;
import java.util.Set;
@NamedQueries({
        @NamedQuery(name = "findWarehouse",query = "select warehouse from Warehouse warehouse where name= :name and city= :city")
})

@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @ManyToMany(mappedBy = "warehouseSet",cascade = CascadeType.ALL)
    private Set<Cement> cementSet;
    @ManyToMany(mappedBy = "warehouseSet",cascade = CascadeType.ALL)
    private Set<Paint> paintSet;
    @ManyToMany(mappedBy = "warehouseSet",cascade = CascadeType.ALL)
    private Set<Screwdriver> screwdriverSet;

    public Warehouse(String name,String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public Warehouse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Cement> getCementSet() {
        return cementSet;
    }

    public void setCementSet(Set<Cement> cementSet) {
        this.cementSet = cementSet;
    }

    public Set<Paint> getPaintSet() {
        return paintSet;
    }

    public void setPaintSet(Set<Paint> paintSet) {
        this.paintSet = paintSet;
    }

    public Set<Screwdriver> getScrewdriverSet() {
        return screwdriverSet;
    }

    public void setScrewdriverSet(Set<Screwdriver> screwdriverSet) {
        this.screwdriverSet = screwdriverSet;
    }


    @Override
    public String toString() {
        return "Warehouse: " + name + ",city: " + city + ", address:" + address;
    }
}
