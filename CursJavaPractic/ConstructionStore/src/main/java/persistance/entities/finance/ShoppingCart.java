package persistance.entities.finance;

import persistance.entities.accounts.ClientAccount;
import persistance.entities.products.Cement;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    public ShoppingCart() {
    }


}
