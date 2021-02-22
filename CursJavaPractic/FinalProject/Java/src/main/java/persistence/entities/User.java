package persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "findUserByEmail", query = "select user from User user where user.email= :email"),
        @NamedQuery(name = "countEmail", query = "select count(email) from User where email= :email "),
        @NamedQuery(name = "updateUserLogIn",query = "update from User set loggedIn= :loggedIn where email= :email"),
        @NamedQuery(name = "checkRegistration", query = "select password from User where email= :email and password= :password"),
        @NamedQuery(name = "findUserAccount", query = "select user from User user where email= :email and password= :password"),


})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
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

    @Column(name = "password")
    private String password;

    @Column(name = "logged_in")
    private boolean loggedIn;

    @OneToMany(mappedBy = "user")
    private Set<PurchasedTrip> purchasedTripSet;

}
