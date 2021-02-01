package persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "deleteCity",query = "delete from City where name= :name"),
        @NamedQuery(name = "countCity",query = "select count(name) from City where name= :name"),
        @NamedQuery(name = "findCity", query = "select city from City city where city.name= :name"),
        @NamedQuery(name = "changeCityName",query = "update from City set name= :newName where name= :name"),
        @NamedQuery(name = "findCitiesInCountry",query = "select city from City city inner join city.country country where country.name= :name")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "countries_id")
    private Country country;

    @OneToMany(mappedBy = "city")
    private Set<Hotel> hotelSet;

    @OneToMany(mappedBy = "city")
    private Set<Airport> airportSet;




}
