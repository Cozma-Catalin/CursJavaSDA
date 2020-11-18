package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "countHotel",query = "select count(hotel.name) from Hotel hotel inner join hotel.city city where city.name= :name")
})

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "number_of_stars")
    private double numberOfStars;
    @Column(name = "description")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cities_id")
    private City city;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hotels_rooms",
    joinColumns = {@JoinColumn(name = "hotels_id")},
    inverseJoinColumns = {@JoinColumn(name = "rooms_id")})
    private Set<Room> roomSet;

    public Hotel(String name, double numberOfStars, String description, City city) {
        this.name = name;
        this.numberOfStars = numberOfStars;
        this.description = description;
        this.city = city;
    }

    public Hotel(String name, double numberOfStars, String description, City city, Set<Room> roomSet) {
        this.name = name;
        this.numberOfStars = numberOfStars;
        this.description = description;
        this.city = city;
        this.roomSet = roomSet;
    }

    public Hotel() {
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

    public double getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(double numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Room> getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(Set<Room> roomSet) {
        this.roomSet = roomSet;
    }

    @Override
    public String toString() {
        return "Hotel: " + name + ", number of stars: " + numberOfStars + ", description: " + description + ", " + city + roomSet;
    }
}
