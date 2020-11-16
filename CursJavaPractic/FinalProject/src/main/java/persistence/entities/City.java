package persistence.entities;

import javax.persistence.*;
@NamedQueries({
        @NamedQuery(name = "deleteCity",query = "delete from City where name= :name"),
        @NamedQuery(name = "findCity", query = "select city from City city where city.name= :name"),
        @NamedQuery(name = "changeCityName",query = "update from City set name= :newName where name= :name")
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

    @Override
    public String toString() {
        return "City: " + name + ", " + country ;
    }
}
