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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;
    @OneToMany(mappedBy = "gym",cascade = CascadeType.ALL )
    private Set<Person> personSet;






    public Gym(){}

    public Gym(String name,String city,String address){
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

    @Override
    public String toString() {
        return "Gym: " + name + ", " + city  + ",  " + address ;
    }
}
