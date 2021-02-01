package persistence.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "deleteContinent",query = "delete from Continent where name= :name") ,
        @NamedQuery(name = "findContinent",query = "select continent from Continent continent where continent.name= :name"),
        @NamedQuery(name = "countContinent",query = "select count(name) from Continent where name= :name"),

})

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "continents")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "continent")
    private Set<Country> countrySet;

    public Continent(String name) {
        this.name = name;
    }
}
