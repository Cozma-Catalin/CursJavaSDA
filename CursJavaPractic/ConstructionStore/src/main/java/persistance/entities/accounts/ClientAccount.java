package persistance.entities.accounts;

import persistance.entities.finance.ShoppingCart;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client_account")
public class ClientAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "client_shopping_cart",
            joinColumns = {@JoinColumn(name = "clients_id")},
            inverseJoinColumns = {@JoinColumn(name = "shopping_carts_id")
    })
    private Set<ShoppingCart> shoppingCartSet;


    public ClientAccount(){}

    public ClientAccount(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<ShoppingCart> getShoppingCartSet() {
        return shoppingCartSet;
    }

    public void setShoppingCartSet(Set<ShoppingCart> shoppingCartSet) {
        this.shoppingCartSet = shoppingCartSet;
    }

    @Override
    public String toString() {
        return "ClientAccount: " + name + " " + surname + ", email: " + email + ", password: " + password + ", shopping cart: " + shoppingCartSet ;
    }
}
