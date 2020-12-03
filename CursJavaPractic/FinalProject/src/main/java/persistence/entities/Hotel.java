package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({

        @NamedQuery(name = "findHotelsInCity",query = "select hotel from Hotel hotel inner join hotel.city city where city.name= :name"),
        @NamedQuery(name = "deleteHotelByName",query = "delete from Hotel where name= :name "),
        @NamedQuery(name = "findHotel",query = "select hotel from Hotel hotel where name= :name"),
        @NamedQuery(name = "changeHotelName",query = "update from Hotel set name= :newName where name= :name"),
        @NamedQuery(name = "countHotelName",query = "select count(name) from Hotel where name= :name"),
        @NamedQuery(name = "countAddressInCity",query = "select hotel.address from Hotel hotel inner join hotel.city city where city.name= :name"),
        @NamedQuery(name = "deleteHotelByAddress",query = "delete from Hotel where address= :address"),
        @NamedQuery(name = "findHotelByAddress" ,query = "select hotel from Hotel hotel where address= :address")
})

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "number_of_stars")
    private double numberOfStars;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "hotels_rooms",
            joinColumns = {@JoinColumn(name = "hotels_id")},
            inverseJoinColumns = {@JoinColumn(name = "rooms_id")})
    private Set<Room> roomSet;

    @ManyToOne
    @JoinColumn(name = "cities_id")
    private City city;

    public Hotel(String name, String address, double numberOfStars,Set<Room> roomSet ,String description, City city) {
        this.name = name;
        this.address = address;
        this.numberOfStars = numberOfStars;
        this.roomSet = roomSet;
        this.description = description;
        this.city = city;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Set<Room> getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(Set<Room> roomSet) {
        this.roomSet = roomSet;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Hotel: " + name + ", address: " + address + ", number of stars: " + numberOfStars
         + " ,rooms: " + roomSet + ", description: " + description + ", " + city ;
    }
}
