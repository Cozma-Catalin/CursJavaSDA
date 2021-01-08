package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "deleteCountry",query = "delete from Country where name= :name") ,
        @NamedQuery(name = "countCountry" ,query = "select count(name) from Country where name= :name"),
        @NamedQuery(name = "findCountry",query = "select country from Country country where country.name= :name"),
        @NamedQuery(name = "findCountriesInContinent",query = "select country from Country country inner join country.continent continent where continent.name= :name"),
        @NamedQuery(name = "changeCountryName",query = "update from Country set name= :newName where name= :name")
})

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "continents_id")
    private Continent continent;

    @OneToMany(mappedBy = "country")
    private Set<City> citySet;

    public Country(String name, Continent continent) {
        this.name = name;
        this.continent = continent;
    }

    public Country() {
    }

    public Country(String name) {
        this.name = name;
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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public Set<City> getCitySet() {
        return citySet;
    }

    public void setCitySet(Set<City> citySet) {
        this.citySet = citySet;
    }

    @Override
    public String toString() {
        return "Country: " + name + ", " + continent ;
    }
}
