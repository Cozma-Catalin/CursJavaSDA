package entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Price_Change", query = "update Product set price= price+2*(price/10)"),
        @NamedQuery(name = "Display_Version", query = "select version from Product version where name= :name"),
        @NamedQuery(name = "Delete_Product", query = "delete Product where clients<= 10"),
        @NamedQuery(name = "Display_Product", query = "select product from Product product where clients>= 200")
})
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "products_name")
    private String name;
    @Column(name = "version")
    private String version;
    @Column(name = "price")
    private int price;
    @Column(name = "clients")
    private int clients;


    public Product() {

    }

    public Product(String name, String version, int price, int clients) {
        this.name = name;
        this.version = version;
        this.price = price;
        this.clients = clients;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getClients() {
        return clients;
    }

    public void setClients(int clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return name + ", " + version + ", " + price + ", " + clients;
    }
}
