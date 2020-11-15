package persistance.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "gyms")
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "gyms_workouts",
            joinColumns = {@JoinColumn(name = "gyms_id")},
            inverseJoinColumns = {@JoinColumn(name = "workouts_id")})
    private Set<Workout> workouts;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "gyms_customers",
            joinColumns = {@JoinColumn(name = "gyms_id")},
            inverseJoinColumns = {@JoinColumn(name = "customers_id")})
    private Set<Customer> customerSet;


    public Gym() {
    }

    public Gym(String name, String city, String address, Set<Workout> workouts) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.workouts = workouts;
    }

    public Gym(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Set<Workout> workouts) {
        this.workouts = workouts;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Gym: " + name + ", " + city + ",  " + address;
    }
}
