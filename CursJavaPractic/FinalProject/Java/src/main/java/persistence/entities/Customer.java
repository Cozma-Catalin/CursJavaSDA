package persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "findCustomerByEmail", query = "select customer from Customer customer where customer.email= :email"),
        @NamedQuery(name = "countEmail", query = "select count(email) from Customer where email= :email "),
        @NamedQuery(name = "findCustomerAccount", query = "select customer from Customer customer inner join customer.account account where account.userName= :userName and account.password= :password"),
        @NamedQuery(name = "findCustomerByUserName",query = "select customer from Customer customer inner join customer.account account where account.userName= :userName")

})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_of_birth")
    private java.sql.Date birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accounts_id")
    private Account account;

    @OneToMany(mappedBy = "customer")
    private Set<PurchasedTrip> purchasedTripSet;

}
