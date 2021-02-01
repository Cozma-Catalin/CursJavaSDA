package persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@NamedQueries({
        @NamedQuery(name = "findAccount", query = "select account from Account account where account.userName= :userName and account.password= :password"),
        @NamedQuery(name = "checkRegistration", query = "select password from Account where userName= :userName and password= :password"),
        @NamedQuery(name = "deleteAccount", query = "delete from Account where userName= :userName"),
        @NamedQuery(name = "countAccountUserName", query = "select count(userName) from Account where userName= :userName "),
        @NamedQuery(name = "changeUserName",query = "update from Account account set userName= : newUserName where userName= :userName "),
        @NamedQuery(name = "updateUserLogIn",query = "update from Account set loggedIn= :loggedIn where userName= :userName")

})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "logged_in")
    private boolean loggedIn;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Customer customer;





}
