package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "findCustomerByEmail", query = "select customer from Customer customer where customer.email= :email"),
        @NamedQuery(name = "countEmail", query = "select count(email) from Customer where email= :email "),
        @NamedQuery(name = "findCustomerAccount",query = "select customer from Customer customer inner join customer.account account where account.userName= :userName and account.password= :password")

})

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
    private String birthDate;
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accounts_id")
    private Account account;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "customers_subscriptions",
            joinColumns = {@JoinColumn(name = "customers_id")},
            inverseJoinColumns = {@JoinColumn(name = "subscriptions_id")})
    private Set<Subscription> subscriptionSet;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "gyms_customers",
            joinColumns = {@JoinColumn(name = "customers_id")},
            inverseJoinColumns = {@JoinColumn(name = "gyms_id")})
    private Set<Gym> gymSet;


    public Customer(String name, String surname, String birthDate, String email, Set<Subscription> subscriptionSet, Set<Gym> gymSet) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.subscriptionSet = subscriptionSet;
        this.gymSet = gymSet;
    }

    public Customer(String name, String surname, String birthDate, String email, Account account, Set<Subscription> subscriptionSet, Set<Gym> gymSet) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.account = account;
        this.subscriptionSet = subscriptionSet;
        this.gymSet = gymSet;
    }

    public Customer() {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Subscription> getSubscriptionSet() {
        return subscriptionSet;
    }

    public void setSubscriptionSet(Set<Subscription> subscriptionSet) {
        this.subscriptionSet = subscriptionSet;
    }

    public Set<Gym> getGymSet() {
        return gymSet;
    }

    public void setGymSet(Set<Gym> gymSet) {
        this.gymSet = gymSet;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer: " + name + ", '" + surname + ", birthDate: " + birthDate + ", email: " + email + ", subscriptions: " + subscriptionSet + ", gyms: " + gymSet ;
    }
}
