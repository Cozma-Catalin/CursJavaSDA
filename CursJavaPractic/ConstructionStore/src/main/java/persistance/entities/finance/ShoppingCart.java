package persistance.entities.finance;

import persistance.entities.accounts.ClientAccount;

import javax.persistence.*;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(mappedBy = "shoppingCart")
    private ClientAccount clientAccount;
    public ShoppingCart(){}

    public ShoppingCart(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }

    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }

    @Override
    public String toString() {
        return "ShoppingCart: "  ;
    }
}
