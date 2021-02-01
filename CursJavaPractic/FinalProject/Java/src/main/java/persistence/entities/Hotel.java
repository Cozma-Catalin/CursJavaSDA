package persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({

        @NamedQuery(name = "findHotelsInCity",query = "select hotel from Hotel hotel inner join hotel.city city where city.name= :name"),
        @NamedQuery(name = "deleteHotelByName",query = "delete from Hotel where name= :name "),
        @NamedQuery(name = "findHotel",query = "select hotel from Hotel hotel where name= :name"),
        @NamedQuery(name = "changeHotelName",query = "update from Hotel set name= :newName where name= :name"),
        @NamedQuery(name = "countHotelName",query = "select count(name) from Hotel where name= :name"),
        @NamedQuery(name = "countHotelAddress",query = "select hotel.address from Hotel hotel where hotel.address= :address"),
        @NamedQuery(name = "deleteHotelByAddress",query = "delete from Hotel where address= :address"),
        @NamedQuery(name = "findHotelByAddress" ,query = "select hotel from Hotel hotel where address= :address")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
