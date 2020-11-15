package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "countGym",query = "select count(*) from Gym where address= :address"),
        @NamedQuery(name = "findGym",query = "select gym from Gym gym where gym.address= :address"),
        @NamedQuery(name = "deleteGym",query = "delete from Gym where address= :address"),
        @NamedQuery(name = "changeGymName",query = "update from Gym set name= :name where address= :address")
})

@Entity
@Table(name = "gyms")
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @OneToOne(mappedBy = "gym", cascade = CascadeType.ALL)
    private Manager manager;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "gyms_courses",
            joinColumns = {@JoinColumn(name = "gyms_id")},
            inverseJoinColumns = {@JoinColumn(name = "courses_id")})
    private Set<Course> courseSet;
    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL)
    private Set<Janitor> janitorSet;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "gyms_customers",
            joinColumns = {@JoinColumn(name = "gyms_id")},
            inverseJoinColumns = {@JoinColumn(name = "customers_id")})
    private Set<Customer> customerSet;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "gyms_trainers",
            joinColumns = {@JoinColumn(name = "gyms_id")},
            inverseJoinColumns = {@JoinColumn(name = "trainers_id")})
    private Set<Trainer> trainerSet;

    public Gym(String name, String address, String city, Manager manager, Set<Course> courseSet) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.manager = manager;
        this.courseSet = courseSet;
    }


    public Gym(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public Gym(String address) {
        this.address = address;
    }

    public Gym(String name, String address, String city, Manager manager) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.manager = manager;
    }

    public Gym() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }

    public Set<Janitor> getJanitorSet() {
        return janitorSet;
    }

    public void setJanitorSet(Set<Janitor> janitorSet) {
        this.janitorSet = janitorSet;
    }

    public Set<Trainer> getTrainerSet() {
        return trainerSet;
    }

    public void setTrainerSet(Set<Trainer> trainerSet) {
        this.trainerSet = trainerSet;
    }

    @Override
    public String toString() {
        return "Gym: " + name + ", address: " + address + ", city: " + city;
    }
}
