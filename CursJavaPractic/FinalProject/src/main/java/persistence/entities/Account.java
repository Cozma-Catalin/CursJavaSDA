package persistence.entities;

import javax.persistence.*;


@NamedQueries({
        @NamedQuery(name = "findAccount", query = "select account from Account account where account.userName= :userName and account.password= :password"),
        @NamedQuery(name = "checkRegistration", query = "select password from Account where userName= :userName and password= :password"),
        @NamedQuery(name = "deleteAccount", query = "delete from Account where userName= :userName"),
        @NamedQuery(name = "countAccountUserName", query = "select count(userName) from Account where userName= :userName "),
        @NamedQuery(name = "changeUserName",query = "update from Account account set userName= : newUserName where userName= :userName "),
        @NamedQuery(name = "updateUserLogIn",query = "update from Account set loggedIn= :loggedIn where userName= :userName")

})

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

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }


    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public String toString() {
        return "Account for user: " + userName + " , " + customer + ".";
    }


}
