package persistance.entities.finance;

import persistance.entities.accounts.ClientAccount;
import persistance.entities.products.Cement;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToMany(mappedBy = "shoppingCartSet",cascade = CascadeType.ALL)
    private Set<ClientAccount> clientAccountSet;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "shopping_carts_cements",
    joinColumns = {@JoinColumn(name = "shopping_carts_id")},
    inverseJoinColumns = {@JoinColumn(name = "cements_id")})
    private Set<Cement> cementSet;





    public ShoppingCart(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<ClientAccount> getClientAccountSet() {
        return clientAccountSet;
    }

    public void setClientAccountSet(Set<ClientAccount> clientAccountSet) {
        this.clientAccountSet = clientAccountSet;
    }

    public Set<Cement> getCementSet() {
        return cementSet;
    }

    public void setCementSet(Set<Cement> cementSet) {
        this.cementSet = cementSet;
    }
}
