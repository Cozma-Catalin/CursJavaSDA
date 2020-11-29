package persistence.entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "getAirportNameByCityName",query = "select airport.name from Airport airport inner join airport.city city where city.name= :name"),
        @NamedQuery(name = "deleteAirportByName",query = "delete from Airport where name= :name"),
        @NamedQuery(name = "changeAirportName",query = "update from Airport set name= :newName where name= :name"),
        @NamedQuery(name = "countAirportName",query = "select count(name) from Airport where name= :name"),
        @NamedQuery(name = "findAirportByName",query = "select airport from Airport airport where name= :name"),
        @NamedQuery(name = "findAirportsInCity",query = "select airport from Airport airport inner join airport.city city where city.name= :cityName")

})

@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cities_id")
    private City city;

    public Airport(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public Airport() {
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport: " + name + ", " + city ;
    }

}
