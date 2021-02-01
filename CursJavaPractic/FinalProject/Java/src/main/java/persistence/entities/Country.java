package persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "deleteCountry",query = "delete from Country where name= :name") ,
        @NamedQuery(name = "countCountry" ,query = "select count(name) from Country where name= :name"),
        @NamedQuery(name = "findCountry",query = "select country from Country country where country.name= :name"),
        @NamedQuery(name = "findCountriesInContinent",query = "select country from Country country inner join country.continent continent where continent.name= :name"),
        @NamedQuery(name = "changeCountryName",query = "update from Country set name= :newName where name= :name")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
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


}
