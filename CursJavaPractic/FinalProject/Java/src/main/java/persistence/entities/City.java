package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "deleteCity",query = "delete from City where name= :name"),
        @NamedQuery(name = "countCity",query = "select count(name) from City where name= :name"),
        @NamedQuery(name = "findCity", query = "select city from City city where city.name= :name"),
        @NamedQuery(name = "changeCityName",query = "update from City set name= :newName where name= :name"),
        @NamedQuery(name = "findCitiesInCountry",query = "select city from City city inner join city.country country where country.name= :name")
})

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


    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public City() {
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Hotel> getHotelSet() {
        return hotelSet;
    }

    public void setHotelSet(Set<Hotel> hotelSet) {
        this.hotelSet = hotelSet;
    }

    public Set<Airport> getAirportSet() {
        return airportSet;
    }

    public void setAirportSet(Set<Airport> airportSet) {
        this.airportSet = airportSet;
    }

    @Override
    public String toString() {
        return "City: " + name + ", " + country ;
    }
}
