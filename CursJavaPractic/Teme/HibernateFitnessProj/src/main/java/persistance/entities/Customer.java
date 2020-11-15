package persistance.entities;

import javax.persistence.*;
import java.util.Set;

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
    @Column(name = "year_of_birth")
    private int yearOfBirth;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "gyms_customers",
    joinColumns = {@JoinColumn(name = "customers_id")},
    inverseJoinColumns = {@JoinColumn(name = "gyms_id")})
    private Set<Gym> gymSet;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscriptions_id")
    private Subscription subscription;


    public Customer() {
    }

    public Customer(String name, String surname, int yearOfBirth, Set<Gym> gymSet , Subscription subscription) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.gymSet = gymSet;
        this.subscription = subscription;
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

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Set<Gym> getGymSet() {
        return gymSet;
    }

    public void setGymSet(Set<Gym> gymSet) {
        this.gymSet = gymSet;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }


    @Override
    public String toString() {
        return "Person: " + name + ", " + surname + ", yearOfBirth: " + yearOfBirth + ", gym: " + gymSet + ", subscription: " + subscription  ;
    }
}